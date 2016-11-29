package view;

import libraryManagementSystem.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BookSearch extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitle;
	private JTextField tfAuthor;
	private JTextField tfYear;
	private JTextField tfPublisher;
	private JTextField tfISBN;
	private JTable tableSearchResults;
	private Library library;
	ArrayList<Book> bookResults;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library library = new Library();
					BookSearch frame = new BookSearch(library);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookSearch(Library library) {
		this.library = library;
		
		setTitle("Book Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 921);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, 12, 664, 198);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Author");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(22, 52, 84, 32);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Year");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		label_1.setBounds(22, 85, 84, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Publisher");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.BOLD, 16));
		label_2.setBounds(22, 118, 84, 32);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("ISBN");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.BOLD, 16));
		label_3.setBounds(22, 154, 84, 32);
		panel.add(label_3);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitle.setBounds(12, 12, 94, 32);
		panel.add(lblTitle);
		
		tfTitle = new JTextField();
		tfTitle.setBounds(133, 20, 198, 19);
		panel.add(tfTitle);
		tfTitle.setColumns(10);
		
		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(133, 60, 198, 19);
		panel.add(tfAuthor);
		
		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(133, 93, 198, 19);
		panel.add(tfYear);
		
		tfPublisher = new JTextField();
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(133, 126, 198, 19);
		panel.add(tfPublisher);
		
		tfISBN = new JTextField();
		tfISBN.setColumns(10);
		tfISBN.setBounds(133, 162, 198, 19);
		panel.add(tfISBN);
		
		JButton btnSearch = new JButton("Search");
		
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 30));
		btnSearch.setBounds(342, 143, 310, 46);
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(12, 222, 664, 660);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSearchResults = new JLabel("Search Results");
		lblSearchResults.setBounds(26, 12, 600, 24);
		lblSearchResults.setBackground(Color.BLACK);
		lblSearchResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchResults.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(lblSearchResults);
		
		tableSearchResults = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Title", "Author", "Year", "Publisher", "ISBN"
			}
		));
		tableSearchResults.setBackground(Color.GRAY);
		tableSearchResults.setBounds(12, 48, 631, 600); 
		
		MouseListener mouseListenerEvents = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		         if (e.getClickCount() == 1) { // double click detection		        	 
		        	 JTable target = (JTable)e.getSource();
		        	 int row = target.getSelectedRow();
		        	 BookDetail bookDetail = new BookDetail(bookResults.get(row));
		        	 bookDetail.setVisible(true);
		         }
			}
		};
		
		tableSearchResults.addMouseListener(mouseListenerEvents);
		
		JScrollPane scrollPaneToTableSearchResults=new JScrollPane(tableSearchResults);
		scrollPaneToTableSearchResults.setBounds(12, 48, 631, 600); 
		scrollPaneToTableSearchResults.setVisible(true);
        add(scrollPaneToTableSearchResults);
		
		panel_1.add(scrollPaneToTableSearchResults);
		
		JLabel label_4 = new JLabel("Title");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(22, 33, 117, 15);
		panel_1.add(label_4);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAuthor.setBounds(147, 33, 117, 15);
		panel_1.add(lblAuthor);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Dialog", Font.BOLD, 12));
		lblYear.setBounds(263, 33, 117, 15);
		panel_1.add(lblYear);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsbn.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIsbn.setBounds(526, 33, 117, 15);
		panel_1.add(lblIsbn);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublisher.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPublisher.setBounds(397, 33, 117, 15);
		panel_1.add(lblPublisher);
		
		SearchButtonClickHandler listener = new SearchButtonClickHandler();
		tfAuthor.addActionListener(listener);
		tfISBN.addActionListener(listener);
		tfPublisher.addActionListener(listener);
		tfTitle.addActionListener(listener);
		tfYear.addActionListener(listener);

		btnSearch.addKeyListener(listener);
		btnSearch.addActionListener(new SearchButtonClickHandler());
	}
	
	class SearchButtonClickHandler implements ActionListener, KeyListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			bookResults = library.advancedSearch(tfTitle.getText(), tfAuthor.getText(), tfYear.getText(), tfPublisher.getText(), tfISBN.getText());
			 ArrayList<Book> results = library.advancedSearch(tfTitle.getText(), tfAuthor.getText(), tfYear.getText(), tfPublisher.getText(), tfISBN.getText());
			 DefaultTableModel tableModel = (DefaultTableModel) tableSearchResults.getModel();
			 tableModel.getDataVector().removeAllElements();
			 tableModel.fireTableDataChanged();
			 
			 for (Book currentBook : results)
			 { 
				 tableModel.addRow(new Object[]{currentBook.getTitle(), 
						 currentBook.getAuthor(),  
						 currentBook.getYear(), 
						 currentBook.getPublishing_house(), 
						 currentBook.getIsbn()});
			 } 
		}
		
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode()==KeyEvent.VK_ENTER){
	            System.out.println("Hello");

				bookResults = library.advancedSearch(tfTitle.getText(), tfAuthor.getText(), tfYear.getText(), tfPublisher.getText(), tfISBN.getText());
				 
				 ArrayList<Book> results = library.advancedSearch(tfTitle.getText(), tfAuthor.getText(), tfYear.getText(), tfPublisher.getText(), tfISBN.getText());
				 DefaultTableModel tableModel = (DefaultTableModel) tableSearchResults.getModel();
				 tableModel.getDataVector().removeAllElements();
				 tableModel.fireTableDataChanged();
				 
				 for (Book currentBook : results)
				 { 
					 tableModel.addRow(new Object[]{currentBook.getTitle(), 
							 currentBook.getAuthor(),  
							 currentBook.getYear(), 
							 currentBook.getPublishing_house(), 
							 currentBook.getIsbn()});
				 } 
	        }


	    }

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
