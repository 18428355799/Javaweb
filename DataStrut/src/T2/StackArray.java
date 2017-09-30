package T2;

public class StackArray {

	Object[] data;
	//ջ����־
	int top=-1;
	public StackArray(){
		data = new Object[100];
	}
	
	public StackArray(int size){
		data = new Object[size];
	}
	//�ж�Ϊ�յĺ���
	public boolean isEmpty(){
		boolean isok = false;
		if(top==-1){
			isok = true;
		}
		return isok;
	}
	//�ж϶�ջ�Ƿ�����
	public  boolean isFull(){
		boolean isok = false;
		if(top+1>=data.length){
			isok=true;
		}
		return isok;
	}
	//��ջ
	public void push(String dat){
		if(isFull()){
			System.out.println("��ջ����");
			return;
		}
		top++;
		data[top]=dat;
	}
	//��ջ
	public Object pop(){
		if(isEmpty()){
			System.out.println("��ջ�ѿ�");
			return null;
		}
		return  data[top--];
	}
	//��ȡջ��Ԫ��
	public Object peek(){
		if (isEmpty()) {
			System.out.println("��ջ�ѿ�");
			return null;
		}
		return data[top];
	}
	//���ض�ջ��С
	public int size(){
		return top+1;
	}
	//����
	public int capacity(){
		return data.length;
	}
	//����
	public void search(String dat){
		for(int i=0;i<=top;i++){
			if(data[i].toString().equals(dat)){
				System.out.println("�ڵ�"+(i+1)+"λ���ҵ���"+dat);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		StackArray stack = new StackArray(5);
		stack.push("�鳤");
		stack.push("���ž���");
		stack.push("���Ÿ���");
		stack.push("�ܾ���");
		stack.push("���³�");
		stack.push("���³�����");
		//ջ��Ԫ��
		System.out.println("ջ��Ԫ��"+stack.peek());
		System.out.println("ջ��Ԫ��"+stack.peek());
		//��С
		System.out.println("--------------------size="+stack.size());
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println("--------------------size="+stack.size());
		System.out.println("ջ��Ԫ��"+stack.peek());
	}
}
