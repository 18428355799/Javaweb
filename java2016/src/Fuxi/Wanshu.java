package Fuxi;
/**
 * ����(���е�������ӵ���������)
 * */
public class Wanshu {
	public static void main(String[] args) {
		int a;
		for(int i=6;i<1000;i++){
			a=0;
			for(int j=2;j<=i;j++){
				if(i%j==0){
					a+=i/j;
				}
			}
			if(i==a){
				System.out.println(i);
			}
		}
	}
}
