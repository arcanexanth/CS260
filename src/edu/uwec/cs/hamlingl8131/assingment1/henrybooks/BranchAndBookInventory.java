package edu.uwec.cs.hamlingl8131.assingment1.henrybooks;

public class BranchAndBookInventory {
	
	private String BOOK_CODE;
	private String BRANCH_NAME;
	private int ON_HAND;
	
	public BranchAndBookInventory(String BOOK_CODE, String branchName, int ON_HAND){
		this.BOOK_CODE = BOOK_CODE;
		this.BRANCH_NAME = branchName;
		this.ON_HAND = ON_HAND;
	}
	
	public String getBookCode(){
		return BOOK_CODE;
	}
	
	public String getBranchName(){
		return BRANCH_NAME;
	}
	
	public int getOnHand(){
		return ON_HAND;
	}
}
