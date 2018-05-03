
public class Book extends PrintMedium {
	
	protected String isbn;
	
	
	public Book(String title, String author, String isbn) {
		super(title, author);
		this.isbn = isbn;
	}
	
	
	public String getDetail() {
		return super.getDetail()
				+ "ISBN: " + this.isbn + "\n";
	}
	
}
