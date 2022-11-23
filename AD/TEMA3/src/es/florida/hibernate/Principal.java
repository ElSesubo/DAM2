package es.florida.hibernate;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Carrega la configuracio i crea un session factory
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(User.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		// Obri una nova sessió de la session factory
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		
		//Crear nou objecte
//		User us = new User("manute", "mama");
//		Serializable id = session.save(us);
		
		//Recuperar llista d’objectes
		List listaCanciones = new ArrayList();
		listaCanciones = session.createQuery("FROM User").list();
		
		//Recuperar un objecte a partir del seu id
		User user = (User) session.get(User.class, 1);
		System.out.println(user.getId() + " " + user.getUser() + " " + user.getPass());

		
		//Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();

	}

}
