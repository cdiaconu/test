package test

class ProjectController {

	def projectService
	def employeeService
	def phaseService

	def index() {
		def projects = projectService.getAllProjects()
		render (view : 'index', model : [projects : projects])
	}

	def showCreate(Project project){
		def techLeads = employeeService.getAllTechnicalLeads()
		def managers = employeeService.getAllProjectManagers()
		def phases = phaseService.getPhases()

		render ( view : "create", model: [project : project, techLeads : techLeads, managers : managers, phases : phases])
	}
	
	def edit(Project project){
		def techLeads = employeeService.getAllTechnicalLeads()
		def managers = employeeService.getAllProjectManagers()
		def phases = phaseService.getPhases()

		render ( view : "update", model: [project : project, techLeads : techLeads, managers : managers, phases : phases])
	}

	def save(Project project){
		println params

		if (project && project.validate()){
			projectService.save(project)
		}
		else{
			project.errors.allErrors.each { println it }
			def techLeads = employeeService.getAllTechnicalLeads()
			def managers = employeeService.getAllProjectManagers()
			def phases = phaseService.getPhases()

			render ( view : "create", model : [project : project, techLeads : techLeads, managers : managers, phases : phases] )
			return
		}

		redirect (action : "index")
	}
	
	def update(Project project){
		if (project && project.validate()){
			projectService.update(project)
		}
		else{
			project.errors.allErrors.each { println it }
			def techLeads = employeeService.getAllTechnicalLeads()
			def managers = employeeService.getAllProjectManagers()
			def phases = phaseService.getPhases()

			render ( view : "update", model : [project : project, techLeads : techLeads, managers : managers, phases : phases] )
			return
		}

		redirect (action : "index")
		
	}
}
