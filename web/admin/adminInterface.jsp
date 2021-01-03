<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; %>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>BJTU G1 Trade System</title>
<link href="<%=request.getContextPath()%>/css/lanrenzhijia.css" type="text/css" rel="stylesheet" />
<style type="text/css">
.dr{
	height: 600px;
	margin-left: 200px;
}
</style>
</head>
<%@include file="/header.jsp"%>
<body>
							<ul class="sidenav">
								<li><a href="<%=request.getContextPath()%>/admin/updateCommodity.jsp" target="Frame">Update Commodity
								<span>Update the information of a commodity.</span></a></li>
								<li><a href="<%=request.getContextPath()%>/admin/deleteCommodity.jsp" target="Frame">Delete Commodity
                                <span>Delete a commodity.</span></a></li>
								<li><a href="<%=request.getContextPath()%>/admin/addCommodity.jsp" target="Frame">Add Commodity
                                <span>Add a commodity.</span></a></li>
                                <li><a href="<%=request.getContextPath()%>/admin/selectCommodity.jsp" target="Frame">Select Commodity
                                <span>Select a commodity.</span></a></li>
                                <li><a href="<%=request.getContextPath()%>/admin/findAllTypeCommodity.jsp" target="Frame">Find All Commodities
                                <span>>Find all commodities.</span></a></li>
							</ul>
				<div class="dr">
				<iframe id="Frame" name="Frame" th:src="@{updateCommodity.jsp}" style="overflow: visible;"
                scrolling="yes" frameborder="no" width="100%" height="100%"></iframe>
				</div>
</body>
<%@include file="/footer.jsp"%>
</html>


