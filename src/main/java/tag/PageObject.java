package main.java.tag;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author NINE. LIU
 * @Date 2020/10/29 21:16
 * @Version 1.0
 */
public class PageObject {

    private final int DEFAULT_PAGE_SIZE = 16; //default display number in each page
    private final int DEFAULT_CUR_SIZE = 1; // default current page number;
    private List data; //current page data
    private int dataCount;
    private int pageSize;
    private int pageCount;
    private int curPage;

    public PageObject(){}

    public PageObject(List data, int dataCount, int pageSize, int pageCount, int curPage) {
        this.data = data;
        this.dataCount = dataCount;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.curPage = curPage;
    }

    public void reqProperty(HttpServletRequest req)
    {
        String curPage = req.getParameter("curPage");
        if(curPage!=null&&!curPage.equals(""))
        {
            this.curPage = Integer.parseInt(curPage);
        }

        String pageSize = req.getParameter("pageSize");
        if(pageSize!=null&&!pageSize.equals(""))
        {
            this.pageSize=Integer.parseInt(pageSize);
        }

        String dataCount = req.getParameter("dataCount");
        if(dataCount!=null&&!dataCount.equals(""))
        {
            this.dataCount=Integer.parseInt(dataCount);
        }
    }

    public int getBeingPoint()
    {
        return (getCurPage()-1)* getPageSize();
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public static PageObject getInstance(HttpServletRequest req)
    {
        PageObject pageObject = new PageObject();
        pageObject.reqProperty(req);
        return pageObject;
    }


    public int getCurPage()
    {
        if(curPage<DEFAULT_CUR_SIZE)
            curPage=DEFAULT_CUR_SIZE;
        return  curPage;
    }


    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getPageSize() {
        if(pageSize<1)
            pageSize=DEFAULT_PAGE_SIZE;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        if(dataCount>0)
        {
            if(dataCount%pageSize==0)
                pageCount = dataCount/pageSize;
            else
                pageCount = dataCount/pageSize +1;
        }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
