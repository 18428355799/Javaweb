package T5;

import java.util.Arrays;
/**
 * 
1��������Ҳ��ѡ�������һ�֣����ݶѵ����ԣ�ÿ�ΰ�������Сֵ�����������ֵΪ�����ó������������У�
2���������Ƕ���ͨѡ�������һ���Ż��������һ���ȶ��ѣ�ÿ����ѡ�����ֵʱ��ֻ�����Ŷ���������һ���ֲ�ȥ�������ɣ�
�����ֲ���϶ѵ����ԣ������źõ��ȶ��ѣ������Կ������ȶ��ģ��������Ž�����ʡȥ�˾�������ıȽϽ������裬
�������Խ�࣬��֧Խ�࣬���㷨�����ƾ�Խ���ԣ�

3����һ�����������ʼ��Ϊ�ȶ��ѣ��ȶ��ѵ����ԣ�������֮���ڵ��ܱ������Һ��ӽڵ�󣡳�ʼ���ȶ����кܶ෽����
���ԴӶѶ���ѵ׷����ʼ����Ҳ���ԴӶѵ���Ѷ��������г�ʼ����Ҳ����ͨ��С���ǵݹ������ɳ�ʼ����
����Ϊ��ⷽ�㣬ѡ�ôӶѵ���Ѷ������ʼ��������ÿ�δ�С�������ҵ����ֵ���ڸ��ڵ㣬
�����һ��С������ǰѭ������һ�飬�ҵ������������ֵ���ڶ���ѭ���ҵ������ֵ���ڵڶ���ڵ��ϣ�
�������ƣ�����ȶ��ѵó�ʼ����

4����ʼ�����ȶ���֮�󣬽�ѡ�������ֵ�����һ�����ֽ���������������̶��������Ժ�ѭ�������õ������֣���
��ʱ���˶������ǲ��ȶ������涼���ȶ��ģ������ȶ��ѵ����ԣ����ڵ����Ǵ��������Һ��ӽڵ㣩���Ӷ������ײ�Ѱ��
������ֻ���ű䶯���Ǹ��ֲ潻����ȥ��ֻ�õ���һ��ѭ�����ɣ��������ֲ治�ö���������Ϻ󣬴�������ֱ��Ƶ�
��������ʱ�Ķ���Ȼ��һ���ȶ��ѣ��ٽ����������ֵ����������ĺ���̶��������ظ�������裬�������ƣ�������ɣ�
����������
1����ʼ����������������ȷ������������Ƕ������Ĳ�������Сһ��

2����ʼ���Ѻ�����������length-2��

����ԭ��

�ȶ������ԣ����������򣬾������������˼��
 * */
public class HeapSort {
	int a[];
	public HeapSort() {
		a = new int[]{8,19,2,3,100,99,1000,888,-1,0};
	}
	public HeapSort(int a[]) {
		this.a = a;
	}
	//������
	public void heapSort(int[] array){  
        int length=array.length;  
        initHeap(array, length);//��ʼ���ȶ���  
//        System.out.println("��ʼ���Ѻ�" + Arrays.toString(array));  
        switchData(array,0,length-1);//������һ��Ԫ�غͱ������һ��Ԫ��  
        //����������  
        for (int length2 = length - 1; length2 > 1 ; length2--) {//ѭ��length - 2��  
            int index=0;  
            while(2 * index + 1 < length2){//ֻҪ�����ӽڵ�Ϳ��ܲ�������������ѭ��  
                if (2 * index + 2 < length2) {//���Һ��Ӷ���  
                    int max = index; //Ĭ���Ǹ��ڵ���±� 
                    if (array[max] < array[2 * index + 1]) {  
                        max = 2 * index + 1;  //�������ӵ��±�
                    }  
                    if (array[max] < array[2 * index + 2]) {  
                        max = 2 * index + 2; //�����Һ��ӵ��±� 
                    }  
                    if (max != index) {  
                        switchData(array, index, max);  
                        index = max;  
                    }else {  
                        break;//max==index����ʾ�ڵ��������ĶѶ����ȶ��ģ����ü���ѭ��  
                    }  
                      
                }  
                if (2 * index + 1 < length2 && 2 * index + 2 >= length2) {//ֻ�����ӣ�û���Һ���  
                    if (array[index] < array[2 * index + 1]) {  
                        switchData(array, index, 2 * index + 1);  
                    }else {  
                        break;//2 * index + 1==index����ʾ�ڵ��������ĶѶ����ȶ��ģ����ü���ѭ��  
                    }  
                }  
            }  
//            print();
            switchData(array, 0, length2 - 1);//������һ��Ԫ�غͱ������һ��Ԫ��  
//            print();
        }  
    }
	//��ʼ����
	public void initHeap(int[] array,int length){  
        int high=length-1; //����±� 
        boolean isChange=false;  
        //k�ĳ�ʼֵ��������һ�����ն˽ڵ�
        for(int k=(high-1)/2;k >= 0;k--){  
            //�ҵ����һ�����ڵ�  
            int left=2*k+1;  	//���ӵ��±�
            int right=left+1;  //�Һ��ӵ��±�
            //�ж��Ƿ��нڵ�  
            if(left<=high){  
                int max=left; //Ĭ��ֵ 
                if(right<=high){  
                    if(array[left]<array[right]){  
                        max=right;  //�������ӻ����Һ��������ֵ���±�
                    }  
                }  
                //�����ֵ�����ڵ㽻��  
                if(array[max] > array[k]){  
                    isChange=true;  
                    switchData(array,max,k);  
                }  
            }  
        }  
        if(isChange){//���һ�ξ�������ȶ��ѵĳ�ʼ����������Ҫ�ݹ���ã��Դﵽ�Ż��㷨��Ŀ��  
            initHeap(array,length);   
//            System.out.println("�ݹ飺"+Arrays.toString(array));  
        }  
	}
	//�����������������ķ�������ΪҪ����õ�����װ��һ��������  
    public static void switchData(int[] array,int index1 ,int index2){  
        array[index1] ^= array[index2];  
        array[index2] ^= array[index1];  
        array[index1] ^= array[index2];  
    }  
    public void print(){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		HeapSort sort = new HeapSort();
		System.out.println("����֮ǰ��");
		sort.print();
		System.out.println("========================");
		sort.initHeap(sort.a, sort.a.length);
		sort.heapSort(sort.a);
		sort.print();
	}
}
