package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        filterName = "checkoutFilter",
        urlPatterns = "/checkout"
)
public class CheckoutFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        if(session != null && session.getAttribute("username") != null)
        {
            if(session.getAttribute("shoppingCart") != null){

                filterChain.doFilter(servletRequest,servletResponse);
            }
            else
            {
                req.setAttribute("message", "Shopping Cart empty");
                req.getRequestDispatcher("/product").forward(req,resp);
            }
        }
        else {
            req.setAttribute("message", "You must loggin to checkout");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
