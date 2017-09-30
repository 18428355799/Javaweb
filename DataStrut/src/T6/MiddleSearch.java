package T6;

import java.util.Random;
import java.util.Scanner;

import T5.BubbleSort;

//�۰����
public class MiddleSearch {

	int a[];
	
	public MiddleSearch(){
		a = new int[10];
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.abs(rnd.nextInt(100));
		}
		sort();
	}
	
	public MiddleSearch(int size){
		a = new int[size];
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.abs(rnd.nextInt(1000));
		}
		sort();
	}
	//����
	public void sort(){
		BubbleSort sort = new BubbleSort(a);
		sort.sort();
		a = sort.getA();
	}
	
	public boolean search(int key){
		int left = 0;
		int right = a.length-1;
		int middle = 0;
		int cnt = 0;
		while(left<=right){
			//ͳ�Ʋ��Ҵ���
			cnt++;
			//�ı�middle��ֵ
			middle = (right+left)/2;
			System.out.println("left="+left+",middle="+middle+",right="+right+",a[middle]="+a[middle]);
			if(key>a[middle]){
				//���벿��
				left = middle+1;
			}else if(key<a[middle]){
				right = middle-1;
			}else {
				System.out.println("�ڵ�"+(middle+1)+"��λ���ҵ���"+key+",������"+cnt+"��");
				return true;
			}
		}
		if(left>right){
			System.out.println("���޴���");
		}
		return false;
	}
	
	public static void main(String[] args) {
		MiddleSearch middle = new MiddleSearch(100);
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ���ҵ����ݣ�");
		int key = input.nextInt();
		middle.search(key);
	}
}
