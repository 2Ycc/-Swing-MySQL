package bean;

public class student {
	private int sno;
	private String clas;
	private String name;
	private String gender;
	private int age;
	private String major;
	private String dept;
	student (int sno, String clas, String name, String gender, int age, String major, String dept){
		this.sno = sno;
		this.clas = clas;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.major = major;
		this.dept = dept;
	}
	public student(){
		
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	
}
