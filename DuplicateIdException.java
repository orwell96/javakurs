
public class DuplicateIdException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateIdException(int id){
		super("Duplicate ID: "+id);
	}
}
