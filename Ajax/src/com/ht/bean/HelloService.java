package com.ht.bean;

public class HelloService {

	public String sayHello(String name){
		System.out.println(name);
		return "��ã�"+name;
	}
	public String sayHello1(String name){
		System.out.println(name);
		return "��ã�"+name +",��ӭ���ʱ�վ";
	}
	public String sayHello2(String name){
		System.out.println(name);
		return "��ã�"+name +",���ǵ�һ�����ʱ�վ���û�";
	}
	public String sayHello3(String name){
		System.out.println(name);
		return "��ã�"+name+",�������ɣ�";
	}
}
