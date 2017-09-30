package T6;

import java.util.Random;
import java.util.Scanner;

import javax.xml.stream.events.StartDocument;

//���Բ���
public class LinearSearch1 {

	int a[];
	public LinearSearch1(){
		a = new int[10];
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.abs(rnd.nextInt(100));
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
	
	public LinearSearch1(int size){
		a = new int[size];
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.abs(rnd.nextInt(1000));
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
	
	public boolean search(int key){
		int index = -1;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==key){
				index = i;
				break;
			}
		}
		if(index>=0){
			System.out.println("�ڵ�"+(index+1)+"��λ���ҵ���"+key);
			return true;
		}else {
			System.out.println("�鲻����");
			return false;
		}
	}
	
	public static void main(String[] args) {
		long start = 0,end = 0;
		start = System.currentTimeMillis();
		LinearSearch1 line = new LinearSearch1(100);
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ���ҵ�����");
		int num = input.nextInt();
		line.search(num);
		end = System.currentTimeMillis()-start;
		System.out.println("�������ݻ�����"+end+"����");
	}
}
