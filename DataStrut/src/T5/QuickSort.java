package T5;

public class QuickSort {
	int a[];
	public QuickSort() {
		a = new int[]{8,19,2,3,100,99,1000,888,-1,0};
	}
	public QuickSort(int a[]) {
		this.a = a;
	}
	//����:i����߽�,j���ұ߽�
	int partition(int a[],int i,int j,int size){
		//��С��m�ķ���m�����,���ڵ���m�ķ���m���ұ�
		int m=a[i];
		while(i<j){
			//�������󣬲���С��m��Ԫ��
			while(i<j && a[j]>=m){
				j--;
			}
			if(i<j){
				a[i++]=a[j];
			}
			//�������ң����Ҵ���m��Ԫ��
			while(i<j && a[i]<m){
				i++;
			}
			if(i<j){
				a[j--]=a[i];
			}
		}
		a[i]=m;
//		print();
		return i;
	}
	//����
	public void quickSort(int a[],int left,int right,int size){
		if(left<right){
			int pos = partition(a, left, right, size);
			//�������
			quickSort(a, left, pos-1, size); //���úܶ��
			quickSort(a, pos+1,right, size);//���úܶ��
		}
//		else{
//			System.out.println("�������");
//		}
	}
	public void print(){
		for (int e : a) {
			System.out.print(e+"\t");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		/*8,19,2,3,100,99,1000,888,-1,0
		 * m=a[0]=8
		 * i=0,j=9
		 * ��������m=a[0]=8,i=0,j=9 a[j]=a[9]=0<m
		 * 0,19,2,3,100,99,1000,888,-1,0	m=8,i=1,j=9
		 * 0,19,2,3,100,99,1000,888,-1,19	m=8,i=1,j=8
		 * 0,-1,2,3,100,99,1000,888,-1,19	m=8,i=2,j=8
		 * 0,-1,2,3,100,99,1000,888,100,19	m=8,i=4,j=7
		 * 0,-1,2,3,100,99,1000,888,100,19	m=8,i=4,j=4
		 * 0,-1,2,3,8,99,1000,888,100,19
		 */
		QuickSort sort = new QuickSort();
		System.out.println("����ǰ����˳��");
		sort.print();
		long start = System.currentTimeMillis();
		sort.quickSort(sort.a, 0, sort.a.length-1, sort.a.length);
		sort.print();
		long end = System.currentTimeMillis()-start;
		System.out.println("������ʱ:"+end +"����");
	}
}
