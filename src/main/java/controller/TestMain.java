package controller;

import com.example.dao.ProductDao;

public class TestMain {
    public static void main(String[] args) {
        com.example.dao.ProductDao productDao = new ProductDao();
        System.out.println(productDao.getProductById(1));
    }
}
