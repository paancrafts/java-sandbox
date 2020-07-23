package paan.hibernates;

import java.sql.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCreate {

	public static void main(String[] args) {
		System.setProperty("javax.xml.accessExternalDTD", "all");
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
		    Item item = new Item("Sword", Level.GOLD, 3, 5, true);
		    SessionFactory sf = (SessionFactory) 
		    		new Configuration()
		    		.configure("hibernate.cfg.xml")
		    		.addAnnotatedClass(Item.class)
		    		.buildSessionFactory();
		       Session session = sf.openSession();
		       session.beginTransaction();
		       session.save(item);
		       session.getTransaction().commit();
		} catch(Exception e) {
		   System.out.println(e.getMessage());
		} finally {
			try{
		           if (conn != null) {
		        	   conn.close();
		           }
		             
			}
			catch(Exception ex ){
		         System.out.println(ex.getMessage());
			}
		}
	}

}
