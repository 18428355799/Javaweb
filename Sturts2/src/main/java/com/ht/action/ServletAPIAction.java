package com.ht.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 * ��ʽһ����Servlet����ϵķ�IOC��ʽ
 * 		context=ActionContext.getContext();
		request=(Map) context.get("request");
		session=context.getSession();
		application=context.getApplication();
��ʽ������Servlet����ϵ�IOC��ʽ
ʵ��RequestAware,SessionAware,ApplicationAware�ӿ�
��ʽ������Servlet��ϵķ�IOC��ʽ
		request = ServletActionContext.getRequest();
		session = request.getSession();
		application = ServletActionContext.getServletContext();
��ʽ�ġ���Servlet��ϵ�IOC��ʽ
ʵ��ServletRequestAware,ServletContextAware�ӿ�
 * 
 * */
public class ServletAPIAction extends ActionSupport{

	Map request;
	Map session;
	Map application;
	
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		//��ȡrequest����
		request = (Map)context.get("request");
		//��ȡsession����
		session = context.getSession();
		//��ȡapplication����
		application = context.getApplication();
		request.put("username", "admin");
		session.put("username", "administrator");
		application.put("count", 1);
		return INPUT;
	}
}
