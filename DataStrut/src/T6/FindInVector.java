package T6;

import java.util.Vector;

//���Բ���
public class FindInVector extends Vector{

	public void addPerson(String name,int age){
		this.add(new Person(name,age));
	}
	public int query(String name){
		int age=-1;
		for(int i=0;i<this.size();i++){
			Person p=(Person)(this.get(i));
			if(p.getName().equals(name)){
				age=(int)p.getAge();
				break;		//�ҵ��������˳�
			}
		}
		return age;
	}

	public static void main(String args[]){
		FindInVector find=new FindInVector();
		find.addPerson("С����",11);
		find.addPerson("С��",13);
		find.addPerson("С¶",15);
		int age=find.query("С¶");
		if(age!=-1){
			System.out.println("С¶: "+"���� "+age);
		}else{
			System.out.println("û�ҵ���ͬ־");
		}
	}
}
class Person{
	private String name;
	private int age;
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
