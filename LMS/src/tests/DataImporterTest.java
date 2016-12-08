package tests;

import libraryManagementSystem.Book;
import libraryManagementSystem.DataImporter;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class DataImporterTest extends TestCase {
	
	public void testCreatingData(){
		
		ArrayList<Book> resultList = DataImporter.creatingData("Books3.csv");
		assertEquals(resultList.size(), 10);
		
		ArrayList<Book> resultList2 = DataImporter.creatingData("Books2.csv");
		assertEquals(resultList2.size(), 100);
		
		ArrayList<Book> resultList3 = DataImporter.creatingData("BXBooks.csv");
		assertEquals(resultList3.size(), 171294);
	}
}
