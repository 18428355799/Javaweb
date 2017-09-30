package T3_1;

public class LoopQueue{
	private int size;
	private int front;
	private int rear;
	private Object[] data;
	public LoopQueue(){
		this.size=10;
		this.front=0;
		this.rear=0;
		data=new Object[size];
	}
	
	public LoopQueue(int size){
		this.size=size;
		this.front=0;
		this.rear=0;
		data=new Object[size];
	}
	//���
	public void inQueue(Object obj){
		if(this.isFull()){			
			//�����ж϶����Ƿ�����
			System.out.println("��������");
		}else{
			System.out.println(obj+"��վ");
			this.rear=(rear+1)%size;//��βָ��Ϊ���1Ȼ��Զ��д�С����ȡģ
			data[rear]=obj;
		}
	}
	//����
	public Object outQueue(){
		Object obj=null;
		if(this.isEmpty()){		
			//�����ж϶����Ƿ�Ϊ��
			System.out.println("����Ϊ��");
		}else{
			this.front=(front+1)%size;//����ָ��Ϊ���1Ȼ��Զ��д�С����ȡģ
			obj=data[front];
			System.out.println(obj+"��վ");
		}
		return obj;
	}
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty(){
		boolean empty=true;
		if(this.rear==this.front){
			//�ӿ�
			empty=true;
		}else{					
			//��Ϊ��
			empty=false;
		}
		return empty;
	}
	//�ж϶����Ƿ�����
	public boolean isFull(){
		boolean full=true;
		if((this.rear+1)%size==this.front){
			//����
			full=true;
		}else{						
			//����
			full=false;
		}
		return full;
	}
}