package main.java.dao;

import main.java.entity.Commodity;
import main.java.tag.PageObject;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author NINE. LIU
 * @Date 2020/10/19 15:32
 * @Version 1.0
 */
public interface CommodityDao {

    Commodity selectByName(String name) throws SQLException;
    boolean insert(Commodity commodity) throws SQLException;
    boolean updateByName(Commodity commodity) throws SQLException;
    boolean updateAmountByName(String name, int amount) throws SQLException;
    boolean deleteByName(String name) throws SQLException;
    List<Commodity> findAll() throws SQLException;
    List<Commodity> searchByName(String name) throws SQLException;
    List<Commodity> searchByType(String type) throws SQLException;
    PageObject queryPage(int pageSize, int curPage, List<Commodity> commodities) throws SQLException;

}
