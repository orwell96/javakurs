
public class Journal extends Medium {
	
	
	protected String name;
	
	public Journal(String n){
		super();
		this.name = n;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
