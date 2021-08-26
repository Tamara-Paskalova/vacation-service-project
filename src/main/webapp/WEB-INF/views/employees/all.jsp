<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<style>
  <%@include file='/WEB-INF/views/css/blue_marine.css' %>
</style>
<html>
<head>
  <title>All employees</title>
</head>
<body>
<h1 class="table_dark">All employees:</h1>
<table border="1" class="table_dark">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Last Name</th>
    <th>Delete</th>
    <th>See all Employee's Vacations</th>
  </tr>
  <c:forEach var="employee" items="${employees}">
    <tr>
      <td>
        <c:out value="${employee.id}"/>
      </td>
      <td>
        <c:out value="${employee.name}"/>
      </td>
      <td>
        <c:out value="${employee.lastName}"/>
      </td>
      <td>
        <a href="/employee/delete?id=${employee.id}">DELETE</a>
      </td>
      <td>
        <a href="/vacation/by_employee?name=${employee.name}&lastName=${employee.lastName}">SEE ALL</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
