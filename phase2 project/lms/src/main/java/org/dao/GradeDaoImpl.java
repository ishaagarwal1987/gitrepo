package org.dao;

import java.util.List;

import org.config.HibConfig;
import org.entities.Grade;
import org.entities.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class GradeDaoImpl implements GradeDao{

	@Override
	public void insert(Grade grade) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(grade);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Grade> getAll() {
		try{SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Grade> query=session.createQuery("select a from org.entities.Grade a");
		return query.list();
	} catch (Exception e) {
		return null;
	}
	}

	@Override
	public Grade get(int gid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Grade grade=session.get(Grade.class, gid);
		return grade;
	}

	@Override
	public void update(Grade grade) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx =null;
		try {
			
			tx = session.beginTransaction();
			
			session.update(grade);
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void assignSubject(Grade grade, String[] subjects) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx =null;
		SubjectDao subjectDao = new SubjectDaoImpl();
		try {
			
			tx = session.beginTransaction();
			
			for(String str : subjects)
			{
				Subject sub = subjectDao.getSubject(Integer.parseInt(str));
				sub.addGrade(grade);
				subjectDao.update(sub);
				grade.addSubject(sub);
			}
			
			session.update(grade);
			//session.update(subject);
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
