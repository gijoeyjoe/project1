package com.revature.dao;


public interface GenericDao <T> 
{

	//	SEARCH BY USERNAME RETURN A MATCHING USER FOR LOGIN
	public T getByName(String userName);
	

}
