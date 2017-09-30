package T4;

public class ArrayTree {

	int max = 16;
	//����һ������Ϊ4�Ķ�����
	int[] node = new int[max];
	//�����������ڵ��ʼ��Ϊ0
	public ArrayTree(){
		for(int i=0;i<max;i++){
			node[i]=0;
		}
	}
	
	//���ӽڵ�
	public void addNode(int data){
		int level=1;
		while(node[level]!=0){
			if(data<node[level]){
				level = level*2;//������
			}else {
				level = level*2+1;//������
			}
		}
		//��Ԫ�ط���ڵ�
		node[level]=data;
	}
	
	//����
	public void display(){
		for(int i=1;i<max;i++){
			System.out.println("node["+i+"]="+node[i]);
		}
	}
	
	public static void main(String[] args) {
		ArrayTree at = new ArrayTree();
		at.addNode(4);
        at.addNode(2);
        at.addNode(6);
        at.addNode(1);
        at.addNode(3);
        at.addNode(5);
        at.addNode(7);
        at.display();
	        
	}
}
