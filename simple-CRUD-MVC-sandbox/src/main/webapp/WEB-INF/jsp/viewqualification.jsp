    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
   
    <a href="/SpringMVCCRUDSimple/">Home page</a>
	<a href="/SpringMVCCRUDSimple/viewemployee">Employees page</a>
  
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
    