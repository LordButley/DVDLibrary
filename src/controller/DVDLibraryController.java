package controller;

import java.util.List;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoException;
import dto.DVD;
import ui.DVDLibraryView;


public class DVDLibraryController {
	
	private DVDLibraryView view;
	private DVDLibraryDao dao;
	
	public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
		this.dao = dao;
		this.view = view;
	}
	
	public void run() {
		
		boolean keepGoing = true;
		int menuSelection = 0;
		try {
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
	                	removeDVD();
	                	break;
	                case 5:
	                	editDVD();
	                	break;
	                case 6:
	                	keepGoing = false;
	                    break;
	                default:
	                    view.displayExitBanner();
	            }
	
	        }
	        exitMessage();
		}catch(DVDLibraryDaoException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}
	
	private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
	
	private void createDVD() throws DVDLibraryDaoException {
		view.displayCreateDVDBanner();
		DVD currentDVD = view.getNewDVDInfo();
		dao.addDVD(currentDVD.getTitle(), currentDVD);
		view.displayCreateDVDSuccessBanner();
	}
	
	private void viewDVD() throws DVDLibraryDaoException {
		view.displayDVDBanner();
		String dvdTitle = view.getDVDByTitle();
		DVD currentDVD = dao.getDVD(dvdTitle);
		view.displayDVD(currentDVD);
	}
	
	private void showDVDs() throws DVDLibraryDaoException {
		view.displayAllDVDBanner();
		List<DVD> dvdList = dao.getAllDVDs();
		view.displayDVDList(dvdList);
	}
	
	private void removeDVD() throws DVDLibraryDaoException {
		view.displayRemoveDVDBanner();
		String dvdTitle =view.getDVDByTitle();
		DVD removedDVD = dao.removeDVD(dvdTitle);
		view.displayRemoveResult(removedDVD);
	}
	
	private void editDVD() throws DVDLibraryDaoException {
		view.displayEditDVDBanner();
		String dvdTitle = view.getDVDByTitle();
		DVD currentDVD = dao.getDVD(dvdTitle);
		int editChoice = view.printDVDAndGetSelection(currentDVD);
		String newValue = view.inputNewValue();
		dao.editDVDInformation(currentDVD, editChoice, newValue);
		view.displayEditDVDSuccessBanner();
		
	}

	private void exitMessage() {
	    view.displayExitBanner();
	}
}
