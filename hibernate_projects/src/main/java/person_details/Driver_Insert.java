package person_details;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver_Insert {
public static void main(String[] args) {
	
	Person p=new Person();
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	Scanner sc= new Scanner(System.in);
	System.out.println("enter id");
	p.setId(sc.nextInt());
	System.out.println("enter name");
	p.setName(sc.next());
	System.out.println("enter gender");
	p.setGender(sc.next());
	System.out.println("enter age");
	p.setAge(sc.nextInt());
	System.out.println("enter phone no");
	p.setPhone_no(sc.nextLong());
	
	transaction.begin();
	manager.persist(p);
	transaction.commit();
	
	
}
}
