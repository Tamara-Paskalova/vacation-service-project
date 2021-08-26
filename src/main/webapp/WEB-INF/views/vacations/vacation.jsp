<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<style>
    <%@include file='/WEB-INF/views/css/blue_marine.css' %>
</style>
<html>
<head>
    <title>Add vacation</title>
</head>
<body>
<form method="post">
    <h1 class="table_dark">Add vacation:</h1>
    <table border="1" class="table_dark">
        <tr>
            <th>Name</th>
            <th>Last Name</th>
            <th>First Day</th>
            <th>Last Day</th>
        </tr>
        <tr>
            <td>
                <input type="text" name="name"/>
            </td>
            <td>
                <input type="text" name="lastName"/>
            </td>
            <td>
                <input type="text" name="firstDay"/>
            </td>            <td>
            <input type="text" name="lastDay"/>
        </td>
            <td>
                <input type="submit" name="add"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
