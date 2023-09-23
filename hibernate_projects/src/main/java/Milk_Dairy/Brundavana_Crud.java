package Milk_Dairy;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Brundavana_Crud {
	public static void main(String[] args) {
		boolean flog =true;
		EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
		EntityManager m=f.createEntityManager();
		EntityTransaction t=m.getTransaction();
		Scanner sc =new Scanner(System.in);
		Brundavana b=new Brundavana();
		while(flog) {
			System.out.println("insert data");
			System.out.println("update data");
			System.out.println("data featch by id");
			System.out.println("featch all data ");
			System.out.println("delete data ");

			switch (sc.nextInt()) {
			case 1:{
				System.out.println("enter id");
				b.setPid(sc.nextInt());
				System.out.println("enter name ");
				b.setPname(sc.next());
				System.out.println("enter liter");
				double x=b.setLiter(sc.nextDouble());
				if(x>0) {
					x=x*33;
				}
				System.out.println("enter fat");
				b.setFat(sc.nextDouble());
				b.setAmount(x);

				t.begin();
				m.persist(b);
				t.commit();
			}

			break;
			case 2:{
				Brundavana b1=m.find(Brundavana.class, sc.nextInt());
				System.out.println("enter new name");
				b1.setPname(sc.next());
				t.begin();
				m.merge(b1);
				t.commit();
				
			}
			break;
			case 3:{
				System.out.println("enter id");
				Brundavana b2=m.find(Brundavana.class, sc.nextInt());
				System.out.println(b2.getPid()+" "+b2.getPname()+" "+b2.getLiter()+" "+b2.getFat()+" "+b2.getAmount());
			}
			break;
			case 4:{
				Query q=m.createQuery("select x from Brundavana x");
				List<Brundavana> list=q.getResultList();
				System.out.println(list);
			}
			break;
			case 5:{
				Brundavana b3=m.find(Brundavana.class, sc.next());
				t.begin();
				m.remove(b3);
				t.commit();
			}

			default:
				System.out.println("invalid data");
				break;
			}
		}
	}
}
