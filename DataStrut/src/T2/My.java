package T2;

public class My {

	Object[] data;
	//ջ����־
	int top=-1;
	public My(){
		data = new Object[100];
	}
	
	public My(int size){
		data = new Object[size];
		System.out.println("Ҫ˯���ˣ������·���,^o^");
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
		System.out.println("��"+dat+"�����¹�");
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
		My stack = new My();
		stack.push("���޷�");
		stack.push("��ë��");
		stack.push("ţ�п�");
		stack.push("ë��");
		stack.push("����");
		System.out.println("----------------------------");
		System.out.println("�����ˣ�Ҫ���·��ˣ�^o^");
		System.out.println("----------------------------");
		while(!stack.isEmpty()){
			System.out.println("��"+stack.pop()+"�ó�������");
		}
	}
}
