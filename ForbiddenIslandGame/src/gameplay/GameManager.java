package gameplay;

import java.util.*;

import board.*;
import player.*;
import setup.*;

public class GameManager {
	public boolean gameOver=false;
	public Setup set =new Setup();
	public String pawn[]= new String[4];  
	public void game( ) {
		HashMap playerLocation= new HashMap();
		playerLocation.put("Engineer", "|  Bronz Gate  |");
		playerLocation.put("Diver", "|  Iron Gate   |");
		playerLocation.put("Explorer", "| Copper Gate  |");
		playerLocation.put("Messenger", "| Silver Gate  |");
		playerLocation.put("Pilot", "|Fool's Landing|");
		playerLocation.put("Navigator", "|   Gold Gate  |");
	
		HashMap<String, Tile> tileMap= new HashMap<String, Tile>();
		tileMap= set.tileInfo;
		Stack<String> treasureDeck = new Stack<>();
		treasureDeck=set.treasureCard;	
	
		HashMap<String, ArrayList> treasureCardHold=new HashMap<>();
		
		Stack<String> floodDeck= new Stack<String>();
		floodDeck= set.floodDeck;
		int waterLevel= set.waterLevel; 
		BoardMap board= new BoardMap();
    	ArrayList<String> player;
    	ArrayList<String> treasures= new ArrayList<>();
    	  player= set.playerParticipant;
	        int i;

	        for (i=0;i<player.size();i++)
			{   
				String temp = (String) playerLocation.get(player.get(i));
			    pawn[i] =temp;
			    treasureCardHold.put((String) player.get(i), treasures);
			}
	        
	        while(gameOver==false) {
			for (i=0;i<player.size();i++)
			{   
			String name = (String) player.get(i);
			
   		    int location[];
   		    location=board.getTileLocation(pawn[i], tileMap);
   	
		
		  PlayerControl p1= new PlayerControl(name,pawn[i],location[0],location[1],tileMap);
			
		      //3 action:
		      p1.takeAction();	
			  pawn[i]=p1.getPawnTile();
            
			  //draw 2 treasure cards:
			  treasureDeck= p1.drawTreasure(treasureCardHold.get(name),treasureDeck);
			  treasureCardHold.put(name, p1.getPlayerTreasureCrads() ) ;
	          if (p1.WaterLevelRise==true)
	          {waterLevel=waterLevel+1;
	          System.out.println("Water level rise to " + waterLevel);
	          }
			  
	          //draw 3 flood cards
			  tileMap=p1.drawFloodCard(floodDeck,waterLevel,tileMap);
			  board.printBoard(tileMap);
			}
	        }
    }
}
