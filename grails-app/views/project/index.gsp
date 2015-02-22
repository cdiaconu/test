<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${resource(dir: 'css', file: 'test.css')}" type="text/css">
<body>

	<div class="home">
		<g:link class="homePage" action="index">Home</g:link>&nbsp;|&nbsp;
		<g:link class="homePage" action="create">Create Project</g:link>
	</div>
			
	<div class="title-box">
        <h2 class="title-box_primary">Projects Management</h2>
   	</div>
   	
   	<table class="projects-list" cellspacing="0" cellpadding="10" border="0">
   		<thead>
   		 	<tr>
   		 		<td>Project Name</td>
   		 		<td>Project Code</td>
   		 		<td>Technical Lead</td>
   		 		<td>Project Manager</td>
   		 		<td>Delivery Date</td>
   		 		<td>Current Phase</td>
   		 		<td>Project Priority</td>
   		 		<td>&nbsp;</td>
   		 	</tr>
   		</thead>
   		<g:each in="${projects}" var="project" status="i">
	   		<tr>
		    	<td><g:link class="update-link" action="update" id="${project.id}">${project.name}</g:link></td>		
		    	<td><g:message message="${project.code}"/></td>		
		    	<td><g:message message="${project.techLead.firstName} ${project.techLead.lastName}"/> </td>		
		    	<td><g:message message="${project.projectManager.firstName} ${project.projectManager.lastName}"/> </td>		
		    	<td><g:formatDate format="yyyy-MM-dd" date="${project.deliveryDate}"/></td>		
		    	<td><g:message message="${project.phase.name}"/> </td>		
		    	<td><g:message message="${project.priority}"/> </td>
		    	<td>		
					<g:link class="delete-image" action="delete" id="${project.id}">
	            		<img title="Delete Project" src="${resource(dir:'images',  file:'icon_delete.png')}"/>
	            	</g:link>
            	</td>
			</tr>
   		</g:each>
   	</table>
   	
</body>
</html>