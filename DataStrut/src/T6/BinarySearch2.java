package T6;

public class BinarySearch2 {

	//���ҵ��ؼ���ʱ�����λ�ò�����true�����򷵻�false
	public boolean bSearch(int[] a,int key,int left,int right){
		int middle;
		//�ڲ���֮ǰ���ж�һ�����ұ߽�
		if(left>right){
			return false;
		}else {
			middle = (right+left)/2;
			//���Ҫ��������С�ڱ�־λ���ұ߽��1���еݹ�
			if(key<a[middle]){
				return bSearch(a, key, left, middle-1);
			}else if(key>a[middle]){
				return bSearch(a, key, middle+1, right);
			}else if(key==a[middle]){
				System.out.println("�ҵ���"+middle);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		BinarySearch2 bs = new BinarySearch2();
		int[] a = {1,3,5,6,7,8,9,12,15,16,18,21,23,25,26,27,30};
		bs.bSearch(a,27,0,a.length-1);
	}
}
