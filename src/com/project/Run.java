package com.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	         
	        Candidate student = new Candidate();
	        student.setCanName("prem2");
	        session.save(student);
	        session.getTransaction().commit();
	        session.close();

	}

}
