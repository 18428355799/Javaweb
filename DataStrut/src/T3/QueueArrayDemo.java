package T3;

public class QueueArrayDemo {

	private int size;
	private int front;
	private int rear;
	private Object[] data;
	
	public QueueArrayDemo(int size){
		//��ʼ�����г���
		this.size=size;
		//��ʼ��ͷָ��
		this.front=-1;
		//��ʼ��βָ��
		this.rear=-1;
		//��ʼ������
		data = new Object[size];
	}
	//���
	public void inQueue(Object obj){
		//���в����������
		if(this.rear<size){
			rear++;
			data[rear] = obj;
			System.out.println(obj+"���");
		}else {
			System.out.println("��������");
		}
	}
	
	//����
	public Object outQueue(){
		Object obj = null;
		if(this.front!=this.rear){
			front++;
			obj = data[front];
			System.out.println(obj+"����");
		}else {
			System.out.println("����Ϊ��");
		}
		return obj;
	}
	
	//����
	public void display(){
		//����ǰ���ж϶����Ƿ�Ϊ��
		if(front!=rear){
			for(int i=front+1;i<rear+1;i++){
				System.out.println(data[i]);
			}
		}else {
			System.out.println("����������");
		}
	}
	
	public static void main(String[] args) {
		//����һ�����ж��󣬳�ʼֵΪ10
		QueueArrayDemo qa = new QueueArrayDemo(10);
		//���
		qa.inQueue("1");
		qa.inQueue("2");
		qa.inQueue("3");
		qa.inQueue("4");
		qa.inQueue("5");
		
		qa.outQueue();
		qa.outQueue();
		System.out.println("\n����������");
		//��ʼ����
		qa.display();
	}
	
}
