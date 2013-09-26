<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Spring 3 MVC - Contact Manager</title>
    <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css" />
    <script type="text/javascript">
    	function validateForm(){
    		var firstName = document.getElementById("firstname");
    		if(firstName.value == ""){
    			alert("Please insert first Name");
    			return false;
    		}else{
    			return true;
    		}
    	}
    </script>
</head>
<body>
<h2><spring:message code="label.title"/></h2>
<span style="float: right">
    <a href="?lang=en">en</a> 
    | 
    <a href="?lang=de">de</a>
</span>

<span style="float: left">
    <a href="?theme=default">def</a> 
    | 
    <a href="?theme=black">blk</a>
    | 
    <a href="?theme=blue">blu</a>
</span>


<form:form name="userInfo" method="post" action="addContact.html" onsubmit="return validateForm()">
 	<br>
 	<br>
 	<table>
    <tr>
        <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
        <td><form:input id="firstname" path="firstname" /></td> 
    </tr>
    <tr>
        <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
        <td><form:input path="lastname" /></td>
    </tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
        <td><form:input path="telephone" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addcontact"/>"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>