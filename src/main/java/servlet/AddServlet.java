package main.java.servlet;

import com.jspsmart.upload.SmartUploadException;
import main.java.entity.Commodity;
import main.java.service.CommodityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;


import com.jspsmart.upload.SmartUpload;

/**
 * @Author NINE. LIU
 * @Date 2020/11/2 12:41
 * @Version 1.0
 */
public class AddServlet extends HttpServlet {

    private CommodityService commodityService;

    public AddServlet()
    {
        commodityService = new CommodityService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SmartUpload smartUpload = new SmartUpload();
        ServletConfig config = this.getServletConfig();
        smartUpload.initialize(config, req, resp);




        try {
            // upload File
            smartUpload.upload();

            String commodityName = smartUpload.getRequest().getParameter("commodityName");
            String amount = smartUpload.getRequest().getParameter("amount");
            String price = smartUpload.getRequest().getParameter("price");
            String description = smartUpload.getRequest().getParameter("description");
            String type = smartUpload.getRequest().getParameter("type");
            // get file object
            com.jspsmart.upload.File smartFile = smartUpload.getFiles().getFile(0);
            String name = smartFile.getFileName();
            // save file
            smartFile.saveAs("image/"+name, SmartUpload.SAVE_AUTO);



            Commodity commodity = new Commodity(commodityName,Double.parseDouble(price), type, Integer.parseInt(amount),"image/"+name, description);
            commodityService.save(commodity);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/success.jsp");
            System.out.println("success");
            requestDispatcher.forward(req,resp);
        } catch (Exception e) {
            String error = "Adding failed";
            System.out.println("error");
            req.setAttribute("error",error);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/fail.jsp");
            requestDispatcher.forward(req,resp);
            e.printStackTrace();
            e.printStackTrace();
        }
    }
}
