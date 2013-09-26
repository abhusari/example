<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
/*
* creates a new XMLHttpRequest object which is the backbone of AJAX,
* or returns false if the browser doesn't support it
*/
function getXMLHttpRequest() {
 var xmlHttpReq = false;
 // to create XMLHttpRequest object in non-Microsoft browsers
 if (window.XMLHttpRequest) {
   xmlHttpReq = new XMLHttpRequest();
 } else if (window.ActiveXObject) {
   try {
     // to create XMLHttpRequest object in later versions
     // of Internet Explorer
     xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
   } catch (exp1) {
     try {
       // to create XMLHttpRequest object in older versions
       // of Internet Explorer
       xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
     } catch (exp2) {
       xmlHttpReq = false;
     }
   }
 }
 return xmlHttpReq;
}
/*
* AJAX call starts with this function
*/
function makeRequest() {
 var xmlHttpRequest = getXMLHttpRequest();
 xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);
 xmlHttpRequest.open("POST", "LoginServlet", true);
 xmlHttpRequest.setRequestHeader("Content-Type",
     "application/x-www-form-urlencoded");
 xmlHttpRequest.send("username=Henry&password=Ford");
}

/*
* Returns a function that waits for the state change in XMLHttpRequest
*/
function getReadyStateHandler(xmlHttpRequest) {

 // an anonymous function returned
 // it listens to the XMLHttpRequest instance
 return function() {
   if (xmlHttpRequest.readyState == 4) {
     if (xmlHttpRequest.status == 200) {
       var data = JSON.parse(xmlHttpRequest.responseText);
       alert(data.text);
       document.getElementById("hello").innerHTML = data.text;
     } else {
       alert("HTTP error " + xmlHttpRequest.status + ": " + xmlHttpRequest.statusText);
     }
   }
 };
}
</script>
</head>
<body>
	<form action="LoginServlet" method="post">
		User Name :- <input type="text" name="username"><br>
		Password :- <input type="password" name="password"><br>
		<label id="hello"></label>
		 <input type="button" name="submit" value="Login" onclick="makeRequest()">
	</form>
</body>
</html>