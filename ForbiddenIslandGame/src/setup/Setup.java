package setup;

import java.util.*;
import board.*;

public class Setup {

	public PlayerSetup playerInit;
	public int waterLevel;
	public Stack<String> floodDeck;
	public BoardMap boardSet;
	public ArrayList<String> playerParticipant;
	public Stack<String> treasureCard;
	
	public HashMap<String, Tile> tileInfo = new HashMap<String,Tile>();
	
	public Setup() {
		
	System.out.println("Welcome to ForbiddenIsland Game!");
	//initialize player 
	PlayerSetup playerInit= new PlayerSetup();
    playerParticipant=playerInit.playerList();
	
	//initialize waterMeter card 
	WaterMeter waterMeter = new WaterMeter();
	waterMeter.inputLevel();
	waterLevel= waterMeter.getLevel();
	System.out.println("\n");
	
	
	//initialize floodCards
	FloodCard floodCard= new FloodCard();
	floodDeck=floodCard.FloodCardIniti();
	Stack floodDiscrad=floodCard.drawCard(6,floodDeck);
	
	//initialize treasureCard
	TreasureDeck treasureDeck= new TreasureDeck();
	treasureCard=treasureDeck.init();
	
	//initialize Board
	BoardMap boardSet= new BoardMap();
	while(floodDiscrad.isEmpty()==false)
    {String drawCardName=(String) floodDiscrad.pop();
    boardSet.initFloodStstus(drawCardName);   
    }
	
	tileInfo=boardSet.initialBoard();
   	boardSet.printBoard();

	}
	
	public ArrayList<String> players() {
		return playerParticipant;
	}
	
	
}
