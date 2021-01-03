package main.java.servlet;

import main.java.entity.Commodity;
import main.java.service.CommodityService;
import main.java.tag.PageObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author NINE. LIU
 * @Date 2020/10/22 18:07
 * @Version 1.0
 */
public class CommodityServlet extends HttpServlet {

    private CommodityService commodityService;

    public CommodityServlet()
    {
        commodityService = new CommodityService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "purchase":
                purchase(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "addCommodity":
                add(req, resp);
                break;
            case "findAll":
                findAll(req, resp);
                break;
            case "findAllLimit":
                findAllLimit(req, resp);
                break;
            case "search":
                search(req, resp);
                break;
            case "searchType":
                searchType(req, resp);
                break;
            case "select":
                select(req, resp);
                break;
        }

    }

    private void purchase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String commodityName = req.getParameter("commodityName");
        String amount = req.getParameter("amount");
        try {
            if( commodityService.purchase(commodityName,Integer.parseInt(amount)))
            {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/commodity/purchase.jsp");
                requestDispatcher.forward(req,resp);
            }
            else
            {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/commodity/purchaseFail.jsp");
                requestDispatcher.forward(req,resp);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String commodityName = req.getParameter("commodityName");
        String amount = req.getParameter("amount");
        String price = req.getParameter("price");
        String type = req.getParameter("type");
        String description = req.getParameter("description");
        String fileName = req.getParameter("fileName");

        InputStream inputStream = req.getInputStream();
        int length = req.getContentLength();
        byte[] bytes = new byte[length];
        int total = 0;
        while (total<length)
        {
            int b = inputStream.read(bytes,total,length);
            total+=b;
        }

        OutputStream outputStream =null;
        String path = "/image/";
        File tempFile = new File(path);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
        outputStream = new FileOutputStream(tempFile.getPath() + fileName);
        while ((length = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, length);
        }

        Commodity commodity = new Commodity(commodityName,Double.parseDouble(price), type, Integer.parseInt(amount),tempFile.getPath() + File.separator + fileName, description);
        try {
            commodityService.update(commodity);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/adminInterfaceCom.jsp");
            requestDispatcher.forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String commodityName = req.getParameter("commodityName");

        try {
            if(commodityService.delete(commodityName))
            {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/success.jsp");
                requestDispatcher.forward(req,resp);
            }
            else
            {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/fail.jsp");
                requestDispatcher.forward(req,resp);
            }


        } catch (SQLException e) {

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/fail.jsp");
            requestDispatcher.forward(req,resp);
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String commodityName = req.getParameter("commodityName");
        String amount = req.getParameter("amount");
        String price = req.getParameter("price");
        String fileName = req.getParameter("fileName");

        InputStream inputStream = req.getInputStream();
        int length = req.getContentLength();
        byte[] bytes = new byte[length];
        int total = 0;
        while (total<length)
        {
            int b = inputStream.read(bytes,total,length);
            total+=b;
        }
        OutputStream outputStream =null;
        String path = "/image/";
        File tempFile = new File(path);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
        outputStream = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
        while ((length = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, length);
        }

        String description = req.getParameter("description");
        String type = req.getParameter("type");
        Commodity commodity = new Commodity(commodityName,Double.parseDouble(price), type, Integer.parseInt(amount),tempFile.getPath() + File.separator + fileName, description);
        try {
            commodityService.save(commodity);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/adminInterface.jsp");
            System.out.println("success");
            requestDispatcher.forward(req,resp);

        } catch (SQLException e) {
            String error = "Adding failed";
            System.out.println("error");
            req.setAttribute("error",error);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/adminInterface.jsp");
            requestDispatcher.forward(req,resp);
            e.printStackTrace();
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            List<Commodity> commodities = commodityService.findAll();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/findAll.jsp");
            req.setAttribute("commodityList",commodities);
            requestDispatcher.forward(req,resp);

        } catch (SQLException e) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/fail.jsp");

            requestDispatcher.forward(req,resp);
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String commodityName = req.getParameter("commodityName");
        String curPage= req.getParameter("curPage");


        try {
            List<Commodity> commodities = commodityService.search(commodityName);
            PageObject pageObject;
            if(curPage==null)
            {
                pageObject = commodityService.getPageObject(16,1,commodities);
            }
            else
            {
                pageObject = commodityService.getPageObject(16,Integer.parseInt(curPage),commodities);
            }

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/commodity/search.jsp");
            req.setAttribute("commodityName",commodityName);
            req.setAttribute("pageObject",pageObject);
            requestDispatcher.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String type = req.getParameter("type");
        String curPage= req.getParameter("curPage");

        try {
            List<Commodity> commodities = commodityService.searchType(type);
            PageObject pageObject;
            if(curPage==null)
            {
                pageObject = commodityService.getPageObject(16,1,commodities);
            }
            else {
                pageObject = commodityService.getPageObject(16,Integer.parseInt(curPage),commodities);
            }

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/commodity/search.jsp");
            req.setAttribute("pageObject",pageObject);
            requestDispatcher.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String commodityName = req.getParameter("commodityName");
        try {
            Commodity commodity = commodityService.select(commodityName);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/commodity/commodity.jsp");
            req.setAttribute("commodity",commodity);
            req.setAttribute("commodityName",commodityName);
            requestDispatcher.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void findAllLimit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            List<Commodity> commodities = commodityService.findAllLimit(16);


            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            req.setAttribute("commodityList",commodities);
            requestDispatcher.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
