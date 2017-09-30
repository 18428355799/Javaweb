package T6;

public class BTree {

	public void insert(Node root,Person1 person){
		
		System.out.println(root.getPerson().getID()+"    "+person.getID());
		
		if(root.getPerson().getID()<=person.getID()){	//������
		
			if(root.getRightChild()==null){
				System.out.println("---------------���Ҳ���"+person.getName());
				root.setRightChild(new Node(person));
			}else{
				System.out.println("����ת");
				insert(root.getRightChild(),person);
			}
		}else{											//������

			if(root.getLeftChild()==null){
				System.out.println("---------------�������"+person.getName());
				root.setLeftChild(new Node(person));
			}else{
				System.out.println("����ת");
				insert(root.getLeftChild(),person);
			}
		}
	}
	
	//�ڵ�Ĳ���
	public void find(Node root,int id){
		Node node = root;
		
		if(node.getPerson().getID()==id){//��ʼ����ʱ���ȿ�ʼ�ж�
			System.out.println("�ҵ�����"+node.getPerson().getName());
			return;
		}
		if(node.getPerson().getID()<id){//�������Ҫ���ҵĽڵ���Ƚϴ�С
		
			if(node.getRightChild()!=null){
				this.find(node.getRightChild(),id);//������������
			}else{
				System.out.println("û���ҵ�����");
				return;
			}
				
		}else if(node.getPerson().getID()>id){
			if(node.getLeftChild()!=null){
				this.find(node.getLeftChild(),id);//������������
			}else{
				System.out.println("û���ҵ�����");
				return;
			}
		}
		if(node.getLeftChild()==null&&node.getRightChild()==null){
			System.out.println("û���ҵ�����");
			return;	//û���ҵ�����
		}			
	}
}
