package org.dao;

import java.util.List;

import org.config.HibConfig;
import org.entities.Airline;
import org.entities.Destination;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AirlineDaoImpl implements AirlineDao {

	@Override
	public void insert(Airline airline) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(airline);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Airline> getAll() {
		try {
			SessionFactory factory = HibConfig.getSessionFactory();
			Session session = factory.openSession();
			Query<Airline> query = session.createQuery("select a from org.entities.Airline a");
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Airline get(int id) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Airline airline=session.get(Airline.class, id);
		return airline;
	}

}
