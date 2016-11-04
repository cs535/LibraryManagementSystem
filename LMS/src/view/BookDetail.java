package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BookDetail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookDetail frame = new BookDetail();
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
	public BookDetail() {
		setTitle("Book Detail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, 12, 176, 169);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Book Title");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 12, 473, 169);
		contentPane.add(lblNewLabel);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAuthor.setBounds(12, 226, 176, 32);
		contentPane.add(lblAuthor);
		
		JLabel lblNameOfThe = new JLabel("Name of the author");
		lblNameOfThe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNameOfThe.setBounds(232, 226, 429, 32);
		contentPane.add(lblNameOfThe);
		
		JLabel label = new JLabel("2016");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(232, 259, 429, 32);
		contentPane.add(label);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setFont(new Font("Dialog", Font.BOLD, 20));
		lblYear.setBounds(12, 259, 176, 32);
		contentPane.add(lblYear);
		
		JLabel lblPublisher_1 = new JLabel("Publisher");
		lblPublisher_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPublisher_1.setBounds(232, 292, 429, 32);
		contentPane.add(lblPublisher_1);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPublisher.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPublisher.setBounds(12, 292, 176, 32);
		contentPane.add(lblPublisher);
		
		JLabel label_4 = new JLabel("978-3-16-148410-0");
		label_4.setFont(new Font("Dialog", Font.BOLD, 16));
		label_4.setBounds(232, 328, 429, 32);
		contentPane.add(label_4);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setFont(new Font("Dialog", Font.BOLD, 20));
		lblIsbn.setBounds(12, 328, 176, 32);
		contentPane.add(lblIsbn);
	}
}
