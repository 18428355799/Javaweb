package Yansi;

public class Student {

	private String username;//����
	private String phone;//�绰����
	private String sex;//�Ա�
	private int age;//����
	private String education;//�ܽ����̶�
	private String[] hobit;//����
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String[] getHobit() {
		return hobit;
	}
	//�������ĺ���
	public String getHobit(int index){
		
		return hobit[index];
	}
	public void setHobit(String[] hobit) {
		this.hobit = hobit;
	}
	//�������ĺ���
	public void setHobit(int index,String value){
		this.hobit[index]=value;
	}
}
