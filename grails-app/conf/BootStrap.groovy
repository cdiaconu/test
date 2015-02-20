import test.Employee
import test.Phase
import test.Project
import test.Role

class BootStrap {

	def init = { servletContext ->

		Phase phase_briefing = new Phase(name : "Briefing").save(failOnError : true)
		Phase phase_scoping = new Phase(name : "Scoping").save(failOnError : true)
		Phase phase_interaction = new Phase(name : "Interaction").save(failOnError : true)
		Phase phase_development = new Phase(name : "Development").save(failOnError : true)
		Phase phase_qa = new Phase(name : "Qa").save(failOnError : true)
		Phase phase_release = new Phase(name : "Release").save(failOnError : true)

		Role role_lead = new Role(positionTitle : "Technical Lead").save(failOnError : true)
		Role role_manager = new Role(positionTitle : "Project Manager").save(failOnError : true)

		Employee lead_1 = new Employee(firstName : "Lead", lastName : "1", role : role_lead).save(failOnError : true)
		Employee lead_2 = new Employee(firstName : "Lead", lastName : "2", role : role_lead).save(failOnError : true)
		Employee lead_3 = new Employee(firstName : "Lead", lastName : "3", role : role_lead).save(failOnError : true)
		Employee manager_1 = new Employee(firstName : "Manager", lastName : "1", role : role_manager).save(failOnError : true)
		Employee manager_2 = new Employee(firstName : "Manager", lastName : "2", role : role_manager).save(failOnError : true)
		Employee manager_3 = new Employee(firstName : "Manager", lastName : "3", role : role_manager).save(failOnError : true)

		new Project(
				name : "name1",
				code : "code1",
				techLead : lead_1,
				projectManager : manager_1,
				deliveryDate : new Date(),
				phase : phase_qa,
				priority : 1).save(failOnError : true)
	}

	def destroy = {
	}
}
