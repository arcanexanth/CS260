package edu.uwec.cs.hamlingl8131.assingment1.henrybooks;

public class Book {
	private String bookCode;
	private String title;
	private String publisherCode;
	private String type;
	private double price;
	private String paperback;
	private String branch;
	private int onHand;
	
	public Book(String bookCode, String title, String publisherCode,
				String type, double price, String paperback){
		this.bookCode = bookCode;
		this.title = title;
		this.publisherCode = publisherCode;
		this.type = type;
		this.price = price;
		this.paperback = paperback;
	}
	
	public String getPaperback(){
		return paperback;
	}
	
	public String getPublisherCode(){
		return publisherCode;
	}
	
	public String getBookCode(){
		return bookCode;
	}
	
	public String toString(){
		return title;
	}
	
	public String getType(){
		return type;
	}
	
	public double getPrice(){
		return price;
	}
}
