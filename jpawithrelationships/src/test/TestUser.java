package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Office;
import entities.Teachin;
import entities.User;

public class TestUser {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("elink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Office office1 = new Office(1, "Denver");
		Office office2 = new Office(2, "Quebec");
		entitymanager.persist(office1);
		entitymanager.persist(office2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		User user = new User();
		user.setAid(1);
		user.setFname("Jack");
		user.setLname("Morgan");
		user.setAddress("123 pensilvania ave,NYC");
		try {
			user.setBirthDate(sdf.parse("1978-12-12"));
		} catch (ParseException ex) {

			System.out.println("can't parse date");
		}
		user.setOffice(office1);
		entitymanager.persist(user);

		user.setAid(2);
		user.setFname("Jimmy");
		user.setLname("Morgan");
		user.setAddress("123 pensilvania ave,NYC");
		try {
			user.setBirthDate(sdf.parse("1978-12-12"));
		} catch (ParseException ex) {

			System.out.println("can't parse date");
		}
		user.setOffice(office2);
		entitymanager.persist(user);
		

		// find a user
		User testUser = entitymanager.find(User.class, 1);
		System.out.format("found user %s on following address %s -> ",
				testUser.getFname() + " " + testUser.getLname() + " ",
				testUser.getAddress());
		// now update user
		testUser.setAddress(" 234Macdonalds ave ,New Jersey");
		
		// check if user updated
		testUser = entitymanager.find(User.class, 1);
		System.out.format("found user %s on following address %s -> ",
				testUser.getFname() + " " + testUser.getLname() + " ",
				testUser.getAddress());

		// select all users
		Query q = entitymanager.createQuery("select u from User u");
		@SuppressWarnings("unchecked")
		List<User> users = new ArrayList<User>(q.getResultList());
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {

			testUser = (User) it.next();
			System.out.println(testUser.getFname() + " " + testUser.getLname()
					+ " " + "born on " + testUser.getBirthDate()
					+ "lives on following Address" + testUser.getAddress());

		}
		// remove user
		//entitymanager.remove(testUser);
		//entitymanager.getTransaction().commit();
		
		Teachin tc = new Teachin();
		tc.setTid(1);
		tc.setAuthor("deil karnegi");
		tc.setTname("realtions");
		tc.setUserList(users);
		
		entitymanager.persist(tc);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

}
