package employ;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import employ.Employ_details;

public class driver {
public static void main(String[] args) {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=factory.createEntityManager();
	EntityTransaction transaction=entityManager.getTransaction();
	 
	Employ_details details=new Employ_details();
	boolean flag =true;
	while(flag){
		System.out.println("add employs");
		System.out.println("featch employs using id");
		System.out.println("modify employ phone no using id");
		System.out.println("featch details of all employs");
		System.out.println("remove data employs by using id");
		
		Scanner scanner=new Scanner(System.in);
		switch(scanner.nextInt())
		{
		case 1:{
			System.out.println("enter the id ");
			details.setId(scanner.nextInt());
			System.out.println("enter the name ");
			details.setEname(scanner.next());
			System.out.println("enter the age ");
			details.setEage(scanner.nextInt());
			System.out.println("enter the phone no ");
			details.setPhoneno(scanner.nextLong());
			System.out.println("enter the salary ");
			details.setSalary(scanner.nextInt());
			
			transaction.begin();
			entityManager.persist(details);
			transaction.commit();
		
			System.out.println("hooooooooo");
		}
		break;
		case 2:{
			System.out.println("enter the Id");
			Employ_details details1= entityManager.find(Employ_details.class, scanner.nextInt());
			
			if(details1!=null)
			{
				System.out.println(details1.getId()+" "+details1.getEage()+" "+details1.getEname()+" "+details1.getPhoneno()+" "+details1.getSalary());
			}else{
				System.out.println("invalid data");
			}
			System.out.println("hoooooooo");
		}
		break;
		case 3:{
			System.out.println("enter the Id");
			Employ_details details2=entityManager.find(Employ_details.class, scanner.nextInt());
			if(details2!=null)
			{
				transaction.begin();
				details2.setPhoneno(scanner.nextLong());
				entityManager.merge(details2);
				transaction.commit();				
			}else{
				System.out.println("no Id found");
			}
			System.out.println("hooooooo");
		}
		break;
		case 4:{
			Query query =entityManager.createQuery("select x from Employ_details x",Employ_details.class );
			List<Employ_details>list= query.getResultList();
			for(Employ_details d:list)
			{
				System.out.println(d.getEage()+" "+d.getEname()+" "+d.getPhoneno()+" "+d.getId()+" "+d.getSalary());
				
			}
			System.out.println(" DATA HAS BEEN FEATCHED---->");
		}
		break;
		case 5:{
			System.out.println("enter the  removing id ");
			Employ_details s1=entityManager.find(Employ_details.class,scanner.nextInt());
			if(s1!=null)
			{
				transaction.begin();
				entityManager.remove(s1);
				transaction.commit();
			}
			else
				System.out.println("no id found");
		}
		System.out.println("*************hoooo***********");
	break;
	case 6:
		{
		 flag=true;
			System.out.println("thank you");
		}
		break;
		default:
		{
			System.out.println("invalid option");
		}
			
		
	}
}
}
}
