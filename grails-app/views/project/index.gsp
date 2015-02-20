<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${resource(dir: 'css', file: 'test.css')}" type="text/css">
<body>

	<div class="home">
		<g:link class="homePage" action="index">Home</g:link>&nbsp;|&nbsp;
		<g:link class="homePage" action="showCreate">Create Project</g:link>
	</div>
			
	<div class="title-box">
        <h2 class="title-box_primary">Projects Management</h2>
   	</div>
   	
   	<g:each in="${projects}" var="project" status="i">
	   	<table>
	   		<tr>
		    	<td>Project Name:</td>
		    	<td><g:link action="edit" id="${project.id}">${project.name}</g:link></td>		
			</tr>
			<tr>
		    	<td>Project Code:</td>
		    	<td><g:message message="${project.code}"/> </td>		
			</tr>
			<tr>
		    	<td>Technical Lead:</td>
		    	<td><g:message message="${project.techLead.firstName} ${project.techLead.lastName}"/> </td>		
			</tr>
			<tr>
		    	<td>Project Manager:</td>
		    	<td><g:message message="${project.projectManager.firstName} ${project.projectManager.lastName}"/> </td>		
			</tr>
			<tr>
		    	<td>Delivery Date:</td>
		    	<td><g:formatDate format="yyyy-MM-dd" date="${project.deliveryDate}"/></td>		
			</tr>
			<tr>
		    	<td>Current Phase:</td>
		    	<td><g:message message="${project.phase.name}"/> </td>		
			</tr>
			<tr>
		    	<td>Project Priority:</td>
		    	<td><g:message message="${project.priority}"/> </td>		
			</tr>
	   	</table>
	   	<br/>
   	</g:each>
   	
</body>
</html>