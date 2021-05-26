package board;
import java.util.*;
import java.util.Map.Entry;
public class Tile {
	public String name;
	public int status=2;//0:removed;1:flooded;2:unflooded(deafult is unflooded); 3:non tile
//	public Boolean ifFlood;
	public int id,x,y;
	
	public  Tile(String name, int id) {
		this.name=name;
		this.id=id;
	}
	
	public  Tile(String name,int x, int y) {
		this.name=name;
		this.x=x;
		this.y=y;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
		
	public int getID() {
		return id;
	}

	public void setLocation(int x, int y) {
		this.x=x;
		this.y=y;		
	} 
	
	public int getLocationX() {
		return x;
	} 
	public int getLocationY() {
		return y;
	} 
	
	public int floodedMoved(int currentStatus) {
		if (currentStatus==2)  
		status=1;
		if (currentStatus==1)
		status=0;
		return status;
	}	
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status= status;	
	}
	
	public void print() {
		if (status==2) {System.out.print(name);}
		
		if (status==1)
		{String newName=name.substring(0, 8)+  "*******|";
		System.out.print(newName);}
		if (status==0)
		{System.out.print("|**************|");}
		if (status==3)
		{System.out.print("|              |");}
		
	}
     public ArrayList<Tile> Initial() {  //initial 24 Island Tiles
 		ArrayList<String> tileName=new ArrayList<String>();//use tiles to store tile's name
 		tileName.add(0,  "| Copper Gate  |");
 		tileName.add(1,  "|  Iron Gate   |");
 		tileName.add(2,  "|  Bronz Gate  |");
 		tileName.add(3,  "| Silver Gate  |");
 		tileName.add(4,  "|   Gold Gate  |");
 		tileName.add(5,  "|Fool's Landing|");
 		tileName.add(6,  "| Temple of Sun|");
 		tileName.add(7,  "|Temple of Moon|");
 		tileName.add(8,  "| Tidal Palace |");
 		tileName.add(9,  "| Coral Palace |");
 		tileName.add(10, "|Whisper Garden|");
 		tileName.add(11, "|Howling Garden|");
 		tileName.add(12, "|Cave of Embers|");
 		tileName.add(13, "|Cave of Shadow|");
 		tileName.add(14, "| Watch Tower  |"); 
 		tileName.add(15, "| observatory  |");
 		tileName.add(16, "| Break Bridge |");
 		tileName.add(17, "|TwilightHollow|");
 		tileName.add(18, "|Crimson Forest|");
 		tileName.add(19, "| Phantom Rock |");
 		tileName.add(20, "|DunesDeception|");
 		tileName.add(21, "| Lost Lagoon  |");
 		tileName.add(22, "|Cliffs Abandon|");
 		tileName.add(23, "| Misty Marsh  |");
 		
 			ArrayList<Tile> tiles= new ArrayList<Tile>();
 			int i;
 			for(i=0;i<=23;i++) {
 				//new 24 island tiles and put them into tiles List
 				Tile tileElement= new Tile(tileName.get(i),i);
 				tiles.add(i, tileElement);
 			}
 			return tiles;
 	 } 	
     public  Tile() {
     }
     
     public void setNullTile()   {
    			name="|              |";
    		    status=3;
    			 	 
     }

}

class NullTile extends Tile  {
	 public  NullTile() {
			this.name="|              |";
		    this.status=3;
		}	 	 
 }
