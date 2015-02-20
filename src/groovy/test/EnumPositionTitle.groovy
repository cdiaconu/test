package test

enum EnumPositionTitle {
	TECH_LEAD(1), //
	PROJECT_MANAGER(2)

	private final Integer id;

	EnumPositionTitle(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
