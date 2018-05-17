import java.util.HashMap;
import java.util.Map;


public class Library {
	
	protected Medium [] books;
	protected int counter;
	
	protected Map<Integer,Copy> copies;
	
	/**
	 * Erstellt eine neue Bibliothek
	 * @param maximal Anzahl der Bücher, die diese Bibliothek maximal enthalten kann/darf
	 */
	public Library(int maximal){
		this.counter=0;
		this.books = new Medium[maximal];
		copies = new HashMap<Integer,Copy>();
	}
	
	/**
	 * Nehme ein neues Medium in die Bibliothek auf.
	 * @param m das aufzunehmende Medium
	 */
	public void addMedium(Medium m){
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
	public Medium getMedium(int id) {
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
		Medium b = getMedium(id);
		System.out.println(b.getDetail());
	}
	
	/**
	 * Füge ein Exemplar (Copy) in die Bibliothek ein
	 */
	public void addCopy(Copy c){
		if(copies.containsKey(c.getId())){
			throw new DuplicateIdException(c.getId());
		}
		int mediumId = c.getMedium().getId();
		if (mediumId == -1 || mediumId >= counter){
			throw new RuntimeException("Medium is not registered in the library");
		}else{
			if (!this.books[mediumId].equals(c.getMedium())){
				throw new RuntimeException("Medium is not registered in the library");
			}
		}
		copies.put(c.getId(), c);
	}
	
	/**
	 * Erhalte ein Exemplar anhand der gegebenen Exemplar-id
	 * @param id
	 */
	public Copy getCopy(int id){
		if (!copies.containsKey(id)){
			throw new IllegalIdException(id);
		}
		return copies.get(id);
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
