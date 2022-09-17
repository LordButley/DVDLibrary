package ui;

import dto.DVD;

public class DVDLibraryView {
	
	public DVD getNewStudentInfo() {
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
}
