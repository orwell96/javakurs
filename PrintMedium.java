
public abstract class PrintMedium extends Medium {
	protected String title;
	protected String author;
	
	public PrintMedium(String t, String a){
		super();
		this.title = t;
		this.author = a;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
	
	@Override
	public String getDetail() {
		return super.getDetail()
				+ "Titel: " + this.title + "\n"
				+ "Author: " + this.author + "\n";
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getAuthor(){
		return this.author;
	}
}
