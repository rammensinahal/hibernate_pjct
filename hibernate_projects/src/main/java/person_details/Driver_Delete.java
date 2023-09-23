package person_details;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class Driver_Delete {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter deleted id");
	Person p=m.find(Person.class, sc.nextInt());
	
	t.begin();
	m.remove(p);
	t.commit();
}
}
