package main.java.servlet;

import main.java.service.CommodityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author NINE. LIU
 * @Date 2020/11/2 9:02
 * @Version 1.0
 */
public class PurchaseServlet extends HttpServlet {
    private CommodityService commodityService;

    public PurchaseServlet()
    {
        commodityService = new CommodityService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commodityName = req.getParameter("commodityName");
        String amount = req.getParameter("amount");
        try {
            if( commodityService.purchase(commodityName, Integer.parseInt(amount)))
            {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/commodity/purchase.jsp");
                requestDispatcher.forward(req, resp);
            }
            else
            {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/commodity/purchaseFail.jsp");
                requestDispatcher.forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
