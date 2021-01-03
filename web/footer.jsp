<%--
  Created by IntelliJ IDEA.
  User: 九
  Date: 2020/10/29
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <style>
    .shopping{
    background: #eee;
    margin-top: 3em;
    padding: 2em 0;

    }
    .shpng-grids{}

    .shpng-grid{
    text-align:center;
    }
    .shpng-grid h3{
    font-size:2em;
    text-transform:uppercase;
    color:#333;
    }
    .shpng-grid:nth-child(2){
    border-left:2px solid rgba(51, 51, 51, 0.29);
    border-right:2px solid rgba(51, 51, 51, 0.29);
    }
    .shpng-grid p{
    color:rgba(189, 0, 0, 0.8);
    font-size: 1.6em;
    text-transform:uppercase;
    padding-top:5px;
    }

    .footer{
    padding:3em 0 2em;
    }
    .ftr-grid h4 {
    color: #646464;
    display: block;
    border-bottom: 1px solid #E5E5E5;
    padding-bottom: 5px;
    font-size: 1.3em;
    text-align: left;
    }
    .ftr-grid ul li{
    display:block;

    }
    .ftr-grid ul{
    padding-left: 0;
    }
    .ftr-grid ul li:nth-child(1) {
    margin-top: 1em;

    }
    .ftr-grid ul li a {
    color: #777;
    padding: 3px 0;
    display: block;
    font-size:1em;
    text-align: left;


    }
    .ftr-grid ul li a:hover{
    text-decoration:none;
    color:#00a0dc;
    }
    </style>
</head>
<body>
<div class="shopping">
    <div class="container">
        <div class="shpng-grids">
            <div class="col-md-4 shpng-grid">
                <h3>Free Shipping</h3>
                <p>On Order Over 99$</p>
            </div>
            <div class="col-md-4 shpng-grid">
                <h3>Order Return</h3>
                <p>Return Within 14days</p>
            </div>
            <div class="col-md-4 shpng-grid">
                <h3>COD</h3>
                <p>Cash On Delivery</p>
            </div>

        </div>
    </div>
</div>
<div class="footer">
    <div class="container">
        <div class="ftr-grids">
            <div class="col-md-3 ftr-grid">
                <h4>About Us</h4>
                <ul>
                    <li><a href="#">Who We Are</a></li>
                    <li><a href="#">Contact Us</a></li>
                    <li><a href="#">Team</a></li>

                </ul>
            </div>
            <div class="col-md-3 ftr-grid">
                <h4>Customer Service</h4>
                <ul>
                    <li><a href="#">FAQ</a></li>
                    <li><a href="#">Shipping</a></li>
                    <li><a href="#">Return</a></li>
                </ul>
            </div>
            <div class="col-md-3 ftr-grid">
                <h4>Your Account</h4>
                <ul>
                    <li><a href="#">Your Account</a></li>
                    <li><a href="#">Track Order</a></li>
                    <li><a href="#">Personal Information</a></li>

                </ul>
            </div>
            <div class="col-md-3 ftr-grid">
                <h4>Categories</h4>
                <ul>
                    <li><a href="#">> Food</a></li>
                    <li><a href="#">> Cloth</a></li>
                    <li><a href="#">> Digital</a></li>
                </ul>
            </div>

        </div>
    </div>
</div>
</body>
</html>
