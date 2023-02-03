package org.dao;

import java.util.List;

import org.config.HibConfig;
import org.entities.Grade;
import org.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StudentDaoImpl implements StudentDao{

	@Override
	public void insert(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(student);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> getAll() {
		try{SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Student> query=session.createQuery("select s from org.entities.Student s");
		return query.list();
	} catch (Exception e) {
		return null;
	}
	}

	@Override
	public List<Student> getStudent(int gradeId) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Student> query=session.createQuery("select s from org.entities.Student s where s.Grade.id =?1");
		query.setParameter(1, gradeId );
		return query.list();
		
	}

}
