package test

class Phase {
	long id
	String name

	static mapping = { cache true }

	static constraints = { name blank : false }
}
