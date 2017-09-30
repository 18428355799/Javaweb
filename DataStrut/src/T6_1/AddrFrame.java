package T6_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class AddrFrame extends JFrame implements ActionListener{
	
	private JTable table;
	private JLabel lab;
	private JTextField name;
	private JButton query;
	private JPanel p1;
	private TelQuery tel_query;
	public AddrFrame(TelQuery tel_query){
		table = new JTable(10,2);
		table.setEnabled(false);
		lab = new JLabel("����");
		name = new JTextField(10);
		query = new JButton("��ѯ");
		p1 = new JPanel();
		this.setFrame();
		this.tel_query = tel_query;
		query.addActionListener(this);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	private void setFrame(){
		this.add(table);
		p1.add(lab);
		p1.add(name);
		p1.add(query);
		this.setTitle("�Ҽ���ͨѶ¼");
		this.add("South",p1);
		this.setBounds(100,100,300,200);
	}

	//��ť�¼�
	public void actionPerformed(ActionEvent e){
		Vector tel = tel_query.getAddr(name.getText());
		if(tel.size()>0){
			for(int i=0;i<tel.size();i++){
				table.setValueAt(name.getText(),i,0);
				table.setValueAt(tel.get(i),i, 1);
			}
		}else {
			JOptionPane.showMessageDialog(this, "û���ҵ�"+name.getText());
		}
	}
	
	public static void main(String[] args) {
		AddrFrame af = new AddrFrame(new TelQuery());
		af.show();
	}
}