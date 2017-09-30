package T1;

import java.util.Scanner;

public class SLink {

	SNode head;
	public SLink() {
		head = new SNode();
	}
	//��ӽڵ�
	public void addNode(Student s){
		SNode p = new SNode(s);
		SNode h = head;
		while(h.getNext() !=null){
			h=h.getNext();
		}
		h.setNext(p);
	}
	//���洢ѧ�����������Ϊ����ģ�ÿ���������м�ѧ��ʱ������������
	public void addNode2(Student s){
		//�����ڵ�
		SNode p = new SNode(s);
		SNode h = head;
		while(h.getNext() !=null){
			if(h.getNext().getStud().getAge()<=s.getAge()){
				h=h.getNext();
			}else{
				p.setNext(h.getNext());
				h.setNext(p);
				break;
			}
		}
		h.setNext(p);
	}
	//��ѧ������ĳ�˫���������ͬ���Ĺ���
	public void addNode3(Student s){
		//�����ڵ�
		SNode p = new SNode(s);
		SNode h = head;
		while(h.getNext() !=null){
			if(h.getNext().getStud().getAge()<=s.getAge()){
				h=h.getNext();
			}else{
				p.setNext(h.getNext());
				h.getNext().setPrior(p);
				h.setNext(p);
				p.setPrior(h);
				break;
			}
		}
		h.setNext(p);
		p.setPrior(h);
	}

	//����
	public void display(){
		SNode p = head;
		while(p.getNext() !=null){
			System.out.println(p.getNext().getStud());
			p= p.getNext();
		}
		System.out.println("-------------------------------");
		System.out.println(p.getStud());
		while(p.getPrior() !=null){
			System.out.println(p.getPrior().getStud());
			p= p.getPrior();
		}
	}

	//��ѧ�Ų���
	public Student searchById(int studid){
		Student s = null;
		SNode p = head;
		while(p.getNext() !=null){
			if(p.getNext().getStud().getStudid()==studid){
				s = p.getNext().getStud();
				break;
			}
			p= p.getNext();
		}
		return s;
	}
	//����������
	public Student searchByName(String name){
		Student s = null;
		SNode p = head;
		while(p.getNext() !=null){
			if(p.getNext().getStud().getName().equals(name)){
				s = p.getNext().getStud();
				break;
			}
			p= p.getNext();
		}
		return s;
	}
	//����������
	public Student minAge(){
		Student s = null;
		SNode p = head;
		if(p.getNext()==null){
			return null;
		}
		//��ʼ��
		int age=head.getNext().getStud().getAge();
		s = head.getNext().getStud();
		//������С�����ѧ����Ϣ
		while(p.getNext() !=null){
			if(p.getNext().getStud().getAge()<age){
				age = p.getNext().getStud().getAge();
				s = p.getNext().getStud();
			}
			p= p.getNext();
		}
		return s;
	}
	//��ѧ��ɾ��
	public void deleteById(int studid){
		SNode p = head;
		while(p.getNext() !=null){
			if(p.getNext().getStud().getStudid()==studid){
				p.setNext(p.getNext().getNext());
				break;
			}
			p= p.getNext();
		}
	}
	//������ɾ��
	public void deleteByName(String name){
		SNode p = head;
		while(p.getNext() !=null){
			if(p.getNext().getStud().getName().equals(name)){
				p.setNext(p.getNext().getNext());
				break;
			}
			p= p.getNext();
		}
	}
	//��������
	public void swap(int studid1, int studid2){
		SNode t1,t2,t3,t4,t5;
		/*
		 * t1:ͷ�ڵ�
		 * t2:p1
		 * t3:p2
		 * t4:p3
		 * */
		t1=t2=t3=t4=t5=null;
		SNode p = head;
		int cnt1=0,cnt2=0;
		while(p.getNext() !=null){
			cnt1++;
			if(p.getNext().getStud().getStudid()==studid1){
				t1=p;
				t2=p.getNext();
				break;
			}
			p=p.getNext();
		}
		p = head;
		while(p.getNext() !=null){
			cnt2++;
			if(p.getNext().getStud().getStudid()==studid2){
				t3=p;
				t4=p.getNext();
				break;
			}
			p=p.getNext();
		}
		System.out.println("cnt1="+cnt1+";cnt2="+cnt2);
		/*2������
		 * t1��ǰ��һ��
		 * t2,t3��ͬһ��
		 */
		
		if(cnt1+1==cnt2){
			t2.setNext(t4.getNext());
			t1.setNext(t4);
			t4.setNext(t2);
		}else if(cnt2+1==cnt1){
			//t3,t4,t1,t2
			t4.setNext(t2.getNext());
			t3.setNext(t2);
			t2.setNext(t4);
		}else{
			t1.setNext(t4);
			t5=t4.getNext();
			t4.setNext(t2.getNext());
			t2.setNext(t5);
			t3.setNext(t2);
		}
	}
	//�������ڵ㣬ֻ�����ڵ��ڵ�ֵ
	public void swapValue(int studid1, int studid2){
		SNode t1,t2;
		t1=t2=null;
		SNode p = head;
		while(p.getNext()!=null){
			if(p.getNext().getStud().getStudid()==studid1){
				t1=p.getNext();
			}
			if(p.getNext().getStud().getStudid()==studid2){
				t2=p.getNext();
			}
			if(t1!=null && t2!=null)
				break;
			p = p.getNext();
		}
		//��ʱ����t1��ѧ������
		Student s = t1.getStud();
		//��t2�ڵ��е�ѧ�����ϸ�ֵ��t1�ڵ�
		t1.setStud(t2.getStud());
		//����ʱ�����е�ѧ�����ϸ�ֵ��t2
		t2.setStud(s);
	}
	public static void main(String[] args) {
		SLink link = new SLink();
		Student s1 = new Student(1001,"С����",18,"��ͼ1601��");
		Student s2 = new Student(1002,"С��",20,"��ͼ1602��");
		Student s3 = new Student(1003,"С¶",17,"��ͼ1603��");
		Student s4 = new Student(1004,"С��",21,"��ͼ1604��");
		Student s5 = new Student(1005,"С��",22,"��ͼ1501��");
		link.addNode(s1);
		link.addNode(s2);
		link.addNode(s3);
		link.addNode(s4);
		link.addNode(s5);
		link.display();
		//���԰�ѧ�ţ����ֲ���ѧ��
		/*
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ��ѧ��������");
//		int studid = input.nextInt();
		String name = input.next();
		Student t = link.searchByName(name);
		System.out.println("����ҵ�����Ϊ��"+name+"����Ϣ���£�");
		if(t==null){
			System.out.println("���޴���");
		}else{
			System.out.println(t);
		}
		*/
		//����ڵ���������С��ѧ��
//		System.out.println("������С��ѧ����Ϣ���£�");
//		System.out.println(link.minAge());
//		//���԰�ѧ�ţ�����ɾ���ڵ�
//		Scanner input = new Scanner(System.in);
//		System.out.println("��������Ҫɾ����ѧ��������");
////		int studid = input.nextInt();
////		link.deleteById(studid);
//		String name = input.next();
//		link.deleteByName(name);
//		link.display();
//		String name = input.next();
//		Student t = link.searchByName(name);
		
//		��������ѧ����ѧ�ţ������ǵ�λ�û���һ��
		link.swap(1001, 1002);
		link.display();
		
	}
}