package com.mkyong.domain;

import java.util.ArrayList;
import java.util.List;


public class MealPlan
{
	private String name;
	private String email;
	
	private List <Meal> meals = new ArrayList<>();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<Meal> getMeals()
	{
		return meals;
	}

	public void setMeals(List<Meal> meals)
	{
		this.meals = meals;
	}

}
