package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet{

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
		String username = req.getParameter("username");//�û���
		String password = req.getParameter("password");//����
		String cfgpwd = req.getParameter("cfgpwd");//ȷ������
		String sex = req.getParameter("sex");//�Ա�
		String age = req.getParameter("age");//����
		String hobit[] = req.getParameterValues("hobit");//����
		String place = req.getParameter("place");//��ַ
		PrintWriter pr = resp.getWriter();
		pr.println("<html><head><title>ע����Ϣ����</title></head><body><h1>ע����Ϣ����</h1>");
		pr.println("�ǳƣ�"+username+"<br/>");
		pr.println("���룺"+password+"<br/>");
		pr.println("ȷ�����룺"+cfgpwd+"<br/>");
		pr.println("�Ա�"+sex+"<br/>");
		pr.println("���䣺"+age+"<br/>");
		StringBuffer str_hobit = new StringBuffer("���ã�");
		for(int i=0;i<hobit.length;i++){
			str_hobit.append(hobit[i]+" ");
			System.out.println(str_hobit);
		}
		pr.println(str_hobit.toString()+"<br/>");
		pr.println("��ַ��"+place+"<br/>");
		pr.println("</body></html>");
		System.out.println("username="+username+";password="+password+";cfgpwd="+
				cfgpwd+";sex="+sex+";age="+age+";hobit="+hobit+";place="+place);
	}
	@Override
	public void destroy() {
		
	}
}
