package bean;

import java.util.*;
import java.util.Random;


public class User {

//	private ArrayList<Flight> 
    private String User_Id ;
    
	public String getUser_Id() {
		return ((new Random()).nextInt(900000) + 100000)+"";
	}
	
	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}
	private String Role ;
	
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
	private String category ;
	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	private String User_name;
	private String Password;
	private String Email_id;
	private String Address1;
	private String city;
	private String State;
	private String Country;
	private String Zipcode , Phone;
	private String date;
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getZipcode() {
		return Zipcode;
	}
	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
	

}