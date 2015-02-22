package test

class Employee {

	String firstName
	String lastName
	Role role

	static mapping = { cache true }

	static constraints = {
	}
}
