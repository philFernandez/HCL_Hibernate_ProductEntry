package com.hcl.productEntry.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
            throws IOException, ServletException {
        String name = null;
        double price = 0;
        int quantity = 0;
        try {
            name = request.getParameter("name");
            price = Double.parseDouble(request.getParameter("price"));
            quantity = Integer.parseInt(request.getParameter("quantity"));

        } catch (NumberFormatException e) {

        }

        ProductEntity product = new ProductEntity(name, price, quantity);
        productDao.saveProduct(product);
        List<?> products = productDao.getAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
    }
}
