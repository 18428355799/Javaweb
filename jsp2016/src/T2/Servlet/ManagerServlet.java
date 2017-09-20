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
import bean.CityVo;
import bean.ManagerVo;
import bean.PageObject1;

public class ManagerServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�������
		String action = request.getParameter("action");
		if(action.equals("add")){
			ManagerVo manager = new ManagerVo();
			manager.setManagerAccount(request.getParameter("managerAccount").trim());
			String pwd = request.getParameter("managerPassword").trim();
			//��������м��ܴ���
			pwd=AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			manager.setManagerPassword(pwd);
			manager.setManagerName(request.getParameter("managerName").trim());
			manager.setSex(Integer.parseInt(request.getParameter("sex").trim()));
			manager.setContact(request.getParameter("contact").trim());
			manager.setStatus(1);//��Ч
			base.managerAdd(manager);
			//��ȡ�������ݲ�ת���б�ҳ��
			listPage(request,response);
			//ת��managerList.jsp
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}else if(action.equals("list")){
			//��ѯ���е����ݲ�ת���б�ҳ��
			listPage(request,response);
			//�ض���managerList.jspĿ��ҳ��
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}else if(action.equals("del")){
			//��ȡ����
			String managerId = request.getParameter("managerId");
			base.managerDel(Integer.parseInt(managerId));
			listPage(request, response);
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}else if(action.equals("update")){
			String managerId = request.getParameter("managerId");
			ManagerVo manager = base.findmanagerById(managerId);
			request.setAttribute("manager", manager);
			request.getRequestDispatcher("/T11/managerUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			ManagerVo manager = new ManagerVo();
			manager.setManagerId(Integer.parseInt(request.getParameter("managerId")));
			manager.setManagerAccount(request.getParameter("managerAccount").trim());
			manager.setManagerName(request.getParameter("managerName").trim());
			manager.setSex(Integer.parseInt(request.getParameter("sex").trim()));
			manager.setContact(request.getParameter("contact").trim());
			base.managerUpdate(manager);
			listPage(request, response);
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}else if(action.equals("modifyPwd")){//�޸�����
			String managerId = request.getParameter("managerId");
			String oldpwd = AesUtils.encryptStr(request.getParameter("oldpwd"),AesUtils.SECRETKEY);
			String managerPassword = AesUtils.encryptStr(request.getParameter("managerPassword"),AesUtils.SECRETKEY);
			if(base.checkPwd(managerId, oldpwd)){
				//�޸�����
				base.modifyPwd(managerId, managerPassword);
				//��modifyPwd.jspҳ��ȡֵ
				request.setAttribute("msg", "��ϲ�㣬�����޸ĳɹ��������Ʊ���");
			}else{
				request.setAttribute("msg", "�����������������������");
			}
			//ת��
			request.getRequestDispatcher("/T11/modifyPwd.jsp").forward(request, response);
		}else if(action.equals("initpwd")){
			//��ʼ������
			String managerId = request.getParameter("managerId");
			base.modifyPwd(managerId, AesUtils.encryptStr("88888888", AesUtils.SECRETKEY));
			listPage(request, response);
			request.setAttribute("msg","��ʼ������ɹ�����ʼ����Ϊ��88888888");
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}else if(action.equals("status")){//����״̬
			String managerId = request.getParameter("managerId");
			int status = Integer.parseInt(request.getParameter("status"));
			base.updateStatus(managerId, status);
			listPage(request, response);
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}
	}
	//��ѯ���еĹ���Ա����
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡ���ݿ��еĹ���Ա����
		List<ManagerVo> managerList = base.managerList();
		//����request����������������еĹ���Ա����
		request.setAttribute("managerList", managerList);
	}
	//��ҳ��ʾ
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡҳ��Ĳ���
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//��ȡ�ܼ�¼��
		int cnt = base.getCount("select count(*) cnt from manager");
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
		//��ȡ���ݿ������еĹ���Ա����
		List<ManagerVo> managerList = base.findManagerByPage(pager.getPageSize(),pager.getStartPos());
		//����request����������������ԵĹ���Ա����
		request.setAttribute("managerList", managerList);
		request.setAttribute("pager", pager);
	}

}
