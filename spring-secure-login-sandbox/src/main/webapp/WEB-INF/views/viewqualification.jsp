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
<div class="container qual-list-view">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <a onclick="document.forms['logoutForm'].submit()" class="log-out-link">Logout</a>
        <h2>Welcome <span class="name">${pageContext.request.userPrincipal.name}</span></h2>
        <a href="/">Home page</a>
		<a href="/viewemployee">Employees page</a>
	  
		<h1>Qualifications List</h1>
		<table border="2" width="70%" cellpadding="2">
		<tr>
		<th>Name</th>
		<th>Level</th>
		<th>Delete</th>
		</tr>
	    <c:forEach var="qual" items="${list}"> 
	    <tr>
	    <td>${qual.qualification}</td>
	    <td>${qual.level}</td>
	    <td><a href="../deletequalification/${qual.id}">Delete</a></td>
	    </tr>
	    </c:forEach>
	    </table>
	    <br/>
	    <a href="../qualificationform/${emp.id}">Add New Qualification</a>

    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
       