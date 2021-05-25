package board;

import java.util.*;

public class TreasureDeck {
//        public String name;
//        int id;
//        public Boolean drawn=false;	
//        
//       public String getName() {
//    	   return name;
//       }
//       public int getId() {
//    	   return id;
//       }
//       
//       public void setName(String name) {
//   		this.name=name;
//   	}
//       
//       public TreasureDeck() {
//    	
//       }
//       
//       public TreasureDeck(String name,int id) {
//    	   this.name=name;
//    	   this.id=id;
//       }
//       
       public Stack<String> init() {
    	   Stack<String> treasureName=new Stack<String>();
    	   treasureName.add("Stone");
    	   treasureName.add("Wind");
    	   treasureName.add("Fire");
    	   treasureName.add("Chalice");
    	   treasureName.add("Stone");
    	   treasureName.add("Wind");
    	   treasureName.add("Fire");
    	   treasureName.add("Chalice");
    	   treasureName.add("Stone");
    	   treasureName.add("Wind");
    	   treasureName.add("Fire");
    	   treasureName.add("Chalice");
    	   treasureName.add("Stone");
    	   treasureName.add("Wind");
    	   treasureName.add("Fire");
    	   treasureName.add("Chalice");
    	   treasureName.add("Stone");
    	   treasureName.add("Wind");
    	   treasureName.add("Fire");
    	   treasureName.add("Chalice");
    	  
    	   treasureName.add("Helicopter");
    	   treasureName.add("Helicopter");
    	   treasureName.add("Helicopter");
    	   
    	   treasureName.add("Sandbags");
    	   treasureName.add("Sandbags");
    	   
    	   treasureName.add("WaterRise");
    	   treasureName.add("WaterRise");
    	   treasureName.add("WaterRise");
    	   
    	   Collections.shuffle(treasureName);

    	   return treasureName;
       }
       
       
}


//class TreasureShuffle extends TreasureDeck{
//	
//	public  TreasureShuffle() {
//		
//	
//	
//	TreasureDeck treasureDeck = new TreasureDeck();
//	treasureDeck.Initial();
//	
//	}
//}

 
 