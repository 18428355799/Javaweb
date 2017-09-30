package T3;

public class Queue {

	Node head;
	public Queue(){
		head = new Node();
	}
	//��Ӳ�������β���
	public void inQueue(String data){
		Node p = head;
		Node t = new Node(data);
		while(p.getNext()!=null){
			p = p.getNext();
		}
		p.setNext(t);
		System.out.println("���:"+data);
	}
	//���Ӳ��������ײ���
	public String outQueue(){
		String data = "";
		if(head.getNext()!=null){
			data = head.getNext().getData();
			head.setNext(head.getNext().getNext());
			System.out.println("���ӣ�"+data);
		}else {
			System.out.println("����Ϊ��");
		}
		return data;
	}
	
	//����
	public void display(){
		Node p = head;
		while(p.getNext()!=null){
			System.out.println(p.getNext().getData());
			p = p.getNext();
		}
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.inQueue("1");
		queue.inQueue("2");
		queue.inQueue("3");
		queue.inQueue("4");
		queue.inQueue("5");
		queue.inQueue("6");
		queue.inQueue("7");
		queue.inQueue("8");
		queue.inQueue("9");
		queue.display();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.display();
	}
}
