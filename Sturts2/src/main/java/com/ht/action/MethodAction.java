package com.ht.action;

import com.opensymphony.xwork2.ActionSupport;

public class MethodAction extends ActionSupport{

	private String action;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	@Override
	public String execute() throws Exception {
		System.out.println("ҳ�������execute����");
		System.out.println("action="+action);
		return null;
	}
	
	public String add() throws Exception {
		System.out.println("ҳ�������add����");
		System.out.println("action="+action);
		return INPUT;
	}
	public String del() throws Exception {
		System.out.println("ҳ�������del����");
		System.out.println("action="+action);
		return null;
	}
	public String update() throws Exception{
		System.out.println("ҳ�������update����");
		System.out.println("action="+action);
		return SUCCESS;
	}
	public String list() throws Exception{
		System.out.println("ҳ�������list����");
		System.out.println("action="+action);
		return "list";
	}
	public String save() throws Exception{
		System.out.println("ҳ�������save����");
		System.out.println("action="+action);
		return null;
	}
	
}
