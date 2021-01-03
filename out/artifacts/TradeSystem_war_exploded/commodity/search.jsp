<%@ page import="main.java.entity.Commodity" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.tag.PageObject" %><%--
  Created by IntelliJ IDEA.
  User: 九
  Date: 2020/10/31
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Interface</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <style>
        .breadcrumb {
            padding: 1em 0;
            margin-bottom: 3em !important;
        }

        .breadcrumb a{
            margin-left: 20px;
        }



        form input[type="text"]{
            width: 60%;
            display: inline-block;
            font-size: 24px;
            margin-left: 120px;


        }
        form input[type="submit"]{

            display: inline-block;
            font-size: 24px;
            text-transform: capitalize;
            padding-left: 2em;
            padding-right: 2em;
        }

        img{
            width: 180px;
            height: 180px;
        }

        .product{
            padding-left: 40px;
        }
        .feature-grid {
            margin-top: 30px;
        }
        .product .arrival-info {
            text-align: center;
        }
        .search-condition
        {
            margin-top: 10px;
            background: #a2acae;
            height: 40px;
            color: black;

        }
        .search-left
        {
            margin-top: 10px;
            float: left;

        }
        .search-left li{

            display: inline-block;

        }

        .search-right li
        {
            display: inline-block;

        }
        .search-right
        {
            float: right;
            margin-top: 10px;
            margin-right: 30px;
        }

        .page {
            margin: 20px 0 0 400px;

        }
        .page-btn{
            display: inline-block;
            background: #00a0dc;
            padding: 0.6em 2em;
            font-size:1em;
            color: #fff;
        }

    </style>

</head>
<body>
<%@include file="/header.jsp" %>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
        <li class="active">Search</li>

    </ol>
</div>
<div class="search">
    <div class="container" >
        <form action="${pageContext.request.contextPath}/CommodityServlet" method="post">
            <input type="text" required="required" name="commodityName">
            <input type="submit" value="search" name="action">
        </form>
    </div>
</div>

    <%if(request.getAttribute("pageObject")!=null)
    {
        @SuppressWarnings("unchecked")
        PageObject pageObject = (PageObject) request.getAttribute("pageObject");
    %>
<div class="result">
    <div class="container">
        <h3>Search Results</h3>
        <div class="search-condition">
        <ol class="search-left">
            <li>Search Condition: </li>
            <li><%=request.getAttribute("commodityName")%></li>
        </ol>
        <ol class="search-right">
            <li>Total <%=pageObject.getDataCount()%> results</li>
        </ol>
    </div>
    </div>
</div>

<div class="commodityList">
    <div class="container">

    <%
            @SuppressWarnings("unchecked")
            List<Commodity> commodities =(List<Commodity>) pageObject.getData();
            int row = commodities.size()/4;
            if(commodities.size()%4!=0)
            {
                row++;
            }
            for(int i = 0 ; i<row ;i++)
            {

        %>
        <div class="feature-grid">
            <%for(int j=0;j<4;j++)
            {
                if(i*4+j>=commodities.size())
                {
                    break;
                }
                Commodity commodity = commodities.get((i)*4+j);
            %>
            <div class="col-lg-3 feature-grid product">
                <div class="arrival-info">
                    <form id = "<%=i*4+j%>" action="${pageContext.request.contextPath}/CommodityServlet" method="post">
                        <input type="hidden" value="<%=commodity.getName()%>" name="commodityName">
                        <input type="hidden" value = select name="action">
                    </form>
                    <a href="javascript:x(<%=i*4+j%>);"><img src="<%=commodity.getImage()%>" alt=""></a>
                    <a href="javascript:x(<%=i*4+j%>);"><h4><%=commodity.getName()%></h4></a>
                    <p>$ <%=commodity.getPrice()%></p>
                </div>
            </div>
            <%}%>
        </div>

        <%}%>

    </div>

</div>

<div class="page">
    <%if(pageObject.getCurPage()>1){
    %>
    <form style="display: none" id="lastPage" action="${pageContext.request.contextPath}/CommodityServlet" method="post">
        <input type="hidden" name="commodityName" value="<%=request.getAttribute("commodityName")%>">
        <input type="hidden" name="action" value="search">
        <input type="hidden" name="curPage" value="<%=(pageObject.getCurPage()-1)%>">
    </form>
    <a class="page-btn" href="javascript:last.submit();" >Last Page</a>


    <%}
    else
    {
    %>

    <p class="page-btn" >Last Page</p>
    <%}%>
    <p class="page-btn" >Current Page: <%=pageObject.getCurPage()%></p>

    <%if(pageObject.getCurPage()<pageObject.getPageCount()){

    %>
    <form style="display: none" id="nextPage" action="${pageContext.request.contextPath}/CommodityServlet" method="post">
        <input type="hidden" name="commodityName" value="<%=request.getAttribute("commodityName")%>">
        <input type="hidden" name="action" value="search">
        <input type="hidden" name="curPage" value="<%=(pageObject.getCurPage()+1)%>">
    </form>
    <a class="page-btn" href="javascript:next.submit();">Next Page</a>

    <%}
    else {
    %>
    <p class="page-btn" >Next Page</p>
    <%}%>
</div>
<%}%>
<%@include file="/footer.jsp" %>
</body>
</html>
<script>
    var select = document.getElementById("select");
    var next = document.getElementById("nextPage");
    var last = document.getElementById("lastPage");


    function x(num)
    {
        var  select = document.getElementById(num);
        select.submit();
    }

</script>

