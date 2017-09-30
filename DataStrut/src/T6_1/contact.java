package T6_1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class contact extends JFrame implements ActionListener{

	JTable dataTable;
	JLabel lblUsername;
	JTextField txtUsername;
	JButton btnFind;
	//��ͷ������
	String head[]={"����","�绰����"};
	String data[][];
	public contact() {
		super("�Ҽ���ͨѶ¼����ϵͳ");
		//�������ļ���data������
		readFile();
		dataTable = new JTable(data,head);
		dataTable.setRowHeight(40);
		add(new JScrollPane(dataTable));
		lblUsername = new JLabel("������");
		txtUsername = new JTextField(20);
		btnFind = new JButton("����");
		btnFind.addActionListener(this);
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.add(lblUsername);
		bottomPanel.add(txtUsername);
		bottomPanel.add(btnFind);
		add(bottomPanel,BorderLayout.SOUTH);
		setSize(400,450);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//��ͨѶ¼�ļ�
	public void readFile(){
		File file= new File("contact.txt");
		if(!file.exists()){
			JOptionPane.showMessageDialog(this, "�ļ�������");
			System.exit(0);
		}
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String strLine="";
			String str="";
			while((strLine=br.readLine())!=null){
				str += strLine +";";
			}
			String arr[] = str.split(";");
			int size=arr.length;
			data = new String[size][2];
			for (int i=0;i<size;i++) {
				data[i]=arr[i].split("@");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnFind){
			//��ȡ�ı��������
			String username = txtUsername.getText().trim();
			int index = -1;
			for(int i=0;i<data.length;i++){
				if(username.equals(data[i][0])){
					index = i;
					break;
				}
			}
			if(index<0){
				JOptionPane.showMessageDialog(this, "û���ҵ�����ҵ��û�����");
				return;
			}else{
				//�Ѳ��ҵ����û���������Ϊѡ��״̬
				dataTable.setRowSelectionInterval(index, index);
			}
		}
	}
	public static void main(String[] args) {
		new contact();
	}
}
