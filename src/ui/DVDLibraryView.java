package ui;

public class DVDLibraryView {
	
	public Student getNewStudentInfo() {
	    String title = io.readString("Please enter DVD Title");
	    String releaseDate = io.readString("Please enter release date in the format yyyy-MM-dd");
	    String mpaaRating = io.readString("Please enter MPAA Rating");
	    String director = io.readString("Please enter the director's name");
	    String studio = io.readString("Please enter the studio's name");
	    String note = io.readString("Please enter any additional information");

	    DVD currentDVD = new DVD(title);
	    currentStudent.setFirstName(firstName);
	    currentStudent.setLastName(lastName);
	    currentStudent.setCohort(cohort);
	    return currentStudent;
	}
}
