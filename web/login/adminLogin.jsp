<%--
  Created by IntelliJ IDEA.
  User: 九
  Date: 2020/10/30
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta charset="UTF-8">
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

            .login_form p{
                color: #A7A7A7;
                line-height:1.8em;
                font-size:1em;
            }

            .login_form  {
                text-align: center;
                margin-top: 20px;

            }
            .login_sec h2{
                text-align: center;
                font-size: 36px;
            }

            .login_form form input[type="text"],.login_form form input[type="password"]{
                width: 25%;
                padding: 8px;
                font-size: 1em;
                font-weight: 400;
                border: 1px solid #D6D6D6;
                outline: none;
                color: #5d5959;
                margin-top: 20px;
            }

            .login_form form p
            {
                color: #b42916;
                margin-left: 30px;
            }

            .login_form form input[type="submit"]{
                width: 12%;
                display:inline-block;
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


            .login_form form input[type="submit"]:hover,a.signin-btn:hover{
                background:#caccce;
                color:#fff;
                text-decoration:none;
            }
        </style>
    </head>
<body>
<%@include file="/header.jsp" %>
<div class="login_sec">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
            <li class="active">Login</li>
        </ol>
        <h2>ADMIN LOGIN</h2>

        <div class="login_form" >
            <p>Please enter user name and password to login</p>
            <%if(request.getAttribute("success")!=null){%>
            <p><%=request.getAttribute("success")%></p>
            <%}%>
            <form action="<%=request.getContextPath()%>/AdminServlet" method="post" >
                <h4>UserName: <input type="text" value="" required="required" name="adminName"></h4>

                <h4>Password:  <input type="password" value="" required="required" name="adminPassword"></h4>
                <%if(request.getAttribute("error")!=null){%>
                <p><%=request.getAttribute("error")%></p>
                <%}%>
                <input type="submit" value="login" name = "action">

            </form>
        </div>

    </div>
</div>
<%@include file="/footer.jsp" %>

</body>

</html>
