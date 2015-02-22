<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${resource(dir: 'css', file: 'test.css')}" type="text/css">
<body>

	<div class="home">
		<g:link class="homePage" action="index">Home</g:link>
	</div>
			
	<div class="title-box">
        <h2 class="title-box_primary">Projects Management</h2>
   	</div>
   	
   	<div class="content-add">
	   	<div class="add-new">
	   		<g:form controller="project">
	   			<g:hiddenField name="id" value="${project?.id}" />
	   			<div>
	   				<span>Project Name:</span>
	   				<span class="required-indicator">*</span>
	   				<g:textField class="project-input ${hasErrors(bean:project, field:'name','errors')}" placeholder="Name" value="${project?.name}" name="name"/>
	   			</div>
	   			
	   			<div>
	   				<span>Project Code:</span>
	   				<span class="required-indicator">*</span>
	   				<g:textField class="project-input ${hasErrors(bean:project, field:'code','errors')}" placeholder="Project Code" value="${project?.code}" name="code"/>
	   			</div>
	   			
	   			<div>
	   				<span>Technical Lead:</span>
	   				<span class="required-indicator">&nbsp;</span>
	   				<g:select optionKey="id" optionValue="fullName" name="techLead" from="${techLeads}"/>
	   			</div>
	   			
	           	<div>
	           		<span>Project Manager:</span>
	           		<span class="required-indicator">&nbsp;</span>
	           		<g:select optionKey="id" optionValue="fullName" name="projectManager" from="${managers}"/>
	           	</div>
	           	
	           	<div>
	           		<span>Delivery Date:</span>
	           		<span class="required-indicator">&nbsp;</span>
	           		<g:datePicker name="deliveryDate" value="${new Date()}" precision="day" />
	           	</div>
	           	
	           	<div>
	           		<span>Project Phase:</span>
	           		<span class="required-indicator">&nbsp;</span>
	           		<g:select optionKey="id" optionValue="name" name="phase" from="${phases}"/>
	           	</div>
	           	
	           	<div>
	           		<span>Priority:</span>
	           		<span class="required-indicator">&nbsp;</span>
	           		<g:textField class="project-input ${hasErrors(bean:project, field:'priority','errors')}" placeholder="Priority" 
	           		 value="${hasErrors(bean: project, field: 'priority', '1') || fieldValue(bean: project, field: 'priority')=="0" ? '' : fieldValue(bean: project, field: 'priority')}" name="priority"/>
	           	</div>
	           	
	           	<div class="project-add-content"><g:actionSubmit class="project-add" value="Save" action="save"/></div>
	      	 </g:form>
	   	</div>
	   	
	   	<div class="errMessage"><g:renderErrors bean="${project}" /></div>
	   	
	</div>
</body>
</html>