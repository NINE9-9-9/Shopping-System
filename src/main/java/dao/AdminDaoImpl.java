package main.java.dao;

import main.java.conn.DBConnection;
import main.java.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author NINE. LIU
 * @Date 2020/10/20 16:42
 * @Version 1.0
 */
public class AdminDaoImpl implements AdminDao{

    private Statement statement = null;
    private ResultSet resultSet =null;

    public AdminDaoImpl()
    {
        DBConnection dbConnection= new DBConnection();
        try {
            statement=dbConnection.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Admin selectByName(String name) throws SQLException
    {
        resultSet = statement.executeQuery("SELECT * FROM admin WHERE name = '" + name+"'");
        if(resultSet.next())
            return new Admin(name, resultSet.getString("password"));
        else
            return null;
    }

    @Override
    public boolean save(Admin admin) throws SQLException
    {
        if(selectByName(admin.getName())==null)
        {
            statement.executeUpdate("INSERT INTO admin (name, password) VALUE ('"+admin.getName()+"','"+admin.getPassword()+"')");
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
            statement.executeUpdate("UPDATE admin SET password = '" + password + "' WHERE name='" + name+"'");
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
            statement.executeUpdate("DELETE FROM admin WHERE name = '" + name+"'");
            return true;
        }
        else
            return false;
    }
}
