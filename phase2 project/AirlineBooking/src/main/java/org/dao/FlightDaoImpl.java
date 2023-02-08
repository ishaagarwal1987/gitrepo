package org.dao;

import java.util.List;

import org.config.HibConfig;
import org.entities.Destination;
import org.entities.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class FlightDaoImpl implements FlightDao{

	@Override
	public void insert(Flight flight) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(flight);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Flight> getAll() {
		try {
			SessionFactory factory = HibConfig.getSessionFactory();
			Session session = factory.openSession();
			Query<Flight> query = session.createQuery("select a from org.entities.Flight a");
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Flight get(int id) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Flight flight=session.get(Flight.class, id);
		return flight;
	}

}
