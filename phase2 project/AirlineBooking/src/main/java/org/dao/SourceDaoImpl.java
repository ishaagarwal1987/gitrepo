package org.dao;

import java.util.List;

import org.config.HibConfig;
import org.entities.Source;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SourceDaoImpl implements SourceDao{

	@Override
	public void insert(Source source) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(source);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Source> getAll() {
		try {
			SessionFactory factory = HibConfig.getSessionFactory();
			Session session = factory.openSession();
			Query<Source> query = session.createQuery("select a from org.entities.Source a");
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Source get(int id) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Source source=session.get(Source.class, id);
		return source;
	}

}
