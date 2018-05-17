
public enum CopyState {
	AVAILABLE(true),
	LOANED(false),
	PRESENCE(false),
	BROKEN(false);
	
	public boolean loanable;
	private CopyState(boolean loanable){
		this.loanable = loanable;
	}
}