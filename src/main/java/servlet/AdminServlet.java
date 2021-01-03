package main.java.servlet;

import main.java.entity.Admin;
import main.java.service.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author NINE. LIU
 * @Date 2020/10/22 10:15
 * @Version 1.0
 */
public class AdminServlet extends HttpServlet {
    private AdminService adminService;

    public AdminServlet()
    {
        adminService = new AdminService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("login"))
        {
            login(req,resp);
        }
        else if(action.equals("updatePassword"))
        {
            updatePassword(req,resp);
        }
        else if(action.equals("logOut"))
        {
            logOut(req,resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String adminName = req.getParameter("adminName");
        String adminPassword = req.getParameter(("adminPassword"));
        Admin admin = new Admin(adminName,adminPassword);
        if(adminName==null||adminName.length()==0)
        {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/adminLogin.jsp");
            String error = "Username can't be null";
            req.setAttribute("error",error);
            requestDispatcher.forward(req,resp);
        }
        if(adminPassword==null||adminPassword.length()==0)
        {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/adminLogin.jsp");
            String error = "Password can't be null";
            req.setAttribute("error",error);
            requestDispatcher.forward(req,resp);
        }
        try {
            if(adminService.checkAdmin(admin))
            {
                System.out.println(adminName+" admin login successful");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/adminInterface.jsp");
                req.getSession().setAttribute("adminName",adminName);
                req.getSession().setAttribute("adminPassword",adminPassword);
                requestDispatcher.forward(req,resp);
            }
            else
            {
                String error = "User name or password error";
                req.setAttribute("error",error);
                System.out.println(adminName+" login failed");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/adminLogin.jsp");
                requestDispatcher.forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String adminName = req.getParameter("adminName");
        String adminPassword = req.getParameter("adminPassword");

        try {
            if(adminService.updatePassword(adminName,adminPassword))
            {
                System.out.println("Password changes successfully");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/adminInterface.jsp");
                req.setAttribute("adminName",adminName);
                req.setAttribute("adminPassword",adminPassword);
                requestDispatcher.forward(req,resp);
            }
            else
            {
                System.out.println("Fail to change password");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/adminInterfaceCP.jsp");
                req.setAttribute("adminName",adminName);
                req.setAttribute("adminPassword",adminPassword);
                requestDispatcher.forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/adminLogin.jsp");
        req.getSession().removeAttribute("adminName");
        req.getSession().removeAttribute("adminPassword");
        requestDispatcher.forward(req,resp);
    }

}
