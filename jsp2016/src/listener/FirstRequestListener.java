package listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServlet;

public class FirstRequestListener extends HttpServlet implements ServletRequestListener,ServletRequestAttributeListener{

	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("�ͻ����ύ��һ������");
		ServletRequest sr = arg0.getServletRequest();
		if(sr.getRemoteAddr().startsWith("127")){
			sr.setAttribute("isLogin","ok");
		}else{
			sr.setAttribute("isLogin", "no");
		}
	}
	
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("�������");
	}
	
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest����������һ�����ԣ�name:"+arg0.getName()+",value:"+arg0.getValue());
	}
	
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest����ĳ�����Ա��Ƴ���name:"+arg0.getName()+",value:"+arg0.getValue());
	}
	
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest����ĳ�����Ա��ı䣬name:"+arg0.getName()+",value:"+arg0.getValue());
	}
	
}
