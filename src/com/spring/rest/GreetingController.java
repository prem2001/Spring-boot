package com.spring.rest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Candidate;
import com.project.HibernateUtil;

@RestController
@RequestMapping("/p")
public class GreetingController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public List<Candidate> greeting(@RequestBody String name) {
    	
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
       
        ObjectMapper objectMapper = new ObjectMapper();
    	Candidate emp=new Candidate();
		try {
			emp = objectMapper.readValue(name, Candidate.class);
			System.out.println(emp.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        session.save(emp);
        session.getTransaction().commit();
        session.close();
    	

    
		 SessionFactory sessionFactory1 = HibernateUtil.getSessionFactory();
	        Session session1 = sessionFactory1.openSession();
	         
	        List<Candidate> students = session1.createQuery("FROM Candidate").list();
        ObjectMapper mapperObj = new ObjectMapper();
         
        try {
            // get Employee object as a json string
            String jsonStr = mapperObj.writeValueAsString(students);
            System.out.println(jsonStr);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return students;
//		return new Greeting(1, name);
    }
}
