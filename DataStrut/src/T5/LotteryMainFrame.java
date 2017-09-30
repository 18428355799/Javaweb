package T5;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionListener;

public class LotteryMainFrame extends JFrame implements FocusListener, ActionListener{
	private JTextArea screen;
	private JScrollPane scroll;
	private JTextField input1;
	private JTextField input2;
	private JTextField input3;
	private JTextField input4;
	private JTextField input5;
	private JTextField input6;
	private JTextField input7;
	
	private JButton begin;
	private JButton tosort;
	private JButton exit;
	private JButton clear;
	private JLabel lab;
	
	private JRadioButton is1;
	private JRadioButton is2;
	private ButtonGroup type;
	private JPanel p1,p2,p3,p4,p5;
	private Container contentPane;
	private boolean hand=false;	//Ĭ��Ϊ��ѡ
	
	private int[] lottery;
	public LotteryMainFrame(){
		screen=new JTextArea();
		scroll=new JScrollPane(screen);
		input1=new JTextField(3);
		input2=new JTextField(3);
		input3=new JTextField(3);
		input4=new JTextField(3);
		input5=new JTextField(3);
		input6=new JTextField(3);
		input7=new JTextField(3);
		
		begin=new JButton("��ʼ");
		tosort=new JButton("����");
		//tosort.setEnabled(false);
		exit=new JButton("�˳�");
		clear=new JButton("���");
		
		lab=new JLabel("����");
		
		is1=new JRadioButton("��ѡ");
		is2=new JRadioButton("��ѡ");
		is1.setSelected(true);
		type = new ButtonGroup();
		type.add(is1);
		type.add(is2);
		contentPane=this.getContentPane();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		lottery=new int[7];
		is1.addFocusListener(this);
		is2.addFocusListener(this);
		
		begin.addActionListener(this);
		tosort.addActionListener(this);
		exit.addActionListener(this);
		clear.addActionListener(this);
		this.setFrame();
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	private void setFrame(){
		p1.add(input1);
		p1.add(input2);
		p1.add(input3);
		p1.add(input4);
		p1.add(input5);
		p1.add(input6);
		p1.add(input7);
		
		p2.add(begin);
		p2.add(tosort);
		p2.add(exit);
		p2.add(clear);
		p3.add(p1);
		p3.add(p2);
		p3.setLayout(new GridLayout(2,1));
		
		p4.setLayout(new GridLayout(2,1));
		p4.add(is1);
		p4.add(is2);
		
		p5.setLayout(new BorderLayout());
		p5.add("North",p4);
		
		this.add(scroll);
		this.add("South",p3);
		this.add("East",p5);
		this.setBounds(100,100,320,240);
		this.setTitle("�Ҽ��ֲ�Ʊ��");
	}

	public void focusGained(FocusEvent e){
		if(e.getSource()==is1){//��ѡ
			this.hand=false;		//���Ƿ�����ѡ��Ϊ��
			tosort.setEnabled(true);//������ť��Ϊ����
		}else if(e.getSource()==is2){//��ѡ
			this.hand=true;			//���Ƿ�����ѡ��Ϊ��
			tosort.setEnabled(false);//������ť����Ϊ������
			
			input1.setText("");		//��ý���ʱ��7���ı�������Ϊ��
			input2.setText("");
			input3.setText("");
			input4.setText("");
			input5.setText("");
			input6.setText("");
			input7.setText("");
			System.out.println("��ѡ");
			
		}
	}
	public void focusLost(FocusEvent e){
		
	}
	//��ť�¼�
	public void actionPerformed(ActionEvent e){
		String msg="";
		if(e.getSource()==begin){//��ʼ
			if(this.hand==true){	//��ѡ
				lottery[0]=Integer.parseInt(input1.getText());
				lottery[1]=Integer.parseInt(input2.getText());
				lottery[2]=Integer.parseInt(input3.getText());
				lottery[3]=Integer.parseInt(input4.getText());
				lottery[4]=Integer.parseInt(input5.getText());
				lottery[5]=Integer.parseInt(input6.getText());
				lottery[6]=Integer.parseInt(input7.getText());
				sort();
				msg=this.getLottery();
				screen.append(msg+"\n");
			}else if(this.hand==false){//��ѡ
				this.rand();
			}
		}else if(e.getSource()==tosort){//����
			this.sort();
			msg=this.getLottery();
			screen.append(msg+"\n");
		}
		else if(e.getSource()==exit){//�˳�
			System.exit(0);
		}else if(e.getSource()==clear){//���
			this.screen.setText(null);
			this.input1.setText(null);
			this.input2.setText(null);
			this.input3.setText(null);
			this.input4.setText(null);
			this.input5.setText(null);
			this.input6.setText(null);
			this.input7.setText(null);
		}
	}
	private void sort(){
		int t=0;
		for(int i=0;i<lottery.length-1;i++){
			for(int j=i+1;j<=lottery.length-1;j++){
				if(lottery[i]>lottery[j]){
					t=lottery[i];
					lottery[i]=lottery[j];
					lottery[j]=t;
				}
			}
		}
	}
	private String getLottery(){
		String msg="";
		for(int i=0;i<7;i++){
			msg+=lottery[i]+"    ";
		}
		return msg;
	}
	private void rand(){
		Random random=new Random();
		for(int i=0;i<7;i++){
			int temp=random.nextInt();//��0��ʼ��������������
			if(temp<0){				  //��������Ϊ����
				temp=-temp;
			}
			//��30ȡģ�ټ�1����1��30�����������浽ȫ������lottery��
			lottery[i]=temp%30+1;
		}
		input1.setText(lottery[0]+"");//���������䵽7���ı�����
		input2.setText(lottery[1]+"");
		input3.setText(lottery[2]+"");
		input4.setText(lottery[3]+"");
		input5.setText(lottery[4]+"");
		input6.setText(lottery[5]+"");
		input7.setText(lottery[6]+"");
	}
	
	public static void main(String[] args) {
		LotteryMainFrame mainFrame=new LotteryMainFrame();
		mainFrame.show();
	}
}