package main.java.servlet;


import main.java.entity.User;
import main.java.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author NINE. LIU
 * @Date 2020/10/21 8:06
 * @Version 1.0
 */

public class UserServlet extends HttpServlet {

    private UserService userService;

    public UserServlet()
    {
        userService=new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");
        if(action.equals("login"))
        {
            login(req,resp);
        }
        else if(action.equals("sign in"))
        {
            addUser(req,resp);
        }
        else if(action.equals("deleteUser"))
        {
            deleteUser(req,resp);
        }
        else if(action.equals("updatePassword"))
        {
            updatePassword(req,resp);
        }
        else if(action.equals("searchUser"))
        {
            searchUser(req,resp);
        }
        else if(action.equals("findAllUser"))
        {
            findAllUser(req,resp);
        }
        else if(action.equals("logOut"))
        {
            logOut(req,resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        if(userName==null||userName.length()==0)
        {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/login.jsp");
            String error = "Username can't be null";
            req.setAttribute("error",error);
            requestDispatcher.forward(req,resp);
        }
        if(userPassword==null||userPassword.length()==0)
        {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/login.jsp");
            String error = "Password can't be null";
            req.setAttribute("error",error);
            requestDispatcher.forward(req,resp);
        }
        User user = new User(userName,userPassword);
        try {
            if(userService.checkUser(user))
            {
                System.out.println(userName+" login successful");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/CommodityServlet?action=findAllLimit");
                req.getSession().setAttribute("userName",userName);
                req.getSession().setAttribute("userPassword",userPassword);
                String login = "success";
                req.setAttribute("login",login);
                requestDispatcher.forward(req,resp);

            }
            else
            {
                String error = "Incorrect user name or password";
                System.out.println("Incorrect user name or password");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/login.jsp");
                req.setAttribute("error",error);

                requestDispatcher.forward(req,resp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String confirmPassword = req.getParameter("confirmPassword");
        if(!userPassword.equals(confirmPassword))
        {
            String error = "The passwords entered twice are inconsistent";
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/register.jsp");
            req.setAttribute("error",error);
            requestDispatcher.forward(req,resp);
        }
        else
        {
            User user = new User(userName,userPassword);
            try {
                if(userService.addUser(user))
                {
                    System.out.println("Registered Successfully");
                    String success = "Registered Successfully";
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/login.jsp");
                    req.setAttribute("success",success);
                    requestDispatcher.forward(req,resp);
                }
                else
                {
                    System.out.println("The user name already exists");
                    String error = "The user name already exists";
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/register.jsp");
                    req.setAttribute("error",error);

                    requestDispatcher.forward(req,resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String userName = req.getParameter("userName");
        try {
            if(userService.deleteUser(userName))
            {
                System.out.println("Deleted Successfully");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/UserManagement.jsp");
                requestDispatcher.include(req,resp);
            }
            else
            {
                System.out.println("Deletion Failed");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/UserManagement.jsp");
                requestDispatcher.include(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String newPassword = req.getParameter("newPassword");
        User user = new User(userName,userPassword);
        try {
            if(userService.checkUser(user))
            {
                userService.updatePassword(userName,newPassword);
                System.out.println("Password changes successfully");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/userInfo.jsp");
                req.getSession().setAttribute("userName",userName);
                req.getSession().setAttribute("userPassword",userPassword);
                String success = "Password changes successfully";
                req.setAttribute("success",success);
                requestDispatcher.forward(req,resp);
            }
            else
            {
                System.out.println("Fail to change password");
                String error = "Incorrect original  password";
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/userInfo.jsp");
                req.setAttribute("error",error);
                requestDispatcher.forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String userName = req.getParameter("userName");
        try {
            User user = userService.findUser(userName);
            List<User> users = new ArrayList<>();
            if(user!=null)
            {
                users.add(user);
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/UserManagement.jsp");
            req.setAttribute("userList",users);
            requestDispatcher.forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void findAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            List<User> users = userService.findAllUser();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/UserManagement.jsp");
            req.setAttribute("userList",users);
            requestDispatcher.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/login.jsp");
        req.getSession().removeAttribute("userName");
        req.getSession().removeAttribute("userPassword");
        requestDispatcher.forward(req,resp);
    }

}
