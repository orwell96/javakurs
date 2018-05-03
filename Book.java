
public class Book {
	
	protected String title;
	protected String author;
	protected String isbn;
	protected int id;
	
	// Bemerkung: Bitte den Standardwert für die ID -1 wählen!
	// -1 soll bedeuten, dass die ID noch nicht gesetzt wurde.
	// Sonst würde unser Unittest fälschlicherweise ein positives Ergebnis zurückgeben

	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		
		this.id = -1;
	}
	
	/**
	 * Setze die ID dieses Mediums. Dies soll aufgerufen werden, wenn das Medium
	 * in eine Bibliothek eingefügt wird.
	 * @param id die ID des Mediums
	 */
	public void setId(int id){
		this.id = id;
	}
	
	/**
	 * Erhalte die ID dieses Mediums
	 * @return die ID des Mediums
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * Gibt eine einzeilige Kurzbeschreibung des Mediums aus.
	 * Diese soll nur der Titel des Buchs sein.
	 */
	public String toString() {
		return this.title;
	}
	/**
	 * Gibt eine mehrzeilige Detailseite aus, die alle Informationen
	 * dieses Mediums enthalten sollte.
	 * Hinweis: für einen Zeilenumbruch verwendet man "\n".
	 */
	public String getDetail() {
		return "Author: " + this.author + "\n"
				+ "Title: " + this.title + "\n"
				+ "ISBN: " + this.isbn + "\n"
				+ "ID: " + this.id;
	}
	
}
