
public class Book {

	private int bId;
	private String bName;
	private String author;
	private boolean rental;
	
	public boolean equals(int bId) {
		if(this.bId == bId)
			return true;
		else
			return false;
	}
	
	public Book() {
		bId = 0;
		bName = " ";
		author =" ";
		rental = false;
	}
	
	public Book(int bId, String bName, String author) {
		this.bId = bId;
		this.bName = bName;
		this.author = author;
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

	public boolean isRental() {
		return rental;
	}

	public void setRental(boolean rental) {
		this.rental = rental;
	}
	
	
	
}
