package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.AesUtils;
import base.BaseDAOImpl;
import base.IBaseDAO;
import bean.PageObject1;
import bean.StudentVo;
import bean.bankVo;

public class studentServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("list")){
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentList.jsp").forward(request, response);
		}else if(action.equals("add")){
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentAdd.jsp").forward(request, response);
		}else if(action.equals("addSave")){
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			String username=request.getParameter("username");
			String sex=request.getParameter("sex");
			String homeaddr=request.getParameter("homeaddr");
			String email=request.getParameter("email");
			String date=request.getParameter("date");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			StudentVo student = new StudentVo();
			String pwd = request.getParameter("password").trim();
			//��������м���
			pwd = AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			student.setMobile(phone);
			student.setPassword(pwd);
			student.setUsername(username);
			student.setSex(Integer.parseInt(sex));
			student.setHomeaddress(homeaddr);
			student.setEmail(email);
			student.setProvinceId(Integer.parseInt(province));
			student.setCityId(Integer.parseInt(city));
			base.studentAdd(student);
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentList.jsp").forward(request, response);
		}else if(action.equals("del")){
			String studentID=request.getParameter("studentID");
			base.studentDel(Integer.parseInt(studentID));
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentList.jsp").forward(request, response);
		}else if(action.equals("update")){
			String studentID=request.getParameter("studentID");
			StudentVo  studentVo=base.findstudentById(studentID);
			request.setAttribute("studentVo", studentVo);
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			String studentid=request.getParameter("studentid");
			String phone=request.getParameter("phone");
			String username=request.getParameter("username");
			String sex=request.getParameter("sex");
			String homeaddr=request.getParameter("homeaddr");
			String email=request.getParameter("email");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			StudentVo dd=new StudentVo();
			dd.setUserId(Integer.parseInt(studentid));
			dd.setMobile(phone);
			dd.setUsername(username);
			dd.setSex(Integer.parseInt(sex));
			dd.setHomeaddress(homeaddr);
			dd.setEmail(email);
			dd.setProvinceId(Integer.parseInt(province));
			dd.setCityId(Integer.parseInt(city));
			base.studentUpdate(dd);
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentList.jsp").forward(request, response);
		}else if(action.equals("modifypwd")){
			String studentId = request.getParameter("studentId");
			String oldpwd = AesUtils.encryptStr(request.getParameter("oldpwd"),AesUtils.SECRETKEY);
			String newPassword = AesUtils.encryptStr(request.getParameter("newPassword"),AesUtils.SECRETKEY);
			if(base.checkpwd(studentId, oldpwd)){
				base.modifypwd2(studentId, newPassword);
				request.setAttribute("msg", "��ϲ�㣬�����޸ĳɹ��������Ʊ���");
			}else{
				request.setAttribute("msg", "�����������������������");
			}
			request.getRequestDispatcher("/T11/modifypwd1.jsp").forward(request, response);
		}else if(action.equals("initpwd")){
			String studentId = request.getParameter("studentId");
			base.modifypwd2(studentId, AesUtils.encryptStr("8888", AesUtils.SECRETKEY));
			listPage(request, response);
			request.setAttribute("msg","��ʼ������ɹ�����ʼ����Ϊ��8888");
			request.getRequestDispatcher("/T11/studentList.jsp").forward(request, response);
		}
	}
	//��ѯ���е�ѧ������
	protected void list(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		List<StudentVo>  studentList=base.studentList();
		req.setAttribute("studentList", studentList);
	}
	//��ҳ��ʾ
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡҳ��Ĳ���
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//��ȡ�ܼ�¼��
		int cnt = base.getCount("select count(*) cnt from student");
		PageObject1 pager = new PageObject1();
		//���õ�һ������
		pager.setRecordCount(cnt);
		//���õڶ�������
		if(currentPage==null || currentPage.equals("")){
			pager.setCurrentPage(1);
		}else{
			pager.setCurrentPage(Integer.parseInt(currentPage));
		}
		//���õ���������
		if(opr==null || opr.equals("")){
			pager.setOpr("first");
		}else{
			pager.setOpr(opr);
		}
		//��ȡ��ǰҳ
		int currPage = pager.getCurrentPage();
		//��ȡ���ݿ������е���������
		List<StudentVo> studentList = base.findstudentByPage(pager.getPageSize(), pager.getStartPos());
		//����request����������������Ե���������
		request.setAttribute("studentList", studentList);
		request.setAttribute("pager", pager);
	}



}
