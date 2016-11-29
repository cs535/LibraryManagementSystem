package view;

import libraryManagementSystem.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;

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
	private DefaultTableModel tableSearchResults;
	private Library library;
	private JTable table;
	private TableRowSorter<DefaultTableModel> rowSorter;
	private ArrayList<Book> bookResults;

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

		/* 					*/
		/* 					*/
		/* Title Search */
		/* 					*/
		/* 					*/

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitle.setBounds(130, 22, 84, 32);
		panel.add(lblTitle);

		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(250, 30, 198, 19);
		panel.add(tfTitle);

		/* 					*/
		/* 					*/
		/* Author Search */
		/* 					*/
		/* 					*/

		JLabel label = new JLabel("Author");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(130, 52, 84, 32);
		panel.add(label);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(250, 60, 198, 19);
		panel.add(tfAuthor);

		/* 					*/
		/* 					*/
		/* Year Search */
		/* 					*/
		/* 					*/

		JLabel label_1 = new JLabel("Year");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		label_1.setBounds(130, 85, 84, 32);
		panel.add(label_1);

		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(250, 93, 198, 19);
		panel.add(tfYear);

		/* 								*/
		/* 								*/
		/* Publishing House Search */
		/* 								*/
		/* 								*/

		JLabel label_2 = new JLabel("Publisher");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.BOLD, 16));
		label_2.setBounds(130, 118, 84, 32);
		panel.add(label_2);

		tfPublisher = new JTextField();
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(250, 126, 198, 19);
		panel.add(tfPublisher);

		/* 					*/
		/* 					*/
		/* ISBN Search */
		/* 					*/
		/* 					*/

		JLabel label_3 = new JLabel("ISBN");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.BOLD, 16));
		label_3.setBounds(130, 154, 84, 32);
		panel.add(label_3);

		tfISBN = new JTextField();
		tfISBN.setColumns(10);
		tfISBN.setBounds(250, 162, 198, 19);
		panel.add(tfISBN);

		/* 							*/
		/* 							*/
		/* Search Results Label */
		/* 							*/
		/* 							*/

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

		String[][] datas = new String[library.getSize()][5];
		for (int i = 0; i < library.getSize(); i++) {
			datas[i][0] = library.getBookList().get(i).getTitle();
			datas[i][1] = library.getBookList().get(i).getAuthor();
			datas[i][2] = library.getBookList().get(i).getYear();
			datas[i][3] = library.getBookList().get(i).getPublishing_house();
			datas[i][4] = library.getBookList().get(i).getIsbn();
		}
		String[] columnName = { "Title", "Author", "Year", "Publisher", "ISBN" };

		tableSearchResults = new DefaultTableModel(datas, columnName) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		table = new JTable(new DefaultTableModel(datas, columnName));
		table.setBackground(Color.WHITE);
		table.setBounds(12, 48, 631, 600);
		
		MouseListener mouseListenerEvents = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) { // double click detection
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					BookDetail bookDetail = new BookDetail(bookResults.get(row));
					bookDetail.setVisible(true);
				}
			}
		};

		table.addMouseListener(mouseListenerEvents);
		
		JScrollPane scrollPaneToTableSearchResults = new JScrollPane(table);
		scrollPaneToTableSearchResults.setBounds(12, 48, 631, 600);
		scrollPaneToTableSearchResults.setVisible(true);
		add(scrollPaneToTableSearchResults);

		panel_1.add(scrollPaneToTableSearchResults);
		rowSorter = new TableRowSorter<>(tableSearchResults);
		table.setRowSorter(rowSorter);

		/* 							*/
		/* 							*/
		/* Dynamic Search */
		/* According to Title */
		/* 							*/

		tfTitle.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfTitle.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(
							("(?i)" + text), 0));
				}
				table.repaint();
				
				int rowCount = table.getRowCount();
				bookResults = new ArrayList<Book>();
				for (int i = 0; i < rowCount; i++)
				{
					Book b = new Book();
					b.setTitle((String)table.getValueAt(i, 0));
					b.setAuthor((String)table.getValueAt(i, 1));
					b.setYear((String)table.getValueAt(i, 2));
					b.setPublishing_house((String)table.getValueAt(i, 3));
					b.setIsbn((String)table.getValueAt(i, 4));
					bookResults.add(b);
				}
				System.out.println(bookResults);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfTitle.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(
							("(?i)" + text), 0));
				}
				
				int rowCount = table.getRowCount();
				bookResults = new ArrayList<Book>();
				for (int i = 0; i < rowCount; i++)
				{
					Book b = new Book();
					b.setTitle((String)table.getValueAt(i, 0));
					b.setAuthor((String)table.getValueAt(i, 1));
					b.setYear((String)table.getValueAt(i, 2));
					b.setPublishing_house((String)table.getValueAt(i, 3));
					b.setIsbn((String)table.getValueAt(i, 4));
					bookResults.add(b);
				}
				System.out.println(bookResults);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// not needed: throw new
				// UnsupportedOperationException("Not supported yet.");
			}
		});

		/* 							*/
		/* 							*/
		/* Dynamic Search */
		/* According to Author */
		/* 							*/

		tfAuthor.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfAuthor.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(
							("(?i)" + text), 1));
				}
				table.repaint();
				
				int rowCount = table.getRowCount();
				bookResults = new ArrayList<Book>();
				for (int i = 0; i < rowCount; i++)
				{
					Book b = new Book();
					b.setTitle((String)table.getValueAt(i, 0));
					b.setAuthor((String)table.getValueAt(i, 1));
					b.setYear((String)table.getValueAt(i, 2));
					b.setPublishing_house((String)table.getValueAt(i, 3));
					b.setIsbn((String)table.getValueAt(i, 4));
					bookResults.add(b);
				}
				System.out.println(bookResults);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfAuthor.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(
							("(?i)" + text), 1));
				}
				
				int rowCount = table.getRowCount();
				bookResults = new ArrayList<Book>();
				for (int i = 0; i < rowCount; i++)
				{
					Book b = new Book();
					b.setTitle((String)table.getValueAt(i, 0));
					b.setAuthor((String)table.getValueAt(i, 1));
					b.setYear((String)table.getValueAt(i, 2));
					b.setPublishing_house((String)table.getValueAt(i, 3));
					b.setIsbn((String)table.getValueAt(i, 4));
					bookResults.add(b);
				}
				System.out.println(bookResults);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// not needed: throw new
				// UnsupportedOperationException("Not supported yet.");
			}
		});

		/* 							*/
		/* 							*/
		/* Dynamic Search */
		/* According to Year */
		/* 							*/

		tfYear.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfYear.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(
							("(?i)" + text), 2));
				}
				table.repaint();
				
				int rowCount = table.getRowCount();
				bookResults = new ArrayList<Book>();
				for (int i = 0; i < rowCount; i++)
				{
					Book b = new Book();
					b.setTitle((String)table.getValueAt(i, 0));
					b.setAuthor((String)table.getValueAt(i, 1));
					b.setYear((String)table.getValueAt(i, 2));
					b.setPublishing_house((String)table.getValueAt(i, 3));
					b.setIsbn((String)table.getValueAt(i, 4));
					bookResults.add(b);
				}
				System.out.println(bookResults);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfYear.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(
							("(?i)" + text), 2));
				}
				
				int rowCount = table.getRowCount();
				bookResults = new ArrayList<Book>();
				for (int i = 0; i < rowCount; i++)
				{
					Book b = new Book();
					b.setTitle((String)table.getValueAt(i, 0));
					b.setAuthor((String)table.getValueAt(i, 1));
					b.setYear((String)table.getValueAt(i, 2));
					b.setPublishing_house((String)table.getValueAt(i, 3));
					b.setIsbn((String)table.getValueAt(i, 4));
					bookResults.add(b);
				}
				System.out.println(bookResults);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// not needed: throw new
				// UnsupportedOperationException("Not supported yet.");
			}
		});

		/* 							*/
		/* 							*/
		/* Dynamic Search */
		/* According to Publisher */
		/* 							*/

		tfPublisher.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfPublisher.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(
							("(?i)" + text), 3));
				}
				table.repaint();
				
				int rowCount = table.getRowCount();
				bookResults = new ArrayList<Book>();
				for (int i = 0; i < rowCount; i++)
				{
					Book b = new Book();
					b.setTitle((String)table.getValueAt(i, 0));
					b.setAuthor((String)table.getValueAt(i, 1));
					b.setYear((String)table.getValueAt(i, 2));
					b.setPublishing_house((String)table.getValueAt(i, 3));
					b.setIsbn((String)table.getValueAt(i, 4));
					bookResults.add(b);
				}
				System.out.println(bookResults);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfPublisher.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(
							("(?i)" + text), 3));
				}

				int rowCount = table.getRowCount();
				bookResults = new ArrayList<Book>();
				for (int i = 0; i < rowCount; i++)
				{
					Book b = new Book();
					b.setTitle((String)table.getValueAt(i, 0));
					b.setAuthor((String)table.getValueAt(i, 1));
					b.setYear((String)table.getValueAt(i, 2));
					b.setPublishing_house((String)table.getValueAt(i, 3));
					b.setIsbn((String)table.getValueAt(i, 4));
					bookResults.add(b);
				}
				System.out.println(bookResults);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// not needed: throw new
				// UnsupportedOperationException("Not supported yet.");
			}
		});

		/* 							*/
		/* 							*/
		/* Dynamic Search */
		/* According to ISBN */
		/* 							*/

		tfISBN.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfISBN.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(
							("(?i)" + text), 4));
				}
				table.repaint();
				
				int rowCount = table.getRowCount();
				bookResults = new ArrayList<Book>();
				for (int i = 0; i < rowCount; i++)
				{
					Book b = new Book();
					b.setTitle((String)table.getValueAt(i, 0));
					b.setAuthor((String)table.getValueAt(i, 1));
					b.setYear((String)table.getValueAt(i, 2));
					b.setPublishing_house((String)table.getValueAt(i, 3));
					b.setIsbn((String)table.getValueAt(i, 4));
					bookResults.add(b);
				}
				System.out.println(bookResults);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfISBN.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(
							("(?i)" + text), 4));
				}
				
				int rowCount = table.getRowCount();
				bookResults = new ArrayList<Book>();
				for (int i = 0; i < rowCount; i++)
				{
					Book b = new Book();
					b.setTitle((String)table.getValueAt(i, 0));
					b.setAuthor((String)table.getValueAt(i, 1));
					b.setYear((String)table.getValueAt(i, 2));
					b.setPublishing_house((String)table.getValueAt(i, 3));
					b.setIsbn((String)table.getValueAt(i, 4));
					bookResults.add(b);
				}
				System.out.println(bookResults);
			}
		

			@Override
			public void changedUpdate(DocumentEvent e) {
				// not needed: throw new
				// UnsupportedOperationException("Not supported yet.");
			}
		});

		/* 									*/
		/* 									*/
		/* Search Result's Columns */
		/* 									*/
		/* 									*/

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

	}

}
