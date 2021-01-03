package main.java.dao;

import main.java.conn.DBConnection;
import main.java.entity.Commodity;
import main.java.tag.PageObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author NINE. LIU
 * @Date 2020/10/16 16:42
 * @Version 1.0
 */
public class CommodityDaoImpl  implements CommodityDao{
    private Statement statement = null;
    private ResultSet resultSet =null;

    public CommodityDaoImpl()
    {
        DBConnection dbConnection= new DBConnection();
        try {
            statement=dbConnection.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Commodity selectByName(String name) throws SQLException
    {
        resultSet = statement.executeQuery("SELECT * FROM commodity WHERE name = '" + name+"'");
        if(resultSet.next())
            return new Commodity(name,resultSet.getDouble("price"), resultSet.getString("type"), resultSet.getInt("amount"),resultSet.getString("image"), resultSet.getString("description"));
        else
            return null;
    }

    @Override
    public boolean insert(Commodity commodity) throws SQLException
    {
        if(selectByName(commodity.getName())==null)
        {
            statement.executeUpdate("INSERT INTO commodity (name, type, price, amount, description, image) VALUES ('"+commodity.getName()+"','"+commodity.getType()+"','"+commodity.getPrice()+"','"+commodity.getAmount()+"','" +commodity.getDescription()+"','" +commodity.getImage()+"')");
            return true;
        }
        else
            return false;

    }

    @Override
    public boolean updateAmountByName(String name, int amount) throws SQLException
    {
        if(selectByName(name)!=null)
        {
            statement.executeUpdate("UPDATE commodity SET amount = '"+ amount +"' WHERE name='"+name+"'");
            return true;
        }
        else
            return false;


    }

    @Override
    public boolean updateByName(Commodity commodity) throws SQLException
    {
        if(selectByName(commodity.getName())!=null)
        {
            statement.executeUpdate("UPDATE commodity SET amount = '"+ commodity.getAmount() + "',price = '"+commodity.getPrice()+ "',type = '"+commodity.getType()+"',description = '"+commodity.getDescription()+"',image = '"+commodity.getImage()+"' WHERE name='"+commodity.getName()+"'");
            return true;
        }
        else
            return false;


    }


    @Override
    public boolean deleteByName(String name) throws SQLException {
        if(selectByName(name)!=null)
        {
            statement.executeUpdate("DELETE FROM commodity WHERE name = '" + name+"'");
            return true;
        }
        else
            return false;

    }

    @Override
    public List<Commodity> findAll() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM commodity");
        List<Commodity> commodities = new ArrayList<>();
        while (resultSet.next())
        {
            commodities.add(new Commodity(resultSet.getString("name"),resultSet.getDouble("price"), resultSet.getString("type"), resultSet.getInt("amount"),resultSet.getString("image"), resultSet.getString("description")));
        }
        return commodities;

    }

    @Override
    public List<Commodity> searchByName(String name) throws SQLException
    {
        resultSet = statement.executeQuery("SELECT * FROM commodity WHERE name like '%" + name+"%'");
        List<Commodity> commodities = new ArrayList<>();
        while (resultSet.next())
        {
            Commodity commodity = new Commodity(resultSet.getString("name"),resultSet.getDouble("price"), resultSet.getString("type"), resultSet.getInt("amount"),resultSet.getString("image"), resultSet.getString("description"));
            commodities.add(commodity);
        }
        return commodities;
    }

    @Override
    public List<Commodity> searchByType(String type) throws SQLException
    {
        resultSet = statement.executeQuery("SELECT * FROM commodity WHERE type like '" + type+"'");
        List<Commodity> commodities = new ArrayList<>();
        while (resultSet.next())
        {
            Commodity commodity = new Commodity(resultSet.getString("name"),resultSet.getDouble("price"), resultSet.getString("type"), resultSet.getInt("amount"),resultSet.getString("image"), resultSet.getString("description"));
            commodities.add(commodity);
        }
        return commodities;
    }

    @Override
    public PageObject queryPage(int pageSize, int curPage,  List<Commodity> commodities) throws SQLException
    {
        PageObject pageObject = new PageObject();
        pageObject.setPageSize(pageSize);
        pageObject.setCurPage(curPage);
        pageObject.setDataCount(commodities.size());
        int index = pageObject.getBeingPoint();
        List<Commodity> commoditiesCur = new ArrayList<>();
        while (index<pageSize*curPage)
        {
            if(index>=commodities.size())
                break;
            commoditiesCur.add(commodities.get(index));
            index++;
        }
        pageObject.setData(commoditiesCur);
        return pageObject;

    }

    public List<Commodity> findAllLimit(int limit) throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM commodity LIMIT "+limit);
        List<Commodity> commodities = new ArrayList<>();
        while (resultSet.next())
        {
            commodities.add(new Commodity(resultSet.getString("name"),resultSet.getDouble("price"), resultSet.getString("type"), resultSet.getInt("amount"),resultSet.getString("image"), resultSet.getString("description")));
        }
        return commodities;
    }

}
