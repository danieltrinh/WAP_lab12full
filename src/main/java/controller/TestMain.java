package controller;

import dao.UserDao;

public class TestMain {
    public static void main(String[] args) {
        String username = "Daniel";
        String password = "123";

        UserDao userDao = new UserDao();

        boolean userExist = false;
        if(userDao.getAllUserMap().containsKey(username))
        {
            if(userDao.getUserByUsername(username).getPassword().equals(password))
                userExist = true;
        }

        System.out.println(userExist);
    }
}
