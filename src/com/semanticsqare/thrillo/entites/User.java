package com.semanticsqare.thrillo.entites;

public class User {
	private long id;
	private static  String Email;
	private String password;
	private String FirstName;
	private String LastName;
	private int Gender;
	private String UserType;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType2) {
		UserType = userType2;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Email=" + Email + ", password=" + password + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", Gender=" + Gender + ", UserType=" + UserType + "]";
	}
	
	
	
	

}
