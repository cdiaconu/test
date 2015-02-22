package test

import grails.transaction.Transactional

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired

@Transactional
class PhaseService {

	@Autowired
	SessionFactory sessionFactory;

	def getPhases(){
		return Phase.list()
	}
}
