package T1;

public class EatFish {
	
	 public static void main(String args[]) {
        NodeEat head = new NodeEat("��Ѫ��");
        LinkEat link = new LinkEat(head);
        link.addNode(new NodeEat("��"));
        link.addNode(new NodeEat("����"));
        link.addNode(new NodeEat("С��"));
        link.addNode(new NodeEat("СϺ"));
        link.addNode(new NodeEat("����"));
        NodeEat p = head;
        System.out.println("����һ��ʳ��������");
        while (p.hasNext()) { //���ȱ�����������
            p = p.getNext();
        }

        while (head.hasNext()) { //���ϵ�ɾ�����һ���ڵ�
            link.delLastNode();
        }
    }
}

class LinkEat {
    private NodeEat head;
    public LinkEat(NodeEat head) {
        this.head = head;
    }

    //׷�ӽڵ�
    public void addNode(NodeEat node) {
        NodeEat p = head;
        while (true) {
            if (!p.hasNext()) {
                p.setNext(node);
                break;
            }
            p = p.getNext();
        }
    }
	//ɾ���ڵ�
    public boolean delLastNode() {
        NodeEat p = head;
        if (!p.hasNext()) {
            System.out.println("�˱�Ϊ��");
            return false;
        } 
		while (p.getNext().getNext() != null) {
            p = p.getNext();
        }
        System.out.println("\n" + p.getName() + " ������ "
                           + p.getNext().getName() + " ����һ�ڣ��Ե��ˣ�-��");
        p.setNext(null);
        return true;
    }

    //��������
    public void display() {
        NodeEat p = head.getNext();
        while (p != null) {
            System.out.println(p.getName());
            p = p.getNext();
        }
    }
}

class NodeEat {
  private String nodeName;
    private NodeEat next;
    //����������һ���ڵ����
    public NodeEat(String nodeName) {
        this.nodeName = nodeName;
    }

    //������һ�ڵ�Ķ���
    public NodeEat getNext() {
        return this.next;
    }

    //���ñ��ڵ������
    public void setNext(NodeEat next) {
        this.next = next;
    }

    //���ؽڵ��������
    public String getName() {
        return this.nodeName;
    }

    //�ж��Ƿ�����һ�ڵ�
    public boolean hasNext() {
        boolean is = false;
        if (this.next != null) {
            is = true;
        }
        return is;
    }
}


