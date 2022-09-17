package controller;

import java.util.List;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoImpl;
import dto.DVD;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class DVDLibraryController {
	
	private DVDLibraryView view = new DVDLibraryView();
    private UserIO io = new UserIOConsoleImpl();
	private DVDLibraryDao dao = new DVDLibraryDaoImpl();
	
	public void run() {
		
		boolean keepGoing = true;
		int menuSelection = 0;
		while(keepGoing) {
			menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                	createDVD();
                    break;
                case 2:
                	viewDVD();
                    break;
                case 3:
                	showDVDs();
                    break;
                case 4:
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
	}
	
	
	private void createDVD() {
		view.displayCreateDVDBanner();
		DVD currentDVD = view.getNewDVDInfo();
		dao.addDVD(currentDVD.getTitle(), currentDVD);
		view.displayCreateDVDSuccessBanner();
	}
	
	private void viewDVD() {
		view.displayDVDBanner();
		String dvdTitle = view.getDVDByTitle();
		DVD currentDVD = dao.getDVD(dvdTitle);
		view.displayDVD(currentDVD);
	}
	
	private void showDVDs() {
		view.displayAllDVDBanner();
		List<DVD> dvdList = dao.getAllDVDs();
		view.displayDVDList(dvdList);
	}
	
}
