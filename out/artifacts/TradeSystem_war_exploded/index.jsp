<%@ page import="java.util.List" %>
<%@ page import="main.java.entity.Commodity" %><%--
  Created by IntelliJ IDEA.
  User: 九
  Date: 2020/10/7
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
      <title>BJTU G1 Trade System</title>
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
      </style>

</head>
<body>
<%@include file="/header.jsp" %>
<div class="container">
      <ol class="breadcrumb">
            <li><a href="index.jsp">Home</a></li>
            <li class="active"></li>
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

<div class="commodityList">
      <div class="container">
            <h3>Featured Products</h3>
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
<%@include file="/footer.jsp" %>
</body>
</html>

<script>
      function x(num)
      {
          var  select = document.getElementById(num);
          select.submit();
      }


</script>
