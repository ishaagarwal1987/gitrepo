package org.dao;

import java.util.List;

import org.config.HibConfig;
import org.entities.Subject;
import org.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SubjectDaoImpl implements SubjectDao{

	@Override
	public void insert(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(subject);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Subject> getAll() {
		try{SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Subject> query=session.createQuery("select s from org.entities.Subject s");
		return query.list();
	} catch (Exception e) {
		return null;
	}
	}

	@Override
	public Subject getSubject(int id) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Subject subject =session.get(Subject.class, id);
		
		return subject;
	}

	@Override
	public void update(Subject subject) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx =null;
		try {
			
			tx = session.beginTransaction();
			
			session.update(subject);
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
