package mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagSupportDemo extends TagSupport{

	//��ǩ��ʼ���øú���
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("<font face='�����п�' size='4' color='red'>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	//��ǩ����ʱ���øú���
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("</font>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
