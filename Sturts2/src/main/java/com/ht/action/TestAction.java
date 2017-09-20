package com.ht.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	private static final long serialVersionUID=1L;
	//map���͵�request
	private Map<String, Object>request;
	//map���͵�session
	private Map<String, Object>session;
	//map���͵�application
	private Map<String, Object>application;
	public TestAction() {
		//��ȡActionContext����
		ActionContext context = ActionContext.getContext();
		//��ȡmap���͵�request
		request = (Map<String, Object>)context.get("request");
		//��ȡmap���͵�session
		session = context.getSession();
		//��ȡmap���͵�application
		application = context.getApplication();
	}
	
	//��������
	@Override
	public String execute() throws Exception {
		String info = "��ͼ���";
		//��request�����Ϣ
		request.put("info", info);
		//��session�����Ϣ
		session.put("info", info);
		//��application�����Ϣ
		application.put("info", info);
		//�ɹ�����
		return SUCCESS;
	}
}
