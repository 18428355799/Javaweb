package T5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ticket2 extends JFrame implements ActionListener{
	
	JTextField txtNum1,txtNum2,txtNum3,txtNum4,txtNum5,txtNum6,txtNum7;
	JTextArea txtResult;
	JRadioButton rbAuto,rbManual;
	JButton btnStart,btnSort,btnExit,btnClear;
	JPanel rightPanel,bottomPanel,topPanel,btnPanel;
	JComboBox cbOrderType;
	ButtonGroup bg;
	String arr[]={"ð������","��������","��������","ϣ������","ѡ������","������","�鲢����"};
	int a[] = new int[7];
	
	public Ticket2() {
		super("�Ҽ��ֲ�Ʊ��");
		txtNum1 = new JTextField();
		txtNum2 = new JTextField();
		txtNum3 = new JTextField();
		txtNum4 = new JTextField();
		txtNum5 = new JTextField();
		txtNum6 = new JTextField();
		txtNum7 = new JTextField();
		btnStart = new JButton("��ʼ");
		btnSort = new JButton("����");
		btnExit = new JButton("�˳�");
		btnClear = new JButton("���");
		cbOrderType = new JComboBox(arr);
		//����
		btnStart.addActionListener(this);
		btnSort.addActionListener(this);
		btnExit.addActionListener(this);
		btnClear.addActionListener(this);
		
		//��ʼ��ť��Ч������ť��Ч
		btnStart.setEnabled(true);
		btnSort.setEnabled(false);
		
		bg = new ButtonGroup();
		rbAuto = new JRadioButton("��ѡ");
		rbAuto.setSelected(true);//Ĭ��ѡ��
		rbManual = new JRadioButton("��ѡ");
		bg.add(rbAuto);
		bg.add(rbManual);
		txtResult = new JTextArea();
		rightPanel = new JPanel(new GridLayout(6,1,10,10));
		rightPanel.add(rbAuto);
		rightPanel.add(rbManual);
		rightPanel.add(cbOrderType);
		bottomPanel = new JPanel(new BorderLayout());
		topPanel = new JPanel(new GridLayout(1,7,10,10));
		topPanel.add(txtNum1);
		topPanel.add(txtNum2);
		topPanel.add(txtNum3);
		topPanel.add(txtNum4);
		topPanel.add(txtNum5);
		topPanel.add(txtNum6);
		topPanel.add(txtNum7);
		btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPanel.add(btnStart);
		btnPanel.add(btnSort);
		btnPanel.add(btnExit);
		btnPanel.add(btnClear);
		bottomPanel.add(topPanel,BorderLayout.NORTH);
		bottomPanel.add(btnPanel,BorderLayout.SOUTH);
		add(new JScrollPane(txtResult));
		add(rightPanel,BorderLayout.EAST);
		add(bottomPanel,BorderLayout.SOUTH);
		
		setSize(700, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnStart){
			if(rbAuto.isSelected()){//��ѡ
				Random rnd = new Random();
				for(int i=0;i<a.length;i++){
					a[i]=Math.abs(rnd.nextInt(100));
				}
				txtNum1.setText(a[0]+"");
				txtNum2.setText(a[1]+"");
				txtNum3.setText(a[2]+"");
				txtNum4.setText(a[3]+"");
				txtNum5.setText(a[4]+"");
				txtNum6.setText(a[5]+"");
				txtNum7.setText(a[6]+"");
			}else{//��ѡ
				try{
					a[0]=Integer.parseInt(txtNum1.getText());
					a[1]=Integer.parseInt(txtNum2.getText());
					a[2]=Integer.parseInt(txtNum3.getText());
					a[3]=Integer.parseInt(txtNum4.getText());
					a[4]=Integer.parseInt(txtNum5.getText());
					a[5]=Integer.parseInt(txtNum6.getText());
					a[6]=Integer.parseInt(txtNum7.getText());
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(this, "������100���ڵ������ַ���");
					return;
				}
			}
			btnStart.setEnabled(false);
			btnSort.setEnabled(true);
		}else if(e.getSource()==btnSort){
			//��ȡ�������ֵ
			int index = cbOrderType.getSelectedIndex();
			switch (index) {
			case 0:
				BubbleSort bubbleSort = new BubbleSort(a);
				bubbleSort.sort();
				a=bubbleSort.a;
				break;
			case 1:
				QuickSort quickSort = new QuickSort(a);
				quickSort.quickSort(quickSort.a, 0, a.length-1, a.length);
				a=quickSort.a;
				break;
			case 2:
				InsertSort insertSort = new InsertSort(a);
				insertSort.insertSort();
				a = insertSort.a;
				break;
			case 3:
				ShellSort shellSort = new ShellSort(a);
				shellSort.shellSort();
				a = shellSort.a;
				break;
			case 4:
				SelectionSort selectionSort = new SelectionSort(a);
				selectionSort.selectionSort();
				a = selectionSort.a;
				break;
			case 5:
				HeapSort heapSort = new HeapSort(a);
				heapSort.heapSort(heapSort.a);
				a = heapSort.a;
				break;
			case 6:
				MergeSort mergeSort = new MergeSort(a);
				mergeSort.sort(mergeSort.a);
				a = mergeSort.a;
				break;
			}
			//��ʾ���ı��������
			String str = txtResult.getText();
			str += "�����㷨��"+arr[index] +"\n";
			str += "ѡƱ�������:\n";
			for(int i=0;i<a.length;i++)
				str+= a[i]+"\t";
			str+="\n";
			txtResult.setText(str);
			btnStart.setEnabled(true);
			btnSort.setEnabled(false);

		}else if(e.getSource()==btnExit){
			System.exit(1);
		}else if(e.getSource()==btnClear){
//			txtResult.setText("");
			txtNum1.setText("");
			txtNum2.setText("");
			txtNum3.setText("");
			txtNum4.setText("");
			txtNum5.setText("");
			txtNum6.setText("");
			txtNum7.setText("");
			
		}
	}

	public static void main(String[] args) {
		new Ticket2();
	}
}
