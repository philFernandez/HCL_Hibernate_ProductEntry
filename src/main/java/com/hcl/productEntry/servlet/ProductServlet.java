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
        urlPatterns = {"/productEntry", "/listProducts"})
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDao productDao;

    @Override
    public void init() {
        productDao = new ProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getRequestURI().equals("/listProducts")) {
            listAll(request, response);
        } else {

            try {
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                ProductEntity product = new ProductEntity(name, price, quantity);
                productDao.saveProduct(product);
                listAll(request, response);

            } catch (NumberFormatException | NullPointerException e) {
                // System.out.print("\n\n\n Caught Exception : ");
                // System.out.print(e.getMessage() + "\n\n\n");
                throw new ServletException(e);
            }

        }
    }

    private void listAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<?> products = productDao.getAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
    }
}
