package listener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener,ServletContextAttributeListener{

	//application����
	public void contextDestroyed(ServletContextEvent arg0) {
		logout("application�����Ѿ�������");
	}
	//��ʼ��
	public void contextInitialized(ServletContextEvent arg0) {
		logout("���ڳ�ʼ��application����");
	}
	//����һ��application����
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		logout("����һ��application������"+arg0.getName()+"="+arg0.getValue());
	}
	//ɾ��һ��application�ı���
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		logout("ɾ����һ��application������"+arg0.getName()+"="+arg0.getValue());
	}
	//�޸�application������ֵ
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		logout("�޸���һ��application������ֵ��"+arg0.getName()+"="+arg0.getValue());
	}
	public void logout(String msg){
		try {
			//����һ�������,����������ݱ��浽D�̵�log.txt�ļ��У�����ļ��������򴴽��������׷��
			PrintWriter out = new PrintWriter(new FileOutputStream("D:\\log.txt",true));
			out.println(new Date().toLocaleString()+"->"+msg);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
