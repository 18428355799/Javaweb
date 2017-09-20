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
import bean.PageObject;
import bean.ProvinceVo;
import bean.UsersVo;

public class UsersServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("init")){
			String provinceId = request.getParameter("provinceId");
			//��ѯ����ʡ������
			List<ProvinceVo> provList = base.provinceList();
			//��û��ʡ������
			List<CityVo> cityList = null;
			if(provinceId!=null){//������ҳ��ı���ʡ��ʱ��ֵ
				cityList = base.CityList(Integer.parseInt(provinceId));
			}else if(provList.size()>0){
				ProvinceVo p = provList.get(0);
				cityList = base.CityList(p.getProvinceId());
			}
			request.setAttribute("provList",provList);
			request.setAttribute("cityList",cityList);
			request.setAttribute("provinceId",provinceId);
			getServletContext().getRequestDispatcher("/T11/userAdd.jsp").forward(request, response);
		}else if(action.equals("add")){
			UsersVo user = new UsersVo();
			user.setProvinceId(Integer.parseInt(request.getParameter("provinceId").trim()));
			user.setCityId(Integer.parseInt(request.getParameter("cityId").trim()));
			user.setMobile(request.getParameter("mobile").trim());
			String pwd = request.getParameter("password").trim();
			//��������м��ܴ���
			pwd=AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			user.setPassword(pwd);
			user.setUserName(request.getParameter("userName").trim());
			user.setSex(Integer.parseInt(request.getParameter("sex").trim()));
			user.setHomeAddress(request.getParameter("homeAddress").trim());
			user.setEmail(request.getParameter("email").trim());
			user.setUserType(1);//ѧ��
			try{
				base.userAdd(user);
			}catch(Exception e){
				request.setAttribute("msg", "���ֻ������Ѿ�ע����ˣ������������ֻ�����");
				String provinceId = request.getParameter("provinceId");
				//��ѯ����ʡ������
				List<ProvinceVo> provList = base.provinceList();
				//��û��ʡ������
				List<CityVo> cityList = null;
				if(provinceId!=null){//������ҳ��ı���ʡ��ʱ��ֵ
					cityList = base.CityList(Integer.parseInt(provinceId));
				}else if(provList.size()>0){
					ProvinceVo p = provList.get(0);
					cityList = base.CityList(p.getProvinceId());
				}
				request.setAttribute("provList",provList);
				request.setAttribute("cityList",cityList);
				request.setAttribute("provinceId",provinceId);
				getServletContext().getRequestDispatcher("/T11/userAdd.jsp").forward(request, response);
			}
			listPage(request,response);
			request.getRequestDispatcher("/T11/userList.jsp").forward(request, response);
		}else if(action.equals("list")){
			listPage(request,response);
			request.getRequestDispatcher("/T11/userList.jsp").forward(request, response);
		}else if(action.equals("update")){
			String provinceId = request.getParameter("provinceId");
			String tel = request.getParameter("mobile");
			String name = request.getParameter("userName");
			String home = request.getParameter("homeAddress");
			String em = request.getParameter("email");
			//��ѯ����ʡ������
			List<ProvinceVo> provList = base.provinceList();
			//��û��ʡ������
			List<CityVo> cityList = null;
			if(provinceId!=null){//������ҳ��ı���ʡ��ʱ��ֵ
				cityList = base.CityList(Integer.parseInt(provinceId));
			}else if(provList.size()>0){
				ProvinceVo p = provList.get(0);
				cityList = base.CityList(p.getProvinceId());
			}
			request.setAttribute("provList",provList);
			request.setAttribute("cityList",cityList);
			request.setAttribute("provinceId",provinceId);
			request.setAttribute("tel",tel);
			request.setAttribute("name",name);
			request.setAttribute("home",home);
			request.setAttribute("em",em);
			String userid = request.getParameter("userid");
			UsersVo user = base.finduserById(userid);
			request.setAttribute("user",user);
			request.getRequestDispatcher("/T11/userUpdate.jsp").forward(request,response);
		}else if(action.equals("updateSave")){
			UsersVo user = new UsersVo();
			user.setUserid(Integer.parseInt(request.getParameter("userid")));
			user.setMobile(request.getParameter("mobile").trim());
			user.setUserName(request.getParameter("userName"));
			user.setSex(Integer.parseInt(request.getParameter("sex")));
			user.setHomeAddress(request.getParameter("homeAddress").trim());
			user.setEmail(request.getParameter("email").trim());
			user.setProvinceId(Integer.parseInt(request.getParameter("provinceId")));
			user.setCityId(Integer.parseInt(request.getParameter("cityId")));
			user.setProvinceName(request.getParameter("provinceName"));
			user.setCityName(request.getParameter("cityName"));
			base.userUpdate(user);
			listPage(request, response);
			request.getRequestDispatcher("/T11/userList.jsp").forward(request,response);
		}else if(action.equals("del")){
			String userid = request.getParameter("userid");
			base.userDel(Integer.parseInt("userid"));
			listPage(request, response);
			request.getRequestDispatcher("/T11/userList.jsp").forward(request,response);
		}else if(action.equals("modifyPwd3")){
			String userid = request.getParameter("userid");
			String oldpwd = AesUtils.encryptStr(request.getParameter("oldpwd"),AesUtils.SECRETKEY);
			String newPassword = AesUtils.encryptStr(request.getParameter("newPassword"),AesUtils.SECRETKEY);
			if(base.checkPwd(userid, oldpwd)){
				//�޸�����
				base.modifypwd3(userid, newPassword);
				//��modifyPwd.jspҳ��ȡֵ
				request.setAttribute("msg", "��ϲ�㣬�����޸ĳɹ��������Ʊ���");
			}else{
				request.setAttribute("msg", "�����������������������");
			}
			//ת��
			request.getRequestDispatcher("/T11/modifyPwd3.jsp").forward(request, response);
		}else if(action.equals("initpwd")){
			//��ʼ������
			String userid = request.getParameter("userid");
			base.modifypwd3(userid, AesUtils.encryptStr("8888",AesUtils.SECRETKEY));
			listPage(request, response);
			request.setAttribute("msg","��ʼ������ɹ�����ʼ����Ϊ��8888");
			request.getRequestDispatcher("/T11/userList.jsp").forward(request, response);
		}
	}
	//��ѯ���е��û�����
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡ���ݿ��е��û�����
		List<UsersVo > userList = base.userList();
		//����request����������������е��û�����
		request.setAttribute("userList", userList);
	}
	//��ҳ��ʾ
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡҳ��Ĳ���
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//��ȡ�ܼ�¼��
		int cnt = base.getCount("select count(*) cnt from users");
		PageObject pager = new PageObject();
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
		//��ȡ���ݿ������е��û�����
		List<UsersVo> userList = base.finduserByPage(pager.getPageSize(),pager.getStartPos());
		//����request����������������Ե��û�����
		request.setAttribute("userList", userList);
		request.setAttribute("pager", pager);
		
	}

}
