package player;

import java.util.*;
import java.util.Map.Entry;

import board.*;

public class PlayerControl {
	private String playerName;
	private String pawnTileName;
	private int actionStep=3;
	private int ID;
	static int x,y;
	public boolean WaterLevelRise=false;
	public HashMap<String, Tile> tileMap = new HashMap<String, Tile>();
	public ArrayList<String> playerTreasureCardHold= new ArrayList<>();
	public Stack<String> treasureDeck= new Stack<>();
	public ArrayList<String> playerTreasure = new ArrayList();
	public ArrayList<String> playerTreasureHold= new ArrayList<String>();
	public Tile tileUp= new Tile();
	public Tile tileDown= new Tile();
	public Tile tileLeft= new Tile();
	public Tile tileRight= new Tile();
	public Tile tilePawn= new Tile();
	
	
	
	public  PlayerControl(){}
	
	public  PlayerControl(String playerName,String pawnTileName,int x, int y, HashMap<String, Tile> tileMap){
		this.playerName=playerName;
		this.pawnTileName=pawnTileName;
		this.x=x;
		this.y=y;
		this.tileMap=tileMap;
	}
	
	public void takeAction(){

		while(actionStep>0) {
			actionStep--;
			giveOptions();
			Scanner actionID= new Scanner(System.in);
			ID= actionID.nextInt();
				switch(ID) {
				case 1:    move();          break;
				case 2:    shoreUp();          break;
				case 3:    passTreasure();     break;
                case 4:    captureTreasure();  break;
		     	case 5:    specialException(); break;
			    case 6:    actionStep=0;       break;
				}	
			}
	
       if(actionStep==0) {
    	   System.out.println(playerName+"'s actions are finihsed.");
    	   
		}
	}
	
	public void move() {
		
		neighborTile();
		
		System.out.println("where do you want to move?" );
		moveOptions();
		Scanner actionID= new Scanner(System.in);
		ID= actionID.nextInt();

		switch(ID) {
		case 1:   
			if (tileUp.getStatus()==0 || tileUp.getStatus()==3) 
			{ System.out.println("you cannot move here because it's flooded");}
			else {x=x-1;}   
		break;
	
		case 2:    
			if (tileDown.getStatus()==0 || tileDown.getStatus()==3) 
			{ System.out.println("you cannot move here because it's flooded");}
			else {x=x+1; }    
			break;
			
		case 3:   
			if (tileLeft.getStatus()==0 || tileLeft.getStatus()==3) 
			{ System.out.println("you cannot move here because it's flooded");}
			else {y=y-1;}   
			break;
			
			
        case 4:  
        	if (tileRight.getStatus()==0 || tileRight.getStatus()==3) 
			{ System.out.println("you cannot move here because it's flooded");}
			else {y=y+1;}  
            break;}
		
		if(x==7) {System.out.println("location out of limit!");x=x-1;}
		if(y==7) {System.out.println("location out of limit!");y=y-1;}
		else
		{
		System.out.println("Moved to Row="+x+",Column="+y+", you still have "+actionStep+" actions.");
		}
		
		Set keySet = tileMap.keySet();
		for(Object k: keySet) {
		if( (tileMap.get(k).getLocationX()==x) && (tileMap.get(k).getLocationY()==y))
		{ pawnTileName=tileMap.get(k).getName();}
		}
	
	}
	
	public void shoreUp() {
		neighborTile();
		System.out.println("where do you want to shore up?" );
		shoreUpOptions();
		Scanner actionID= new Scanner(System.in);
		ID= actionID.nextInt();
		Tile shoreUpTile = new Tile();
		switch(ID) {
		case 1:   shoreUpTile=tilePawn;   break;
		case 2:   shoreUpTile=tileUp;     break;
		case 3:   shoreUpTile=tileDown;   break;
		case 4:   shoreUpTile=tileLeft;   break;
		case 5:   shoreUpTile=tileRight;  break; }
		
		if (shoreUpTile.getStatus()==0) 
		{ System.out.println("Cannot shoreUp because it's moved");}
		if (shoreUpTile.getStatus()==2) 
		{ System.out.println("Don't need shoreup because it's not flooded");}
		
		else {shoreUpTile.setStatus(2);}  
		
		System.out.println("successfully shored up "+shoreUpTile.getName()+", you still have "+actionStep+" actions.");
	}
	
	public void passTreasure() {
		if (playerTreasure.size()==0) 
		System.out.println("No Treasures in your hand");
		System.out.println("you still have "+actionStep+" actions.");
	}
	
    public void captureTreasure() {
    	int i,j,k=0;
    	Collections.sort(playerTreasureHold);
    	for (i=0;i<=2;i++)
    		{k=0;
    		for (j=i+1;j<playerTreasureHold.size();j++)
    		{
    			if (playerTreasureHold.get(i)==playerTreasureHold.get(j))
    			k++;}
    		}
    	if (k>=4)
    	{System.out.println("Captured treasure, you still have "+actionStep+" actions.");
    	playerTreasureHold.remove(i); }
    	
    	if (k<4) System.out.println("No 4 matching Treasure cards in your hand! you still have "+actionStep+" actions.");
	}
    
    public void specialException() {
    	System.out.println("Used special exception, you still have "+actionStep+" actions.");		
    }
    
	private void giveOptions() {
		System.out.println("\n"+playerName+" your location is Row="+x+" Column="+y+", What do you want to do?");
		System.out.println("[1]    move");
		System.out.println("[2]    shore up");
		System.out.println("[3]    pass treasure");
		System.out.println("[4]    capture treasure");
		System.out.println("[5]    special exception");
		System.out.println("[6]    end action");
	}
	
	private void moveOptions() {
		System.out.println("[1]    up");
		System.out.println("[2]    down");
		System.out.println("[3]    left");
		System.out.println("[4]    right");
	}
	
	private void shoreUpOptions() {
		System.out.println("[1]    My location");
		System.out.println("[2]    up");
		System.out.println("[3]    down");
		System.out.println("[4]    left");
		System.out.println("[5]    right");
	}
	
	public void neighborTile() {
//		   tileUp.setNullTile();
//	       tileLeft.setNullTile();
//		   tileRight.setNullTile();
//		   tileDown.setNullTile();
		   
		   Set keySet = tileMap.keySet();
		   for(Object k: keySet) {
			   int X, Y;
			   Tile tile=new Tile();
			   X=tileMap.get(k).getLocationX();
			   Y=tileMap.get(k).getLocationY();
			   
			   if ( (x==X) && (y==Y)){tilePawn= tileMap.get(k);}   
			   if ( (x==X) && (y==Y+1)){ tileLeft= tileMap.get(k);} 
			   if ( (x==X) && (y==Y-1)){ tileRight=  tileMap.get(k);}  
			   if ( (x==X+1) && (y==Y)) {tileUp= tileMap.get(k);}  
			   if ( (x==X-1) && (y==Y)) {tileDown=tileMap.get(k);  }   
		   }
		   
	   }
   public Stack<String>  drawTreasure(ArrayList<String> playerTreasureCardHold,Stack<String> treasureDeck) {
	   this.treasureDeck=treasureDeck;
	   this.playerTreasureCardHold=playerTreasureCardHold;
	   int i;
	// if (treasureDeck.get(0)=="WaterRise")
	  for(i=0;i<2;i++) {
	   if(treasureDeck.empty())
		   {TreasureDeck treasures= new TreasureDeck(); 
		   treasureDeck=treasures.init();}
	   String treasureName =  treasureDeck.pop();
	   System.out.println("drew TreasureCard: "+treasureName);
	   if (treasureName!="WaterRise")
	        playerTreasureCardHold.add(treasureName);
	   if  (treasureName=="WaterRise")
		   WaterLevelRise=true;
	   }
	   int length=playerTreasureCardHold.size();
	   int k;
	   if (length>=6)
		   for (k=length;k>5;k--)
	   {   i=0;
		   System.out.println("Please choose one TreasureCard to discard: ");
		   for(i=0;i<playerTreasureCardHold.size();i++)
		   System.out.println((i)+"   "+playerTreasureCardHold.get(i));
		      
		   Scanner actionID= new Scanner(System.in);
			ID= actionID.nextInt();
			playerTreasureCardHold.remove(ID);
	   }
	    System.out.println("your hold TreasureCards are: " +playerTreasureCardHold.toString());
  
	    
	    return treasureDeck;
   }
   
   public HashMap<String,Tile> drawFloodCard(Stack<String> floodDeck, int waterLevel, HashMap<String, Tile> tileMap) {
	   FloodCard floodCard= new FloodCard(); 
	   Stack floodDiscrad=floodCard.drawCard(waterLevel,floodDeck);
	   Tile tile = new Tile();
	   int currentStatus, status;
	   BoardMap boardSet= new BoardMap();
		while(floodDiscrad.isEmpty()==false)
	    {String drawCardName=(String) floodDiscrad.pop();
	    tile=tileMap.get(drawCardName);
	    currentStatus=tile.getStatus();
	    status= tile.floodedMoved(currentStatus);
	    tileMap.get(drawCardName).setStatus(status); 
	    }
	    return tileMap;
	   	
		}
	
   public String getPawnTile() {
	return pawnTileName;
   }
	
   public ArrayList<String> getPlayerTreasureCrads(){
	   return playerTreasureCardHold;
   }

   public boolean getWaterLevelRise() {
	   return WaterLevelRise;
   }
   
}

  