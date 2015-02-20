package test

class Project {

	String name
	String code
	Employee techLead
	Employee projectManager
	Date deliveryDate
	Phase phase
	int priority

	static constraints = {
		name matches : "^[a-zA-Z0-9*]+\$"
		code matches : "^[a-zA-Z0-9*]+\$"
		priority matches : "[0-9]+"
	}
}
