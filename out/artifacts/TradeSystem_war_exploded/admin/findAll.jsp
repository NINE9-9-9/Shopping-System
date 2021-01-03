<%@ page import="main.java.entity.Commodity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 九
  Date: 2020/11/2
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <style>
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
    </style>
</head>
<body>
<div class="commodityList">
    <div class="container">
        <h3>All Products</h3>
        <%if(request.getAttribute("commodityList")!=null)
        {
            @SuppressWarnings("unchecked")
            List<Commodity> commodities = (List<Commodity>) request.getAttribute("commodityList");
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
                    <form id="<%=i*4+j%>" action="${pageContext.request.contextPath}/CommodityServlet" method="post">
                        <input type="hidden" value="<%=commodity.getName()%>" name="commodityName">
                        <input type="hidden" value = select name="action">
                    </form>
                    <a href="javascript:x(<%=i*4+j%>)" ><img src="<%=commodity.getImage()%>" alt=""></a>
                    <a href="javascript:x(<%=i*4+j%>);"><h4><%=commodity.getName()%></h4></a>
                    <p>$ <%=commodity.getPrice()%></p>
                </div>
            </div>
            <%}%>
        </div>

        <%}
        }%>


    </div>
</div>
</body>
</html>
