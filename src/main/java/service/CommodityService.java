package main.java.service;

import main.java.dao.CommodityDaoImpl;
import main.java.entity.Commodity;
import main.java.tag.PageObject;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author NINE. LIU
 * @Date 2020/10/19 13:55
 * @Version 1.0
 */
public class CommodityService {
    private CommodityDaoImpl commodityDao;

    public CommodityService()
    {
        commodityDao = new CommodityDaoImpl();
    }

    public boolean purchase(String name, int amount) throws SQLException {
        if(commodityDao.selectByName(name)!=null)
        {
            Commodity commodity = commodityDao.selectByName(name);
            if(commodity.getAmount()>=amount)
                return commodityDao.updateAmountByName(name,commodity.getAmount()-amount);
            else
                return false;
        }
        else
            return false;
    }

    public boolean save(Commodity commodity) throws SQLException {
        return commodityDao.insert(commodity);
    }

    public boolean update(Commodity commodity) throws SQLException {
        return commodityDao.updateByName(commodity);
    }

    public boolean delete(String name) throws SQLException {
        return commodityDao.deleteByName(name);
    }

    public List<Commodity> findAll() throws SQLException {
        return commodityDao.findAll();
    }

    public List<Commodity> search(String name) throws SQLException {
        return commodityDao.searchByName(name);
    }

    public Commodity select(String name) throws SQLException {
        return commodityDao.selectByName(name);
    }

    public List<Commodity> findAllLimit(int limit) throws SQLException {
        return commodityDao.findAllLimit(limit);
    }

    public List<Commodity> searchType(String type) throws SQLException {
        return commodityDao.searchByType(type);
    }

    public PageObject getPageObject(int pageSize, int curPage, List<Commodity> commodities) throws SQLException {
        return commodityDao.queryPage(pageSize,curPage,commodities);
    }
}
