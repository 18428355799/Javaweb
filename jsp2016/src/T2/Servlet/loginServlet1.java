package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet1 extends HttpServlet{

	//��ʼ��
	@Override
	public void init() throws ServletException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String telephone = req.getParameter("telephone");
		String soft = req.getParameter("soft");
		String system = req.getParameter("system");
		String remark = req.getParameter("remark");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>���ʹ����Ϣ��������</title></head><body><h1 align='center' color='cyan'>���ʹ����Ϣ��������</h1>");
		out.println("�ǳƣ�"+username+"<br/>");
		out.println("�����ַ��"+email+"<br/>");
		out.println("�绰��"+telephone+"<br/>");
		out.println("�����"+soft+"<br/>");
		out.println("����ϵͳ��"+system+"<br/>");
		out.println("��ע��"+remark+"<br/>");
		out.println("</body></html>");
		System.out.println("username="+username+";email="+email+";telephone="+
				telephone+";soft="+soft+";system="+system+";remark="+remark);
		
	}
	@Override
	public void destroy() {
		
	}
}
