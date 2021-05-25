package board;
import java.util.*;

public class BoardMap {
    private int i,j,k=0,t;
    private Tile islandTileIniti = new Tile();
	private Tile[][] tileMap=new Tile[6][6];
	static Tile nulltile=(Tile) new NullTile();
	
	ArrayList<Tile> tileArray=islandTileIniti.Initial();
	
	public HashMap<String, Tile> tiles = new HashMap<String,Tile>();
	
	public void initFloodStstus(String drawCardName) {
		for(t=0;t<24;t++)
		{if(tileArray.get(t).getName()==drawCardName)
		{tileArray.get(t).setStatus(1); }
	}
	}
	
	public HashMap<String, Tile> initialBoard() {
		Collections.shuffle(tileArray);
		tileMap[0][0]=nulltile;
		tileMap[0][1]=nulltile;
		tileMap[0][4]=nulltile;
		tileMap[0][5]=nulltile;
		tileMap[1][0]=nulltile;
		tileMap[1][5]=nulltile;
		tileMap[4][0]=nulltile;
		tileMap[4][5]=nulltile;
		tileMap[5][0]=nulltile;
		tileMap[5][1]=nulltile;
		tileMap[5][4]=nulltile;
		tileMap[5][5]=nulltile;
		
		for(i=0;i<=5;i++) {
			switch(i) {
			case 0:
			case 5:
			for(j=2;j<=3;j++) {
		             tileMap[i][j]=tileArray.get(k++); 
		             tileMap[i][j].setLocation(i,j);
		             tiles.put(tileMap[i][j].getName(), tileMap[i][j]);}
			break;
			
			case 1:
			case 4:
				for(j=1;j<=4;j++) {
					   tileMap[i][j]=tileArray.get(k++);
					   tileMap[i][j].setLocation(i,j);
					   tiles.put(tileMap[i][j].getName(), tileMap[i][j]);} 
				break;
				
			case 2:
			case 3:
				for(j=0;j<=5;j++) {
					   tileMap[i][j]=tileArray.get(k++);
					   tileMap[i][j].setLocation(i,j);
		  		   tiles.put(tileMap[i][j].getName(), tileMap[i][j]);} 
				break;
			}
		}
		
		
		
		return tiles;
		
		}	
	
	public int[] getTileLocation(String tileName, HashMap<String, Tile> tiles) {

		int[] location= new int[2];
		Tile tile = (Tile) tiles.get(tileName);
		location[0]=tile.getLocationX();
		location[1]=tile.getLocationY();
	
		return location;
		}
	
	public void printBoard() {
		System.out.println("Island Tiles distribution:\n"); 	
		for(i=0;i<6;i++) {
			for(j=0;j<6;j++) {tileMap[i][j].print(); }
	      System.out.print("\n");
	}
					
}
	
	public void printBoard(HashMap<String, Tile> tiles) {
		Tile[][] printTile=new Tile[6][6];
		printTile[0][0]=nulltile;
		printTile[0][1]=nulltile;
		printTile[0][4]=nulltile;
		printTile[0][5]=nulltile;
		printTile[1][0]=nulltile;
		printTile[1][5]=nulltile;
		printTile[4][0]=nulltile;
		printTile[4][5]=nulltile;
		printTile[5][0]=nulltile;
		printTile[5][1]=nulltile;
		printTile[5][4]=nulltile;
		printTile[5][5]=nulltile;
		int x,y;
		Set keySet = tiles.keySet();
		for(Object k: keySet) {
		x=tiles.get(k).getLocationX();
		y=tiles.get(k).getLocationY();
		printTile[x][y]=tiles.get(k);
		}		
				
		System.out.println("Island Tiles distribution:\n"); 	
		
		for(i=0;i<6;i++) {
			for(j=0;j<6;j++) {printTile[i][j].print();}
	        System.out.print("\n");
	}
	}
	
}

