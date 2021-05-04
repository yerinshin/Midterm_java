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
			System.out.print("1.관리자로그인\t 2.사용자로그인\t 3.회원가입\t 4.종료====>");
			int num = sc.nextInt();
			System.out.println();

			switch (num) {
			case 1:
				System.out.println("관리자 로그인 페이지입니다.");
				user.SignIn();
				if ((user.getLoginedId().equals("admin"))) {
					System.out.println("<<관리자계정으로 로그인되었습니다.>>");
					adminMenu();
				} else {
					System.out.println("등록된 관리자가 아닙니다.");
				}
				break;
			case 2:
				System.out.println("사용자 로그인 페이지입니다.");
				user.SignIn();
				if (user.getLoginedId() == "") {
					break;
				} else {
					System.out.println("[ " + user.getLoginedId() + "1 ] 님 로그인 되었습니다.");
					userMenu();
				}
				break;
			case 3:
				user.SignUp();
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
			System.out.println();
			System.out.println("메뉴를 선택하세요.");
			System.out.print("1. 도서등록\t 2.도서삭제 3. 종료=====> ");
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
				System.out.println("종료되었습니다.");
				bool = false;
			}
		}
	}

	public void userMenu() {
		boolean bool = true;

		System.out.println(" --------------------- << 일반 사용자 메뉴 >> ---------------------");
		while (bool) {
			System.out.println("메뉴를 선택하세요.");
			System.out.print("1. 도서대출\t 2.도서반납\t 3.도서검색\t 4.종료=====> ");
			int num = sc.nextInt();

			switch (num) {
			case 1:
				System.out.println("----------------- << 도서 대출 >> ------------------");
				book.rentBook();
				book.printRentedBook();
				break;
			case 2:
				System.out.println("----------------- << 도서 반납 >> ------------------ ");
				book.returnBook();
				book.printRentedBook();
				break;
			case 3:
				System.out.println("----------------- << 도서 검색 >> ------------------");
				book.printAllBookList();
				break;
			case 4:
				System.out.println("종료되었습니다.");
				bool = false;
			}
		}

	}

}
