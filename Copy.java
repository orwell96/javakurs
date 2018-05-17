
public class Copy {
	
	private int id;
	private Medium medium;
	private String location;
	private CopyState state;
	
	public Copy(int id, Medium medium, String location){
		this.id = id;
		this.medium = medium;
		this.location = location;
		this.state = CopyState.AVAILABLE;
	}
	
	public int getId(){
		return id;
	}
	public Medium getMedium(){
		return medium;
	}
	public String getLocation(){
		return location;
	}
	@Override
	public String toString(){
		return "Copy "+id+" at "+location+": "+medium.toString();
	}
	
	public boolean isLoanable(){
		return this.state.loanable;
	}

}