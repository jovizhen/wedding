package com.mkyong.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meal_plan")
public class MealRecord
{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="householder")
	private String householder;
	
	@Column(name="email")
	private String email;
	
	@Column(name="age_group")
	private String ageGroup;
	
	@Column(name="main_course")
	private String mainCourse;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cr_date")
	private Date crDate;

	
	
	public MealRecord(String householder, String email, String ageGroup, String mainCourse, String name)
	{
		super();
		this.householder = householder;
		this.email = email;
		this.ageGroup = ageGroup;
		this.mainCourse = mainCourse;
		this.name = name;
	}

	public String getHouseholder()
	{
		return householder;
	}

	public void setHouseholder(String householder)
	{
		this.householder = householder;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getAgeGroup()
	{
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup)
	{
		this.ageGroup = ageGroup;
	}

	public String getMainCourse()
	{
		return mainCourse;
	}

	public void setMainCourse(String mainCourse)
	{
		this.mainCourse = mainCourse;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getCrDate()
	{
		return crDate;
	}

	public void setCrDate(Date crDate)
	{
		this.crDate = crDate;
	}

}
