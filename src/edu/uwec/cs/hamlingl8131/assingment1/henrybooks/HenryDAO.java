package edu.uwec.cs.hamlingl8131.assingment1.henrybooks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HenryDAO {
	static final String DB_URL = "jdbc:oracle:thin:@dario.cs.uwec.edu:1521:csdev";
	static final String USER = "HAMLINGL8131";
	static final String PASS = "7CLRORF7";
	private static Statement stmt;
	private static ResultSet rs;
	private static Connection conn;
	
	private List<Author> authors;
	private List<Book> books;
	private List<BranchAndBookInventory> inventoryAndBranch;
	
	public HenryDAO(){
		conn = null;
		
		try{
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			getAllAuthorsWithBooks();
			getAllInventoryAndBranches();
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			
		}
	}
	
	private void getAllInventoryAndBranches() {
		inventoryAndBranch = new ArrayList<BranchAndBookInventory>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT BOOK_CODE, BRANCH_NAME, ON_HAND FROM HENRY_INVENTORY inv INNER JOIN HENRY_BRANCH bran ON inv.BRANCH_NUM = bran.BRANCH_NUM";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String bookCode = rs.getString("BOOK_CODE");
				String branchName = rs.getString("BRANCH_NAME");
				int onHand = rs.getInt("ON_HAND");
				BranchAndBookInventory item = new BranchAndBookInventory(bookCode, branchName, onHand);
				inventoryAndBranch.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void getAllAuthorsWithBooks(){
		authors = new ArrayList<Author>(); 
		try {
			stmt = conn.createStatement();
			String sql = "SELECT DISTINCT auth.AUTHOR_NUM, AUTHOR_FIRST, AUTHOR_LAST FROM HENRY_AUTHOR auth INNER JOIN HENRY_WROTE wrote ON auth.AUTHOR_NUM = wrote.AUTHOR_NUM INNER JOIN HENRY_BOOK book ON wrote.BOOK_CODE = book.BOOK_CODE ORDER BY AUTHOR_LAST ASC";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int authorNum = rs.getInt("AUTHOR_NUM");
				String firstName = rs.getString("AUTHOR_FIRST");
				String lastName = rs.getString("AUTHOR_LAST");
				//System.out.println("AUTHOR_NUM" + authorNum + "AUTHOR_FIRST" + firstName + "AUTHOR_LAST");
				Author author = new Author(authorNum, firstName, lastName);
				authors.add(author);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		//return authors;
	}
	
	public void findAuthorsBooks(int authorNum) {
		//System.out.println("Inside of findAuthorsBooks");
		books = new ArrayList<Book>();
		try {
			String sql = "SELECT book.BOOK_CODE, TITLE, PUBLISHER_CODE, TYPE, PRICE, PAPERBACK FROM HENRY_BOOK book INNER JOIN HENRY_WROTE wrote ON book.BOOK_CODE = wrote.BOOK_CODE INNER JOIN HENRY_AUTHOR auth ON auth.AUTHOR_NUM = wrote.AUTHOR_NUM WHERE auth.AUTHOR_NUM = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, authorNum);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				String bookCode = rs.getString("BOOK_CODE");
				String bookTitle = rs.getString("TITLE");
				String publisherCode = rs.getString("PUBLISHER_CODE");
				String type = rs.getString("TYPE");
				double price = rs.getDouble("PRICE");
				String paperback = rs.getString("PAPERBACK");
				Book book = new Book(bookCode, bookTitle, publisherCode, type, price, paperback);
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return books;
	}
	
	public List<Author> getAuthors(){
		return authors;
	}
	
	public List<Book> getBooks(){
		return books;
	}
	
	public List<BranchAndBookInventory> getInventory(){
		return inventoryAndBranch;
	}
	
	public void getBookBranchAndAmount(Book bookName) {
		// TODO Auto-generated method stub
		
	}
}
