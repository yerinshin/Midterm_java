import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BookUtil implements BookInterface{

	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Book> rentedBook = new ArrayList<Book>();
	private ArrayList<Book> allBookList = new ArrayList<Book>();

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public ArrayList<Book> getRentedBook() {
		return rentedBook;
	}

	public void setRentedBook(ArrayList<Book> rentedBook) {
		this.rentedBook = rentedBook;
	}

	public ArrayList<Book> getAllBookList() {
		return allBookList;
	}

	public void setAllBookList(ArrayList<Book> allBookList) {
		this.allBookList = allBookList;
	}

	public void addBook() {
		FileReader fr;

		try {
			Book b = new Book();
			fr = new FileReader("iodata\\booklist.txt");
			br = new BufferedReader(fr);

			String line = "";

			int id = 0;
			boolean registered;

			do {
				registered = false;
				System.out.print("책 id입력 : ");
				id = sc.nextInt();
				sc.nextLine();

				while ((line = br.readLine()) != null) {
					String strId = Integer.toString(id);
					String[] temp = line.split(",");

					if (strId.equals(temp[0])) {
						System.out.println("이미 등록된 아이디입니다. 사용되지 않은 id를 입력해 주세요.");
						registered = true;

					}

				}

			} while (registered == true);


			System.out.print("책 이름 입력 : ");
			String name = sc.nextLine();

			System.out.print("저자 입력 : ");
			String author = sc.nextLine();

			System.out.print("장르 입력 : ");
			String genre = sc.nextLine();

			b.setId(id);
			b.setName(name);
			b.setAuthor(author);
			b.setGenre(genre);
			bookList.add(b);

			System.out
					.println("id :" + id + ", 도서명 :" + name + ", 지은이 :" + author + ", 장르 :" + genre + " 인 도서가 등록 되었습니다.");
			writeFile();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteBook() {
		FileWriter fw;
		readFileAddList();
		System.out.println("<< 현재 전체 책 목록 >>");
		
		printBookList(allBookList);

		System.out.println();
		System.out.print("삭제할 책의 id를 입력해 주세요 : ");
		
		int id = sc.nextInt();
		for (int i = 0; i < allBookList.size(); i++) {
			if (id == allBookList.get(i).getId()) {
				allBookList.remove(i);
			}
		}

		try {
			
			fw = new FileWriter("iodata\\booklist.txt"); // true =>파일이 있을경우 이어쓰기

			for (int i = 0; i < allBookList.size(); i++) {
				fw.write(allBookList.get(i).getId() + "," + allBookList.get(i).getName() + "," + allBookList.get(i).getAuthor()
						+ "," + allBookList.get(i).getGenre() + "\r\n");
			}

			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("삭제되었습니다.");
		System.out.println();
		System.out.println("<< 삭제 후 전체 책 목록 >>");
		printBookList(allBookList);

	}

	public void rentBook() {


		System.out.print("대여할 책의 이름을 입력하세요 : ");
		String name = sc.nextLine(); // 빌리고 싶은 책이름
		System.out.println();

		boolean registered = false;

		for (int i = 0; i < allBookList.size(); i++) {

			if (name.equals(allBookList.get(i).getName())) {
				registered = true;

				if (allBookList.get(i).isRental()) {
					System.out.println("이미 대여 중입니다.");
				} else {
					System.out.println("도서명 : " + allBookList.get(i).getName() + "이 정상적으로 대여되었습니다.");
					
					allBookList.get(i).setRental(true);
					rentedBook.add(allBookList.get(i));


				}

			}
		}
		if (!registered) {
			System.out.println("등록된 책이 아닙니다.");
		}

	}

	public void returnBook() {
		System.out.println("반납할 책 id를 입력하세요.");
		int id = sc.nextInt();

		for (int i = 0; i < allBookList.size(); i++) {
			Book storedBook = allBookList.get(i);
			if (id == storedBook.getId()) {
				if (storedBook.isRental()) {
					System.out.println(storedBook.getName() + "이 정상적으로 반납되었습니다.");
					storedBook.setRental(false);

					for (int j = 0; j < rentedBook.size(); j++) {
						if (id == rentedBook.get(j).getId()) {
							rentedBook.remove(j);
						}

					}
				} else {
					System.out.println("대여중인 책이 아닙니다.");
				}
			}
		}
		System.out.println("[현재 대출한 책 목록]");
		printBookList(rentedBook);
	}


	
	public void printBookList(ArrayList<Book> bookList) {
		
		System.out.println("도서id\t도서명\t지은이 \t장르");
		for (Book b : bookList) {
			System.out.println(b.getId() + "\t" + b.getName() + "\t" + b.getAuthor() + "\t" + b.getGenre());
		}
	}
	
	public void printCanRent() {
		
		System.out.println("도서id\t도서명\t지은이 \t장르");
		for (Book b : allBookList) {
			if(!(b.isRental())) {
			System.out.println(b.getId() + "\t" + b.getName() + "\t" + b.getAuthor() + "\t" + b.getGenre());
			}
		}
	}


	public void writeFile() {

		FileWriter fw;

		try {
			fw = new FileWriter("iodata\\booklist.txt", true);

			for (int i = 0; i < bookList.size(); i++) {
				fw.write(bookList.get(i).getId() + "," + bookList.get(i).getName() + "," + bookList.get(i).getAuthor()
						+ "," + bookList.get(i).getGenre()+"\r\n");
			}

			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		//System.out.println("iodata/userlist.txt 에 저장완료");
	}

	public void readFileAddList() {
		allBookList.clear();

		FileReader fr;

		try {
			fr = new FileReader("iodata\\booklist.txt");
			br = new BufferedReader(fr);

			String line = "";
			while ((line = br.readLine()) != null) {
				String[] tempArr = line.split(",");
				
				allBookList.add(new Book(Integer.parseInt(tempArr[0]), tempArr[1], tempArr[2], tempArr[3]));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
