package Test2;
//��������
public class InsertSort {
	int a[];
	public InsertSort() {
		a = new int[]{8,19,2,3,100,99,1000,888,-1,0};
	}
	public InsertSort(int a[]) {
		this.a = a;
	}
	//��������
	public void insertSort(){
		int insertNode,j;
//		System.out.println("�����У�");
		for(int i=1;i<a.length;i++){
			//�������ڵ㵽������
			insertNode = a[i];
			j=i-1;
			//��ʾ�����е�����
//			System.out.println("i="+i+";insertNode="+insertNode+";j="+j);
			while(j>=0 && insertNode<a[j]){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=insertNode;
		}
	}
	
	public void print(){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		InsertSort sort = new InsertSort();
		System.out.println("����֮ǰ��");
		sort.print();
		sort.insertSort();
		System.out.println("����֮��");
		sort.print();
	}
}
