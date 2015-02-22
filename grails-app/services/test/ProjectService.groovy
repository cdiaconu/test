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
	
	def get(String id){
		return Project.get(Long.valueOf(id))
	}

	def save(Project project) {
		EnumPriorityUpdateType updateType = project.id ? EnumPriorityUpdateType.UPDATE : EnumPriorityUpdateType.INSERT
		int originalPriority = project.priority
		if (project.id){
			originalPriority = project.getPersistentValue("priority")
		}
		
		project.save()
		
		IPriorityUpdateStrategy strategy = PriorityUpdateStrategyFactory.getStrategy(project.priority, originalPriority, updateType, project.id)
		Session session = sessionFactory.openSession()
		strategy.updatePriority(session)
		session.close()
	}

	def delete(Project project){
		IPriorityUpdateStrategy strategy = PriorityUpdateStrategyFactory.getStrategy(project.priority, project.priority, EnumPriorityUpdateType.DELETE, project.id)
		Session session = sessionFactory.openSession()
		strategy.updatePriority(session)
		session.close()
		
		project.delete()
	}
}
