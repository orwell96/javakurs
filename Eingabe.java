import java.util.Scanner;


public class Eingabe {
	
	public static Scanner scanner;
	
	/**
	 * Fragt den Benutzer nach einer Zeichenkette, und gibt diese zurück
	 * @param query Text, der dem Benutzer als Eingabeaufforderung angezeigt wird
	 * @return die Nutzereingabe
	 */
	public static String liesString(String query){
		System.out.print(query + "#");
		return scanner.nextLine();
	}
	/**
	 * Fragt den Benutzer nach einer Ganzzahl (int), und gibt diese zurück
	 * Gibt der Benutzer keine Ganzzahl ein, wird die Eingabe wiederholt.
	 * @param query Text, der dem Benutzer als Eingabeaufforderung angezeigt wird
	 * @return die Nutzereingabe
	 */
	public static int liesInt(String query){
		String s = liesString(query);
		try{
			return Integer.parseInt(s);
		} catch(NumberFormatException e){
			System.out.println("Sie müssen eine ganze Zahl eingeben!");
			return liesInt(query);
		}
	}
	
	
	/**
	 * Erläuterung zum static-Block:
	 * Dies ist quasi der Konstruktorersatz für statische Methoden und Attribute einer Klasse.
	 * Die Eingabeklasse besitzt ein static-Attribut Eingabe.scanner, der dem Lesen der Nutzereingaben dient.
	 * Da von Eingabe nie Objekte erstellt werden, gibt es sonst keine Möglichkeit, diesen Scanner zu initialisieren*.
	 * 
	 * * das stimmt nicht ganz, gleichbedeutend könnte man auch oben public static Scanner scanner = new Scanner(...);
	 *   schreiben, aber so kann ich euch den Sinn eines static-Blocks zeigen.
	 */
	static{
		scanner = new Scanner(System.in);
	}
}
