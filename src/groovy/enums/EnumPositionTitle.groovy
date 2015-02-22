package enums

enum EnumPositionTitle {
	TECHNICAL_LEAD(1, "Technical Lead"), //
	PROJECT_MANAGER(2, "Project Manager")

	private int id;
	private String value;

	EnumPositionTitle(int id, String value){
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

}
