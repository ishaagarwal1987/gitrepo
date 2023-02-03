package org.config;

import java.util.Properties;

import org.entities.Grade;
import org.entities.Student;
import org.entities.Subject;
import org.entities.SubjectClassTeacher;
import org.entities.Teacher;
import org.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibConfig {
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		properties.put(Environment.URL,"jdbc:mysql://localhost:3306/lms?autoReconnect=true&amp;useSSL=false");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "Company@1303");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

		configuration.setProperties(properties);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Grade.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(Teacher.class);
		configuration.addAnnotatedClass(SubjectClassTeacher.class);
		SessionFactory factory = configuration.buildSessionFactory();
		return factory;
	}

}
