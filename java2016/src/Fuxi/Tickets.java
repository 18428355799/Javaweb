package Fuxi;
/**
 * ��Ʊϵͳ
 * */
public class Tickets extends Thread{
	static int ticket=100;
	static String s = "";
	public void run(){
		while(true){
			synchronized (s) {
				if(ticket>0){
					ticket-=1;
					System.out.println(Thread.currentThread().getName()+"ȡ��1��Ʊ����ʣ��"+ticket+"��Ʊ");
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}else{
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		Tickets t1  = new Tickets();
		t1.setName("��ƱԱ");
		t1.start();
		Tickets t2 = new Tickets();
		t2.setName("Ʊ");
		t2.start();
	}
	
}
