package main.java.dao;


import main.java.entity.User;
import main.java.tag.PageObject;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author NINE. LIU
 * @Date 2020/10/20 15:12
 * @Version 1.0
 */
public interface UserDao {
    User selectByName(String name) throws SQLException;
    boolean save(User user) throws SQLException;
    boolean updatePasswordByName(String name,String password) throws SQLException;
    boolean deleteByName(String name) throws SQLException;
    List<User> findAllUser() throws SQLException;
    PageObject queryPage(int pageSize,int curPage,PageObject pageObject,List<User> users) throws SQLException;
}
