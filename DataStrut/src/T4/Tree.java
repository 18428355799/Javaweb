package T4;

public class Tree {

	//���ݽڵ�
	private int data;
	//������
	private Tree left;
	//������
	private Tree right;
	
	//��ʼ��
	public Tree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	//���������������ظ��ڵ�
	public static Tree createTree(int[] input){
		Tree root = null;
		Tree temp = null;
		for(int i=0;i<input.length;i++){
			//�������ڵ�
			if(root==null){
				root = temp = new Tree(input[i]);
			}else {
				//�ص����ڵ�
				temp = root;
				//��ӽڵ�
				while(temp.data!=input[i]){
					if(input[i]<=temp.data){
						if(temp.left!=null){
							temp = temp.left;
						}else {
							temp.left= new Tree(input[i]);
						}
					}else{
						if(temp.right!=null){
							temp = temp.right;
						}else {
							temp.right= new Tree(input[i]);
						}
					}
				}
			}
		}
		return root;
	}
	//ǰ�����
	public static void preOrder(Tree tree) {  
		if(tree!=null){
			System.out.println(tree.data+" ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}  
	//�������
	public static void midOrder(Tree tree){
		if(tree!=null){
			midOrder(tree.left);
			System.out.println(tree.data+" ");
			midOrder(tree.right);
		}
	}
	//�������
	public static void posOrder(Tree tree){
		if(tree!=null){
			posOrder(tree.left);
			posOrder(tree.right);
			System.out.println(tree.data+" ");
		}
	}
	
    
	public static void main(String[] args) {
		int[] input = {4, 2, 6, 1, 3, 5, 7};
		Tree tree = createTree(input);
		System.out.println("ǰ�����");
		preOrder(tree);
		System.out.println("\n�������");
		midOrder(tree);
		System.out.println("\n�������");
		posOrder(tree);
		
	}
}
