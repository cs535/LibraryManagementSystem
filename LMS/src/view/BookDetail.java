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
					Library library = new Library("Books3.csv");
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
		String path = "http://hdimagesnew.com/wp-content/uploads/2016/09/image-not-found-i19.png";
		
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
		
		JLabel recommendedBookTitle = new JLabel("Recommended Books");
		recommendedBookTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		recommendedBookTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		recommendedBookTitle.setBounds(230, 363, 250, 32);
		contentPane.add(recommendedBookTitle);
		
		

		





		
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
		System.out.println(recommendedBookList.size() + "  asdasdasdasd");
		
		/* Recommended Book 1*/
		
		Image recommendedBookImage1 = null;
		String path1 = "http://hdimagesnew.com/wp-content/uploads/2016/09/image-not-found-i19.png";
		
		if ((recommendedBookList.size() > 0) && (recommendedBookList.get(0).getImage() != null))
		{
			path1 = recommendedBookList.get(0).getImage();
		}
		
        try {
            URL url = new URL(path1);
            recommendedBookImage1 = ImageIO.read(url);
        } catch (IOException e) {
        	System.out.println("hataaaa \n");
        	e.printStackTrace();
        }
        



        JLabel recommendedBookLabel1 = new JLabel(new ImageIcon(recommendedBookImage1));
		
		JPanel recommendedBook1 = new JPanel();
		recommendedBook1.add(recommendedBookLabel1, BorderLayout.CENTER);
		recommendedBook1.setBounds(15, 400, 125, 160);
		contentPane.add(recommendedBook1);
		
		/* Recommended Book 2*/
		
		Image recommendedBookImage2 = null;
		String path2 = "http://hdimagesnew.com/wp-content/uploads/2016/09/image-not-found-i19.png";
		
		if ((recommendedBookList.size() > 1) && (recommendedBookList.get(1).getImage() != null))
		{
			path2 = recommendedBookList.get(1).getImage();
		}
		
        try {
            URL url = new URL(path2);
            recommendedBookImage2 = ImageIO.read(url);
        } catch (IOException e) {
        	System.out.println("hataaaa \n");
        	e.printStackTrace();
        }
        



        JLabel recommendedBookLabel2 = new JLabel(new ImageIcon(recommendedBookImage2));
		
		JPanel recommendedBook2 = new JPanel();
		recommendedBook2.add(recommendedBookLabel2, BorderLayout.CENTER);
		recommendedBook2.setBounds(155, 400, 125, 160);
		contentPane.add(recommendedBook2);
		
		/* Recommended Book 3*/
		
		Image recommendedBookImage3 = null;
		String path3 = "http://hdimagesnew.com/wp-content/uploads/2016/09/image-not-found-i19.png";
		
		if ((recommendedBookList.size() > 2) && (recommendedBookList.get(2).getImage() != null))
		{
			path3 = recommendedBookList.get(2).getImage();
		}
		
        try {
            URL url = new URL(path3);
            recommendedBookImage3 = ImageIO.read(url);
        } catch (IOException e) {
        	System.out.println("hataaaa \n");
        	e.printStackTrace();
        }
        
        JLabel recommendedBookLabel3 = new JLabel(new ImageIcon(recommendedBookImage3));

		JPanel recommendedBook3 = new JPanel();
		recommendedBook3.add(recommendedBookLabel3, BorderLayout.CENTER);
		recommendedBook3.setBounds(295, 400, 125, 160);
		contentPane.add(recommendedBook3);



		
		/* Recommended Book 4*/
		
		Image recommendedBookImage4 = null;
		String path4 = "http://hdimagesnew.com/wp-content/uploads/2016/09/image-not-found-i19.png";
		
		if ((recommendedBookList.size() > 3) && (recommendedBookList.get(3).getImage() != null))
		{
			path4 = recommendedBookList.get(3).getImage();
		}
		
        try {
            URL url = new URL(path4);
            recommendedBookImage4 = ImageIO.read(url);
        } catch (IOException e) {
        	System.out.println("hataaaa \n");
        	e.printStackTrace();
        }
        
        JLabel recommendedBookLabel4 = new JLabel(new ImageIcon(recommendedBookImage4));
		
		
		JPanel recommendedBook4 = new JPanel();
		recommendedBook4.add(recommendedBookLabel4, BorderLayout.CENTER);
		recommendedBook4.setBounds(435, 400, 125, 160);
		contentPane.add(recommendedBook4);
		
		/* Recommended Book 5*/
		
		Image recommendedBookImage5 = null;
		String path5 = "http://hdimagesnew.com/wp-content/uploads/2016/09/image-not-found-i19.png";
		
		if ((recommendedBookList.size() > 4) && (recommendedBookList.get(4).getImage() != null))
		{
			path5 = recommendedBookList.get(4).getImage();
		}
		
        try {
            URL url = new URL(path5);
            recommendedBookImage5 = ImageIO.read(url);
        } catch (IOException e) {
        	System.out.println("hataaaa \n");
        	e.printStackTrace();
        }
        
        JLabel recommendedBookLabel5 = new JLabel(new ImageIcon(recommendedBookImage5));
        
		JPanel recommendedBook5 = new JPanel();
		recommendedBook5.add(recommendedBookLabel5, BorderLayout.CENTER);
		recommendedBook5.setBounds(575, 400, 125, 160);
		contentPane.add(recommendedBook5);
		
		for (Book tempBook : recommendedBookList)
		{
			System.out.println(tempBook.getTitle());
		}
		
		
		
		
		
		
	}
}
