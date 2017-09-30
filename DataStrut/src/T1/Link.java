package T1;

//������
public class Link {

	//����ͷ�ڵ�
	Node head;
	//��ʼ��
	public Link() {
		//����
		head = new Node();
		head.next = null;
	}
	//�����ڵ�
	public void addNode(String data){
		//��ȡ��ͷ,ͨ����ͷ�ҵ����һ��Ԫ��,�������Ľڵ�ŵ����һ��Ԫ�صĺ���
		Node p = head;
		while(p.next!=null){
			p=p.next;
		}
		//��Ҫ�����Ľڵ�
		Node temp = new Node(data);
		p.next = temp;
	}
	//ɾ���ڵ�
	public void delNode(String data){
		//��ȡ��ͷ,ͨ����ͷ�ҵ����һ��Ԫ��,�����һ��Ԫ��ɾ��
		Node p = head;
		while(p.next!=null){
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
		Node p = head;
		while(p.next!=null){
			System.out.println(p.next.name+"->>");
			p=p.next;
		}
	}
	//����
	public void findNode(String data){
		//��ȡ��ͷ,ͨ����ͷ�ҵ����һ��Ԫ��,�����һ��Ԫ��ɾ��
		Node p = head;
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
		//param��ʾ�����Ľڵ�Ҫ���뵽�ýڵ�ĺ���,��ȡ��ͷ,ͨ����ͷ�ҵ�paramԪ�صĽڵ�,�������Ľڵ�ŵ��Ľڵ�ĺ���
		Node p = head;
		while(p.next!=null){
			if(p.next.name.equals(param)){
				Node t = p.next;
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
		int n=0;
		Node p = head;
		while(p.next!=null){
			p=p.next;
			n++;
		}
		return n;
	}
	public static void main(String[] args) {
		Link link = new Link();
		link.addNode("�鳤");
		link.addNode("���ž���");
		link.addNode("���ܸ���");
		link.addNode("�ܾ���");
		//��ʾ���
		link.display();
		//��ʾ��С
		System.out.println("size="+link.size());
		//ɾ���ڵ�
		link.delNode("���ž���");
		link.display();
		System.out.println("---------------------------");
		//�����ڵ�
		link.insertNode("�鳤", "���ž���");
		link.display();
	}
}
