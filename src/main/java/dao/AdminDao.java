package main.java.dao;

import main.java.entity.Admin;



import java.sql.SQLException;

/**
 * @Author NINE. LIU
 * @Date 2020/10/20 15:37
 * @Version 1.0
 */
public interface AdminDao {

    Admin selectByName(String name) throws SQLException;
    boolean save(Admin admin) throws SQLException;
    boolean updatePasswordByName(String name,String password) throws SQLException;
    boolean deleteByName(String name) throws SQLException;
}
