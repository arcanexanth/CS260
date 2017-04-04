package edu.uwec.cs.hamlingl8131.assingment1.henrybooks;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Henry extends JPanel {
		
	private Henry(HenryDAO henry){
		JTabbedPane pane = new JTabbedPane();
		JPanel SearchByAuthor = new SearchByAuthorPanel(henry);
		SearchByAuthor.setLayout(new FlowLayout(1, 3, 3));
		JPanel SearchByCategory = new SearchByCategoryPanel(henry);
		SearchByCategory.setLayout(new FlowLayout(1, 3, 3));
		JPanel SearchByPublisher = new SearchByPublisherPanel(henry);
		SearchByPublisher.setLayout(new FlowLayout(1, 3, 3));
		
		pane.addTab("Search By Author", SearchByAuthor);
		pane.setSelectedIndex(0);
		pane.addTab("Search By Category", SearchByCategory);
		pane.setSelectedIndex(1);
		pane.addTab("Search By Publisher", SearchByPublisher);
		pane.setSelectedIndex(2);
		setLayout(new GridLayout(1, 3));
		add(pane);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowUI();
			}
		});
		//List<Book> books = henry.getAllBooks();
		

		
	}
	
	public static void createAndShowUI(){
		HenryDAO henry = new HenryDAO();
		JFrame frame = new JFrame();
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		frame.getContentPane().add(new Henry(henry), BorderLayout.CENTER);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}
