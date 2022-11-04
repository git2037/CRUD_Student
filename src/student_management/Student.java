package student_management;

public class Student {

	private String id;
	private String fullName;
	private String birthDay;
	private String gender;
	private String email;
	private double score;

	public Student(String id) {
		this.id = id;
	}

	public Student(String id, String fullName, String birthDay, String gender, String email, double score) {
		this.id = id;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.gender = gender;
		this.email = email;
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id;
	}
	
	public void show() {
		System.out.printf("|%-10s | %-30s | %-15s | %-5s | %-30s | %-6f |%n", id, fullName, birthDay, gender, email, score);
	}

}
