package test

import grails.transaction.Transactional;

import org.hibernate.Criteria
import org.hibernate.Session
import org.hibernate.criterion.Conjunction
import org.hibernate.criterion.Restrictions

abstract class AbstractUpdateStrategy implements IPriorityUpdateStrategy {

	@Override
	public void updatePriority(Session session) {
		List<Project> projects = getProjectsBetweenPriorities(session, getFromPriority(), getToPriority())

		boolean shouldIncrement = shouldIncrement()
		for (Project pr : projects){
			def project = Project.lock(pr.id)
			project.priority += shouldIncrement ? 1 : -1
			project.save(flush: true)
		}
	}

	private List<Project> getProjectsBetweenPriorities(Session session, int fromPriority, int toPriority){
		Criteria projectCriteria = session.createCriteria(Project.class, "project")

		Conjunction and = Restrictions.conjunction();
		and.add( Restrictions.ge("project.priority", fromPriority) );
		and.add( Restrictions.le("project.priority", toPriority) );

		long dirtyProjectId = getDirtyProjectId()
		if (dirtyProjectId != null){
			and.add( Restrictions.ne("project.id", dirtyProjectId) );
		}

		projectCriteria.add(and);
		return projectCriteria.list()
	}

	protected abstract int getFromPriority()

	protected abstract int getToPriority()

	protected abstract long getDirtyProjectId()

	protected abstract boolean shouldIncrement()
}
