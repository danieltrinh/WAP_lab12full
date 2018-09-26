package controller;

import model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart sp = (ShoppingCart) session.getAttribute("shoppingCart");

        req.setAttribute("products", sp.getProducts());

        req.getRequestDispatcher("checkout.jsp").forward(req, resp);
    }
}
