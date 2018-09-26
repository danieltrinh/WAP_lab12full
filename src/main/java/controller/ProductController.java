package controller;

import com.example.dao.ProductDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductController extends HttpServlet {

    com.example.dao.ProductDao productDao = new ProductDao();

    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> products = productDao.getAllProducts();
        System.out.println(products);
        req.setAttribute("products", products);

        req.getRequestDispatcher("product.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String productJson = req.getParameter("product");

    }
}
