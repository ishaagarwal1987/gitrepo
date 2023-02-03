package org.dao;

import java.util.List;

import org.config.HibConfig;
import org.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public void insert(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(teacher);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Teacher> getAll() {
		try {
			
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Teacher> query=session.createQuery("select t from org.entities.Teacher t");
		return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Teacher get(int tid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Teacher teacher=session.get(Teacher.class, tid);
		session.close();
		return teacher;
	}

}
