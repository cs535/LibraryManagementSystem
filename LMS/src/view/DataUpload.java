package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import libraryManagementSystem.Library;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class DataUpload extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton openFileButton;
	private JButton uploadButton;
	private JFileChooser jFileChooser;
	private String uploadFilePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataUpload frame = new DataUpload();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataUpload() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Import Data Set");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lmsTitle = new JLabel("Library Management System");
		lmsTitle.setFont(new Font("Dialog", Font.BOLD, 40));
		lmsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lmsTitle.setBounds(22, 73, 681, 59);
		contentPane.add(lmsTitle);
		
		JLabel chooseData = new JLabel("Select data resource");
		chooseData.setFont(new Font("Dialog", Font.BOLD, 20));
		chooseData.setHorizontalAlignment(SwingConstants.CENTER);
		chooseData.setBounds(22, 173, 681, 59);
		contentPane.add(chooseData);
		
		textField = new JTextField();
		textField.setBounds(32, 255, 334, 44);
//		textField.setEditable(false);
//        JScrollPane panel = new JScrollPane(textField); //scroll çalışmıyor !!!!!!!!!!!!!
//		  panel.setBounds(32, 255, 334, 44);
//        panel.setPreferredSize(new Dimension(300, 100));
		contentPane.add(textField);
		textField.setColumns(10);
		
		openFileButton = new JButton("Open");
		openFileButton.addActionListener(this);
		openFileButton.setBounds(378, 255, 147, 44);
		contentPane.add(openFileButton);
		
		uploadButton = new JButton("Upload");
		uploadButton.addActionListener(this);
		uploadButton.setBounds(543, 255, 153, 44);
		contentPane.add(uploadButton);
		
	} 

    public void actionPerformed(ActionEvent e) {
         
        if(e.getSource() == openFileButton){
            jFileChooser = new JFileChooser();
            int returnVal = jFileChooser.showOpenDialog(DataUpload.this);
            if(returnVal == JFileChooser.APPROVE_OPTION){
            	uploadFilePath = jFileChooser.getSelectedFile().getParent() + "/" + jFileChooser.getSelectedFile().getName();
            	System.out.println(uploadFilePath);
                File selectedDataFile = jFileChooser.getSelectedFile();
                System.out.println(selectedDataFile.getName());
                textField.setText("Selected file: " + selectedDataFile.getName());
            }else if(returnVal == JFileChooser.CANCEL_OPTION){
            	textField.setText("Cancelled");
            }else if(returnVal == JFileChooser.ERROR_OPTION){
            	textField.setText("Error!");
            }else{
            	textField.setText("unknown...");
            }
        }
        
        if(e.getSource() == uploadButton){
        	System.out.println("upload button clicked");
        	try 
			{
        		if (uploadFilePath == null){
        			uploadFilePath = "BXBooks.csv";
        		}
				Library library = new Library(uploadFilePath);
				BookSearch frame = new BookSearch(library);
				frame.setVisible(true);
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
        }
    }
}
