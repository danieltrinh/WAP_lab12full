package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        filterName = "authenFilter",
        urlPatterns = {"/homepage/*"},
        servletNames = {"HomepageController"}
)
public class AuthenFilter implements Filter {
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
            try{
                filterChain.doFilter(servletRequest,servletResponse);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else {
            resp.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {

    }
}
