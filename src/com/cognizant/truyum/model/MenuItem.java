package com.cognizant.truyum.model;

import java.util.Date;

public class MenuItem {
	
	private long id;
	private String name, category;
	private float price;
	private boolean active, freeDelivery;
	private Date dateOflaunch;
	
	public MenuItem(long id, String name, float price, boolean active, Date dateOflaunch, String category, boolean freeDelivery) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOflaunch=dateOflaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
		
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public boolean getActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Date getDateOflaunch() {
		return this.dateOflaunch;
	}
	
	public void setDateOflaunch(Date dateOflaunch) {
		this.dateOflaunch = dateOflaunch;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public boolean getFreeDelivery() {
		return freeDelivery;
	}
	
	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	
	@Override
	public String toString()
	{
		return this.id + " "+ this.name + " " + this.price + " " + this.active + " " + this.dateOflaunch + " " + 
		this.category + " " + this.freeDelivery;
	}
	
	boolean equals(MenuItem menu)
	{
		if(menu.id==this.id)
			return true;
		else
			return false;
	}
	
}