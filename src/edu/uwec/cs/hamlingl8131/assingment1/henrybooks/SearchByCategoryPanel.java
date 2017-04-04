package edu.uwec.cs.hamlingl8131.assingment1.henrybooks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class SearchByCategoryPanel extends JPanel{
	
	public SearchByCategoryPanel(HenryDAO henry) {
		// TODO Auto-generated constructor stub
	}

	public class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox comboBox = (JComboBox)e.getSource();
			String authorName = (String)comboBox.getSelectedItem();
			//grabAuthorBooks(authorName);
		}

	}
}
