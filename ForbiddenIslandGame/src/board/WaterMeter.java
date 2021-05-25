package board;

import java.util.Scanner;

public class WaterMeter {
	private int meterLevel;
	
	public int inputLevel() {
        System.out.println("Input the Water Meter level(between 1~5): ");
		Scanner userinput= new Scanner(System.in);
		meterLevel= userinput.nextInt();
		setLevel(meterLevel);
		showLevel();
		return meterLevel;

	}
	
	public int setLevel(int meterLevel){
		this.meterLevel=meterLevel;
		return meterLevel;
	}
	
	public int increaseLevel() {
		meterLevel++;
		return meterLevel;
	}
	
	public void showLevel() {
		System.out.println("currently WaterMeter level is "+ meterLevel);
	}
	
	public int getLevel() {
		return meterLevel;
	}
	
	
}
