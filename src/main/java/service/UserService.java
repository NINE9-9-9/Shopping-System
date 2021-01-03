package main.java.service;

import main.java.dao.UserDaoImpl;
import main.java.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author NINE. LIU
 * @Date 2020/10/21 8:03
 * @Version 1.0
 */
public class UserService {
    private UserDaoImpl userDao;

    public UserService()
    {
        userDao = new UserDaoImpl();
    }

    public boolean checkUser(User user) throws SQLException {
        if(userDao.selectByName(user.getName())!=null)
        {
            String userPassword = userDao.selectByName(user.getName()).getPassword();
            return userPassword.equals(user.getPassword());
        }
        else
            return false;
    }

    public boolean addUser(User user) throws SQLException {
        return userDao.save(user);
    }

    public User findUser(String name) throws SQLException {
        return  userDao.selectByName(name);
    }

    public boolean deleteUser(String name) throws SQLException {
        return userDao.deleteByName(name);
    }

    public boolean updatePassword(String name, String password) throws SQLException {
        return userDao.updatePasswordByName(name,password);
    }

    public List<User> findAllUser() throws SQLException {
        return userDao.findAllUser();
    }


}
