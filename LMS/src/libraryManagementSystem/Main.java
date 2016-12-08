package libraryManagementSystem;

import java.awt.EventQueue;
import view.*;

public class Main {
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Library library = new Library();
					BookSearch frame = new BookSearch(library);
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

}
