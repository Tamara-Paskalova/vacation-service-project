<%@ page contentType="text/html;charset=UTF-8" %>
<style>
    <%@include file='/WEB-INF/views/css/blue_marine.css' %>
</style>
<html>
<head>
    <title>My team</title>
</head>
<body>
<form method="post" id="redirect"></form>
<h1 class="table_dark">Welcome to Vacation Service</h1>
<table class="table_dark">
    <tr>
        <th>Redirect to</th>
    </tr>
    <tr><td><a href="${pageContext.request.contextPath}/employee">Add Employee</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/employee/all/">Display All Employees</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/vacation/all">Display all Vacations</a> </td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/vacation">Add Vacation</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/employee/all">Get Vacation by Employee</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/vacation/all">Delete Vacation</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/employee/all">Delete Employee</a></td></tr>
</table>
</body>
</html>
