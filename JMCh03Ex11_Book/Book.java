/**
 * TODO Book Class that keeps track of current Page and number of pages.
 *
 * @author TODO Gavin Wong
 * @version TODO 8/29/2018
 * @author Period: 5
 * @author Assignment: JMCh03Ex11_Book
 *
 * @author Sources: TODO list collaborators
 */
public class Book {
	// TODO implement data fields

	// TODO implement constructor

	// TODO implement methods
	private int numPages, currentPage;

	public Book(int totalPage) {
		numPages = totalPage;
		currentPage = 1;
	}

	public int getNumPages() {
		return numPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void nextPage() {
		if (currentPage < numPages) {
			currentPage++;
		}
	}
}
