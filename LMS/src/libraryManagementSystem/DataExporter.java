package libraryManagementSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataExporter {
	private static String writeDataToFile(String fileName, String path, StringBuilder sb) {
		
		// formatted data file
		File fileForDataWriting = new File(path + fileName);
		FileWriter fw;
		BufferedWriter bw = null;
		try {
			
			if (!fileForDataWriting.exists()) {
				
				fileForDataWriting.createNewFile();
			}
			
			fw = new FileWriter(fileForDataWriting.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}finally{
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return fileName;
	}
}
