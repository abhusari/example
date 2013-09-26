<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="sendhere.html" method="post">
		Select Student with role number. <select id="rollNo" name="rollNo">
			<%
				for (int i = 1; i <= 10; i++) {
			%>
			<option>
				<%
					out.print(i);
				%>
			</option>
			<%
				}
			%>
		</select> 
		<input type="submit" value="Submit">
		<%-- <c:if test="${student}==null"> --%>
			<br><br><br>
			<table border="1px" cellpadding="0px" cellspacing="0">
				<tr>
					<td><h2>Roll No</h2></td>
					<td><h2>Student Name</h2></td>
					<td><h2>Result</h2></td>
				</tr>
				<tr>
					<td>${student.rollNo}</td>
					<td>${student.name}</td>
					<td>${student.result}</td>
				</tr>
			</table>
	<%-- 	</c:if> --%>
	</form>
</body>
</html>