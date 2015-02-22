package test

import org.hibernate.Session

public interface IPriorityUpdateStrategy {

	void updatePriority(Session session)
}
