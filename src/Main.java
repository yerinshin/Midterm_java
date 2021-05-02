public class Main {
	public static void main(String[] args) {
//		LibraryView menu = new LibraryView();
//		menu.process();
		
		BookUtil b = new BookUtil();
		UserUtil u = new UserUtil();
		
		u.SignUp();
//		u.SignUp();
//		u.SignUp();
//		u.writeFile();
//		
		u.SignIn();
		
//
		b.addBook();
		b.addBook();
//		b.addBook();
		b.writeFile();
		
		b.readFileAddList();
//		b.printAllBookList();
		
//		b.writeFile();
		for(int i=0; i<3;i++) {
			b.rentBook();
		}
		System.out.println("----");
		b.printRentedBook();
		System.out.println("====");
		b.printAllBookList();
		System.out.println("----");
		b.returnBook();
//		
//		System.out.println();
//		b.printBookList(); 
//		
//		b.deleteBook();
	}
}
