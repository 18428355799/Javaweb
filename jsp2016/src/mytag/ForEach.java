package mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ForEach extends BodyTagSupport{

	private int count;
	private String align;
	private String border;
	private String bgcolor;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getBorder() {
		return border;
	}
	public void setBorder(String border) {
		this.border = border;
	}
	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
	//��ǩ��ʼʱ���øñ�ǩ
	@Override
	public int doStartTag() throws JspException {
		if(align==null || align.equals("")){
			align="center";
		}
		if(bgcolor==null || bgcolor.equals("")){
			bgcolor="white";
		}
		if(count>0){
			JspWriter out = pageContext.getOut();
			try{
				String str = "<table border='"+border+"' align='"+align+"' bgcolor='"+bgcolor+"'>";
				System.out.println(str);
				out.write(str);
			}catch(Exception e){
				e.printStackTrace();
			}
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
	}
	//��ǩ�������øñ�ǩ
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("</table>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	//��ѭ������ʱ����Ҫ���øú������ú����ظ����У�ֱ������ֵΪEVAL_BODY_INCLUDE��������
	@Override
	public int doAfterBody() throws JspException {
		count--;
		System.out.println("count="+count);
		if(count>0){
			return EVAL_BODY_AGAIN;
		}else{
			return SKIP_BODY;
		}
	}
	//��ʼ��
	@Override
	public void doInitBody() throws JspException {
		System.out.println("doInitBody");
	}
}
