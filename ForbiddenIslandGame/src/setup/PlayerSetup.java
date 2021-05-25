package setup;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerSetup {
    int input,i=0,roleID;
    ArrayList<String> playerRole = new ArrayList();
    
    ArrayList<String> Role = new ArrayList();
    
	public PlayerSetup() {
		Role.add(0, "Engineer");
		Role.add(1, "Diver");
		Role.add(2, "Explorer");
		Role.add(3, "Messenger");
		Role.add(4, "Pilot");
		Role.add(5, "Navigator");
		
		Scanner userInput= new Scanner(System.in);
		System.out.println("How many people are playing? (between 2 and 4):");
		input= userInput.nextInt();
	//	if (input<2 || input>4) System.out.println("please input right number:");
		
			for(i=0;i<input;i++)
			{   
				System.out.println("choose role for Player "+(i+1)+":");
				roleOptions();
				Scanner roleInput= new Scanner(System.in);
				roleID= roleInput.nextInt();
				roleID--;
			    playerRole.add(i, Role.get(roleID));
			    System.out.println("Player "+(i+1)+" role is "+playerRole.get(i));
			    Role.remove(roleID);
			    
			}
	}
	
	private void roleOptions() {
		int j=0;
		while (j<Role.size())
		{System.out.println((j+1)+"    "+Role.get(j));
		j++;}
	}

	public ArrayList<String> playerList() {
		int k;
		int l=playerRole.size();
		ArrayList<String> List=new ArrayList<String>();
		for(k=0;k<l;k++) {
			String temp=playerRole.get(k);
			List.add(temp);
		}
		return List;
	}
}
