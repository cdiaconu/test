import test.Employee
import test.Phase
import test.Project
import test.Role

class BootStrap {

	def init = { servletContext ->

		Phase phase_briefing = new Phase(id: "1", name : "Briefing").save(failOnError : true)
		Phase phase_scoping = new Phase(id: "2", name : "Scoping").save(failOnError : true)
		Phase phase_interaction = new Phase(id: "3", name : "Interaction").save(failOnError : true)
		Phase phase_development = new Phase(id: "4", name : "Development").save(failOnError : true)
		Phase phase_qa = new Phase(id: "5", name : "Qa").save(failOnError : true)
		Phase phase_release = new Phase(id: "6", name : "Release").save(failOnError : true)
		
		servletContext.setAttribute("phases", Phase.list())

		Role role_lead = new Role(id: "1", positionTitle : "Technical Lead").save(failOnError : true)
		Role role_manager = new Role(id: "2", positionTitle : "Project Manager").save(failOnError : true)

		Employee lead_1 = new Employee(firstName : "Lead", lastName : "1", role : role_lead).save(failOnError : true)
		Employee lead_2 = new Employee(firstName : "Lead", lastName : "2", role : role_lead).save(failOnError : true)
		Employee lead_3 = new Employee(firstName : "Lead", lastName : "3", role : role_lead).save(failOnError : true)
		Employee manager_1 = new Employee(firstName : "Manager", lastName : "1", role : role_manager).save(failOnError : true)
		Employee manager_2 = new Employee(firstName : "Manager", lastName : "2", role : role_manager).save(failOnError : true)
		Employee manager_3 = new Employee(firstName : "Manager", lastName : "3", role : role_manager).save(failOnError : true)
		
		servletContext.setAttribute("leads", Employee.findAllByRole(role_lead, []))
		servletContext.setAttribute("managers", Employee.findAllByRole(role_manager, []))

		new Project(
				name : "name1",
				code : "code1",
				techLead : lead_1,
				projectManager : manager_1,
				deliveryDate : new Date(),
				phase : phase_qa,
				priority : 1).save(failOnError : true)
		new Project(
				name : "name2",
				code : "code1",
				techLead : lead_1,
				projectManager : manager_1,
				deliveryDate : new Date(),
				phase : phase_qa,
				priority : 2).save(failOnError : true)

		new Project(
				name : "name3",
				code : "code1",
				techLead : lead_1,
				projectManager : manager_1,
				deliveryDate : new Date(),
				phase : phase_qa,
				priority : 3).save(failOnError : true)
		new Project(
				name : "name4",
				code : "code1",
				techLead : lead_1,
				projectManager : manager_1,
				deliveryDate : new Date(),
				phase : phase_qa,
				priority : 4).save(failOnError : true)
		new Project(
				name : "name5",
				code : "code1",
				techLead : lead_1,
				projectManager : manager_1,
				deliveryDate : new Date(),
				phase : phase_qa,
				priority : 5).save(failOnError : true)
		new Project(
				name : "name6",
				code : "code1",
				techLead : lead_1,
				projectManager : manager_1,
				deliveryDate : new Date(),
				phase : phase_qa,
				priority : 6).save(failOnError : true)
		new Project(
				name : "name7",
				code : "code1",
				techLead : lead_1,
				projectManager : manager_1,
				deliveryDate : new Date(),
				phase : phase_qa,
				priority : 7).save(failOnError : true)
	}

	def destroy = {
	}
}
