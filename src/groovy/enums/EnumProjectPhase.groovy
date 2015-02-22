package enums

enum EnumProjectPhase {
	BRIEFING(1, "Briefing"), //
	SCOPING(2, "Scoping"), //
	INTERACTION(3, "Interaction"), //
	DEVELOPMENT(4, "Development"), //
	QA(5, "Qa"), //
	RELEASE(6, "Release");

	private int id
	private String value

	EnumProjectPhase(int id, String value) {
		this.id = id
		this.value = value
	}

	public int getId() {
		return id
	}

	public String getValue() {
		return value
	}
}
