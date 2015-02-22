package test

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ProjectController)
@Mock([Project])
class ProjectControllerSpec extends Specification {

	def mockService;

	def setup() {
		mockService = 	mockFor(ProjectService)
		controller.projectService = mockService.createMock();
	}

	void "test index"() {
		given:
		Project project = new Project(name: "A", code: "B")
		mockService.demand.getAllProjects() { -> return [project]}

		when:
		controller.index();

		then:
		view == '/artist/index'
		model.projects == [project]
	}
}
