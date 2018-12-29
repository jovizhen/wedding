package com.mkyong.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong.domain.MealRecord;

@Component
public class MealDao
{

	@Autowired
	private SessionFactory sf ;
	
	public void saveMealRecord(MealRecord record){
		Session session = null;
		try{
			session = sf.openSession();
			session.save(record);
		}catch(Exception ex){
			throw ex;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}
}
