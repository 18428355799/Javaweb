package T2;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		Stack<String> myStack = new Stack<String>();
		myStack.push("�鳤");
		myStack.push("���ž���");
		myStack.push("���ܸ���");
		myStack.push("�ܾ���");
		myStack.push("���³�");
		//ȡջ��Ԫ�أ�����ɾ��
		System.out.println(myStack.peek());
		System.out.println(myStack.peek());
		//��С
		System.out.println("------------size="+myStack.size());
		//����
		System.out.println("------------size="+myStack.capacity());
		while(!myStack.isEmpty()){
			//ȥջ��Ԫ�أ�ͬʱɾ����Ԫ��
			System.out.println(myStack.pop());
		}
		//��С
		System.out.println("------------size="+myStack.size());
		//����
		System.out.println("------------size="+myStack.capacity());
	}
}
