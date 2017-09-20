package listener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.*;
//ͬʱʵ��ServletContextListener,��ȡapplication����
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener,ServletContextListener{

	//��ȡapplication����
	ServletContext application=null;
	//��������ʱִ��
	public void sessionCreated(HttpSessionEvent arg0) {
		setApp(1);
		logout("��ʼ��session����Ŀǰ���������У�"+getApp());
	}
	public void sessionDestroyed(HttpSessionEvent arg0) {
		setApp(-1);
		logout("����session����");
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		logout("����һ��session������id="+arg0.getSession().getId()+","+arg0.getName()+"="+arg0.getValue());
		logout("Ŀǰ�У�"+getApp()+"λ��������");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		logout("ɾ��һ��session������id="+arg0.getSession().getId()+","+arg0.getName()+"="+arg0.getValue());
		logout("Ŀǰ�У�"+getApp()+"λ��������");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		logout("�޸�һ��session������id="+arg0.getSession().getId()+","+arg0.getName()+"="+arg0.getValue());
		
	}
	//д��־
	public void logout(String msg){
		try {
			//����һ�������������������ݱ��浽C�̵�log.txt�ļ��У�����ļ��������򴴽��������׷��
			PrintWriter out = new PrintWriter(new FileOutputStream("c:\\log.txt",true));
			out.println(new Date().toLocaleString()+"->"+msg);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//��application������ֵ
	public void setApp(int n){
		int count =0;
		//��һ���û�������վ
		if(application.getAttribute("count")==null){
			application.setAttribute("count",new Integer(1));
		}else{
			count = Integer.parseInt(application.getAttribute("count").toString());
			count = count +n;
			application.setAttribute("count",new Integer(count));
		}
	}
	public int getApp(){
		int count = 1;
		if(application.getAttribute("count")!=null){
			count = Integer.parseInt(application.getAttribute("count").toString());
		}
		return count;
	}
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	//��ʼ��ServletContextʱ�����Ի�ȡ����
	public void contextInitialized(ServletContextEvent sce) {
		application=sce.getServletContext();
	}
}
