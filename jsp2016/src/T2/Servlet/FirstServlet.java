package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����Servlet�ķ���
 * */
public class FirstServlet extends HttpServlet{
	
	String username;
	String age;
	String sex;
	
	//��ʼ������
	@Override
	public void init() throws ServletException {
		
	}
	//��ʼ����������Ҫ��ȡ���ò���ʱ�����øú�����ʼ��
	@Override
	public void init(ServletConfig config) throws ServletException {
		//��ȡServlet�������еĲ���
		username = config.getInitParameter("username");
		age = config.getInitParameter("age");
		sex = config.getInitParameter("sex");
		System.out.println("username="+username+";age="+age+";sex="+sex);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Ĭ�ϱ����ǣ�ISO8859-1������ı������ת��ΪGBK,GB2312��utf-8
		resp.setContentType("text/html;charset=utf-8");
		//������ݵ������
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>�����ҵĵ�һ��Servlet����</title></head>");
		out.println("<body>");
		out.println("<h1>�����ҵĵ�һ��Servlet����ִ�е���doGet����</h1>");
		out.println("<hr color='red'>");
		out.println("<h1>��ȡServlet�Ĳ���ֵ���£�</h1>");
		String str = "username="+username+";age="+age+";sex="+sex;
		out.println("<h2>"+str+"</h2>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	public void destroy() {
		
	}
}
