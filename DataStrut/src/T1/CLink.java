package T1;

//ѭ������
public class CLink {

	//����ͷ�ڵ�
	Node head;
	//��ʼ��
	public CLink() {
		//����
		head = new Node();
		head.next = null;
	}
	//�����ڵ�
	public void addNode(String data){
		
		Node p = head;//ͷ�ڵ�
		if(p.next ==null){
			Node temp = new Node(data);//��һ���ڵ�
			p.next = temp;
			temp.next = head.next;
			return;
		}
		p=p.next;
		//�ڶ����ڵ㿪ʼ
		while(p.next!=head.next){
			p=p.next;
		}
		//��Ҫ�����Ľڵ�
		Node temp = new Node(data);
		p.next = temp;
		//β�ڵ����һ���ڵ��ǵ�һ���ڵ�
		temp.next = head.next;
	}
	//ɾ���ڵ�
	public void delNode(String data){
		
		Node p = head.next;
		while(p.next!=head.next){
			//ɾ���ڵ�
			if(p.next.name.equals(data)){
				p.next = p.next.next;
				break;
			}else{
				p=p.next;
			}
			
		}
	}
	//����
	public void display(){
		Node p = head.next;
		while(p.next!=head.next){
			System.out.println(p.name+"->>");
			p=p.next;
		}
		System.out.println(p.name+"->>");
	}
	//����
	public void findNode(String data){
		
		Node p = head;
		while(p.next!=head.next){
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
		
		Node p = head.next;
		while(p.next!=head.next){
			if(p.name.equals(param)){
				Node t = p;
				Node insertNode = new Node(data);
				
				insertNode.next = t.next;
				t.next = insertNode;
				break;
			}else{
				p=p.next;
			}
		}
	}
	//�����С
	public int size(){
		int n=1;
		Node p = head.next;
		while(p.next!=head.next){
			p=p.next;
			n++;
		}
		return n;
	}
	public static void main(String[] args) {
		CLink link = new CLink();
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
