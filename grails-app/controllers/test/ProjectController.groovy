package test

class ProjectController {

	def projectService

	def index() {
		def projects = projectService.getAllProjects()
		render (view : 'index', model : [projects : projects])
	}

	def create(){
		def project = new Project()
		bindData(project, params, [include: [
				'name',
				'code',
				'deliveryDate',
				'priority'
			]])
		render ( view : "create", model: [project : project])
	}

	def update(){
		def project = projectService.get(params.id)
		render ( view : "create", model: [project : project])
	}

	def save(Project project){
		if (project && project.validate()){
			projectService.save(project)
			redirect action : "index"
			return
		}
		render ( view : "create", model : [project : project] )
	}

	def delete(Project project){
		if (project){
			projectService.delete(project);
		}
		redirect action : "index"
	}
}
