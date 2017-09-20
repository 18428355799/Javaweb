package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class TagWithBody extends BodyTagSupport{

	int counts;//countsλ�����Ĵ���

	public  TagWithBody(){
		super();
	}
	//����counts���ԣ���������������Զ�����
	public void setCounts(int c) {
		this.counts = c;
	}
	//����doStartTag����
	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag");
		if(counts>0){
			return EVAL_BODY_TAG;
		}else{
			return SKIP_BODY;
		}
	}
	//����doAfterBody����
	@Override
	public int doAfterBody() throws JspException {
		System.out.println("doAfterBody");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(counts>1){
			counts--;
			return EVAL_BODY_TAG;
		}else{
			return SKIP_BODY;
		}
		
	}
	//����doEndTag����
	@Override
	public int doEndTag() throws JspException {
		System.out.println("doEndTag");
		try{
			if(bodyContent!=null){
				bodyContent.writeOut(bodyContent.getEnclosingWriter());
			}
		}catch(java.io.IOException e){
			throw new JspTagException("io Error��"+e.getMessage());
		}
		return EVAL_PAGE;
	}
	@Override
	public void doInitBody() throws JspException {
		System.out.println("doInitBody");
	}
	@Override
	public void setBodyContent(BodyContent bodyContent) {
		System.out.println("setBodyContext");
		this.bodyContent = bodyContent;
	}
}
