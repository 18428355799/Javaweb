package mytag;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.BaseDAOImpl;
import base.IBaseDAO;
import bean.PageObject1;
import bean.TeacherGradeVo;

public class GradeServlet2 extends HttpServlet {
	
	IBaseDAO baseDao = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���봦��
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action!=null){
			 if(action.equals("init")){
				//��ȡ��ʦ������
				List<TeacherGradeVo> teacherList = baseDao.gradeList();
				request.setAttribute("teacherList", teacherList);
				//�ض���
				request.getRequestDispatcher("/T7/gradeAdd.jsp").forward(request, response);
			}else if(action.equals("add")){
				//��ȡҳ�����
				String gradeName = request.getParameter("gradeName");
				String gradePercent = request.getParameter("gradePercent");
				TeacherGradeVo teacher = new TeacherGradeVo();
				teacher.setGradeName(gradeName);
				teacher.setGradePercent(Float.parseFloat(gradePercent));
				baseDao.gradeAdd(teacher);
				listPage(request,response);
				request.getRequestDispatcher("/T10/gradeList.jsp").forward(request, response);
			}else if(action.equals("update")){
				String gradeId = request.getParameter("gradeId");
				TeacherGradeVo grade = baseDao.findgradeById(gradeId);
				request.setAttribute("grade", grade);
				request.getRequestDispatcher("/T7/gradeUpdate.jsp").forward(request, response);
			}else if(action.equals("updateSave")){
				//��ȡҳ�����
				String gradeId = request.getParameter("gradeId");
				String gradeName = request.getParameter("gradeName");
				String gradePercent = request.getParameter("gradePercent");
				TeacherGradeVo tg = new TeacherGradeVo();
				tg.setGradeId(Integer.parseInt(gradeId));
				tg.setGradeName(gradeName);
				tg.setGradePercent(Float.parseFloat(gradePercent));
				baseDao.gradeUpdate(tg);
				listPage(request,response);
				request.getRequestDispatcher("/T10/gradeList.jsp").forward(request, response);
			}else if(action.equals("del")){
				int gradeId = Integer.parseInt(request.getParameter("gradeId"));
				baseDao.gradeDel(gradeId);
				listPage(request,response);
				request.getRequestDispatcher("/T10/gradeList.jsp").forward(request, response);
			}else if(action.equals("list")){
				//��ѯ���е����ݣ���ת���б�ҳ��
				listPage(request, response);
				//ת��gradeList.jspҳ��
				request.getRequestDispatcher("/T10/gradeList.jsp").forward(request, response);
			}
		}
	}
	//��ѯ��ʦ����
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡ���ݿ������еĽ�ʦ����
		List<TeacherGradeVo> gradeList = baseDao.gradeList();
		//����request����������������еĽ�ʦ����
		request.setAttribute("gradeList", gradeList);
	}
	//��ҳ
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡҳ��Ĳ���
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//��ȡ�ܵļ�¼��
		int cnt = baseDao.getCount("select count(*) cnt from teacherGrade");
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
		int currpage = pager.getCurrentPage();
		//��ȡ���ݿ������еĽ�ʦ����
		List<TeacherGradeVo> teacherList = baseDao.teacherList(pager.getPageSize(), pager.getStartPos());
		//����request����������������еĽ�ʦ����
		request.setAttribute("teacherList", teacherList);
		request.setAttribute("pager", pager);
	}
}
