package T2;


public class Leave {

	private Object[] data;
	private int top=-1;//��ջָ���
	private int size;
	public Leave(){
		data = new Object[100];
		this.size=100;
	}
	public Leave(int size){
		data = new Object[size];
		this.size=size;
	}
	//��ջ
	public Object pop(){
		Object obj = null;
		if(top>-1){
			obj = this.data[top];
			top--;
		}
		return obj;
	}
	
	//��ջ
	public void push(Object obj){
		if(top<size-1){
			top++;
			this.data[top]=obj;
			System.out.println(obj+"�Ͻ�");
		}else{
			System.out.println("\n----"+obj+"�����˼�������׼----\n");
		}
	}
	
	//�ж�ջ���Ƿ�Ϊ��
	public boolean empty(){
		boolean isEmpty = true;
		if(top>-1){
			isEmpty = false;
		}
		return isEmpty;
	}
	
	public static void main(String[] args) {
		Leave leave = new Leave();
		leave.push("�鳤");
		leave.push("���ž���");
		leave.push("���Ÿ���");
		leave.push("�ܾ���");
		leave.push("���³�");
		System.out.println("--------------");
		while(!leave.empty()){
			System.out.println(leave.pop()+"��׼!!!");
		}
		System.out.println("\n�Ǻ�~~�ؼ��^Q^");
	}
}
