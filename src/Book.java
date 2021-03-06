
public class Book {

	private int bId;
	private String bName;
	private String author;
	private String genre;

	private boolean rental;
	
	
	public Book() {
		bId = 0;
		bName = "";
		author ="";
		genre = "";
		rental = false;
	}
	
	public Book(int bId, String bName, String author, String genre) {
		this.bId = bId;
		this.bName = bName;
		this.author = author;
		this.genre = genre;
		rental = false;
		
	}

	public int getId() {
		return bId;
	}

	public void setId(int bId) {
		this.bId = bId;
	}

	public String getName() {
		return bName;
	}

	public void setName(String bName) {
		this.bName = bName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public boolean isRental() {
		return rental;
	}

	public void setRental(boolean rental) {
		this.rental = rental;
	}
	
	
	
}
