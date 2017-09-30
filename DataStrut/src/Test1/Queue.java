package Test1;

public class Queue {
	private int size;
	private int front;
	private int rear;
	private Object [] queue;
	int cnt1,cnt2;
	
	public Queue(){
		this.front=1;//��ʼ��ͷָ��
		this.rear=1;//��ʼ��βָ��
		queue=new Object[size];//��ʼ������
	}
	public Queue(int size){
		this.size=size;//��ʼ�����г���
		this.front=1;//��ʼ��ͷָ��
		this.rear=1;//��ʼ��βָ��
		queue=new Object[size];//��ʼ������
		
	}
	//���
	public void inQueue(int  obj){
		int huan;
		//�����ж϶����Ƿ�Ϊ��
		if(isFull()){
			System.out.println("��������");
		}else{
			//System.out.println(front+"-----------------"+rear);
			//��βָ��Ϊ���һȻ����д�С����ȡģ
			this.rear=(rear+1)%size;
			queue[rear]=obj;
			System.out.println(front+"-----------------"+obj);
		}
	}
	
	//����
	public Object outQueue(){
		//����һ���������ڱ�����ӵ�����
		Object obj=null;
		if(this.isEmpty()){
			System.out.println("����Ϊ��");
		}else{
			//��βָ��Ϊ���һȻ����д�С����ȡģ
			this.front=(front+1)%size;
			obj=queue[front];
		}
		return obj;
	}
	
	//����
	public void display(){
		//���ж϶����Ƿ�Ϊ��
		if(front!=rear){
			//������ʱָ��"i"����Ԫ�ص��±�
			for(int i=front+1;i<rear+1;i++){
				System.out.println(queue[i]);
			}
		}else{
			System.out.println("����������");
		}
	}
	
	//�ж��Ƿ�����
	public boolean isEmpty(){
		boolean empty=true;	
		if(this.front==this.rear){
			empty=true;//�ӿ�
		}else{
			empty=false;//��Ϊ��
		}
		return empty;
	}
	//�ж��Ƿ�Ϊ��
	public  boolean isFull(){
		if((rear+1)%this.size==front){
			return true;
		}else{
			return false;
		}
	}
	//����
	public void find(int data){
		if(this.front!=this.rear){
				System.out.println("��ѯ�����ݣ�"+queue[data-1]);
		}
	}
	//��С
	public void size(){
		int cnt3=cnt1-cnt2;
		System.out.println("ʵ��������:"+cnt3);
	}
	
	public static void main(String[] args) {
		Queue qa=new Queue(5);//����һ�����ж��󣬳�ʼ��Ϊ10
		qa.inQueue(11);//���
		qa.inQueue(45);
		qa.inQueue(13);
		qa.inQueue(14);
		qa.inQueue(15);
		//����
		qa.outQueue();
		qa.outQueue();
		qa.inQueue(6);
		qa.inQueue(7);
		qa.outQueue();
		qa.outQueue();
		qa.inQueue(8);
		qa.inQueue(9);
	}
}
