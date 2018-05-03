
public class IllegalIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalIdException(int id){
		super("The ID "+id+" does not exist.");
	}
}
