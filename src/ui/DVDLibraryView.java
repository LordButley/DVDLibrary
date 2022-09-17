package ui;

import dto.DVD;

public class DVDLibraryView {
	
    private UserIO io = new UserIOConsoleImpl();
	
	public DVD getNewDVDInfo() {
	    String title = io.readString("Please enter DVD Title");
	    String releaseDate = io.readString("Please enter release date in the format yyyy-MM-dd");
	    String mpaaRating = io.readString("Please enter MPAA Rating");
	    String director = io.readString("Please enter the director's name");
	    String studio = io.readString("Please enter the studio's name");
	    String note = io.readString("Please enter any additional information");

	    DVD currentDVD = new DVD(title);
	    currentDVD.setReleaseDate(releaseDate);
	    currentDVD.setRating(mpaaRating);
	    currentDVD.setDirector(director);
	    currentDVD.setStudio(studio);
	    currentDVD.setNote(note);
	    return currentDVD;
	}
	
	public void displayCreateDVDBanner() {
	    io.print("=== Create DVD entry ===");
	}
	
	public void displayCreateDVDSuccessBanner() {
	    io.readString(
	            "DVD entry successfully created.  Please hit enter to continue");
	}
	
	public void displayDVDBanner() {
	    io.print("=== Display DVD ===");
	}
	
	public String getDVDByTitle() {
		return io.readString("Please enter the DVD Title.");
	}
	
	public void displayDVD(DVD dvd) {
		if(dvd != null) {
			io.print(dvd.getTitle());
			io.print(dvd.getReleaseDate());
			io.print(dvd.getRating());
			io.print(dvd.getDirector());
			io.print(dvd.getStudio());
			io.print(dvd.getNote());
			io.print("");
		}else {
			io.print("DVD not in library");
		}
		io.readString("Please hit enter to continue");
	}
	
	public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD to library");
        io.print("2. View DVD");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.");
    }
	
	
}
