package T4;
//������ʵ�ֶ�����
public class BTreeArray {

	//����ʵ�ֶ������Ĵ洢10,8,7,3,1��-10,6,20,90,100
	//����0λ�����ڵ�����
	int data[];
	int size;
	
	public BTreeArray(int dat){
		size=33;
		data = new int[size];
		data[1]=dat;
	}
	public BTreeArray(int size,int dat){
		this.size = size;
		data = new int[this.size];
		data[1]=dat;
	}
	//�����ڵ�
	public void addNode(int dat){
		int i=1;
		while(true){
			if(data[i]>dat){//������
				i = i*2;//���ӵ��±�
				if(data[i]==0){
					data[i]=dat;
					break;
				}
			}else {
				i = i*2+1;//�Һ��ӵ��±�
				if(data[i]==0){
					data[i]=dat;
					break;
				}
			}
		}
	}
	
	//����
	public void display(){
		for(int i=0;i<size;i++){
			System.out.println("data["+i+"]"+data[i]);
		}
	}
	
	public static void main(String[] args) {
		BTreeArray tree = new BTreeArray(10);
		tree.addNode(8);
		tree.addNode(7);
		tree.addNode(20);
		tree.addNode(90);
		tree.addNode(100);
		tree.addNode(3);
		tree.addNode(6);
		tree.addNode(1);
		tree.addNode(-10);
		tree.display();
	}
}
