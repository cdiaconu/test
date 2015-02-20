package test

import grails.transaction.Transactional

import org.hibernate.Criteria
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.criterion.Projections
import org.hibernate.criterion.Restrictions
import org.hibernate.transform.Transformers
import org.springframework.beans.factory.annotation.Autowired

import dto.EmployeeDto

@Transactional
class EmployeeService {

	@Autowired
	SessionFactory sessionFactory;

	def getAllTechnicalLeads(){
		return getEmployeesByPositionTitle("Technical Lead")
	}

	def getAllProjectManagers(){
		return getEmployeesByPositionTitle("Project Manager")
	}

	def getEmployeesByPositionTitle(String positionTitle){
		Session session = sessionFactory.getCurrentSession()
		Criteria employeeCriteria = session.createCriteria(Employee.class, "employee")
		employeeCriteria.createAlias("employee.role", "role")
		employeeCriteria.setProjection(Projections
				.projectionList()
				.add(Projections.alias(Projections.property("employee.id"),
				"id"))
				.add(Projections.alias(Projections.property("employee.firstName"),
				"firstName"))
				.add(Projections.alias(Projections.property("employee.lastName"),
				"lastName"))
				)
		employeeCriteria.add(Restrictions.eq("role.positionTitle", positionTitle))
		employeeCriteria.setResultTransformer(Transformers.aliasToBean(EmployeeDto.class))
		List<EmployeeDto> employeeDtos = employeeCriteria.list()

		return employeeDtos
	}
}
