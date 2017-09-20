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
import bean.CityVo;
import bean.PageObject;
import bean.ProvinceVo;

public class CityServlet extends HttpServlet {

	IBaseDAO baseDao = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*action="list"����ִ�в�ѯ�Ĵ���
		 * action="init"��������ҳ��ĳ�ʼ��
		 * action="add"�����������еĴ���
		 * action="update"�����ȡ��Ҫ���µĳ�������
		 * action="updateSave"�����������
		 * action="del"����ִ��ɾ������
		 * 
		 * */
		//���봦��
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action!=null){
			if(action.equals("init")){
				//��ȡʡ�ݵ�����., 
				List<ProvinceVo> provList = baseDao.provinceList();
				request.setAttribute("provList", provList);
				//ת��cityList.jspҳ��
				request.getRequestDispatcher("/T7/cityAdd.jsp").forward(request, response);
			}else if(action.equals("add")){
				String provinceId = request.getParameter("provinceId");
				String cityName = request.getParameter("cityName").trim();
				CityVo city = new CityVo();
				city.setProvinceId(Integer.parseInt(provinceId));
				city.setCityName(cityName);
				baseDao.cityAdd(city);
				//��ѯ���е����ݣ�ת���б�ҳ��
				listPage(request, response);
				//ת��cityList.jspҳ��
				request.getRequestDispatcher("/T7/cityList.jsp").forward(request, response);
			}else if(action.equals("update")){
				//��ȡʡ������
				List<ProvinceVo> provList = baseDao.provinceList();
				request.setAttribute("provList",provList);
				//������Ҫ�޸ĵĳ�������
				String cityId = request.getParameter("cityId");
				CityVo city = baseDao.findCityById(cityId);
				request.setAttribute("city", city);
				//ת��cityList.jspҳ��
				request.getRequestDispatcher("T7/cityUpdate.jsp").forward(request, response);
			}else if(action.equals("updateSave")){
				String provinceId = request.getParameter("provinceId");
				String cityId = request.getParameter("cityId");
				String cityName = request.getParameter("cityName");
				CityVo city = new CityVo();
				city.setProvinceId(Integer.parseInt(provinceId));
				city.setCityName(cityName);
				city.setCityId(Integer.parseInt(cityId));
				baseDao.cityUpdate(city);
				//��ѯ���еĳ������ݣ���ת���б�ҳ��
				listPage(request, response);
				//ת��cityList.jspҳ��
				request.getRequestDispatcher("/T7/cityList.jsp").forward(request, response);
			}else if(action.equals("del")){
				String cityId = request.getParameter("cityId");
				baseDao.cityDel(Integer.parseInt(cityId));
				listPage(request, response);
				//ת��cityList.jspҳ��
				request.getRequestDispatcher("T7/cityList.jsp").forward(request, response);
			}else if(action.equals("list")){
				//��ѯ���е����ݣ���ת���б�ҳ��
				listPage(request, response);
				//ת��cityList.jspҳ��
				request.getRequestDispatcher("/T7/cityList.jsp").forward(request, response);
			}
		}
	}
	//��ѯ��������
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡ���ݿ������еĳ�������
		List<CityVo> cityList = baseDao.cityList();
		//����request����������������Եĳ�������
		request.setAttribute("cityList", cityList);
	}
	//��ҳ
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡҳ��Ĳ���
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//��ȡ�ܼ�¼��
		int cnt = baseDao.getCount("select count(*) cnt from city");
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
		//��ȡ���ݿ������еĳ�������
		List<CityVo> cityList = baseDao.cityList(pager.getPageSize(),pager.getStartPos());
		//����request����������������еĳ�������
		request.setAttribute("cityList", cityList);
		request.setAttribute("pager", pager);
	}
}
