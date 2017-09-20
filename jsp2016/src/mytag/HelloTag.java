package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag{

	private PageContext pageContext;
	private Tag parent;
	//��ǩ����ʱ���øú���
	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;
	}
	//��ǩ��ʼʱ���øú���
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("<h1>Hello World</h1>");
		}catch(IOException e){
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public Tag getParent() {
		
		return null;
	}

	public void release() {
		
	}
	//��ȡҳ���pageContext����ϵͳ�Զ���ȡ
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public void setParent(Tag tag) {
		this.parent = tag;
	}

}
