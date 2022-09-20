package dao;

import java.util.List;

import dto.DVD;

public interface DVDLibraryDao {

	void addDVD(String title, DVD dvd) throws DVDLibraryDaoException;
		
	DVD removeDVD(String title) throws DVDLibraryDaoException;
	
	List<DVD> getAllDVDs() throws DVDLibraryDaoException;
	
	DVD getDVD(String title) throws DVDLibraryDaoException;

	void editDVDInformation(DVD dvd, int editChoice, String newValue) throws DVDLibraryDaoException;

}
