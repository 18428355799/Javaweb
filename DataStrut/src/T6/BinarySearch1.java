package T6;

public class BinarySearch1 {

	public boolean bSearch(int[] a,int key){
		int left=0;
		int right = a.length-1;
		int middle;
		//����߽�С���ұ߽�ʱ����û���ҵ������˳�ѭ��
		while(left<=right){
			//ÿ�β���Ҫ�����趨��־λ
			middle = (right+left)/2;
			//��������ҵ����ݴ��ڱ�־λ���������Ұ���ٴβ���
			if(key>a[middle]){
				left=middle+1;
			}else if(key<a[middle]){
				right = middle-1;
			}else if(key==a[middle]){
				System.out.println("�ҵ���..."+middle);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		BinarySearch1 bs = new BinarySearch1();
		int[] a = {1,3,5,6,7,8,9,12,15,16,18,21,23,25,26,27,30};
		bs.bSearch(a,27);
	}
}
