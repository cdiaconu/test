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
   	
   	<div class="content">
	   	<div class="add-new">
	   		<g:form controller="project">
	   			<div><span class="required-indicator">*</span></div>
	           	<div>
	           		<g:textField class="project-input ${hasErrors(bean:project, field:'name','errors')}" placeholder="Name" value="${project?.name}" name="name"/>
	           	</div>
	           	<div><span class="required-indicator">*</span></div>
	           	<div>
	           		<g:textField class="project-input ${hasErrors(bean:project, field:'name','errors')}" placeholder="Project Code" value="${project?.code}" name="code"/>
	           	</div>
	           	<div>
	           		<g:select optionKey="id" optionValue="fullName" name="techLead" from="${techLeads}"/>
	           	</div>
	           	<div>
	           		<g:select optionKey="id" optionValue="fullName" name="projectManager" from="${managers}"/>
	           	</div>
	           	<div>
	           		<g:datePicker name="deliveryDate" value="${new Date()}" precision="day" />
	           	</div>
	           	<div>
	           		<g:select optionKey="id" optionValue="name" name="phase" from="${phases}"/>
	           	</div>
	           	<div>
	           		<g:textField class="project-input ${hasErrors(bean:project, field:'priority','errors')}" placeholder="Priority" value="${project?.priority}" name="priority"/>
	           	</div>
	           	<div><g:actionSubmit class="artist-add" value="Add New Project" action="save"/></div>
	      	 </g:form>
	   	</div>
	   	
	   	<div class="errMessage"><g:renderErrors bean="${project}" /></div>
	   	
	</div>
</body>
</html>