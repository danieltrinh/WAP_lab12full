package dao;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    Map<String, User> userDb = new HashMap<>();

    {
        userDb.put("Daniel", new User("Daniel", "123"));
        userDb.put("Leo", new User("Leo", "123"));
    }

    public List<User> getAllUser()
    {
        return new ArrayList<>(userDb.values());
    }

    public  Map<String, User> getAllUserMap()
    {
        return userDb;
    }

    public User getUserByUsername(String username)
    {
        return userDb.get(username);
    }
}
