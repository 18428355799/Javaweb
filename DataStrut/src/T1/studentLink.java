package T1;


public class studentLink {
	//����ͷ�ڵ�
	studentNode head;
	//��ʼ��
	public studentLink() {
		//����
		head=new studentNode();
		head.next=null;
		head.prior=null;
	}
	
	//����
	public void addNode(String xuehao,String name,int age,String banji){
		studentNode p=head;
		while(p.next!=null){
			p=p.next;
		}
		//��Ҫ�����Ľڵ�
		studentNode temp=new studentNode( xuehao, name, age, banji);
		p.next=temp;
		temp.prior=p;
	}
	//����
	public void display(){
		studentNode p=head;
		System.out.println("��ͷ��β-------------------------");
		while(p.next!=null){
			System.out.print(p.next.xuehao+"   ");
			System.out.print(p.next.name+"   ");
			System.out.print(p.next.age+"   ");
			System.out.println(p.next.banji);
			p=p.next;
		}
		
		//��β��ͷ
		System.out.println("��β��ͷ-------------------------");
		while(p.prior!=head){
			
			System.out.print(p.xuehao+"   ");
			System.out.print(p.name+"   ");
			System.out.print(p.age+"   ");
			System.out.println(p.banji);
		
			p=p.prior;
		}
		System.out.print(p.xuehao+"   ");
		System.out.print(p.name+"   ");
		System.out.print(p.age+"   ");
		System.out.println(p.banji);
		
	}
	//����
	public void findNode(String xuehao,String name){
		
		studentNode  p=head;
		while(p.next!=null){
			if(p.next.name.equals(xuehao)){
				System.out.println(p.next.xuehao+"    ");
				break;
			}else if(p.next.name.equals(name)){
				System.out.println(p.next.name);
				break;
			}else{
				p=p.next;
			}
		}
	}
	
	public void MinAge(){
		System.out.println("������С��ѧ����");
		studentNode p=head;
		while(p.next!=null){
			if(p.next.age<=p.next.next.age){
				System.out.println(p.next.name);
				break;
			}else{
				p=p.next;
			}
			
		}
	}
	///ɾ��
	public void DelNOde(String xuehao,String name){
		studentNode p=head;
		while(p.next!=null){
			if(p.next.xuehao.equals(xuehao)){
				p.next.next.prior=p.next.prior;
				p.next=p.next.next;
				break;
			}else if(p.next.name.equals(name)){
				p.next.next.prior=p.next.prior;
				p.next=p.next.next;
				break;
			}else{
				p=p.next;
			}
		}
		
	}
	
	//5.��������ѧ����ѧ�ţ������ǵ�λ�û���һ��
	public void Huan(String xuehao1,String xuehao2){
		studentNode p=head;
		while(p.next!=null){
			if(p.next.name.equals(xuehao1)){
				boolean t=p.next.name.equals(xuehao2);
				
			}
		}
		
	}
	
	//����
	public void addNode2(String xuehao,String name,int age,String banji){
		studentNode p=head;
		while(p.next!=null){
			p=p.next;
		}
		//��Ҫ�����Ľڵ�
		studentNode temp=new studentNode( xuehao, name, age, banji);
		while(p.next!=null){
			if(age<=p.next.age){
				p.next=temp;
			}
		}
	}
	
	//�����С
	public int size(){
		int n=0;
		studentNode p=head;
		while(p.next!=null){
			p=p.next;
			n++;
		}
		return n; 
	}
	
	public static void main(String[] args) {
		studentLink link=new studentLink();
		link.addNode("HT001", "С����", 21, "�߼������");
		link.addNode("HT002", "С��", 19, "�߼������");
		link.addNode("HT003", "С��", 20, "ѧǰרҵ");
		link.addNode("HT004", "С¶", 12, "�������̰�");
		
		link.display();
		System.out.println("size="+link.size());
		System.out.println("-----------------------------------");
		link.findNode("HT002", "С��");
		link.findNode("HT004", "С¶");
		System.out.println("-----------------------------------");
		link.MinAge();
		System.out.println("------------ɾ����������------------");
	
		link.DelNOde("HT002", "");
		link.DelNOde("", "С��");
		link.display();
		System.out.println("size="+link.size());
		System.out.println("---------------**--------------------");
	}
}
