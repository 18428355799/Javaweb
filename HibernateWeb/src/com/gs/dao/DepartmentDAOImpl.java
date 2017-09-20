package com.gs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.gs.bean.Department;

public class DepartmentDAOImpl extends BaseDAO implements DepartmentDAO {

	@Override
	public Department queryById(int id) {
		Session session = sessionFactory.openSession();
		Department dept = (Department) session.get(Department.class, id);
		//session.close(); 
		return dept;
	}

	@Override
	public void add(Department dept) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(dept);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Department dept) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(dept);
		transaction.commit();
		session.close();
	}

	@Override
	public Department queryByCriteria() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Department.class);
		// criteria.setFetchMode("employees", FetchMode.JOIN);
		// criteria.setProjection(Projections.max("name")); // ȡָ�����Ե����ֵ   min��Сֵ
		// criteria.setProjection(Projections.avg("id")); // ָ�����Ե�ƽ��ֵ
		// criteria.setProjection(Projections.rowCount()); // ���� count(*)
		// criteria.setProjection(Projections.count("id")); // ��ָ��������������  count(id)
		// criteria.setProjection(Projections.countDistinct("id")); // �Ȱ������ų��ظ������ټ���
		// criteria.setProjection(Projections.id()); // ���������ֶε�ֵ  
		// criteria.setProjection(Projections.groupProperty("name")); // ��ָ�����Խ��з��� group by
		// criteria.setProjection(Projections.sum("id")); // ��� sum(id);
		// criteria.setProjection(Projections.property("name")); // ָ����ѯĳ���ֶ�
		criteria.add(Restrictions.like("name", "%4%"));
		criteria.add(Restrictions.eq("name", "�з���"));
		// session.close();
		List<Department> depts = criteria.list();
		for (Department dept : depts) {
			System.out.println(dept.getName());
		}
		return null;
	}
	
	

}
