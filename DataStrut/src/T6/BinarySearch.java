package T6;
//�۰����
public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] a = {1,3,5,6,7,8,9,12,15,16,18,21,23,25,26,27,30};
		bs.bSearch(a,30,0,a.length-1);
	}
	
	public boolean bSearch(int[] a,int key,int left,int right){
		int middle;
		//����߽�С���ұ߽�ʱ����û���ҵ������˳�ѭ��
		if(left>right){
			return false;
		}else {
			//ÿ�β���Ҫ�����趨��־λ
			middle=(right+left)/2;
			//��������ҵ����ݴ��ڱ�־λ���������Ұ���ٴβ���
			if(key<a[middle]){
				return bSearch(a, key, left, middle-1);
			}else if(key>a[middle]){
				return bSearch(a, key, middle+1, right);
			}else if(key==a[middle]){
				System.out.println("�ҵ���"+key+"��λ����"+middle);
				return true;
			}
		}
		return false;
	}
	
}
