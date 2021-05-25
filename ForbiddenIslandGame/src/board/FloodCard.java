package board;

import java.util.*;


public class FloodCard {
	public Boolean drawn=false;
	public Boolean discardFlag=false;
	public String temp;
	
	
	static int i,j=24;
	static Tile tileArray= new Tile();
	ArrayList<Tile> floodcardSet =tileArray.Initial();
	
	public Stack<String> floodDeck =new Stack<String>();//define "floodDeck" to store Flood cards
	Stack<String> discardDeck =new Stack<String>();
	
	public Stack<String> FloodCardIniti() {
		
		  Collections.shuffle(floodcardSet);
		  
		  for(i=0;i<24;i++)
			{ temp=floodcardSet.get(i).getName();
			  floodDeck.push(temp);
			}
		  return floodDeck;
	}
	
	
	public Stack<String> drawCard(int drawnNumber, Stack<String> floodDeck) {
		System.out.println("you had drawn flood Cards:");
		while (drawnNumber>0)
		{ if(floodDeck.empty())
		     { System.out.println("Flood Deck runs out, shuffle cards is done!");
		       floodDeck=FloodCardIniti();
		       }
		
		   	String b1=(String) floodDeck.pop(); 
		    discardDeck.add(b1);
		    System.out.println(b1);
		 drawnNumber--;
		 
		}
		return discardDeck;
	}
	
	public Stack<String> floodDeck(){
		return floodDeck;
	}
	
}
