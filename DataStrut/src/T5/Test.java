package T5;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		int a[] = new int[10000];
		Random random = new Random();
		int len = a.length;
		for (int i = 0; i < len; i++) {
			a[i] = random.nextInt();
		}
		long start = 0,end = 0;
		int b[] = new int[len];
		System.arraycopy(a, 0, b, 0, len);
		
		//ð������
//		start = System.currentTimeMillis();
//		BubbleSort bubbleSort = new BubbleSort(b);
//		bubbleSort.sort();
//		end = System.currentTimeMillis()-start;
//		System.out.println("ð�����򻨷ѣ�"+end+"����");
		
		//ϣ������
//		start = System.currentTimeMillis();
//		ShellSort shellSort = new ShellSort();
//		shellSort.shellSort();
//		end = System.currentTimeMillis()-start;
//		System.out.println("ϣ�����򻨷ѣ�"+end+"����");
		
		//��������
		start = System.currentTimeMillis();
		QuickSort quickSort = new QuickSort(a);
		quickSort.quickSort(quickSort.a, 0, len-1, len);
		quickSort.print();
		end = System.currentTimeMillis()-start;
		System.out.println("�������򻨷ѣ�"+end+"����");
		
		//������
		start = System.currentTimeMillis();
		HeapSort heapSort = new HeapSort(b);
		heapSort.heapSort(heapSort.a);
		heapSort.print();
		end = System.currentTimeMillis()-start;
		System.out.println("�����򻨷ѣ�"+end+"����");
		
	}
}
