package main.java.dao;

import main.java.conn.DBConnection;
import main.java.entity.User;
import main.java.tag.PageObject;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author NINE. LIU
 * @Date 2020/10/20 15:37
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao{

    private Statement statement = null;
    private ResultSet resultSet =null;

    public UserDaoImpl()
    {
        DBConnection dbConnection= new DBConnection();
        try {
            statement=dbConnection.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectByName(String name) throws SQLException
    {
        resultSet = statement.executeQuery("SELECT * FROM user WHERE name LIKE '" + name+ "'");
        if(resultSet.next())
        {
            return new User(name, resultSet.getString("password"));
        }
        else
            return null;
    }

    @Override
    public boolean save(User user) throws SQLException
    {
        if(selectByName(user.getName())==null)
        {
            statement.executeUpdate("INSERT INTO user (name,password) VALUE ('"+user.getName()+"','"+user.getPassword()+"')");
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean updatePasswordByName(String name,String password) throws SQLException
    {
        if(selectByName(name)!=null)
        {
            statement.executeUpdate("UPDATE user SET password = '" + password + "' WHERE name='" + name+"'");
            return true;
        }
        else
        {
            return false;
        }

    }

    @Override
    public boolean deleteByName(String name) throws SQLException {
        if(selectByName(name)!=null)
        {
            statement.executeUpdate("DELETE FROM user WHERE name = '" + name+"'");
            return true;
        }
        else
            return false;
    }

    @Override
    public List<User> findAllUser() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM user");
        List<User> users = new ArrayList<>();
        while (resultSet.next())
        {
            User user = new User(resultSet.getString("name"),resultSet.getString("password"));
            users.add(user);
        }
        return  users;
    }

    @Override
    public PageObject queryPage(int pageSize,int curPage,PageObject pageObject,List<User> users) throws SQLException
    {
        pageObject.setPageSize(pageSize);
        pageObject.setCurPage(curPage);
        pageObject.setDataCount(users.size());
        int index = pageObject.getBeingPoint();
        List<User> usersCur = new ArrayList<>();
        while (index<pageSize*curPage)
        {
            usersCur.add(users.get(index));
            index++;
        }
        pageObject.setData(usersCur);
        return pageObject;

    }


}
