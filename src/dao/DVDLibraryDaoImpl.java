package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.DVD;

public class DVDLibraryDaoImpl implements DVDLibraryDao {
	
	public static final String LIBRARY_FILE = "dvdlibrary.txt";
	public static final String DELIMITER = "::";
	private Map<String, DVD> dvds = new HashMap<>();
	
	@Override
	public void addDVD(String title, DVD dvd) {
		// TODO Auto-generated method stub
		dvds.put(title, dvd);
		
	}

	@Override
	public DVD removeDVD(String title) {
		// TODO Auto-generated method stub
		return dvds.remove(title);
	}

	@Override
	public List<DVD> getAllDVDs() {
		// TODO Auto-generated method stub
		return new ArrayList<DVD>(dvds.values());
	}

	@Override
	public DVD getDVD(String title) {
		// TODO Auto-generated method stub
		return dvds.get(title);
	}

}
