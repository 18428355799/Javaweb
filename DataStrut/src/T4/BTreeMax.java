package T4;

public class BTreeMax {

	int max;
	public BTreeMax(Node root){
		//�ø��ڵ��id��ʼ��Ϊmax
		max = root.getPerson().getId();
	}
	
	//����
	public void insert(Node root,Person person){
		System.out.println(root.getPerson().getId()+"  "+person.getId());
		if(root.getPerson().getId()<=person.getId()){//������
			if(root.getRightChild()==null){
				System.out.println("----------���Ҳ���"+person.getName());
				root.setRightChild(new Node(person));
			}else {
				System.out.println("����ת");
				insert(root.getRightChild(), person);
			}
		}else {//������
			if(root.getLeftChild()==null){
				System.out.println("----------�������"+person.getName());
				root.setLeftChild(new Node(person));
			}else {
				System.out.println("����ת");
				insert(root.getLeftChild(), person);
			}
		}
	}
	
	//����
	public void display(Node root){
		 if (root == null){
	            System.out.println("������Ϊ��");
	     }else{
            if (max < root.getPerson().getId()) { //��ʼ�Ƚ�
                max = root.getPerson().getId();
            }
            System.out.println("���ʽڵ�  ---->  " + root.getPerson().getName());
            if (root.getLeftChild() != null) {
                System.out.println("����ת");
                this.display(root.getLeftChild());
            }
            if (root.getRightChild() != null) {
                System.out.println("����ת");
                this.display(root.getRightChild());
            }
    	}
	}
	
	public static void main(String[] args) {
		Node root = new Node(new Person(3,"root"));
		BTreeMax tree = new BTreeMax(root);
		tree.insert(root,new Person(2,"22"));
		tree.insert(root, new Person(4, "44"));
        tree.insert(root, new Person(1, "11"));
        tree.insert(root, new Person(99, "9999"));
        tree.insert(root, new Person(5, "55"));
        System.out.println("��ʼ����");
        //�õ������ֵ
        tree.display(root);
		
	}
}
