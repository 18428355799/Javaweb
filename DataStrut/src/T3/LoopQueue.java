package T3;
//ѭ������
public class LoopQueue {

	private int size;
	private int front;
	private int rear;
	private Object[] data;
	
	public LoopQueue(){
		this.size=11;
		this.front=0;
		this.rear=0;
		data = new Object[size];
	}
	
	public LoopQueue(int size){
		this.size=size+1;
		this.front=0;
		this.rear=0;
		data = new Object[this.size];
	}
	public boolean isFull(){
		boolean full = true;
		if((this.rear+1)%size==this.front){//����
			full = true;
		}else {//����
			full = false;
		}
		return full;
	}
	public boolean isEmpty(){
		boolean empty = true;
		if(this.front==this.rear){//�ӿ�
			empty = true;
		}else {//��Ϊ��
			empty = false;
		}
		return empty;
	}
	//��Ӳ���
	public void inQueue(Object obj){
		//�ж϶����Ƿ�����
		if(this.isFull()){
			System.out.println("��������");
		}else {
			System.out.println(front+"  "+rear);
			this.rear=(rear+1)%size;
			data[rear]=obj;
		}
	}
	//���Ӳ���
	public Object outQueue(){
		Object obj = null;
		//�ж϶����Ƿ�Ϊ��
		if(this.isEmpty()){
			System.out.println("����Ϊ��");
		}else {
			//����ָ��Ϊ���1Ȼ��Զ��д�С����ȡģ
			this.front = (front+1)%size;
			obj = data[front];
		}
		return obj;
	}
}
