package T2;

import java.util.Stack;

public class YufaCheck {

	/**
	 * дһ������������
	 * ���JavaԴ�����е������Ƿ�ƥ�䣬
	 * ��ÿ����{�����ж�Ӧ�ġ�}����ÿ�����������ж�Ӧ�ġ�������ʹ��ջʵ��
	 * 
	 * */
	public static void main(String[] args) {
		String str = "if((a==b)&&(c==d) || (x==y)){}";
		boolean flag = false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c=='('){
				//��������ջ
				stack.push(c);
			}else if(c==')'){
				try{
					//�����ų�ջ
					stack.pop();
				}catch(Exception e){
					System.out.println("����������(");
					flag=true;
				}
			}
			if(c=='{'){
				//��������ջ
				stack.push(c);
			}else if(c=='}'){
				try{
					//�����ų�ջ
					stack.pop();
				}catch(Exception e){
					System.out.println("����������{");
					flag = true;
				}
			}
		}
		if(!flag &&stack.size()==0){
			System.out.println("�﷨����");
		}
		if(stack.size()>0){
			System.out.println("����������");
		}
	}
}
