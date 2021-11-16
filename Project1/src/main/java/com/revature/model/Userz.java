package com.revature.model;

public class Userz 
{
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String userRole;

	public Userz() {
		// TODO Auto-generated constructor stub
	}
	
	public Userz(String userName, String passWord) 
	{
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public Userz(String userName, String passWord, String firstName, String lastName, String userEmail,
			String userRole) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userEmail=" + userEmail + ", userRole=" + userRole + "]";
	}
	
	
	
	
	
	
	
	
}
