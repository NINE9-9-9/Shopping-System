package main.java.test;

import main.java.dao.AdminDaoImpl;
import main.java.dao.UserDaoImpl;
import main.java.entity.Admin;
import main.java.entity.User;

import java.sql.SQLException;

/**
 * @Author NINE. LIU
 * @Date 2020/10/24 15:05
 * @Version 1.0
 */
public class DBTest {

    public static void main(String[] arg) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        AdminDaoImpl adminDao= new AdminDaoImpl();

        userDao.save(new User("zzz1","zzz"));
        userDao.deleteByName("zzz");
        userDao.updatePasswordByName("zzz1","ssss");

        adminDao.save(new Admin("zzz1","zzz"));
        adminDao.save(new Admin("zzz","zzz"));
        adminDao.deleteByName("zzz");
        adminDao.updatePasswordByName("zzz1","ssss");
    }
}
