package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet2 extends HttpServlet{

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
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>��¼ҳ��</title></head>");
		out.println("<body>");
		out.println("�û�����"+name+"<br>");
		out.println("���룺"+password+"<br>");
		out.println("</body>");
		out.println("</html>");
		System.out.println("name="+name+";password="+password);
	}
}
