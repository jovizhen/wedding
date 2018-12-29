package com.mkyong.controllers;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.dao.MealDao;
import com.mkyong.domain.Constant;
import com.mkyong.domain.Greeting;
import com.mkyong.domain.Meal;
import com.mkyong.domain.MealPlan;
import com.mkyong.domain.MealRecord;
import com.mkyong.domain.Response;

@RestController
public class MainController
{
	@Autowired
	private MealDao mealDao;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping(value = "/savemeal/", method = RequestMethod.POST)
	public Response saveMeals(@RequestBody MealPlan mealPlan)
	{
		Response rs = new Response();
		try
		{
			String householder = mealPlan.getName();
			String email = mealPlan.getEmail();
			for (Meal meal : mealPlan.getMeals())
			{
				MealRecord record = new MealRecord(householder, email, meal.getAgeGroup(), meal.getMainCourse(),
						meal.getName());
				record.setCrDate(new Date());
				mealDao.saveMealRecord(record);

			}
			rs.setStatus(Constant.RSP_SUCCESS_CODE);
			rs.setContent(Constant.RSP_SUCESS_CONT);
		}
		catch (Exception e)
		{
			rs.setStatus(Constant.RSP_ERROR_CODE);
			rs.setContent(Constant.RSP_ERROR_CONT);
			rs.setDetails(e.getMessage());
		}

		return rs;
	}
}
