package edu.uwec.cs.hamlingl8131.assingment1.henrybooks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class SearchByPublisherPanel extends JPanel{

	public SearchByPublisherPanel(HenryDAO henry) {
		// TODO Auto-generated constructor stub
	}

	public class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox)e.getSource();
			String authorName = (String)cb.getSelectedItem();
			//updateLabel(authorName);
		}

	}
}
