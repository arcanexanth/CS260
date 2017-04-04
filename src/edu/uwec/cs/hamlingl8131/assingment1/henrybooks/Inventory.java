package edu.uwec.cs.hamlingl8131.assingment1.henrybooks;

public class Inventory {
	private String BOOK_CODE;
	private int BRANCH_NUM;
	private int ON_HAND;
	
	public Inventory(String BOOK_CODE, int BRANCH_NUM, int ON_HAND){
		this.BOOK_CODE = BOOK_CODE;
		this.BRANCH_NUM = BRANCH_NUM;
		this.ON_HAND = ON_HAND;
	}
	
	public String getBook_Code(){
		return BOOK_CODE;
	}
	
	public int getBranch_Num(){
		return BRANCH_NUM;
	}
	
	public int getOn_Hand(){
		return ON_HAND;
	}

}
