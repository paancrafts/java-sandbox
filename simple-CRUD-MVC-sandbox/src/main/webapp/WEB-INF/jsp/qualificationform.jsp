<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
	<a href="/SpringMVCCRUDSimple/">Home page</a>
	<a href="/SpringMVCCRUDSimple/viewemployee">Employees page</a>
		<h1>Add New Qualification</h1>
		<h2>${emp.firstName} ${emp.lastName}</h2>
       <form:form method="post" action="save">  
      	<table >  
      	 <tr>  
          <td><form:hidden path="employeeId" value="${ emp.id }" /></td>
         </tr>  
         <tr>  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="qualification"  /></td>
         </tr>  
         <tr>  
          <td>Level :</td>  
          <td><form:input path="level" /></td>
         </tr> 
         <tr> 
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
       <br>
  
