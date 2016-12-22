package view;

import libraryManagementSystem.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class BookDetail extends JFrame {

	private JPanel contentPane;
	
	private Book book;
	private Library library;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library library = new Library("/home/songulab/workspace/Books3.csv");
					Book book = new Book(); 
					BookDetail frame = new BookDetail(book, library);
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
	public BookDetail(Book book, Library library) {
		this.book = book;
		this.library = library;
		
		setTitle("Book Detail");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image image = null;
		String path = "http://images.amazon.com/images/P/0449906736.01.THUMBZZZ.jpg";
		
		if (this.book.getImage() != null)
		{
			path = this.book.getImage();
		}
		
        try {
            URL url = new URL(path);
            image = ImageIO.read(url);
        } catch (IOException e) {
        	System.out.println("hataaaa \n");
        	e.printStackTrace();
        }
        



        JLabel image_label = new JLabel(new ImageIcon(image));

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(image_label, BorderLayout.CENTER);
		panel.setBounds(12, 12, 125, 160);
		contentPane.add(panel);
		
		JLabel recommendedBookTitle = new JLabel("Recommended Book");
		recommendedBookTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		recommendedBookTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		recommendedBookTitle.setBounds(230, 363, 250, 32);
		contentPane.add(recommendedBookTitle);
		
		JPanel recommendedBook1 = new JPanel();
		recommendedBook1.setBackground(Color.LIGHT_GRAY);	//when book images placed this color will be removed
		recommendedBook1.setBounds(15, 400, 125, 160);
		contentPane.add(recommendedBook1);
		
		JPanel recommendedBook2 = new JPanel();
		recommendedBook2.setBackground(Color.LIGHT_GRAY);	//when book images placed this color will be removed
		recommendedBook2.setBounds(155, 400, 125, 160);
		contentPane.add(recommendedBook2);
		
		JPanel recommendedBook3 = new JPanel();
		recommendedBook3.setBackground(Color.LIGHT_GRAY);	//when book images placed this color will be removed
		recommendedBook3.setBounds(295, 400, 125, 160);
		contentPane.add(recommendedBook3);

		JPanel recommendedBook4 = new JPanel();
		recommendedBook4.setBackground(Color.LIGHT_GRAY);	//when book images placed this color will be removed
		recommendedBook4.setBounds(435, 400, 125, 160);
		contentPane.add(recommendedBook4);

		JPanel recommendedBook5 = new JPanel();
		recommendedBook5.setBackground(Color.LIGHT_GRAY);	//when book images placed this color will be removed
		recommendedBook5.setBounds(575, 400, 125, 160);
		contentPane.add(recommendedBook5);
		
		JLabel lblNewLabel = new JLabel(this.book.getTitle());
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 12, 473, 169);
		contentPane.add(lblNewLabel);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAuthor.setBounds(12, 226, 176, 32);
		contentPane.add(lblAuthor);
		
		JLabel lblNameOfThe = new JLabel(this.book.getAuthor());
		lblNameOfThe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNameOfThe.setBounds(232, 226, 429, 32);
		contentPane.add(lblNameOfThe);
		
		JLabel label = new JLabel(this.book.getYear());
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(232, 259, 429, 32);
		contentPane.add(label);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setFont(new Font("Dialog", Font.BOLD, 20));
		lblYear.setBounds(12, 259, 176, 32);
		contentPane.add(lblYear);
		
		JLabel lblPublisher_1 = new JLabel(this.book.getPublishing_house());
		lblPublisher_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPublisher_1.setBounds(232, 292, 429, 32);
		contentPane.add(lblPublisher_1);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPublisher.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPublisher.setBounds(12, 292, 176, 32);
		contentPane.add(lblPublisher);
		
		JLabel label_4 = new JLabel(this.book.getIsbn());
		label_4.setFont(new Font("Dialog", Font.BOLD, 16));
		label_4.setBounds(232, 328, 429, 32);
		contentPane.add(label_4);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setFont(new Font("Dialog", Font.BOLD, 20));
		lblIsbn.setBounds(12, 328, 176, 32);
		contentPane.add(lblIsbn);
		
		
		ArrayList<Book> recommendedBookList = library.getRecommendedBooksFor(book);
		
		
		for (Book tempBook : recommendedBookList)
		{
			System.out.println(tempBook.getTitle());
		}
		
		
		
		
		
		
	}
}
