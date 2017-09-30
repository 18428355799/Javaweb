package T3;

import java.util.Queue;

public class CQueue {

	Object [] data;
	int size;
	int front;
	int rear;
	public CQueue() {
		this.size = 11;
		front = 0;
		rear = 0;
		data = new Object[this.size];
	}
	public CQueue(int size) {
		this.size = size+1;
		front = 0;
		rear = 0;
		data = new Object[this.size];
	}
	//�����Ƿ���������βָ��+1=����ָ��
	public boolean isFull(){
		if((rear+1) % this.size == front){
			return true;
		}else{
			return false;
		}
	}
	//����Ϊ�գ�front==rear;
	public boolean isEmpty(){
		if(front==rear){
			return true;
		}else{
			return false;
		}
	}
	
	//���
	public int inQueue(Object dat){
		if(isFull()){
			System.out.println("��������");
			return -1;
		}else{
			rear++;
			rear = rear % this.size;
			data[rear]=dat;
			System.out.println("��ӣ�"+dat);
			return rear;
		}
	}
	//����
	public int outQueue(){
		if(isEmpty()){
			System.out.println("����Ϊ��");
			return -1;
		}else{
			front++;
			front = front % this.size;
			System.out.println("���ӣ�"+data[front]);
			return front;
		}
	}
	//����
	public void display(){
		int f = (front+1) % this.size;//1
		int r = (rear+1) % this.size; 
		System.out.println("f="+f+";r="+r);
		while(f!=r){
			System.out.println("������"+data[f]);
			f++;
			f=f % this.size;
		}
	}
	public static void main(String[] args) {
		CQueue queue = new CQueue();
		queue.inQueue("1");
		queue.inQueue("2");
		queue.inQueue("3");
		queue.inQueue("4");
		queue.inQueue("5");
		queue.inQueue("6");
		queue.inQueue("7");
		queue.inQueue("8");
		queue.inQueue("9");
		queue.inQueue("10");
		queue.inQueue("11");

		queue.display();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.inQueue("11");
		queue.inQueue("12");
		queue.inQueue("13");
		queue.inQueue("14");
		queue.display();
	}
}
