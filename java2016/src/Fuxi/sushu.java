package Fuxi;
/**
 * ��1~100֮�������
 * */
public class sushu {
	public static void main(String[] args) {
		int count = 0,t;
		for(int i=2;i<100;i++){
			t=0;
			for(int j=2;j<i;j++){
				if(i%j==0){
					t=1;
				}
			}
			if(t==0){
				System.out.println(i+"\t");
				count++;
			}
		}
		System.out.println("1��100֮���������"+count+"��");
	}
}
