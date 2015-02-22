package test

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ProjectController)
@Mock([Project])
class ProjectControllerSpec extends Specification {

	def projectMockService;

	def setup() {
		projectMockService = mockFor(ProjectService)
		controller.projectService = projectMockService.createMock();
	}

	void "test index"() {
		given:
		Project project = new Project(name: "A", code: "B")
		projectMockService.demand.getAllProjects() { -> return [project]}

		when:
		controller.index();

		then:
		view == '/project/index'
		model.projects == [project]
	}

	void "test update"() {
		given:
		Project project = new Project(name: "A", code: "B")
		projectMockService.demand.get(_) { -> return project}

		when:
		controller.update();

		then:
		view == '/project/create'
	}

	void "test save"() {
		given:
		Project project = new Project(name: "A", code: "B")
		
		when:
		controller.save(project);

		then:
		view == '/project/create'
		model.project == project
	}
}
