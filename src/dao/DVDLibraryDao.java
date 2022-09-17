package dao;

import java.util.List;

import dto.DVD;

public interface DVDLibraryDao {

	void addDVD(String title);
		
	DVD removeDVD(String title);
	
	List<DVD> getAllDVDs();
	
	DVD getDVD(String title);
}
