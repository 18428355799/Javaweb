package T2;

import java.util.*;

public class StackTest {
    public static void main(String args[]) {
    	MyStacks mystack = new MyStacks(10); //����һ��MyStack����,����С��Ϊ10
        mystack.push("���޷�");
        mystack.push("��ë��");
        mystack.push("ţ�п�");
        mystack.push("ë��");
        mystack.push("����");
        System.out.println("-------------------------------");
        System.out.println("�����ˣ�Ҫ���·���		^Q^");
        while (!mystack.empty()) {
            System.out.println("   �� " + mystack.pop() + " ȡ��������");
        }
    }
}


class MyStacks {
    private Object[] data;
    private int top = -1; //��ջָ���
    private int size;
    public MyStacks() {
        data = new Object[100];
        this.size = 100;
    }

    public MyStacks(int size) {
        data = new Object[size];
        this.size = size;
        System.out.println("Ҫ˯����,�����·���		^Q^");
    }

    //��ջ
    public Object pop() {
        Object obj = null; //����һ��Object���������洢ȡ�������ݣ���ʼ��Ϊnull
        if (top > -1) { //�ж϶�ջ�Ƿ�Ϊ�գ���ָ����λ��
            obj = this.data[top]; //������ȡ��
            top--; //��ָ��������ƶ�һλ
        }
        return obj; //��ȡ�������ݷ���
    }

    //��ջ
    public void push(Object obj) {
        //�����ջ�����Ļ�������ջ
        if (top < size - 1) {
            top++; //��ָ��������ƶ�һλ
            this.data[top] = obj; //�����ݷ���ջ��
            System.out.println("   �� " + obj + " �����¹�");
        } else { //�����ջ���������ݲ�����ջ
            System.out.println("----��ջ����----");
        }
    }

    //�ж϶�ջ�Ƿ�Ϊ��
    public boolean empty() {
        boolean isEmpty = true;
        if (top > -1) {
            isEmpty = false;
        }
        return isEmpty;
    }
}
