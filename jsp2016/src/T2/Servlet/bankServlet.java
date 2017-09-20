package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.BaseDAOImpl;
import base.IBaseDAO;
import bean.ManagerVo;
import bean.PageObject1;
import bean.bankVo;

public class bankServlet extends HttpServlet {

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
			request.getRequestDispatcher("/T11/bankList.jsp").forward(request, response);
		}else if(action.equals("add")){
			String bankName = request.getParameter("bankName");
			bankVo bank = new bankVo();
			bank.setBankName(bankName);
			base.bankAdd(bank);
			listPage(request, response);
			request.getRequestDispatcher("/T11/bankList.jsp").forward(request, response);
		}else if(action.equals("del")){
			int bankId = Integer.parseInt(request.getParameter("bankId"));
			base.bankDel(bankId);
			listPage(request, response);
			request.getRequestDispatcher("/T11/bankList.jsp").forward(request, response);
		}else if(action.equals("update")){
			String bankId = request.getParameter("bankId");
			bankVo bank = base.findbankById(bankId);
			request.setAttribute("bank", bank);
			request.getRequestDispatcher("/T11/bankUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			int bankId = Integer.parseInt(request.getParameter("bankId"));
			String bankName = request.getParameter("bankName");
			bankVo bank = new bankVo();
			bank.setBankId(bankId);
			bank.setBankName(bankName);
			base.bankUpdate(bank);
			listPage(request, response);
			request.getRequestDispatcher("/T11/bankList.jsp").forward(request, response);
		}
	}
	//��ѯ���е���������
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡ���ݿ��е���������
		List<bankVo> bankList = base.bankList();
		//����request����������������е���������
		request.setAttribute("bankList", bankList);
	}
	//��ҳ��ʾ
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡҳ��Ĳ���
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//��ȡ�ܼ�¼��
		int cnt = base.getCount("select count(*) cnt from bank");
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
		List<bankVo> bankList = base.findbankByPage(pager.getPageSize(),pager.getStartPos());
		//����request����������������Ե���������
		request.setAttribute("bankList", bankList);
		request.setAttribute("pager", pager);
	}


}
