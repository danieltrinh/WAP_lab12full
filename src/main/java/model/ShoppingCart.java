package model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> shoppingCart) {
        this.products = shoppingCart;
    }

    public void addProductToShoppingCart(Product p)
    {
        products.add(p);
    }
}
