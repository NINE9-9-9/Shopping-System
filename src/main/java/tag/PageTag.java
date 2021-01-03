package main.java.tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author NINE. LIU
 * @Date 2020/10/29 21:36
 * @Version 1.0
 */
public class PageTag extends BaseTagSupport {
    private final Logger logger = LoggerFactory.getLogger(PageTag.class);

    private PageObject pageObject;
    private String link;  //page url
    private String script; // JS method name;

    public PageTag(){}

    public PageTag(PageObject pageObject, String link, String script) {
        this.pageObject = pageObject;
        this.link = link;
        this.script = script;
    }

    public int doStartTag()
    {
        int[] iParams={0,0,0};
        String[] sParams={"",""};
        if(pageObject!=null&&pageObject.getData()!=null)
        {
            iParams[0]=pageObject.getDataCount();
            iParams[1]=pageObject.getPageCount();
            iParams[2]=pageObject.getCurPage();
            if(link!=null&&!link.equals(""))
            {
                sParams[0]=link;
            }
            if(script!=null&&!script.equals(""))
            {
                sParams[1]=script;
            }
        }
        getRequest().setAttribute("iPageObjectTag",iParams);
        getRequest().setAttribute("sPageObjectTag",sParams);
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag()
    {
        getRequest().removeAttribute("iPageObject");
        getRequest().removeAttribute("sPageObject");
        return EVAL_PAGE;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getScript() {
        return script;
    }


    public void setScript(String script) {
        this.script = script;

    }

    public PageObject getPageObject() {
        return pageObject;
    }

    public void setPageObject(PageObject pageObject) {
        this.pageObject = pageObject;
    }
}
