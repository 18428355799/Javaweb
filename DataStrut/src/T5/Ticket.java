package T5;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Ticket extends JFrame implements ActionListener{

	JLabel lb;
	JTextPane tex;
	JRadioButton but1,but2;
	JTextField tex1,tex2,tex3,tex4,tex5,tex6,tex7;
	JButton begin,paixu,isnull,close,kong;
	JPanel panel;
	ButtonGroup bg;
	
	int height=15;
	int width=15;
	public Ticket() {
		setTitle("�Ҽ��ֲ�Ʊ��");
		panel = new JPanel(null);
		lb = new JLabel("�Ҽ��ֲ�Ʊ��");
		lb.setFont(new Font("����",Font.BOLD,20));
		lb.setBounds(200, 20, 200, 30);
		panel.add(lb);
		
		tex = new JTextPane();
		tex.setBounds(0, 60, 380, 200);
		panel.add(tex);
		bg = new ButtonGroup();
		but1 = new JRadioButton("��ѡ",true);
		but1.setBounds(400, 80, 60, 30);
		but2 = new JRadioButton("��ѡ");
		but2.setBounds(400, 120, 60, 30);
		bg.add(but1); 
		bg.add(but2);
		panel.add(but1);
		panel.add(but2);
		
		tex1 = new JTextField();
		tex1.setBounds(10, 320, 60, 30);
		panel.add(tex1);
		
		tex2 = new JTextField();
		tex2.setBounds(80, 320, 60, 30);
		panel.add(tex2);
		
		tex3 = new JTextField();
		tex3.setBounds(150, 320, 60, 30);
		panel.add(tex3);
		
		tex4 = new JTextField();
		tex4.setBounds(220, 320, 60, 30);
		panel.add(tex4);
		
		
		tex5 = new JTextField();
		tex5.setBounds(290, 320, 60, 30);
		panel.add(tex5);
		
		tex6 = new JTextField();
		tex6.setBounds(360, 320, 60, 30);
		panel.add(tex6);
		
		tex7 = new JTextField();
		tex7.setBounds(430, 320, 60, 30);
		panel.add(tex7);
		
		begin = new JButton("��ʼ");
		begin.setBounds(30, 400, 60, 30);
		panel.add(begin);
		
		paixu = new JButton("����");
		paixu.setBounds(130, 400, 60, 30);
		panel.add(paixu);
		
		isnull = new JButton("���");
		isnull.setBounds(230, 400, 60, 30);
		panel.add(isnull);
		
		close = new JButton("�ر�");
		close.setBounds(330, 400, 60, 30);
		panel.add(close);
		
		kong = new JButton("���");
		kong.setBounds(430, 400, 60, 30);
		panel.add(kong);
		//����
		close.addActionListener(this);
		isnull.addActionListener(this);
		kong.addActionListener(this);
		begin.addActionListener(this);
		
		add(panel);
		this.setSize(520,500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==close){//�ر�
			System.exit(0);
		}else if(e.getSource()==isnull){//���
			if(tex7.getText()!=null && !tex7.getText().equals("")){
				tex7.setText(null);
				System.out.println("---------");
			}else if(tex7.getText().equals("") && tex6.getText()!=null && !tex6.getText().equals("")){
				tex6.setText(null);
			}else if(tex6.getText().equals("")  && tex5.getText()!=null  && !tex5.getText().equals("")){
				tex5.setText(null);
			}else if(tex5.getText().equals("")  && tex4.getText()!=null  && !tex4.getText().equals("")){
				tex4.setText(null);
			}else if(tex4.getText().equals("")  && tex3.getText()!=null  && !tex3.getText().equals("")){
				tex3.setText(null);
			}else if(tex3.getText().equals("")  && tex2.getText()!=null  && !tex2.getText().equals("")){
				tex2.setText(null);
			}else if(tex2.getText().equals("")  && tex1.getText()!=null  && !tex1.getText().equals("")){
				tex1.setText(null);
			}else {
				JOptionPane.showMessageDialog(this, "������Ϊ�գ�");
				return;
			}
		}else if(e.getSource()==kong){//���
			tex.setText(null);
			tex1.setText(null);
			tex2.setText(null);
			tex3.setText(null);
			tex4.setText(null);
			tex5.setText(null);
			tex6.setText(null);
			tex7.setText(null);
		}else if(e.getSource()==begin){//��ʼ
			long oldtime = System.currentTimeMillis();
			if(but1.isSelected()){//��ѡ
				if(!tex1.getText().equals("") || !tex2.getText().equals("") ||!tex3.getText().equals("") ||!tex4.getText().equals("") ||!tex5.getText().equals("") ||!tex6.getText().equals("") ||!tex7.getText().equals("")){
					JOptionPane.showMessageDialog(this, "��ѡ���˻�ѡ�����������������Ƿ��ѡ,��ѡ��ȷ�ϣ�����ر���ѡ");
				}else{//��ѡ
					//��ѡʱ����7λ�������
					int random = new Random().nextInt(8999999)+1000000;
					System.out.println(random);
					String string = random+"";
					tex1.setText(string.charAt(0)+"");
					tex2.setText(string.charAt(1)+"");
					tex3.setText(string.charAt(2)+"");
					tex4.setText(string.charAt(3)+"");
					tex5.setText(string.charAt(4)+"");
					tex6.setText(string.charAt(5)+"");
					tex7.setText(string.charAt(6)+"");
					char ch[]=new char[string.length()];
					for(int i=0;i<string.length();i++){
						ch[i]=string.charAt(i);
					}
					Arrays.sort(ch);
					String str="",str1=tex.getText();
					for(int i=0;i<ch.length;i++){
						str+=ch[i]+"    ";
					}
					str1+=str;
					tex.setText(str1+"\n���λ�ѡ��Ʊ���򹲻���ʱ��"+(System.currentTimeMillis()-oldtime)+"����\n");
					JOptionPane.showMessageDialog(this, "���λ�ѡ��Ʊ���򹲻���ʱ��"+(System.currentTimeMillis()-oldtime)+"����");
				}
			}else {
				try{
					if(tex7.getText().equals("") || tex7.getText()==null){
						JOptionPane.showMessageDialog(this, "���һ���ı���Ϊ�գ�������!");
					}else if(tex6.getText().equals("") || tex6.getText()==null){
						JOptionPane.showMessageDialog(this, "�������ı���Ϊ�գ������룡");
					}else if(tex5.getText().equals("") || tex5.getText()==null){
						JOptionPane.showMessageDialog(this, "������ı���Ϊ�գ������룡");
					}else if(tex4.getText().equals("") || tex4.getText()==null){
						JOptionPane.showMessageDialog(this, "���ĸ��ı���Ϊ�գ�������!");
					}else if(tex3.getText().equals("") || tex3.getText()==null){
						JOptionPane.showMessageDialog(this, "�������ı���Ϊ�գ������룡");
					}else if(tex2.getText().equals("") || tex2.getText()==null){
						JOptionPane.showMessageDialog(this, "�ڶ����ı���Ϊ�գ������룡");
					}else if(tex1.getText().equals("") || tex1.getText()==null){
						JOptionPane.showMessageDialog(this, "��һ���ı���Ϊ�գ������룡");
					}else {
						String string = "",string2 = tex.getText();
						int n[]={
								Integer.parseInt(tex1.getText()),
								Integer.parseInt(tex2.getText()),
								Integer.parseInt(tex3.getText()),
								Integer.parseInt(tex4.getText()),
								Integer.parseInt(tex5.getText()),
								Integer.parseInt(tex6.getText()),
								Integer.parseInt(tex7.getText())
						};
						Arrays.sort(n);
						for (int i = 0; i < n.length; i++) {
							string+=n[i]+" ";
						}
						string2+=string;
						tex.setText(string2+"\n������ѡ��Ʊ���򹲻���ʱ��"+(System.currentTimeMillis()-oldtime)+"����\n");
						JOptionPane.showMessageDialog(this, "������ѡ��Ʊ���򹲻���ʱ��"+(System.currentTimeMillis()-oldtime)+"����");
					}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(this, "�������ֵ���зǷ��ַ������������룡");
					tex1.setText(null);
					tex2.setText(null);
					tex3.setText(null);
					tex4.setText(null);
					tex5.setText(null);
					tex6.setText(null);
					tex7.setText(null);
				}
			}
		}
	}
	public static void main(String[] args) {
		new Ticket();
	}
}
