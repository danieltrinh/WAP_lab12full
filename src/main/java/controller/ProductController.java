package controller;

import com.example.dao.ProductDao;
import model.Product;
import model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductController extends HttpServlet {

    com.example.dao.ProductDao productDao = new ProductDao();

//    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> products = productDao.getAllProducts();
        System.out.println(products);
        req.setAttribute("products", products);

        req.getRequestDispatcher("product.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String productId = req.getParameter("product_id");

//        Product requestedProduct = (Product) mapper.readValue(productJson, Product.class);

        Product requestedProduct = productDao.getProductById(Integer.parseInt(productId));
        System.out.println(requestedProduct);

        HttpSession session = req.getSession();
        ShoppingCart sp  = (ShoppingCart) session.getAttribute("shoppingCart");

        if(sp == null)
            sp = new ShoppingCart();
        sp.addProductToShoppingCart(requestedProduct);
        session.setAttribute("shoppingCart", sp);

        try{
            String ids = "";
            for(Product p :  ((ShoppingCart) session.getAttribute("shoppingCart")).getProducts())
                ids += p.getName() + ";";
            resp.getWriter().println(ids);
//            resp.getWriter().println(mapper.writeValueAsString(requestedProduct));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
