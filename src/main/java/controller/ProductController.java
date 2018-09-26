package controller;

import com.example.dao.ProductDao;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        com.example.dao.ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAllProducts();

        req.setAttribute("products", products);

        req.getRequestDispatcher("product.jsp").forward(req,resp);
    }
}
