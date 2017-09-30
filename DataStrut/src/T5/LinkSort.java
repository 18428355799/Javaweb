package T5;

public class LinkSort {

	private Link link;
	public static void main(String[] args) {
		//ͷ�ڵ�
		Node head = new Node(0,"head");
		//�׽ڵ�
		Node one = new Node(1,"��ɮ");
		Node two=new Node(2,"�����");
		Node three=new Node(3,"��˽�");
		Node four=new Node(4,"ɳ����");
		Node five=new Node(5,"������");
		//��������
		Link link=new Link(head);
		//��β����ӽڵ�
		link.addNode(one);
		link.addNode(two);
		link.addNode(three);
		link.addNode(four);
		link.addNode(five);
		System.out.println("����ǰ���");
		//�����б�
		link.display();
		
		LinkSort ls = new LinkSort(link);
		ls.sort();
		System.out.println("���ڵ�����ɴ�С�������");
		link.display();
	}
	public LinkSort(Link link){
		this.link=link;
	}
	
	//����������
	public void sort(){
		Node head=link.getHead();
		int tempID=0;
		String tempName=null;
		Node temp=null;
		//��һ�˴��׽ڵ㿪ʼ
		for(Node p=head.getNext();p.getNext()!=null;p=p.getNext())
		{
			//��p����һ���ڵ㿪ʼ�Ƚ�
			for(Node q=p.getNext();q!=null;q=q.getNext())
			{
				if(p.getID()<q.getID())
				{
					tempName=p.getName();
					p.setName(q.getName());
					q.setName(tempName);
					
					tempID=p.getID();
					p.setID(q.getID());
					q.setID(tempID);
				}
			}
		}
	}
}
//������
class Link{
	private Node head;
	public Link(Node head)
	{
		this.head=head;
	}
	public Node getHead()	//����ͷ�ڵ����
	{
		return head;
	}
	public void addNode(Node node)
	{
		Node p=head;
		while(true)
		{
			if(!p.hasNext())
			{
				p.setNext(node);
				break;
			}
			p=p.getNext();
		}
	}
	//����ڵ�
	public void insertNode(Node p,Node q)
	{
		q.setNext(p.getNext());
		p.setNext(q);
	}
	//��������
	public void display()
	{
		Node p=head.getNext();
		while(p!=null)
		{
			System.out.print(p.getName()+"   ");
			p=p.getNext();
		}
		System.out.println();
	}
}
//�ڵ���
class Node{
	private String nodeName;
	private int id;
	private Node next;
	//����������һ���ڵ����
	public Node(int id,String nodeName)
	{
		this.id=id;
		this.nodeName=nodeName;
	}
	//������һ�ڵ�Ķ���
	public Node getNext()
	{
		return this.next;
	}
	//���ñ��ڵ������
	public void setNext(Node next)
	{
		this.next=next;
	}

	//���ؽڵ��������
	public String getName()
	{
		return this.nodeName;
	}
	public int getID()
	{
		return this.id;
	}
	
	public void setName(String name)
	{
		this.nodeName=name;
	}

	public void setID(int id)
	{
		this.id=id;
	}
	//�ж��Ƿ�����һ�ڵ�
	public boolean hasNext()
	{
		boolean is=false;

		if(this.next!=null)
		{
			is=true;
		}
		return is;
	}
}
