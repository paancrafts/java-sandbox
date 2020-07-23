<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/styles.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <a onclick="document.forms['logoutForm'].submit()" class="log-out-link">Logout</a>
        <h2>Welcome <span class="name">${pageContext.request.userPrincipal.name}</span></h2>
<a href="/">Home page</a>
	<a href="/viewemployee">Employees page</a>
	
	<h1>Edit Employee</h1>
       <form method="POST" action="/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><input hidden  path="id" /></td>
         </tr> 
         <tr>  
          <td>First name : </td> 
          <td><input path="firstName"  /></td>
         </tr>  
         <tr>  
          <td>Last name :</td>  
          <td><input path="lastName" /></td>
         </tr> 
         <tr>  
          <td>Personal Id :</td>  
          <td><input path="personalId" /></td>
         </tr>
         <tr>  
          <td>Designation :</td>  
          <td><input path="designation" /></td>
         </tr> 
         <tr>  
          <td>Archived :</td>  
          <td><checkbox path="archived" /></td>
         </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save"  class="btn-primary"/></td>  
         </tr>  
        </table>  
       </form> 
    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
       