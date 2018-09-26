package controller;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");
        String remember = (String) req.getParameter("remember");

        UserDao userDao = new UserDao();

        boolean userExist = false;
        if(userDao.getAllUserMap().containsKey(username))
        {
            if(userDao.getUserByUsername(username).getPassword().equals(password))
                userExist = true;
        }

        if(userExist)
        {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            if(remember != null)
            {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60*60*24*30);
                System.out.println(cookie.getValue());
                resp.addCookie(cookie);
            }
            else
            {
                Cookie cookie = new Cookie("username", "");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }

            resp.sendRedirect("/homepage");
        }
        else {
            req.setAttribute("message", "Username or password not correct");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
