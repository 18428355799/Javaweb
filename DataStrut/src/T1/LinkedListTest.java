package T1;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		//��������
		LinkedList list = new LinkedList();
		//��ӽڵ�
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		//��ȡʵ��,����
		Iterator li = list.iterator();
		//�ж��Ƿ�����һ���ڵ�
		while(li.hasNext()){
			//ȡ�õ�ǰ�ڵ㲢��ȡ��һ�ڵ�
			System.out.println(li.next());
		}
	}
}
