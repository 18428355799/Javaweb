package T5;

public class BubbleSort {
	
	int a[];
	public int[] getA(){
		return a;
	}
	public BubbleSort() {
		a = new int[]{8,19,2,3,100,99,1000,888,-1,0};
	}
	public BubbleSort(int a[]) {
		this.a = a;
	}
	//ð������
	public void sort(){
		int t=0,k=0,len=a.length;
		//��ѭ������ѭ��������
		for(int i=0;i<len-1;i++){
			//��ѭ������ÿһ�˵Ĵ���
			k=0;
			for(int j=0;j<len-i-1;j++){
				//��ӡÿѭ��һ�κ����ݵı仯
				k++;
//				System.out.println("��"+(i+1)+"�˵ĵ�"+k+"��");
				if(a[j]>a[j+1]){
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
//				print();
			}
		}
		System.out.println("�����˳�����£�");
		print();
	}
	public void print(){
		
		for (int e : a) {
			System.out.print(e+"\t");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		System.out.println("����ǰ˳�����£�");
		bubbleSort.print();
		//����
		long start = System.currentTimeMillis();
		bubbleSort.sort();
		long end = System.currentTimeMillis()-start;
		System.out.println("������ʱ:"+end +"����");
	}
}
