package org.config;

import java.util.Properties;

import org.entities.Airline;
import org.entities.Destination;
import org.entities.Flight;
import org.entities.Route;
import org.entities.Source;
import org.entities.Ticket;
import org.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibConfig {
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		properties.put(Environment.URL,"jdbc:mysql://localhost:3306/airline_booking?autoReconnect=true&amp;useSSL=false");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "Company@1303");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

		configuration.setProperties(properties);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Source.class);
		configuration.addAnnotatedClass(Destination.class);
		configuration.addAnnotatedClass(Route.class);
		configuration.addAnnotatedClass(Airline.class);
		configuration.addAnnotatedClass(Flight.class);
		configuration.addAnnotatedClass(Ticket.class);
		
		SessionFactory factory = configuration.buildSessionFactory();
		return factory;
	}

}
