package main.java.servlet;

import main.java.entity.Commodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author NINE. LIU
 * @Date 2020/10/30 13:50
 * @Version 1.0
 */
public class IndexFilter implements Filter {

  //  private static Logger logger = LoggerFactory.getLogger("IndexFilter");
   // private  String filterName = "IndexFilter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
       // logger.debug("Request to be destroyed by "+filterName);
        @SuppressWarnings("unchecked")
        List<Commodity> commodityList = (List<Commodity>) request.getAttribute("commodityList");
        if(commodityList==null)
        {
            request.getRequestDispatcher("/CommodityServlet?action=findAllLimit").forward(request,response);
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
