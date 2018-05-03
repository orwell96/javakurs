
public class Library {
	
	protected Book [] books;
	protected int counter;
	
	/**
	 * Erstellt eine neue Bibliothek
	 * @param maximal Anzahl der Bücher, die diese Bibliothek maximal enthalten kann/darf
	 */
	public Library(int maximal){
		this.counter=0;
		this.books = new Book[maximal];
	}
	
	/**
	 * Nehme ein neues Medium in die Bibliothek auf.
	 * @param m das aufzunehmende Medium
	 */
	public void addMedium(Book m){
		if (m==null){
			throw new IllegalArgumentException("m is null");
		}
		if (counter >= books.length){
			throw new RuntimeException("Zu viele Buecher!");
		}
		m.setId(counter);
		books[counter] = m;
		counter++;
	}
	
	/**
	 * Gibt alle bisher in der Bibliothek aufgenommenen Medien auf der Kommandozeile aus (system.out).
	 */
	public void listMedia(){
		for(int i = 0; i < counter; i++){
			System.out.println(i+": "+books[i]);
		}
	}
	
	/**
	 * Erhalte ein Buch-Objekt mit der gegebenen ID
	 * @param id die ID des betreffenden Mediums
	 * @return das betreffende Medium
	 */
	public Book getMedium(int id) {
		if(id < 0 || id >= counter){
			throw new IllegalIdException(id);
		}
		return books[id];
	}
	
	/**
	 * Gebe eine Detailansicht für ein Medium auf der Kommandozeile aus
	 * @param id die ID des betreffenden Mediums
	 */
	public void showDetail(int id) {
		Book b = getMedium(id);
		System.out.println(b.getDetail());
	}
	
	
	/**
	 * Hauptmethode. Keine Kommandozeilenargumente
	 */
	public static void main(String[] args) {
		Library bib = new Library(30);
		
		while(true){
			try{
				int action = Eingabe.liesInt("Was möchten Sie tun? 1:Medien auflisten, 2:Detail anzeigen, 3:neues Buch hinzu, 0: beenden");
				switch(action){
				case 1:{
					bib.listMedia();
				break;}
				case 2:{
					int id = Eingabe.liesInt("Welche ID?");
					bib.showDetail(id);
				break;}
				case 3:{
					String titel = Eingabe.liesString("Titel?");
					String autor = Eingabe.liesString("Autor?");
					String isbn = Eingabe.liesString("ISBN?");
					
					Book b = new Book(titel, autor, isbn);
					bib.addMedium(b);
					
				break;}
				case 0:{
					System.exit(0);
				break;}
				}
			}catch(Exception e){
				System.out.println("Es ist ein Fehler aufgetreten: " + e);
			}
		}
	}
}
