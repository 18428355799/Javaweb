package Test2;
//��������
public class QuickSort {

	int a[];
	public QuickSort() {
		a = new int[]{8,2,-1,0,4,7,99,100,43,5};
	}
	public QuickSort(int a[]){
		this.a = a;
	}
	
	//����,i����j����
	int partiton(int a[],int i,int j,int size){
		int m = a[i];
		while(i<j){
			//�������󣬲���С��M��Ԫ��
			while(i<j && a[j]>=m){
				j--;
			}
			if(i<j){
				a[i++]=a[j];
			}
			//�������ң����Ҵ���M��Ԫ��
			while(i<j && a[i]<m){
				i++;
			}
			if(i<j){
				a[j--]=a[i];
			}
		}
		a[i]=m;
		return i;
	}
	
	public void quicksort(int a[],int left,int right,int size){
		if(left<right){
			int pos = partiton(a, left, right, size);
			quicksort(a, left, pos-1, size);
			quicksort(a, pos+1, right, size);
		}
	}
	public void print(){
		for (int e : a) {
			System.out.print(e+"\t");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		System.out.println("����֮ǰ��˳��");
		sort.print();
		System.out.println("����֮���˳��");
		sort.quicksort(sort.a, 0, sort.a.length-1, sort.a.length);
		sort.print();
	}
}
