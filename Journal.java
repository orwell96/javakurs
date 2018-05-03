
public class Journal extends Medium {
	
	protected String name;
	protected String edition;
	
	public Journal(String n, String e){
		super();
		this.name = n;
		this.edition = e;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
