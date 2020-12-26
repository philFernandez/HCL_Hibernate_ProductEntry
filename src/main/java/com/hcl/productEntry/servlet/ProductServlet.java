package com.hcl.productEntry.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hcl.productEntry.dao.ProductDao;
import com.hcl.productEntry.entity.ProductEntity;

@WebServlet(name = "ProductServlet",
        description = "Servlet for handling product entry into database",
        urlPatterns = {"/productEntry"})
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDao productDao;

    @Override
    public void init() {
        productDao = new ProductDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductEntity product = new ProductEntity(name, price, quantity);
        productDao.saveProduct(product);
        response.sendRedirect("index.jsp");
    }
}
