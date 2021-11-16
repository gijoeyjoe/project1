package com.revature.model;

import java.sql.Timestamp;

public class Reimburse 
{
	private int reId;
	private Timestamp reSubmitted;
	private int	reAmount;
	private Timestamp reResolved;
	private String reDescript;
	private String reAuthorUN;
	private String reResolverUN;
	private String reStatus;
	private String reType;

	
	public Reimburse() {
		// TODO Auto-generated constructor stub
	}

	public Reimburse(int reId, Timestamp reSubmitted, String reResolverUN, String reStatus, String reType) 
	{
		super(); 
		this.reId = reId;
		this.reSubmitted = reSubmitted;
		this.reResolverUN = reResolverUN;
		this.reStatus = reStatus;
		this.reType = reType;
	}
	

	public Reimburse(int reId, Timestamp reSubmitted, int reAmount, String reDescript, String reAuthorUN, String reResolverUN, String reStatus, String reType)
	{
		super();
		this.reId = reId;
		this.reSubmitted = reSubmitted;
		this.reAmount = reAmount;
		this.reDescript = reDescript;
		this.reAuthorUN = reAuthorUN;
		this.reResolverUN = reResolverUN;
		this.reStatus = reStatus;
		this.reType = reType;
	}



	public int getReId() {
		return reId;
	}


	public void setReId(int id) {
		this.reId = id;
	}


	public Timestamp getReSubmitted() {
		return reSubmitted;
	}


	public void setReSubmitted(Timestamp reSubmitted) {
		this.reSubmitted = reSubmitted;
	}


	public int getReAmount() {
		return reAmount;
	}


	public void setReAmount(int reAmount) {
		this.reAmount = reAmount;
	}


	public Timestamp getReResolved() {
		return reResolved;
	}


	public void setReResolved(Timestamp reResolved) {
		this.reResolved = reResolved;
	}


	public String getReDescript() {
		return reDescript;
	}


	public void setReDescript(String reDescript) {
		this.reDescript = reDescript;
	}


	public String getReAuthorUN() {
		return reAuthorUN;
	}


	public void setReAuthorUN(String reAuthorUN) {
		this.reAuthorUN = reAuthorUN;
	}


	public String getReResolverUN() {
		return reResolverUN;
	}


	public void setReResolverUN(String reResolverUN) {
		this.reResolverUN = reResolverUN;
	}


	public String getReStatus() {
		return reStatus;
	}


	public void setReStatus(String reStatus) {
		this.reStatus = reStatus;
	}


	public String getReType() {
		return reType;
	}


	public void setReType(String reType) {
		this.reType = reType;
	}




	@Override
	public String toString() {
		return "Reimburse [reId=" + reId + ", reSubmitted=" + reSubmitted + ", reResolverUN=" + reResolverUN + ", reStatus=" + reStatus + ", reType=" + reType + "]";
	}
	
	
	
	
	
	

}
