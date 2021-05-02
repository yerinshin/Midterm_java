import java.util.Scanner;

public class LibraryView {
	Scanner sc = new Scanner(System.in);
	
	public void process() {
		
		System.out.println("-------<< 도서 관리 프로그램 >>-------");
		
		System.out.println("로그인이 필요합니다.");
		System.out.print("1.로그인 \t 2.회원가입 ====>");
		int num = sc.nextInt();
		System.out.println("로그인 페이지입니다.");
		
		//if login 성공하면?
		loginSuccess();
		
		
	}
	
	public void loginSuccess(){
		//login
		
		boolean bool = true;
		BookUtil booklist = new BookUtil();
		
		while(bool) {
			System.out.println("메뉴를 선택하세요.");
			System.out.print("1.도서 추가\t 2.도서대출 \t 3.도서 검색 \t 4.도서 삭제 ====> ");
			int num2 = sc.nextInt();
		switch(num2) {
			case 1:
				System.out.println("도서 추가 페이지 입니다.");
				booklist.addBook();
				booklist.printBookList();
			case 2:
				System.out.println("도서 대출 페이지 입니다.");
				break;
			case 3:
				System.out.println("도서 검색 페이지 입니다.");
				break;
			case 4:
				System.out.println("도서 삭제 페이지 입니다.");
				booklist.deleteBook();
			default :
				System.out.println("종료되었습니다.");
				bool = false;
		}
	}
	}
	
	
}
