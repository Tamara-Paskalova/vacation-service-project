<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<style>
  <%@include file='/WEB-INF/views/css/blue_marine.css' %>
</style>
<html>
<head>
  <title>All vacations</title>
</head>
<body>
<h1 class="table_dark">All vacations:</h1>
<table border="1" class="table_dark">
  <tr>
    <th>ID</th>
    <th>Employee name</th>
    <th>Employee last name</th>
    <th>First Day</th>
    <th>Last Day</th>
    <th>Delete</th>
  </tr>
  <c:forEach var="vacation" items="${vacations}">
    <tr>
      <td>
        <c:out value="${vacation.id}"/>
      </td>
      <td>
        <c:out value="${vacation.employee.name}"/>
      </td>
      <td>
        <c:out value="${vacation.employee.lastName}"/>
      </td>
      <td>
        <c:out value="${vacation.firstDay}"/>
      </td>      <td>
      <c:out value="${vacation.lastDay}"/>
    </td>
      <td>
        <a href="/vacation/delete?id=${vacation.id}">DELETE</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
