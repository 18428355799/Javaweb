package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���봦��
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username"); //�������ǿؼ�����
		String pass = request.getParameter("password");
		System.out.println("username="+username+";password="+pass);
		if(username.equals("admin") && pass.equals("1234")){
			//�ض���success.jspҳ��
			response.sendRedirect("success.jsp");
			System.out.println("��¼�ɹ�");
		}else{
			System.out.println("��¼ʧ��");
			//�ض���success.jspҳ��
			response.sendRedirect("failed.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
