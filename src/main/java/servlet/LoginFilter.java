package main.java.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author NINE. LIU
 * @Date 2020/10/29 20:10
 * @Version 1.0
 */

public class LoginFilter implements Filter {


    private  String filterName = "LoginFilter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String userName = (String) request.getSession().getAttribute("userName");
        if(userName==null)
        {
            request.setAttribute("status","Login, please");
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
        }
        else
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
