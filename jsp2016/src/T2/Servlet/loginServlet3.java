package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet3 extends HttpServlet{

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
		
		PrintWriter out= resp.getWriter();
		String username = req.getParameter("username");
		String sex = req.getParameter("sex");
		String age = req.getParameter("age");
		String telephone = req.getParameter("telephone");
		String reason = req.getParameter("reason");
		String remark = req.getParameter("remark");
		
		out.println("<html>");
		out.println("<head><title>��ϲ����������ѡ</title></head>");
		out.println("<body>");
		out.println("������"+username+"<br/>");
		out.println("�Ա�"+sex+"<br/>");
		out.println("���䣺"+age+"<br/>");
		out.println("�绰��"+telephone+"<br/>");
		out.println("ϲ����ԭ��"+reason+"<br/>");
		out.println("Ϊʲôѡ��(��):"+remark+"<br/>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("username="+username+";sex="+sex+";age="+age+";telephone="+telephone+";reason="+reason+";remark="+remark);
	}
}
