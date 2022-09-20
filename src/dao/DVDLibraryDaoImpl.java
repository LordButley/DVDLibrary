package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dto.DVD;

public class DVDLibraryDaoImpl implements DVDLibraryDao {
	
	public static final String LIBRARY_FILE = "dvdlibrary.txt";
	public static final String DELIMITER = "::";
	private Map<String, DVD> dvds = new HashMap<>();
	
	@Override
	public void addDVD(String title, DVD dvd) throws DVDLibraryDaoException{
		// TODO Auto-generated method stub
		loadLibrary();
		dvds.put(title, dvd);
		writeLibrary();
		
	}

	@Override
	public DVD removeDVD(String title) throws DVDLibraryDaoException {
		// TODO Auto-generated method stub
		loadLibrary();
		DVD removedDVD = dvds.remove(title);
		writeLibrary();
		return removedDVD;
	}

	@Override
	public List<DVD> getAllDVDs() throws DVDLibraryDaoException{
		// TODO Auto-generated method stub
		loadLibrary();
		return new ArrayList<DVD>(dvds.values());
	}

	@Override
	public DVD getDVD(String title) throws DVDLibraryDaoException{
		// TODO Auto-generated method stub
		loadLibrary();
		return dvds.get(title);
	}
	
	@Override
	public void editDVDInformation(DVD dvd, int editChoice, String newValue) throws DVDLibraryDaoException{
		// TODO Auto-generated method stub
		switch (editChoice) {
			case 1:
				dvd.setTitle(newValue);
				break;
			case 2:
				dvd.setReleaseDate(newValue);
				break;
			case 3:
				dvd.setRating(newValue);
				break;
			case 4:
				dvd.setDirector(newValue);
				break;
			case 5:
				dvd.setStudio(newValue);
			case 6:
				dvd.setNote(newValue);
				break;
		}
		dvds.put(dvd.getTitle(), dvd);
		writeLibrary();		
	}

	
	
	private DVD unmarshallDVD(String dvdAsText){

	    String[] dvdTokens = dvdAsText.split(DELIMITER);

	    String title = dvdTokens[0];

	    DVD dvdFromFile = new DVD(title);

	    dvdFromFile.setReleaseDate(dvdTokens[1]);
	    dvdFromFile.setRating(dvdTokens[2]);
	    dvdFromFile.setDirector(dvdTokens[3]);
	    dvdFromFile.setStudio(dvdTokens[4]);
	    dvdFromFile.setNote(dvdTokens[5]);


	    // We have now created a student! Return it!
	    return dvdFromFile;
	}
	
	private void loadLibrary() throws DVDLibraryDaoException {
	    Scanner scanner;

	    try {
	        // Create Scanner for reading the file
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(LIBRARY_FILE)));
	    } catch (FileNotFoundException e) {
	        throw new DVDLibraryDaoException(
	                "-_- Could not load DVD data into memory.", e);
	    }
	    String currentLine;
	    DVD currentDVD;

	    while (scanner.hasNextLine()) {
	        currentLine = scanner.nextLine();
	        currentDVD = unmarshallDVD(currentLine);
	        dvds.put(currentDVD.getTitle(), currentDVD);
	    }
	    // close scanner
	    scanner.close();
	}
	
	private String marshallDVD(DVD dvdToFile) {
		
		String dvdAsText = dvdToFile.getTitle() + DELIMITER;

		dvdAsText += dvdToFile.getReleaseDate() + DELIMITER;
		dvdAsText += dvdToFile.getRating() + DELIMITER;
		dvdAsText += dvdToFile.getDirector() + DELIMITER;
		dvdAsText += dvdToFile.getStudio() + DELIMITER;
		
		dvdAsText += dvdToFile.getNote();

	    return dvdAsText;
		
	}
	
	private void writeLibrary() throws DVDLibraryDaoException {
	 
	    PrintWriter out;

	    try {
	        out = new PrintWriter(new FileWriter(LIBRARY_FILE));
	    } catch (IOException e) {
	        throw new DVDLibraryDaoException(
	                "Could not save DVD data.", e);
	    }
	    
	    String dvdAsText;
	    List<DVD> dvdLibrary = this.getAllDVDs();
	    for (DVD currentDVD : dvdLibrary) {
	        dvdAsText = marshallDVD(currentDVD);
	        out.println(dvdAsText);
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}
}
