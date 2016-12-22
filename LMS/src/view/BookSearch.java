package view;

import libraryManagementSystem.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
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
	private JButton btnExport;
	BookDetail previousBookDetail = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library library = new Library("/home/songulab/workspace/Books3.csv");
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
	public BookSearch(final Library library) {

		this.library = library;

		setTitle("Book Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 981);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, 12, 964, 198);
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
		lblTitle.setBounds(280, 22, 84, 32);
		panel.add(lblTitle);

		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(400, 30, 198, 19);
		panel.add(tfTitle);

		/* 					*/
		/* 					*/
		/* Author Search */
		/* 					*/
		/* 					*/

		JLabel label = new JLabel("Author");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(280, 52, 84, 32);
		panel.add(label);

		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(400, 60, 198, 19);
		panel.add(tfAuthor);

		/* 					*/
		/* 					*/
		/* Year Search */
		/* 					*/
		/* 					*/

		JLabel label_1 = new JLabel("Year");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		label_1.setBounds(280, 85, 84, 32);
		panel.add(label_1);

		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(400, 93, 198, 19);
		panel.add(tfYear);

		/* 								*/
		/* 								*/
		/* Publishing House Search */
		/* 								*/
		/* 								*/

		JLabel label_2 = new JLabel("Publisher");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.BOLD, 16));
		label_2.setBounds(280, 118, 84, 32);
		panel.add(label_2);

		tfPublisher = new JTextField();
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(400, 126, 198, 19);
		panel.add(tfPublisher);

		/* 					*/
		/* 					*/
		/* ISBN Search */
		/* 					*/
		/* 					*/

		JLabel label_3 = new JLabel("ISBN");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.BOLD, 16));
		label_3.setBounds(280, 154, 84, 32);
		panel.add(label_3);

		tfISBN = new JTextField();
		tfISBN.setColumns(10);
		tfISBN.setBounds(400, 162, 198, 19);
		panel.add(tfISBN);

		/* 							*/
		/* 							*/
		/* Search Results Label */
		/* 							*/
		/* 							*/

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(12, 222, 964, 660);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblSearchResults = new JLabel("Search Results");
		lblSearchResults.setBounds(30, 0, 900, 33);
		lblSearchResults.setBackground(Color.BLACK);
		lblSearchResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchResults.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(lblSearchResults);

		String[][] datas = new String[library.getSize()][6];
		for (int i = 0; i < library.getSize(); i++) {
			datas[i][0] = library.getBookList().get(i).getTitle();
			datas[i][1] = library.getBookList().get(i).getAuthor();
			datas[i][2] = library.getBookList().get(i).getYear();
			datas[i][3] = library.getBookList().get(i).getPublishing_house();
			datas[i][4] = library.getBookList().get(i).getIsbn();
			datas[i][5] = library.getBookList().get(i).getImage();
		}
		String[] columnName = { "Title", "Author", "Year", "Publisher", "ISBN", "Image URL" };

		tableSearchResults = new DefaultTableModel(datas, columnName) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};

		//panel_1.add(scrollPaneToTableSearchResults);
		rowSorter = new TableRowSorter<>(tableSearchResults);

		/* 							*/
		/* 							*/
		/* Dynamic Search */
		/* According to Title */
		/* 							*/
		
		bookResults = new ArrayList<Book>(library.getBookList());

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
					bookCreation(i);
				}
				////system.out.println(bookResults);
			}

			private void bookCreation(int i) {

				Book b = library.getBookByID((String)table.getValueAt(i, 4)); 
				bookResults.add(b); 
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
					bookCreation(i);
				}
				////system.out.println(bookResults);
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
					bookCreation(i);
				}
				////system.out.println(bookResults);
			}

			private void bookCreation(int i) {

				Book b = library.getBookByID((String)table.getValueAt(i, 4)); 
				bookResults.add(b); 
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
					bookCreation(i);
				}
				////system.out.println(bookResults);
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
					bookCreation(i);
				}
				////system.out.println(bookResults);
			}

			private void bookCreation(int i) {

				Book b = library.getBookByID((String)table.getValueAt(i, 4)); 
				bookResults.add(b); 
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
					bookCreation(i);
				}
				////system.out.println(bookResults);
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
					bookCreation(i);
				}
				////system.out.println(bookResults);
			}

			private void bookCreation(int i) {

				Book b = library.getBookByID((String)table.getValueAt(i, 4)); 
				bookResults.add(b); 
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
					bookCreation(i);
				}
				////system.out.println(bookResults);
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
					bookCreation(i);
				}
				//system.out.println(bookResults);
			}

			private void bookCreation(int i) {

				Book b = library.getBookByID((String)table.getValueAt(i, 4)); 
				bookResults.add(b); 
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
					bookCreation(i);
				}
				////system.out.println(bookResults);
			}
		

			@Override
			public void changedUpdate(DocumentEvent e) {
				// not needed: throw new
				// UnsupportedOperationException("Not supported yet.");
			}
		});
		
		
		MouseListener mouseListenerEvents = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) { // double click detection
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					BookDetail bookDetail = new BookDetail(bookResults.get(row), library);
					if (previousBookDetail != null)
					{ 
						previousBookDetail.setVisible(false); //you can't see me!
						previousBookDetail.dispose(); //Destroy the JFrame object;
						previousBookDetail = null;
						previousBookDetail = bookDetail;
					}
					else
					{
						previousBookDetail = bookDetail;
					}
					
					bookDetail.setVisible(true);
				}
			}
		};
		table = new JTable(new DefaultTableModel(datas, columnName));
		table.setBackground(Color.WHITE);
		table.setBounds(12, 48, 631, 600);
		

		
		JScrollPane scrollPaneToTableSearchResults = new JScrollPane(table);
		scrollPaneToTableSearchResults.setBounds(0, 33, 964, 627);
		panel_1.add(scrollPaneToTableSearchResults);
		scrollPaneToTableSearchResults.setVisible(true);
		table.setRowSorter(rowSorter);
		
		
		/*
		 * @ export search results into the project path
		 * @ example: /home/songulab/git/CS535-LibraryManagementSystem/LMS/export.txt
		 * */
		btnExport = new JButton("Export");
        btnExport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser saveFile = new JFileChooser();
                saveFile.showSaveDialog(null);
                String exportPath = saveFile.getSelectedFile().getParent() + "/";
                String exportFileName = saveFile.getSelectedFile().getName();
                DataExporter exportData = new DataExporter();
                exportData.writeDataToFile(exportFileName, exportPath,bookResults);
            }
        });
		btnExport.setBounds(520, 894, 456, 48);
		btnExport.setToolTipText("Export Search Results");
		contentPane.add(btnExport);
		
				table.addMouseListener(mouseListenerEvents);

	}
}
