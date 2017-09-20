package com.ht.action;

import java.util.ArrayList;
import java.util.List;

import com.ht.vo.ClassesVo;
import com.ht.vo.NationVo;
import com.ht.vo.StudentVo;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction1 extends ActionSupport{

	//��ҳ���ֵ��ȡ��Student javabean��
	private StudentVo stud;
	private List<NationVo> nationList;
	private List<ClassesVo> classList;
	private String[] hobit;
	public String[] getHobit() {
		return hobit;
	}
	public void setHobit(String[] hobit) {
		this.hobit = hobit;
	}
	public List<NationVo> getNationList() {
		return nationList;
	}
	public void setNationList(List<NationVo> nationList) {
		this.nationList = nationList;
	}
	public List<ClassesVo> getClassList() {
		return classList;
	}
	public void setClassList(List<ClassesVo> classList) {
		this.classList = classList;
	}
	public StudentVo getStud() {
		return stud;
	}
	public void setStud(StudentVo stud) {
		this.stud = stud;
	}
	public StudentAction1() {
		
	}
	@Override
	public String execute() throws Exception {
		init();
		if(stud!=null){
			System.out.println("studid="+stud.getStudid());
			System.out.println("studname="+stud.getStudname());
			System.out.println("age="+stud.getAge());
			System.out.println("sex="+stud.getSex());
			System.out.println("cardno="+stud.getCardno());
			System.out.println("nationid="+stud.getNationid());
			System.out.println("classid="+stud.getClassid());
			String hobit[] = this.hobit;
			for(int i=0;i<hobit.length;i++){
				System.out.println("hobit="+hobit[i]);
			}
		}
		return INPUT;
	}
	public void init(){
		nationList = new ArrayList<NationVo>();
		classList = new ArrayList<ClassesVo>();
		ClassesVo c1 = new ClassesVo(1,"��ͼ1601��");
		ClassesVo c2 = new ClassesVo(2,"��ͼ1602��");
		ClassesVo c3 = new ClassesVo(3,"��ͼ1603��");
		ClassesVo c4 = new ClassesVo(4,"��ͼ1604��");
		classList.add(c1);
		classList.add(c2);
		classList.add(c3);
		classList.add(c4);
		
		NationVo n1 = new NationVo(1,"����");
		NationVo n2 = new NationVo(2,"��������");
		NationVo n3 = new NationVo(3,"��������");
		nationList.add(n1);
		nationList.add(n2);
		nationList.add(n3);
	}
	
	public StudentVo getModel() {
		return this.stud;
	}
}
