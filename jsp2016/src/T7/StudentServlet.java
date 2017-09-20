package T7;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

	StudentsqlImp im = new StudentsqlImp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���봦��
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("order")!=null) {
			String order = request.getParameter("order");
			if(order.equals("list")){
				//��ѯ���е�����,��ת���б�ҳ��
				list(request, response);
				//�ض���Ŀ��ҳ��
				request.getRequestDispatcher("T7sj/votemain.jsp").forward(request, response);
			}else if (order.equals("save")) {
				StudentBean bean = new StudentBean();
				bean.setStudentname(request.getParameterValues("studentname"));
				im.addcount(bean);
				//��ȡѧԱ�����
				List<StudentBean> list = im.list();
				request.setAttribute("list", list);
				request.getRequestDispatcher("T7sj/student.jsp").forward(request, response);
			}else if (order.equals("add")) {
				im.addstudent(request.getParameter("studentname"));
				list(request, response);
				request.getRequestDispatcher("T7sj/votemain.jsp").forward(request, response);
			}
		}
	}
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		List<StudentBean> studentList = im.studentlist();
		request.setAttribute("studentList", studentList);
		
	}

}
