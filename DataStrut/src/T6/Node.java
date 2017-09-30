package T6;

public class Node{
	private Person1 person;	//����ڵ����Ϣ
	private Node leftChild;	//����
	private Node rightChild;//�Һ���
	public Node(Person1 person)
	{
		this.person=person;
		this.leftChild=null;
		this.rightChild=null;
	}
	public Person1 getPerson()
	{
		return person;
	}
	public Node getLeftChild()
	{
		return leftChild;
	}
	public Node getRightChild()
	{
		return rightChild;
	}
	public void setLeftChild(Node leftChild)
	{
		this.leftChild=leftChild;
	}
	public void setRightChild(Node rightChild)
	{
		this.rightChild=rightChild;
	}
}

class Person1{
	private int id;
	private String name;
	public Person1(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public int getID()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public void setID(int id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
}