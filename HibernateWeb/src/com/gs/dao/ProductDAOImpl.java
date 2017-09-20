package com.gs.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gs.bean.Product;
import com.gs.common.bean.Pager4EasyUI;

public class ProductDAOImpl extends BaseDAO implements ProductDAO {
	
	@Override
	public Product add(Product product) {
		// ͨ��sessionFactory�����ȡsession���ݿ����� 
		Session session = sessionFactory.openSession(); // ����������
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit(); // �����ύ
		session.close();
		return null;
	}

	@Override
	public Product queryById(int id) {
		Session session = sessionFactory.openSession();
		Product p = (Product) session.get(Product.class, id); // get����ͨ��ָ������������ѯ��������
		session.close();
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager4EasyUI<Product> queryAll(Pager4EasyUI<Product> pager) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		query.setFirstResult(pager.getBeginIndex()); // ��ҳ�ĵ�һ����¼��ʼλ��
		query.setMaxResults(pager.getPageSize()); // ��ѯ���ٸ���¼��ÿҳ���ٸ���
		List<Product> products = query.list();
		pager.setRows(products);
		session.close();
		return pager;
	}

	@Override
	public void update(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(product); // ���Ҫɾ��ĳ��object�����object�������ֶε����Ա��븳ֵ
		transaction.commit();
		session.close();
	}
	
	@Override
	public int count() {
		Session session = sessionFactory.openSession();
		BigInteger count = (BigInteger) session.createSQLQuery("select count(id) from t_product1").uniqueResult();
		session.close();
		return count.intValue();
	}

}
