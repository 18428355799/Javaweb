package T6;
/**
 * �ص㣺
 * 1.javabean����Ҫ��Ĭ�ϵĹ��캯��
 * 2.��Ա����һ�������;
 * 3.���Զ�Ӧȡֵ�ͻ�ȡֵ��get��set����
 * */
public class Student {
	private int studid;
	private String studName;
	private String sex;
	private int age;
	private String className;
	private String[] hobit;
	private boolean marry;
	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
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
	public boolean isMarry() {
		return marry;
	}
	public void setMarry(boolean marry) {
		this.marry = marry;
	}
	
}
