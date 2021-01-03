<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style type="text/css">
            div
            {
                display:inline-block;
                padding-top: 80px;
                padding-right: 20px;
            }
            h2
            {font-family: "微软雅黑";font-size: 40px;color:black;}
        </style>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/CommodityServlet" method = "post" target="_top">
            <center>
            <div>
            <h2>
                    Find ALL Commodities.
            </h2>
            <table align = "center" border="0" cellpadding="0" cellspacing="20">
            <tr>
            </table>
                        <p>
                        <input type="submit" name = "action" value="findAll" id="sub">
                        </p>
            </div>
            </center>
        </form>

        <%
            if(request.getAttribute("error") != null){
        %>
        <div class="alert-div">
            <a href=" " class="close">
                &times;
            </a>
            <strong>WARNING！</strong><span class="tips-text"><%= request.getAttribute("error") %></span>
        </div>
        <%
            }
        %>

    </body>
</html>