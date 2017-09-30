package T1;

//˫����
public class DLink {

	//����ͷ�ڵ�
	DNode head;
	//��ʼ��
	public DLink() {
		//����
		head = new DNode();
		head.prior = null;
		head.next = null;
	}
	//�����ڵ�
	public void addNode(String data){
		DNode p = head;
		while(p.next!=null){
			p=p.next;
		}
		//��Ҫ�����Ľڵ�
		DNode temp = new DNode(data);
		p.next = temp;
		temp.prior = p;
	}
	//ɾ���ڵ�
	public void delNode(String data){
		DNode p = head;
		while(p.next!=null){
			//ɾ���ڵ�
			if(p.next.name.equals(data)){
				//˳���ܻ�
				p.next.next.prior=p.next.prior;
				p.next = p.next.next;
				break;
			}else{
				p=p.next;
			}
		}
	}
	//����
	public void display(){
		DNode p = head;
		//��ͷ��β
		System.out.println("��ͷ��β------------------------");
		while(p.next!=null){
			System.out.println(p.next.name+"->>");
			p=p.next;
		}
		//��β��ͷ
		System.out.println("��β��ͷ-------------------------");
		while(p.prior!=head){
			System.out.println(p.name+"->>");
			p=p.prior;
		}
		System.out.println(p.name+"->>");
	}
	//����
	public void findNode(String data){
		DNode p = head;
		while(p.next!=null){
			//ɾ���ڵ�
			if(p.next.name.equals(data)){
				System.out.println("data="+p.next.name);
				break;
			}else{
				p=p.next;
			}
		}
	}
	//����ڵ�
	public void insertNode(String param,String data){
		DNode p = head;
		while(p.next!=null){
			if(p.next.name.equals(param)){
				DNode t = p.next;
				DNode insertNode = new DNode(data);
				
				insertNode.next = t.next;
				t.next.prior = insertNode;
				t.next = insertNode;
				insertNode.prior = t;
				break;
			}else{
				p=p.next;
			}
		}
	}
	//�����С
	public int size(){
		int n=0;
		DNode p = head;
		while(p.next!=null){
			p=p.next;
			n++;
		}
		return n;
	}
	public static void main(String[] args) {
		DLink link = new DLink();
		link.addNode("�鳤");
		link.addNode("���ž���");
		link.addNode("���ܸ���");
		link.addNode("�ܾ���");
		link.display();
		System.out.println("size="+link.size());
		link.delNode("���ž���");
		link.display();
		System.out.println("---------------------------");
		link.insertNode("�鳤", "���ž���");
		link.display();
	}
}
