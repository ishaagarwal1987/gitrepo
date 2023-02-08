package org.dao;

import java.util.List;

import org.config.HibConfig;
import org.entities.Flight;
import org.entities.Source;
import org.entities.Ticket;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TicketDaoImpl implements TicketDao{

	@Override
	public void insert(Ticket ticket) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(ticket);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Ticket> getAll() {
		try {
			SessionFactory factory = HibConfig.getSessionFactory();
			Session session = factory.openSession();
			Query<Ticket> query = session.createQuery("select a from org.entities.Ticket a");
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int getBookedSeats(Flight flight) {
		try {
			SessionFactory factory = HibConfig.getSessionFactory();
			Session session = factory.openSession();
			String sql = "select sum(bookedSeats) FROM airline_booking.ticket where flight_id="+flight.getId()+";";
			SQLQuery query = session.createSQLQuery(sql);
			//Query query = session.createQuery("select sum(a.bookedSeats) from org.entities.Ticket a where Flight = ?1");
			//query.setParameter(1,flight);
			//List<Integer> list = query.list();
			return Integer.parseInt(query.getSingleResult().toString());
		} catch (Exception e) {
			System.out.println("Error "+e);
			return 1;
		}
	}

}
