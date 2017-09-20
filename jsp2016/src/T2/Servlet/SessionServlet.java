package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	public static final String CONTENT_TYPE = "text/html;charset=utf-8";
	
	public void destroy() {
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		out.println("<br>�ͻ��˵�sessionID:"+request.getRequestedSessionId());
		out.println("<br>sessionID�Ƿ���cookie�ṩ��"+request.isRequestedSessionIdFromCookie());
		out.println("<br>sessionID�Ƿ�������URL�н��룺"+request.isRequestedSessionIdFromURL());
		out.println("<br>�ͻ��˷��ص�sessionID �Ƿ���Ч��"+request.isRequestedSessionIdValid());
		out.println("<br>sessionID�Ƿ�Ϊ�´����ģ�"+session.isNew());
		out.println("<br>session��Ĭ�ϴ����Ϊ��"+session.getMaxInactiveInterval()+"��");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
