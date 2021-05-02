public class Main {
	public static void main(String[] args) {
//		LibraryView menu = new LibraryView();
//		menu.process();
		
		BookUtil b = new BookUtil();
		UserUtil u = new UserUtil();
		
//		u.SignUp();
//		u.SignUp();
//		u.SignUp();
//		u.writeFile();
		
		u.SignIn();
		
		for(int i=0; i<3;i++) {
			b.addBook();
		}
		
		b.writeFile();
//		for(int i=0; i<3;i++) {
//			b.rentBook();
//		}
//		b.printRentedBook();
//		
//		b.returnBook();
//		
//		System.out.println();
//		b.printBookList(); 
//		
//		b.deleteBook();
	}
}
