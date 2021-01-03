<%--
  Created by IntelliJ IDEA.
  User: 九
  Date: 2020/10/29
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <style>
        .header_top {
            background: #1a1818;
        }
        .header_top-sec {
            padding: 0.7em 0;
        }
        .top_left{
            float: left;
            color:#fff;
        }
        .top_right {
            float: right;
            color:#fff;
        }
        .top_right a{
            color:#fff;
        }

        .header_top2 {
            background: #5fd2f2;
        }
        .header_bottom
        {
            padding: 0.5em 0.5em 1em;
        }

        .logo  a h1{
            color: #ffffff;
            font-family: 'Times New Roman';
            font-size: 48px;
            font-weight: 100;
        }
        .logo a h1:hover{
            text-decoration:none;
            display:inline-block;
        }
        .logo{
            float:left;
        }
        .top_nav{

            width:60%;
            margin: 20px auto 0 100px;
            display: inline-block;
            float: left;
        }

        .header_top-sec ul {
            padding:0;
            list-style:none;
            display: inline-block;
            vertical-align: middle;

        }
        .header_top-sec li
        {
            display: inline-block;
            text-align:center;
            vertical-align: middle;
        }
        .cart_box{
            padding: 30px 30px 0 0;
            display: inline-block;
            float: right;
            font-size: 36px;
        }

        .menu, .menu ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }
        .menu {
            height: 0px;
        }
        .menu li {
            background: -moz-linear-gradient(#5fd2f2, #ffffff);
            background: -ms-linear-gradient(#ce6a7c, #5fd2f2);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #5fd2f2), color-stop(100%, #5fd2f2));
            background: -webkit-linear-gradient(#292929, #7aeaf2);
            background: -o-linear-gradient(#292929, #7aeaf2);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#292929', endColorstr='#252525');
            -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#292929', endColorstr='#252525')";
            background: linear-gradient(#292929, #252525);

            border-bottom: 2px solid #181818;
            border-top: 2px solid #303030;
            min-width: 200px;
        }
        .menu > li {
            display: block;
            float: left;
            position: relative;
        }
        .menu > li:first-child {
            border-radius: 5px 0 0;
        }
        .menu a {
            border-left: 3px solid rgba(0, 0, 0, 0);
            color: #ffffff;
            display: block;
            font-family: 'Lucida Console';
            font-size: 18px;
            line-height: 54px;
            padding: 0 25px;
            text-decoration: none;
            text-transform: uppercase;
            text-align: center;

        }

        .menu li:hover {
            background-color: #5fd2f2;
            background: -moz-linear-gradient(#a7f2f2, #5fd2f2);
            background: -ms-linear-gradient(#7aeaf2, #1b1b1b);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #5fd2f2), color-stop(100%, #1b1b1b));
            background: -webkit-linear-gradient(#1c1c1c, #1b1b1b);
            background: -o-linear-gradient(#1c1c1c, #1b1b1b);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#1c1c1c', endColorstr='#1b1b1b');
            -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#1c1c1c', endColorstr='#1b1b1b')";
            background: linear-gradient(#1c1c1c, #1b1b1b);

            border-bottom: 2px solid #222222;
            border-top: 2px solid #1B1B1B;
        }
        .menu li:hover > a {
            border-radius: 5px 0 0 0;
            border-left: 3px solid #C4302B;
            color: #C4302B;
        }

        .submenu {
            left: 0;
            max-height: 0;
            position: absolute;
            top: 100%;
            z-index: 0;

            -webkit-perspective: 400px;
            -moz-perspective: 400px;
            -ms-perspective: 400px;
            -o-perspective: 400px;
            perspective: 400px;
        }
        .submenu li {
            opacity: 0;

            -webkit-transform: rotateY(90deg);
            -moz-transform: rotateY(90deg);
            -ms-transform: rotateY(90deg);
            -o-transform: rotateY(90deg);
            transform: rotateY(90deg);

            -webkit-transition: opacity .4s, -webkit-transform .5s;
            -moz-transition: opacity .4s, -moz-transform .5s;
            -ms-transition: opacity .4s, -ms-transform .5s;
            -o-transition: opacity .4s, -o-transform .5s;
            transition: opacity .4s, transform .5s;
        }
        .menu .submenu li:hover a {
            border-left: 3px solid #454545;
            border-radius: 0;
            color: #ffffff;
        }
        .menu > li:hover .submenu, .menu > li:focus .submenu {
            max-height: 2000px;
            z-index: 10;
        }
        .menu > li:hover .submenu li, .menu > li:focus .submenu li {
            opacity: 1;
            -webkit-transform: none;
            -moz-transform: none;
            -ms-transform: none;
            -o-transform: none;
            transform: none;
        }

        .menu li:hover .submenu li:nth-child(1) {
            -webkit-transition-delay: 0s;
            -moz-transition-delay: 0s;
            -ms-transition-delay: 0s;
            -o-transition-delay: 0s;
            transition-delay: 0s;
        }
        .menu li:hover .submenu li:nth-child(2) {
            -webkit-transition-delay: 50ms;
            -moz-transition-delay: 50ms;
            -ms-transition-delay: 50ms;
            -o-transition-delay: 50ms;
            transition-delay: 50ms;
        }
        .menu li:hover .submenu li:nth-child(3) {
            -webkit-transition-delay: 100ms;
            -moz-transition-delay: 100ms;
            -ms-transition-delay: 100ms;
            -o-transition-delay: 100ms;
            transition-delay: 100ms;
        }
        .menu li:hover .submenu li:nth-child(4) {
            -webkit-transition-delay: 150ms;
            -moz-transition-delay: 150ms;
            -ms-transition-delay: 150ms;
            -o-transition-delay: 150ms;
            transition-delay: 150ms;
        }
        .menu li:hover .submenu li:nth-child(5) {
            -webkit-transition-delay: 200ms;
            -moz-transition-delay: 200ms;
            -ms-transition-delay: 200ms;
            -o-transition-delay: 200ms;
            transition-delay: 200ms;
        }


        .submenu li:nth-child(1) {
            -webkit-transition-delay: 350ms;
            -moz-transition-delay: 350ms;
            -ms-transition-delay: 350ms;
            -o-transition-delay: 350ms;
            transition-delay: 350ms;
        }
        .submenu li:nth-child(2) {
            -webkit-transition-delay: 300ms;
            -moz-transition-delay: 300ms;
            -ms-transition-delay: 300ms;
            -o-transition-delay: 300ms;
            transition-delay: 300ms;
        }
        .submenu li:nth-child(3) {
            -webkit-transition-delay: 250ms;
            -moz-transition-delay: 250ms;
            -ms-transition-delay: 250ms;
            -o-transition-delay: 250ms;
            transition-delay: 250ms;
        }
        .submenu li:nth-child(4) {
            -webkit-transition-delay: 200ms;
            -moz-transition-delay: 200ms;
            -ms-transition-delay: 200ms;
            -o-transition-delay: 200ms;
            transition-delay: 200ms;
        }
        .submenu li:nth-child(5) {
            -webkit-transition-delay: 150ms;
            -moz-transition-delay: 150ms;
            -ms-transition-delay: 150ms;
            -o-transition-delay: 150ms;
            transition-delay: 150ms;
        }
    </style>
</head>
<body>
<div class="header_top">
    <div class="container" >
        <div class="header_top-sec" >
            <div class="top_left">
                <ul>
                    <li>HELP</li> |
                    <li>CONTACT</li>
                </ul>
            </div>
            <div class="top_right">
                <%if(request.getSession().getAttribute("userName")==null&&request.getSession().getAttribute("adminName")==null){%>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/login/login.jsp">Login</a></li> |
                    <li><a href="<%=request.getContextPath()%>/login/register.jsp">Sign in</a></li> |
                    <li><a href="<%=request.getContextPath()%>/login/adminLogin.jsp">Admin</a></li>
                </ul>
                <%}
                else if(request.getSession().getAttribute("userName")!=null){%>
                <ul>
                    <li>Welcome <%=request.getSession().getAttribute("userName")%></li> |
                    <li><a href="${pageContext.request.contextPath}/user/userInfo.jsp"> My Account</a></li> |
                    <li><a href="*">Track Order</a></li> |
                    <li><a href="${pageContext.request.contextPath}/UserServlet?action=logOut">Log out</a></li>
                </ul>
                <%}
                else if(request.getSession().getAttribute("adminName")!=null)
                {%>
                <ul>
                    <li>Welcome <%=request.getSession().getAttribute("adminName")%></li> |

                    <li><a href="${pageContext.request.contextPath}/AdminServlet?action=logOut">Log out</a></li>
                </ul>
                <%}%>
            </div>
        </div>
    </div>
</div>
<div class="header_top2">
    <div class="header_bottom">
        <div class="container">
            <div class="logo">
                <a href="<%=request.getContextPath()%>/index.jsp"><h1>BJTU STORE</h1></a>
            </div>
            <div class="top_nav">
                <ul class="menu">
                    <li>

                        <a href="<%=request.getContextPath()%>/index.jsp">HOME</a></li>
                    <li><a href="#">PRODUCT</a>
                        <ul class="submenu">
                            <li>
                                <form style="display:none;" id="food" action="${pageContext.request.contextPath}/CommodityServlet" method="post">
                                    <input type="hidden" value = "food" name="type">
                                    <input type="hidden" value = "searchType" name="action">
                                </form>
                                <a href="javascript:food.submit()">FOOD</a></li>
                            <li>
                                <form style="display:none;" id="cloth" action="${pageContext.request.contextPath}/CommodityServlet" method="post">
                                    <input type="hidden" value = "cloth" name="type">
                                    <input type="hidden" value = "searchType" name="action">
                                </form>
                                <a href="javascript:cloth.submit()">CLOTH</a></li>
                            <li>
                                <form style="display:none;" id="digital" action="${pageContext.request.contextPath}/CommodityServlet" method="post">
                                    <input type="hidden" value = "digital" name="type">
                                    <input type="hidden" value = "searchType" name="action">
                                </form>
                                <a href="javascript:digital.submit()">DIGITAL</a></li>

                        </ul>
                    </li>

                    <li><a href="#">CONTACT</a>

                    </li>
                </ul>
            </div>
            <div class="cart_box">
                <a href="*">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></h3>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script>
    var food = document.getElementById("food");
    var cloth = document.getElementById("cloth");
    var digital = document.getElementById("digital");
</script>