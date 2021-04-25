import java.util.ArrayList;
import java.util.Scanner;

public class BookList {

	Scanner sc = new Scanner(System.in);
	ArrayList<Book> bookList = new ArrayList<Book>();
	ArrayList<Book> rentedBook = new ArrayList<Book>();
	
	
	public void addBook(){
		System.out.println("id입력");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("책 이름 입력 : ");
		String name = sc.nextLine();
		
		System.out.println("저자 입력 : ");
		String author = sc.nextLine();
		
		Book b = new Book();
		
		b.setId(id);
		b.setName(name);
		b.setAuthor(author);
		
		bookList.add(b);
		
		System.out.println("id : " + id + "도서명 : " +name + "지은이 : " + author+ "인 도서가 등록 되었습니다.");
	}
	
	public void deleteBook() {
		System.out.println("삭제할 책의 id를 입력해 주세요.");
		int id = sc.nextInt();
		for(int i=0; i < bookList.size(); i++) {
			if(id == bookList.get(i).getId()) {
				bookList.remove(i);
			}
		}
		System.out.println("삭제되었습니다.");
		printBookList();
		
	}
	
	public void rentBook() {
		System.out.println("대여할 책의 이름을 입력하세요.");
		String name = sc.nextLine(); //빌리고 싶은 책이름
		
		//존재하지 않는 책 표시
		
		for(int i=0; i<bookList.size(); i++) {
			Book storedBook = bookList.get(i); //존재하는 책
	//		String bookName = bookList.get(i).getName(); //bookList index(i)에 저장되어있는 책이름
			
			if(name.equals(storedBook.getName())){
				if(storedBook.isRental()) {
					System.out.println("이미 대여 중입니다.");
				}else {
					System.out.println("도서명 : " + storedBook.getName() + "이 정상적으로 대여되었습니다.");
					storedBook.setRental(true);
					rentedBook.add(storedBook);
					//user 대여 목록에 넣는 코드 짜기
					
				}
			
			}
		}
	}
	
	public void returnBook() {
		System.out.println("반납할 책 id를 입력하세요.");
		int id = sc.nextInt();
	
		for(int i=0;i<bookList.size(); i++) {
			Book storedBook = bookList.get(i);
			if(id == storedBook.getId()) {
				if(storedBook.isRental()) {
					System.out.println(storedBook.getName()+"이 정상적으로 반납되었습니다.");
					storedBook.setRental(false);
					
					for(int j=0; j < rentedBook.size(); j++) {
						if(id == rentedBook.get(j).getId()) {
							rentedBook.remove(j);	
						}
						
					}
				}else {
					System.out.println("대여중인 책이 아닙니다.");
				}
			}
		}
		printRentedBook();
	}
	
	public void printRentedBook() {	//빌려진 책 목록
		System.out.println("현재 빌려진 책 목록");
		for(Book bo : rentedBook) {
			System.out.println(bo.getId() +"  "+ bo.getName() +"  "+ bo.getAuthor());
		}
	}
	
	
	
	
	
	
	public void printBookList() { //도서관이 소유 모든 책(빌린 책 포함)
		for(Book bo : bookList) {
			System.out.println(bo.getId() +"  "+ bo.getName() +"  "+ bo.getAuthor());
		}
	}
	
}
