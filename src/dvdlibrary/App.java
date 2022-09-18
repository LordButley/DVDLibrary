package dvdlibrary;

import controller.DVDLibraryController;
import dao.DVDLibraryDao;
import dao.DVDLibraryDaoImpl;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class App {

	public static void main(String[] args) {
		UserIO io = new UserIOConsoleImpl();
		DVDLibraryView view = new DVDLibraryView(io);
		DVDLibraryDao dao = new DVDLibraryDaoImpl();
		DVDLibraryController controller = new DVDLibraryController(dao, view);
		controller.run();
	}
}
