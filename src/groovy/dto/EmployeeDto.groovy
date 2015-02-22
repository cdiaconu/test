package dto

class EmployeeDto {
	long id
	String firstName
	String lastName
	String fullName

	public String getFullName() {
		return firstName + " " + lastName
	}
}
