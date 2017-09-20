package mytag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import bean.CityVo;
import bean.PageObject;

public class CityByPageList extends BodyTagSupport{

	private List<CityVo> cityList;
	private PageObject pager;
	private String updateUrl;
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("<table border='1' style='min-width:500px;height:auto;background-color:#fff;'>");
			out.write("<caption style='background-color:#0ae;margin:0 auto;height:60px;line-height:60px;font-size:20px;color:#FFF' >���������б�</caption>");
			out.write("<thead><th>���б��</th><th>ʡ������</th><th>��������</th><th>����</th></thead>");
			int cnt = cityList.size();
			CityVo city = null;
			for(int i=0;i<cnt;i++){
				city = cityList.get(i);
				out.write("<tr>");
				out.write("<td>"+city.getCityId()+"</td>");
				out.write("<td>"+city.getProvinceName()+"</td>");
				out.write("<td>"+city.getCityName()+"</td>");
				out.write("<td>");
				out.write("<a href='"+updateUrl+"?action=update&cityId="+city.getCityId()+"'>�޸�</a>");
				out.write("<a href='"+updateUrl+"?action=del&cityId="+city.getCityId()+"' onclick='javascript:if(confirm('ɾ��ȷ��')){return true;}else{return false;}'>ɾ��</a>");
				out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");
			
			out.write("<table border='0' cellpadding='1' cellspacing='1' width='500'>");
			out.write("<tr>");
			out.write("<td>�ܼ�¼��:"+pager.getRecordCount()+"</td>");
			out.write("<td>��ҳ��:"+pager.getPageCount()+"</td>");
			out.write("<td>��ǰҳ:"+pager.getCurrentPage()+"</td>");
			out.write("<td><a href="+updateUrl+"?action=list&currentPage=1&opr=first>��ҳ</a></td>");
			out.write("<td><a href="+updateUrl+"?action=list&currentPage="+pager.getCurrentPage()+"&opr=piror>��һҳ</a></td>");
			out.write("<td><a href="+updateUrl+"?action=list&currentPage="+pager.getCurrentPage()+"&opr=next>��һҳ</a></td>");
			out.write("<td><a href="+updateUrl+"?action=list&currentPage="+pager.getPageCount()+"&opr=last>ĩҳ</a></td>");
			out.write("</tr>");
			out.write("</table>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;
	}
	
	
	public List<CityVo> getCityList() {
		return cityList;
	}
	public void setCityList(List<CityVo> cityList) {
		this.cityList = cityList;
	}
	public PageObject getPager() {
		return pager;
	}
	public void setPager(PageObject pager) {
		this.pager = pager;
	}
	public String getUpdateUrl() {
		return updateUrl;
	}
	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}
	
}
