import java.util.Scanner;

public class LibraryView {
	Scanner sc = new Scanner(System.in);
	UserUtil user = new UserUtil();
	BookUtil book = new BookUtil();

	public void process() {

		System.out.println("-------<< 도서 관리 프로그램 >>-------");

		System.out.println("로그인이 필요합니다.");

		boolean bool = true;

		while (bool) {
			System.out.println();
			System.out.print("1.관리자로그인\t 2.사용자로그인\t 3.회원가입\t 4.종료 ==>");
			int num = sc.nextInt();
			System.out.println();

			switch (num) {
			case 1:
				System.out.println("관리자 로그인 페이지입니다.");
				user.signIn();
				if ((user.getLoginedId().equals("admin"))) {
					System.out.println("[ " + user.getLoginedId() + " ] 관리자  계정으로  로그인 되었습니다.");
					adminMenu();
				} else {
					System.out.println("등록된 관리자가 아닙니다.");
				}
				break;
			case 2:
				System.out.println("사용자 로그인 페이지입니다.");
				user.signIn();
				if (user.getLoginedId() == "") {
					break;
				} else {
					System.out.println("[ " + user.getLoginedId() + " ] 님 로그인 되었습니다.");
					userMenu();
				}
				break;
			case 3:
				user.signUp();
				break;
			case 4:
				System.out.println("종료되었습니다.");
				bool = false;
			}
		}

	}

	public void adminMenu() {

		System.out.println(" --------------------- << 관리자 메뉴 >> ---------------------");
		boolean bool = true;
		while (bool) {
			System.out.println("메뉴를 선택하세요.");
			System.out.print("1. 도서등록\t 2.도서삭제 \t 3.전체 도서 조회\t 4.종료  ==> ");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("----------------- << 도서를 등록하세요 >> ------------------");
				book.addBook();
				break;
			case 2:
				System.out.println("----------------- << 삭제할 도서를 입력하세요 >> ------------- ");
				book.deleteBook();
				break;
			case 3:
				System.out.println("----------------- << 전체 도서 목록 >> ------------- ");
				book.readFileAddList();
				book.printBookList(book.getAllBookList());
				break;
			case 4:
				System.out.println("종료되었습니다.");
				bool = false;
			}
		}
	}

	public void userMenu() {
		boolean bool = true;

		System.out.println(" --------------------- << 일반 사용자 메뉴 >> ---------------------");
		book.readFileAddList();
		while (bool) {
			System.out.println("메뉴를 선택하세요.");
			System.out.print("1. 도서대출\t 2.도서반납\t 3.도서검색\t 4.종료 ==> ");
			int num = sc.nextInt();
	
			switch (num) {
			case 1:
				System.out.println("----------------- << 도서 대출 >> ------------------");
				book.rentBook();
				book.printBookList(book.getRentedBook());
				break;
			case 2:
				System.out.println("----------------- << 도서 반납 >> ------------------ ");
				book.returnBook();
//				book.printBookList(book.getRentedBook());
				break;
			case 3:
				System.out.println("----------------- << 도서 검색 >> ------------------");
			
				System.out.println("1. 빌릴 수 있는 책 목록  \t 2.현재 내가 빌린 책 ==>");
				int select = sc.nextInt();
				if(select == 1) {
					System.out.println("<< 현재 대출 가능한 책 목록 >>");
					book.printCanRent();
				}else if(select ==2) {
					System.out.println();
					System.out.println("<< [ " + user.getLoginedId() + " ] 님 의 대출 목록  >>");
					book.printBookList(book.getRentedBook());
				}
				
				break;
			case 4:
				System.out.println("종료되었습니다.");
				bool = false;
			}
		}

	}

}
