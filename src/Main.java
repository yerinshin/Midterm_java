public class Main {
	public static void main(String[] args) {
//		LibraryView menu = new LibraryView();
//		menu.process();
		
		BookList b = new BookList();
		for(int i=0; i<3;i++) {
			b.addBook();
		}
		for(int i=0; i<3;i++) {
			b.rentBook();
		}
		b.printRentedBook();
		
		b.returnBook();
		
		System.out.println();
		b.printBookList(); 
		
		b.deleteBook();
	}
}
