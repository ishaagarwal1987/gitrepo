package org.dao;

import java.util.List;

import org.config.HibConfig;
import org.entities.Destination;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DestinationDaoImpl implements DestinationDao{

	@Override
	public void insert(Destination destination) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(destination);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Destination> getAll() {
		try {
			SessionFactory factory = HibConfig.getSessionFactory();
			Session session = factory.openSession();
			Query<Destination> query = session.createQuery("select a from org.entities.Destination a");
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Destination get(int id) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Destination destination=session.get(Destination.class, id);
		return destination;
	}

}
