package Fuxi;
/**
 * ����ӵ����ִ���500�Ժ��Զ�ֹͣ
 * */
public class Jia {
	public static void main(String[] args) {
		int sum=0;
		for(int i=0;i<100;i++){
			sum+=i;
			if(sum>=500){
				System.out.println(sum);
				break;
			}
		}
	}
}
