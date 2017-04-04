package edu.uwec.cs.hamlingl8131.assingment1.henrybooks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchByAuthorPanel extends JPanel implements ActionListener, ItemListener{
	private JComboBox author;
	private JComboBox book;
	private double bookPrice;
	private JFormattedTextField priceField;
	private JTextArea branchField;
	private HenryDAO henry;
	
	public SearchByAuthorPanel(HenryDAO henry){
		
		this.henry = henry;
		book = new JComboBox();
		
		startSearchByAuthor();
		
		
		this.add(author);
		this.add(book);
		this.add(priceField);
		this.add(branchField);
	}
	
	private void startSearchByAuthor() {
		priceField = new JFormattedTextField();
		branchField = new JTextArea();
		
		priceField.setColumns(7);
		branchField.setColumns(30);
		
		author = new JComboBox(henry.getAuthors().toArray());
		
		
		author.setSelectedItem(author.getSelectedIndex());
		Author authorName = (Author) (author.getSelectedItem());
		grabAuthorBooksAndBranch(authorName);
		Book bookName = (Book) (book.getSelectedItem());
			
		author.addActionListener(this);
		
		book.addActionListener(this);
		
}

	private void getBookBranchAndAmount(Book bookName) {
		
		branchField.setText(null);
		List<BranchAndBookInventory> inventory =  (henry.getInventory());
		List<String> bookInventory = new ArrayList<String>();
		for(int i = 0; i < henry.getInventory().size(); i++){
			if(bookName.getBookCode().equals(inventory.get(i).getBookCode())){
				bookInventory.add(inventory.get(i).getBranchName() + inventory.get(i).getOnHand());
			}
		}
		
		for(int j = 0; j < bookInventory.size(); j++){
			System.out.println("Size of bookInventory is: " + bookInventory.size()+ "\n");
			branchField.append(bookInventory.get(j) + "\n");
			branchField.setCaretPosition(branchField.getDocument().getLength());
		}
		
	}

	private void grabAuthorBooksAndBranch(Author authorName) {
		
		int authNum = authorName.getAuthorNum();
		
		henry.findAuthorsBooks(authNum);
		book.setModel(new DefaultComboBoxModel(henry.getBooks().toArray()));
		Book bookName = (Book) (this.book.getSelectedItem());
		getBookPrice(bookName);
		getBookBranchAndAmount(bookName);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Got to actionPerformed");
		if(e.getSource().equals(author)){
			
			JComboBox comboBox = (JComboBox)e.getSource();
			Author authorName = (Author) (comboBox.getSelectedItem());
			grabAuthorBooksAndBranch(authorName);
		}else if(e.getSource().equals(book)){
			
			JComboBox comboBox = (JComboBox)e.getSource();
			Book bookName = (Book) (comboBox.getSelectedItem());
			getBookPrice(bookName);
		}
	}

	private void getBookPrice(Book bookName) {
	
		bookPrice = bookName.getPrice();
	
		priceField.setText("$" + bookPrice);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("Got to itemStateChanged");
		
		if(e.getSource().equals(book)){
			System.out.println("Inside if statment inside itemStateChanged");
			JComboBox comboBox = (JComboBox)e.getSource();
			Book bookName = (Book) (comboBox.getSelectedItem());
			getBookPrice(bookName);
		}
	}
}
