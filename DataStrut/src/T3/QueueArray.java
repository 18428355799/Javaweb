package T3;
//�������
public class QueueArray {

	private int size;
	private int front;
	private int rear;
	private Object[] queue;
	
	public QueueArray(int size){
		this.size=size;//��ʼ�����г���
		this.front = -1;//��ʼ��ͷָ��
		this.rear = -1;//��ʼ��βָ��
		queue = new Object[size];
	}
	//��Ӳ���
	public void inQueue(Object obj){
		if(this.rear<size){
			//�Ƚ�αָ������ƶ�һ����λ
			rear++;
			//�����ݷ���
			queue[rear]=obj;
			System.out.println(obj+"���");
		}else {
			System.out.println("��������");
		}
	}
	//���Ӳ���
	public Object outQueue(){
		Object obj = null;
		if(this.front!=this.rear){
			//��ͷָ������ƶ�һ����λ��ָ��Ҫ���ӵ�����
			front++;				
			//��ͷָ����ָ����ȡ��
			obj=queue[front];		
			System.out.println(obj+"����");
		}else {
			System.out.println("�����ѿ�");
		}
		return obj;
	}
	//��������
	public void display(){
		if(front!=rear){
			for(int i=front+1;i<rear+1;i++){
				System.out.println(queue[i]);
			}
		}else {
			System.out.println("����������");
		}
	}
}
