package person_details;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver_FeatchById {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter id");
	Person p=m.find(Person.class, sc.nextInt());
	System.out.println(p.getId()+" "+p.getName()+" "+p.getGender()+" "+p.getAge()+" "+p.getPhone_no());
}
}
