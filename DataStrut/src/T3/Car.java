package T3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Car extends JFrame implements ActionListener{

	JPanel southPanel;
	JButton btnIn,btnOut;
	CQueue queue;
	ImagePanel imagePanel;
	int index=-1;
	boolean flag=false;
	public Car() {
		super("�Ҽ���ͣ����...");
		queue = new CQueue();
		//����ͼ��
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("qq.jpg");
		setIconImage(img);
		java.awt.Container c = getContentPane();
		southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		imagePanel = new ImagePanel();
		btnIn = new JButton("���");
		btnOut = new JButton("����");
		btnIn.addActionListener(this);
		btnOut.addActionListener(this);
		southPanel.add(btnIn);
		southPanel.add(btnOut);
		c.add(imagePanel);
		c.add(southPanel,BorderLayout.SOUTH);
		setSize(1250, 250);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIn){
			System.out.println("��վ������"+queue.rear);
			flag=true;
			index = queue.inQueue("1");
			imagePanel.repaint();
		}else if(e.getSource()==btnOut){
			System.out.println("��վ������"+queue.front);
			flag=false;
			index=queue.outQueue();
			imagePanel.repaint();
		}
	}
	//�ڲ���
	class ImagePanel extends JPanel{
		ImageIcon[] images ={
				new ImageIcon("qq.jpg"),
				new ImageIcon("clear.jpg")
		};
		int width=126; //ͼƬ��
		int height=131;//ͼƬ�ĸ�
		@Override
		public void paint(Graphics g) {
			if(index>=0){
				if(flag){
					g.drawImage(images[0].getImage(), index*width, 0,width,height,Color.BLUE, this);
				}else{
					g.drawImage(images[1].getImage(), index*width, 0,width,height,Color.BLUE, this);
				}
			}
		}
	}
	public static void main(String[] args) {
		new Car();
	}
}
