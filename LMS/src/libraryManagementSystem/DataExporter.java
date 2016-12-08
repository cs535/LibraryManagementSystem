package libraryManagementSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataExporter 
{
	
	/**
	 * @param fileName
	 * @param path
	 * @param resultBookList
	 * @return fileName
	 */
	public static String writeDataToFile(String fileName, String path, ArrayList<Book> resultBookList) 
	{
		// formatted data file
		File fileForDataWriting = new File(path + fileName);
		FileWriter fw;
		BufferedWriter bw = null;
		try 
		{
			
			if (!fileForDataWriting.exists()) 
			{
				fileForDataWriting.createNewFile();
			}
			
			fw = new FileWriter(fileForDataWriting.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(resultBookList.toString());
			
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		finally
		{
			try 
			{
				bw.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return fileName;
	}
}
