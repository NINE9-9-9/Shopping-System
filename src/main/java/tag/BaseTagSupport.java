package main.java.tag;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @Author NINE. LIU
 * @Date 2020/10/29 21:14
 * @Version 1.0
 */
public class BaseTagSupport extends TagSupport {

    protected ServletRequest getRequest()
    {
        return pageContext.getRequest();
    }
}
