package test

import grails.transaction.Transactional

import org.hibernate.Criteria
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.criterion.Order
import org.springframework.beans.factory.annotation.Autowired

@Transactional
class ProjectService {

	@Autowired
	SessionFactory sessionFactory;

	def getAllProjects(){
		Session session = sessionFactory.getCurrentSession()
		Criteria projectCriteria = session.createCriteria(Project.class, "project")
		projectCriteria.addOrder(Order.asc("priority"))
		return projectCriteria.list()
	}

	def save(Project project) {
		project.save()
	}
	
	def update(Project project) {
		project.merge()
	}
}
