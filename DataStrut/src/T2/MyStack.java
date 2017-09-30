package T2;

public class MyStack {

	Node head;
	int size;
	public MyStack(){
		//ͷ�ڵ�
		head = new Node();
	}
	
	//����Ԫ��
	public void push(String data){
		//��ȡͷָ��
		Node p = head;
		//�����ڵ�
		Node d = new Node(data);
		//�����½ڵ����һ���ڵ�Ϊͷ�ڵ����һ���ڵ�
		d.next = p.next;
		//��ͷ�ڵ����һ���ڵ�ָ���½ڵ�;
		p.next=d;
		size++;
	}
	
	//ɾ��Ԫ��
	public String pop(){
		//�ж϶�ջ�Ƿ�Ϊ��
		if(isEmpty()){
			System.out.println("��ջ�Ѿ�Ϊ�գ��޷�ɾ��");
			return null;
		}
		//��ȡͷָ��
		Node p = head;
		Node temp = p.next;
		//ɾ��
		p.next=p.next.next;
		size--;
		return temp.name;
	}
	
	//�ж϶�ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		boolean isok = false;
		if(head.next==null){
			isok=true;
		}
		return isok;
	}
	
	//����Ԫ�ظ���
	public int size(){
		return size;
	}
	
	//����
	public void find(String data){
		Node p = head;
		while(p.next!=null){
			if(p.next.name.equals(data)){
				System.out.println("�ҵ�������Ҫ�����ݣ�"+data);
			}else {
				p.next = p.next.next;
			}
		}
	}
	
	//��ȡջ��Ԫ��
	public String peek(){
		if(isEmpty()){
			return null;
		}
		return head.next.name;
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push("�鳤");
		stack.push("���ž���");
		stack.push("���ܸ���");
		stack.push("�ܾ���");
		stack.push("���³�");
		System.out.println("ջ��Ԫ�أ�"+stack.peek());
		System.out.println("ջ��Ԫ�أ�"+stack.peek());
		System.out.println("---------------size="+stack.size());
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println("---------------size="+stack.size());
	}
}
