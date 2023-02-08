package org.dao;

import java.util.List;

import org.config.HibConfig;
import org.entities.Airline;
import org.entities.Route;
import org.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RouteDaoImpl implements RouteDao {

	@Override
	public void insert(Route route) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(route);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public List<Route> getAll() {

		try {
			SessionFactory factory = HibConfig.getSessionFactory();
			Session session = factory.openSession();
			Query<Route> query = session.createQuery("select a from org.entities.Route a");
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Route get(int id) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Route route=session.get(Route.class, id);
		return route;
	}

}
