package main.java.service;

import main.java.dao.AdminDaoImpl;
import main.java.entity.Admin;
import main.java.entity.User;

import java.sql.SQLException;

/**
 * @Author NINE. LIU
 * @Date 2020/10/21 8:03
 * @Version 1.0
 */
public class AdminService {
    private AdminDaoImpl adminDao;

    public AdminService()
    {
        adminDao = new AdminDaoImpl();
    }

    public boolean checkAdmin(Admin admin) throws SQLException {
        if(adminDao.selectByName(admin.getName())!=null)
        {
            String userPassword = adminDao.selectByName(admin.getName()).getPassword();
            return userPassword.equals(admin.getPassword());
        }
        else
            return false;
    }

    public boolean updatePassword(String name, String password) throws SQLException {
        return adminDao.updatePasswordByName(name,password);
    }
}
