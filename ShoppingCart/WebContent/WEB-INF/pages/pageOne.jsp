<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="product" method="post">
		<table>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<tr>
				<td>
					<%
						/* String c = request.getParameter("choice");
							out.println(c); */
					%>
				</td>
				<td>some</td>
				<td>
					<%
						String q = request.getParameter("quantity");
							out.println(q);
					%>
				</td>

			</tr>
		</table>
		<input type="submit" value="Next" name="_target2"/>
		<input type="submit" value="Cancel" name="_cancel">
	</form:form>
</body>
</html>