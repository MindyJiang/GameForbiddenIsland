package player;

public class Players {
	
	private String playerName;

	private int ID;
	private int x,y;
	private int actionStep;
	
	public String getName() {
		return playerName;
	}
	 
	public int getID() {
		return ID;
	}
	 
	
	public void setName(String playerName) {
		this.playerName=playerName;
	}
	 
	public void setID(int ID) {
		this.ID= ID;
	}
	
	 public void setLocation(int x, int y) {
			this.x=x;
			this.y=y;		
		} 
		
		public int[] getLocation() {
			int[] site=new int[2];
			site[0]=x;
			site[1]=y;
			return site;
		} 
	 
}



