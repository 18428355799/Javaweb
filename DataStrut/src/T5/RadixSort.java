package T5;

import java.util.Arrays;
/*
 * �����������ۺܺ���⣬����˼����ǣ������д��Ƚ���ֵ����������ͳһΪͬ������λ���ȣ���λ�϶̵���ǰ�油�㡣
 * Ȼ�󣬴����λ��ʼ�����ν���һ���������������λ����һֱ�����λ��������Ժ�,���оͱ��һ���������С�
	
	���ڻ������������ַ�����
	���λ���ȷ���MSD��(Most Significant Digit first)
	���λ���ȷ���LSD��(Least Significant Digit first)
	�����������ȶ��������㷨������ƽ��ʱ�临�ӳ̶�Ϊ��O(d(r+n))���ռ临�Ӷ�Ϊ��O��rd+n����
 * */
public class RadixSort {
	public static void main(String[] args) {  
        Integer[] array = new Integer[] { 1200, 292, 121, 72, 233, 44, 12 };  
        radixSort(array, 10, 4);  
        System.out.println("���������飺");  
        print(array);  
    }    
    /*
     * 8.��������  �ȶ��������㷨  
     * array    ��������
     * radix    �������
     * d        ��������Ԫ�ص�λ��
     */
    public static void radixSort(Integer []array, int radix, int d){
        // ��ʱ����  
        Integer[] tempArray = new Integer[array.length];  
        // count���ڼ�¼������Ԫ�ص���Ϣ,������ʾ��λ��i�����ĸ���  
        Integer[] count = new Integer[radix];  
        
        int rate = 1;
        for (int i = 0; i < d; i++) {  
            //����count���飬��ʼͳ����һ���ؼ���  
            Arrays.fill(count, 0);
            //��array�е�Ԫ����ȫ���Ƶ�tempArray������  
            System.arraycopy(array, 0, tempArray, 0, array.length);  
            
            //����ÿ�����������ݵ��ӹؼ���  
            for (int j = 0; j < array.length; j++) {  
                int subKey = (tempArray[j] / rate) % radix;  
                count[subKey]++;
            }  
            //ͳ��count�����ǰjλ������j�����ж��ٸ���
            for (int j = 1; j < radix; j++) {  
                count[j] = count[j] + count[j - 1]; 
            }  
            //���ӹؼ��ֶ�ָ�������ݽ������� ����Ϊ��ʼ�Ǵ�ǰ����ţ����ڴӺ���ǰ��ȡ����֤����������ȶ���
            for (int m = array.length - 1; m >= 0; m--) {  
                int subKey = (tempArray[m] / rate) % radix;  
                array[--count[subKey]] = tempArray[m]; //���뵽��--count[subKey]λ����Ϊ�����±��0��ʼ
            }  
            rate *= radix;//ǰ��һλ  
            System.out.print("��" + (i+1) + "�Σ�");
            print(array);
        }  
    }
    //�������===============
    public static void print(Integer[] array){  
	    for (int i = 0; i < array.length; i++){  
	        System.out.print(array[i] + "\t");  
	    }  
	    System.out.println();  
    }  
}
