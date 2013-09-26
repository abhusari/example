<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart Application</title>
</head>
<body>
	<h2>Product List</h2>
	<form:form commandName="product" method="post">
		<table>
			<tr>
				<th>Buy</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${product.productList}" var="entry">
   				 <tr>
					<td><input type="checkbox" value="check"></td>
					<td><c:out value="${entry.value.name}"/></td>
					<td>some price</td>
					<td><input type="text" value=></td>
				</tr>
			</c:forEach>
			<c:forEach items="${products}" var="pro">
				<tr>
					<td><input type="checkbox" value="check"></td>
					<td><c:out value="${pro.name}"/></td>
					<td>some price</td>
					<td><input type="text" value=></td>
				</tr>
			</c:forEach>
			
		</table>
		<br>
		<br>
		<input type="submit" value="Buy Now" name="_target1">
		<input type="submit" value="Cancel" name="_cancel">
		<input type="submit" value="Finish" name="_finish">
	</form:form>
</body>
</html>