package es.florida.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ej8 {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(User.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List listaUsuaris;
		int opciones;
		
		boolean continuar = false;
		do {
			Scanner teclado = new Scanner(System.in);
			System.out.println("1. Mostrar tots els usuaris.");
			System.out.println("2. Mostrar la informació detallada d’un usuari a partir del seu id.");
			System.out.println("3. Afegir un nou usuari.");
			System.out.println("4. Modificar atributs d’un usuari a partir del seu id.");
			System.out.println("5. Esborrar usuari.");
			System.out.println("6. Tancar programa");
			System.out.print("Elegir opció: ");
			String opcion = teclado.nextLine();
			
			switch(opcion) {
				case "1":
					listaUsuaris = new ArrayList();
					listaUsuaris = session.createQuery("FROM User").list();
					for(int i = 0; i < listaUsuaris.size(); i++) {
						User u = (User) listaUsuaris.get(i);
						System.out.println(u.toString());
					}
					break;
				case "2":
					listaUsuaris = new ArrayList();
					listaUsuaris = session.createQuery("FROM User").list();
					for(int i = 0; i < listaUsuaris.size(); i++) {
						User u = (User) listaUsuaris.get(i);
						System.out.println(u.toString());
					}
					System.out.print("Elegir opció: ");
					opciones = Integer.parseInt(teclado.nextLine());
					
					User user = (User) session.get(User.class, opciones);
					System.out.println(user.getId() + " " + user.getUser() + " " + user.getPass());
					break;
				case "3":
					System.out.print("Nou nom d'usuari: ");
					String name1 = teclado.nextLine();

					System.out.print("Nova contrasenya d'usuari: ");
					String pass1 = teclado.nextLine();
					
					User us = new User(name1, pass1);
					Serializable id = session.save(us);
					break;
				case "4":
					listaUsuaris = new ArrayList();
					listaUsuaris = session.createQuery("FROM User").list();
					for(int i = 0; i < listaUsuaris.size(); i++) {
						User u = (User) listaUsuaris.get(i);
						System.out.println(u.toString());
					}
					System.out.print("Elegir opció: ");
					opciones = Integer.parseInt(teclado.nextLine());
					
					User us1 = (User) session.load(User.class, opciones);
					System.out.print("Nou nom d'usuari: ");
					String name = teclado.nextLine();
					us1.setUser(name);
					System.out.print("Nova contrasenya d'usuari: ");
					String pass = teclado.nextLine();
					us1.setPass(pass);
					session.update(us1);
					break;
				case "5":
					listaUsuaris = new ArrayList();
					listaUsuaris = session.createQuery("FROM User").list();
					for(int i = 0; i < listaUsuaris.size(); i++) {
						User u = (User) listaUsuaris.get(i);
						System.out.println(u.toString());
					}
					System.out.print("Elegir opció: ");
					opciones = Integer.parseInt(teclado.nextLine());
					
					User us2 = new User();
					us2.setId(opciones);
					session.delete(us2);
					
					break;
				case "6":
					continuar = true;
					break;
			}
			
		}while(continuar == false);
	}

}
