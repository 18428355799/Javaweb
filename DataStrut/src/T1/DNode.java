package T1;
//˫����
public class DNode {

	String name;
	//ǰ���ڵ��ַ
	DNode prior;
	//�����ڵ��ַ
	DNode next;
	public DNode(){}
	public DNode(String name){
		this.name = name;
		prior = null;
		next = null;
	}
}
