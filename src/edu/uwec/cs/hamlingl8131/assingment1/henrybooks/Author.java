package edu.uwec.cs.hamlingl8131.assingment1.henrybooks;

public class Author {
  private int authorNumber;
  private String authorFirstName;
  private String authorLastName;
	
  public Author(int authorNumber, String authorFirstName, String authorLastName){
	this.authorNumber=authorNumber;
	this.authorLastName=authorLastName;
	this.authorFirstName=authorFirstName;
  }
  
  public String toString(){
	  return authorFirstName + authorLastName;
  }
  
  public int getAuthorNum(){
	  return authorNumber;
  }

}
