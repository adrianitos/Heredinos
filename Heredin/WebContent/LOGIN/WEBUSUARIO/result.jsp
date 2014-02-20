<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.io.*,java.util.*,java.sql.*"%>
	<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
	<% 
		int a=Integer.parseInt(request.getParameter("pene").trim());
		System.out.println(a);
	%>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://192.254.225.120:3306/kriptsof_heredin" user="kriptsof_admin1"  password="admin"/>
	<sql:query dataSource="${snapshot}" var="result">
		SELECT cartera.* FROM cartera,cartera_persona,persona WHERE persona.nomUser='admin' AND persona.id=cartera_persona.id_persona AND cartera.id=cartera_persona.id_cartera;
	</sql:query>
	<table>
	<tr>
		<td>ID</td>
		<td>Clau Publica</td>
		<td>Saldo</td>
	</tr>
	<c:set value="<%= a %>" var="idCartera"/>
	<c:forEach var="row" items="${result.rows}">
		<c:choose>
    		<c:when test="${ row.id==idCartera }">
      			<tr style="color:blue;">
					<td>${row.id}</td>
					<td>${row.adrPub}</td>
					<td>${row.saldo}</td>
				</tr>
      		</c:when>
      		<c:otherwise>
      			<tr>
					<td>${row.id}</td>
					<td>${row.adrPub}</td>
					<td>${row.saldo}</td>
				</tr>
      		</c:otherwise>
		</c:choose>		
	</c:forEach>
</table>
</body>
</html>