package test

import grails.test.GrailsMock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Project)
class ProjectSpec extends Specification {


	void "validate name and code alphanumeric fields"(){
		setup:
		mockForConstraintsTests(Project)

		when:
		def project1 = new Project('name' : value)
		then:
		validateConstraints(project1, 'name', error )

		when:
		def project2 = new Project('code' : value)
		then:
		validateConstraints(project2, 'code', error )

		where:
		error      | value
		'matches'  | "a_"
		'matches'  | "a!"
		'matches'  | "a%"
		'matches'  | "3^"
		'matches'  | "()"
		'valid'    | "123"
		'valid'    | "abc123"
		'valid'    | "a1b2c3"
		'valid'    | "validProjectName"
	}

	void "validate nullable fields"(){
		setup:
		mockForConstraintsTests(Project)

		when:
		def project = new Project("$field" : null)
		then:
		validateConstraints(project, field, error )

		where:
		error      | field      	  | value
		'nullable' | 'name' 		  | null
		'nullable' | 'code'		 	  | null
		'nullable' | 'techLead' 	  | null
		'nullable' | 'projectManager' | null
		'nullable' | 'deliveryDate'   | null
		'nullable' | 'phase' 		  | null
	}

	void "validate priority range - add new project"(){
		setup:
		mockForConstraintsTests(Project)

		when:
		mockExistingProjects(nrExistingProjects)
		def project = mockProject(priority)

		then:
		Project.count == nrExistingProjects
		validateConstraints(project, 'priority', error )

		where:
		error  		| priority | nrExistingProjects
		'valid'		| 	1	   |	0
		'validator' |	0	   |	0
		'validator' | 	2	   | 	0
		'valid'		| 	1      |	3
		'valid'		| 	4	   |	3
		'validator' | 	5	   | 	3
	}

	void "validate priority range - update project"(){
		setup:
		mockForConstraintsTests(Project)

		when:
		def testInstances = mockExistingProjects(nrExistingProjects)
		def project = testInstances[0]
		project.priority = priority

		then:
		Project.count == nrExistingProjects
		validateConstraints(project, 'priority', error )

		where:
		error  			| priority | nrExistingProjects
		'valid'			| 	1	   |	3
		'valid'			| 	2	   |	3
		'valid'			| 	3	   |	3
		'validator'		| 	0	   |	3
		'validator'		| 	4	   |	3
	}

	def mockExistingProjects(nrExistingProjects){
		def testInstances = []
		if (nrExistingProjects > 0){
			for ( i in 1..nrExistingProjects ) {
				def pr = mockProject(i)
				testInstances.push(pr)
			}
			mockDomain(Project, testInstances)
		}
		return testInstances
	}

	def mockProject(int priority){
		return  new Project(name : "name1", code : "code1", techLead : Mock(Employee), projectManager :  Mock(Employee), deliveryDate : new Date(), phase :  Mock(Phase), priority : priority)
	}

	void validateConstraints(project, field, error) {
		def validated = project.validate()
		if (error == 'valid'){
			assert !project.errors[field]
			return
		}

		assert !validated
		assert project.errors[field]
		if (error != 'validator'){
			assert error == project.errors[field]
		}
	}
}
