package Test1;
/**
 * 3.������ʵ�ֶ������Ĺ��ܣ�Ҫ�����£�
1.�����ڵ��ࣻ
2.ʵ�������ڵ㹦�ܣ�
3.ʵ���ȸ������ڵ㹦�ܣ�
4.ʵ���и������ڵ㹦�ܣ�
5.ʵ�ֺ�������ڵ㹦�ܣ�
 * 
 * */
public class BTree {

	//���ڵ�
	Node root;
	public BTree(int data){
		root = new Node(data);
	}
	
	//�����ڵ�
	public void addNode(int data){
		Node p = root;
		//���������ڵ�
		Node t = new Node(data);
		while(true){
			//�ŵ����ڵ�����
			if(p.data>data){
				if(p.leftChild!=null){
					p = p.leftChild;
				}else {
					p.leftChild = t;
					break;
				}
			}else {
				//�ŵ����ڵ���ұ�
				if(p.rightChild!=null){
					p = p.rightChild;
				}else {
					p.rightChild = t;
					break;
				}
			}
		}
	}
	
	//����
	public void display(Node root){
		//�ȸ����� 10,8,7,3,1��-10,6,20,90,100
		System.out.println(root.data);
		if(root.leftChild!=null){
			System.out.println("������");
			display(root.leftChild);
		}
		//�и����� -10,1,3,6,7,8,10,20,90,100
//		System.out.println(root.data);
		if(root.rightChild!=null){
			System.out.println("������");
			display(root.rightChild);
		}
		//������� -10,1,6,3,7,8,100,90,20,10
//		System.out.println(root.data);
		
	}
	
	public static void main(String[] args) {
		//10,8,7,20,90,100,3,6,1,-10
		BTree tree = new BTree(10);
		tree.addNode(8);
		tree.addNode(7);
		tree.addNode(20);
		tree.addNode(90);
		tree.addNode(100);
		tree.addNode(3);
		tree.addNode(6);
		tree.addNode(1);
		tree.addNode(-10);
		tree.display(tree.root);
	}
}
