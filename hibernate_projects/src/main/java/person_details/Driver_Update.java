package person_details;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver_Update {
public static void main(String[] args) {
//	Person person=new Person();
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter id");
	Person update=manager.find(Person.class, sc.nextInt());

	System.out.println("enter new name");
	update.setName(sc.next());
	
	transaction.begin();
	manager.merge(update);
	transaction.commit();
	

}
}
