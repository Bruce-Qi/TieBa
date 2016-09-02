package cn.tf.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class H3Utils {
	
	private static SessionFactory factory=new Configuration().configure().buildSessionFactory();
	
	public static Session getCurrentSession(){
		return factory.getCurrentSession();
	}

}
