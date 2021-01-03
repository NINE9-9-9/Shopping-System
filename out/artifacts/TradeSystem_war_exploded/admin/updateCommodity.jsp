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
        <form action="${pageContext.request.contextPath}/UpdateServlet" method = "post" enctype="multipart/form-data">
            <center>
            <div>
            <h2>
                    Update Commodity.
            </h2>
            <table align = "center" border="0" cellpadding="0" cellspacing="20">
            <tr>
                <td>Commodity Name:</td>
                <td><input type="text" name = "commodityName"></td>
            </tr>
            <tr>
            <td>Amount:</td>
            <td><input type="text" name = "amount"></td>
            </tr>
            <tr>
            <td>Price:</td>
            <td><input type="text" name = "price"></td>
            </tr>
            <tr>
            <td>Type:</td>
            <td><input type="text" name = "type"></td>
            </tr>
            <tr>
            <td>Description:</td>
            <td><input type="text" name = "description"></td>
            </tr>
                <tr>
                    <td>Picture:</td>
                    <td><input type="file" name = "picture" value=""></td>
                </tr>
            </table>
                        <p>
                        <input type="submit" name = "action" value="update" id="sub">
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