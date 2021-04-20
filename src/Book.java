
public class Book {

	private int id;
	private String name;
	private String author;
	private boolean rental;
	
	public boolean equals(int id) {
		if(this.id == id)
			return true;
		else
			return false;
	}
	
	public Book() {
		id = 0;
		name = " ";
		author =" ";
		rental = false;
	}
	
	public Book(int id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
		rental = false;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
