package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", "ThirdServlet");
		//��ȡServletContext����
		ServletContext sc = getServletContext();
		//ͨ��sc ��ȡRequestDispatcher����,����/��ͷ,ͨ��Servet��web.xml�����õ�����ȥ����
		RequestDispatcher rd = sc.getNamedDispatcher("ExampleServlet");
		//ת��
		rd.forward(request, response);
	}

}
