package T3;

public class Test {

	public static void main(String[] args) {
		//����һ�����ж��󣬳�ʼ��ֵΪ10
		QueueArray qa = new QueueArray(10);
		//���
		qa.inQueue("1");
		qa.inQueue("2");
		qa.inQueue("3");
		qa.inQueue("4");
		qa.inQueue("5");
		//����
		qa.outQueue();
		qa.outQueue();
		System.out.println("\n��������:");
		//��ʼ����
		qa.display();
	}
}
