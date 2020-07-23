    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

    <a href="/SpringMVCCRUDSimple/">Home page</a>
	<a href="/SpringMVCCRUDSimple/viewemployee">Employees page</a>
    
	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr>
	<th>Id</th>
	<th>First name</th>
	<th>Last name</th>
	<th>Person ID</th>
	<th>Designation</th>
	<th>Date</th>
	<th>Qualifications</th>
	<th>Edit</th>
	<th>Delete</th>
	<th>Archived</th></tr>
    <c:forEach var="emp" items="${list}">
    <tr>
    <td>${emp.id}</td>
    <td>${emp.firstName}</td>
    <td>${emp.lastName}</td>
    <td>${emp.personalId}</td>
    <td>${emp.designation}</td>
    <td>${emp.date}</td>
    <td><a href="qualification/viewqualification/${emp.id}">View qualifications</a></td>
    <td><a href="editemployee/${emp.id}">Edit</a></td>
    <td><a href="deleteemployee/${emp.id}">Delete</a></td>
    <td><input type="checkbox" <c:if test="${emp.archived}">checked</c:if>/></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="employeeform">Add New Employee</a>