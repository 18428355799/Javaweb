package T4;

public class BTree {

	int num=0;
	public void insert(Node root,Person person){
		System.out.println("ת���ڵ�id��"+root.getPerson().getId()+"   Ҫ����Ľڵ�:"+person.getId());
		//������
		if(root.getPerson().getId()<=person.getId()){
			if(root.getRightChild()==null){
				System.out.println("--------���Ҳ���:"+person.getName());
				root.setRightChild(new Node(person));
			}else {
				System.out.println("����ת");
				insert(root.getRightChild(), person);
			}
		}else {
			//������
			if(root.getLeftChild()==null){
				System.out.println("--------������룺"+person.getName());
				root.setLeftChild(new Node(person));
			}else {
				System.out.println("����ת");
				insert(root.getLeftChild(), person);
			}
		}
	}
	public void leafNum(Node root){
		if(root==null){
			System.out.println("������Ϊ��");
		}else {
			//û���ӽڵ�
			if((root.getRightChild()==null)&&(root.getLeftChild()==null)){
				//Ҷ������+1
				num++;
			}
			System.out.println("���ʽڵ�->>"+root.getPerson().getName());
			if(root.getLeftChild()!=null){
				System.out.println("����ת");
				this.leafNum(root.getLeftChild());
			}
			if(root.getRightChild()!=null){
				System.out.println("����ת");
				this.leafNum(root.getRightChild());
			}
		}
	}
	public int getLeafNum(){
		return num;
	}
}
