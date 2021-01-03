<%@ page import="main.java.entity.Commodity" %><%--
  Created by IntelliJ IDEA.
  User: 九
  Date: 2020/10/31
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Commodity</title>
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
            width: 360px;
            height: 360px;
            margin-top: 50px;
            margin-left: 60px;
            display: inline-block;
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

        .brief{
            display: inline-block;
            margin-right: 230px;
            margin-top: 30px;
            float: right;
        }

        .brief h3
        {
            text-align: center;
            font-size: 36px;
        }
        .brief p
        {
            padding-right: 20px;
            margin-top: 10px;
            padding-left:20px ;
        }
        .inf {
            background-color: #d0d0d0;
             margin-top: 30px;

        }
        .description
        {
            margin-top: 30px;
        }
        .purchase input[type="text"]
        {
            width: 60px;
        }
        .amount
        {
            float: right;
        }

        .purchase input[type="text"]
        {
            text-align: right;
        }

        .purchase input[type="submit"]{
            width: 40%;
            background: #00a0dc;
            padding: 0.6em 2em;
            font-size:1em;
            text-transform: capitalize;
            color: #fff;
            text-decoration: none;
            font-weight: 500;
            border:none;
            outline:none;
            margin: 35px 0.1em 1em 7em;
            transition: 0.5s all;
            -webkit-transition: 0.5s all;
            -moz-transition: 0.5s all;
            -o-transition: 0.5s all;
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

<div class="result">
    <div class="container">
        <h3>Search Results</h3>
        <div class="search-condition">
            <ol class="search-left">
                <li>Search Condition: </li>
                <li><%=request.getAttribute("commodityName")%></li>
            </ol>
        </div>
    </div>
</div>

<div class="commodity">
    <div class="container">
        <%if(request.getAttribute("commodity")!=null){
            Commodity commodity = (Commodity) request.getAttribute("commodity");
        %>
        <img src="<%=commodity.getImage()%>" alt="">
        <div class="brief">
            <h3><%=commodity.getName()%></h3>
            <div class="inf">
                <p style="display: inline-block">Price: $ <%=commodity.getPrice()%></p>
                <p class="amount" style="display: inline-block">Amount: <%=commodity.getAmount()%></p>
            </div>

            <p class="description">Description: <%=commodity.getDescription()%></p>

            <form class="purchase" action="${pageContext.request.contextPath}/PurchaseServlet" method="post">
                <p>Purchase Number: <input type="text" value="1" required="required" name="amount"></p>
                <input type="hidden" value="<%=commodity.getName()%>" name="commodityName">
                <input type="submit" value="Purchase">
            </form>
        </div>

        <%}%>
    </div>
</div>
<%@include file="/footer.jsp" %>
</body>
</html>
