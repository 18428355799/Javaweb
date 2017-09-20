package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEncoding implements Filter{
	
	String encoding = "";
	public void destroy() {
		
	}
	//���˴������и�������Ժ�֮ǰҳ���Servlet�����е����봦����䶼����ɾ��
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(!encoding.equals("")){
			request.setCharacterEncoding(this.encoding);
		}
		//�����ǳ���Ҫ�����û�и���䣬����ϵͳ�������κη�Ӧ
		chain.doFilter(request, response);
	}
	//��ȡ��ʼ������
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
	}

}
