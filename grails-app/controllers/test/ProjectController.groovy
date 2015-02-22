package test

class ProjectController {

	def projectService
	def employeeService
	def phaseService
  
	def index() {
		def projects = projectService.getAllProjects()
		render (view : 'index', model : [projects : projects])
	}

	def create(){
		def project = new Project()
		bindData(project, params, [include: ['name', 'code', 'techLead', 'projectManager', 'deliveryDate', 'phase', 'priority']])

		def techLeads = employeeService.getAllTechnicalLeads()
		def managers = employeeService.getAllProjectManagers()
		def phases = phaseService.getPhases()

		render ( view : "create", model: [project : project, techLeads : techLeads, managers : managers, phases : phases])
	}
	
	def update(){
		def project = Project.get(params.id)

		def techLeads = employeeService.getAllTechnicalLeads()
		def managers = employeeService.getAllProjectManagers()
		def phases = phaseService.getPhases()

		render ( view : "create", model: [project : project, techLeads : techLeads, managers : managers, phases : phases])
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

		redirect action : "index"
	}

	def delete(Project project){
		if (project){
			projectService.delete(project);
		}
		redirect action : "index"
	}
}
