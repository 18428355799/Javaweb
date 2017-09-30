package Test1;

import java.util.Scanner;

import Test1.Student;

/**
 * 1.ʵ����������²�����
1.����һ��ѧ���ࣻ
2.�����ڵ��࣬��ѧ���൱���ڵ��������
3.���������ࣻ
4.ʵ�������ڵ㹦�ܣ�
5.ɾ���ڵ㹦�ܣ�
6.�����ڵ㹦�ܣ�
7.���������࣬��������Ĺ��ܣ�
 * 
 * */
public class studentLink {

	studentNode head;
	public studentLink(){
		//����
		head = new studentNode();
	}
	//�����ڵ�
	public void addNode(Student s){
		studentNode p = new studentNode(s);
		studentNode h = head;
		while(h.getNext()!=null){
			h = h.getNext();
		}
		h.setNext(p);
	}
	
	
	//ɾ���ڵ�
	//��ѧ��ɾ��
	public void deleteById(int studid){
		studentNode p = head;
		while(p.getNext()!=null){
			if(p.getNext().getStud().getStudid()==studid){
				p.setNext(p.getNext().getNext());
				break;
			}
			p = p.getNext();
		}
	}
	
	//������ɾ��
	public void deleteByName(String name){
		studentNode p = head;
		while(p.getNext()!=null){
			if(p.getNext().getStud().getName().equals(name)){
				p.setNext(p.getNext().getNext());
				break;
			}
			p = p.getNext();
		}
	}
	
	//����
	public void display(){
		studentNode p = head;
		while(p.getNext()!=null){
			System.out.println(p.getNext().getStud());
			p = p.getNext();
		}
		System.out.println("--------------------------");
		System.out.println(p.getStud());
		while(p.getPrior()!=null){
			System.out.println(p.getPrior().getStud());
			p = p.getPrior();
		}
	}
	
	public static void main(String[] args) {
		studentLink link = new studentLink();
		Student s1 = new Student(1001,"С����",18,"��ͼ1601��");
		Student s2 = new Student(1002,"С��",20,"��ͼ1602��");
		Student s3 = new Student(1003,"С��",20,"��ͼ1603��");
		Student s4 = new Student(1004,"С¶",17,"��ͼ1604��");
		Student s5 = new Student(1005,"С��",21,"��ͼ1501��");
		link.addNode(s1);
		link.addNode(s2);
		link.addNode(s3);
		link.addNode(s4);
		link.addNode(s5);
		link.display();
		//��ѧ��ɾ��
		Scanner input = new Scanner(System.in);
//		System.out.println("��������Ҫɾ����ѧ����ѧ��:");
//		int studid = input.nextInt();
//		link.deleteById(studid);
//		link.display();
		//������ɾ��
		System.out.println("��������Ҫɾ����ѧ��������");
		String name = input.next();
		link.deleteByName(name);
		link.display();
	}
}
