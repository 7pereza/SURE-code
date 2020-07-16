/*
 * This is the main class that will help filter out the password
 * 
 * it can go to a text file and make a new file with passwords that are 10 or less 
 * (the train.py does this by default but it seem to take a longer time to do this )
 * 
 * this class will make three new file one file is just the 10 or less, the other two is the date set cut in half 
 * one to be use to give to the train.py to do a model and the other to do the comparing
 * 
 * after it is done running it should show the estimate number of password to generate 
 * from the 1.5x 2x ... 10x
 *  
 * */

import java.io.*;
import java.util.Scanner;



public class Main { 

	/*
	 * total =  will be used to see how many line of passwords 
	 * split = for right now will split in half
	 * */
	static int  total = 0, split1 = 0, split2;
	
		
	/* This is going into the give folder and split up the password filled with text file up */
	public static void writeGive(String currentName, int split, File fObj) {
		String newName = "g" + currentName; //should already include .txt
		
		try {
			
			File f = new File("D:\\Programs\\eclipse\\work-space\\filterforpass\\fillter\\src\\split\\"+ newName);
			System.out.println("Make new file called: " + f.getName());
			
			FileWriter w = new FileWriter(f);
			Scanner sc = new Scanner(fObj);
			
			System.out.println("Writing to file ... ");
			for(int i=0; i<split; i++){
				w.write(sc.nextLine()+"\n");;
				
			}//end of forloop
			sc.close();
			w.close();
		}catch(Exception e) {
			System.out.println("Something happen in writeNotGive function ...");
		}
		System.out.println("Done Writing\n");
		
	}//end of writeGive()	
	
	/**the first param is the name of the file the user type in
	 * int split is to know where to start the cutting out of the text
	 * the file object is to pass the file that it is going t be working with
	 * */
	public static void writeNotGive(String currentName, int split ,File fObj) {
		
		String newName = "notg" + currentName;//should already include .txt
		
		try {
			
			File f = new File("D:\\Programs\\eclipse\\work-space\\filterforpass\\fillter\\src\\split\\"+ newName);
			System.out.println("Make new file called: " + f.getName());
			
			FileWriter w = new FileWriter(f);
			Scanner sc = new Scanner(fObj);
			int count = 0;
			
			System.out.println("Writing to file ... ");
			while(sc.hasNextLine()) {
				
				if(split < count ) {
					w.write(sc.nextLine()+"\n");
					
				}else {
					sc.nextLine();
					count++;					
				}
				
			}//end of loop	
			sc.close();
			w.close();
			
		}catch(Exception e) {
			System.out.println("Something happen in writeNotGive function ...");
		}
		System.out.println("Done writing.\n");
		
	}//end of wrtieNotGive()
	
	/**
	 * This will calculate the estimate number for the sample.py to generate for me
	 * and it will output the number in the console
	 * */
	public static void muilt (int split) {
		int x1_5 = 0, x2 = 0, x3 = 0, x5 = 0, x10 = 0;
		
		x1_5 = (int) (split * 1.50);
		x2   = split * 2;
		x3   = split * 3;
		x5   = split * 5;
		x10  = split * 10;
		System.out.println("Number of not given = " + split);
		System.out.println("Esimated number to get...");
		System.out.println("1.5x = " + x1_5 );
		System.out.println("2x = " + x2 );
		System.out.println("3x = " + x3 );
		System.out.println("5x = " + x5 );
		System.out.println("10x = " + x10 );		
	}
	
	public static void main(String[] args) {
			
		try {			
			Scanner in = new Scanner(System.in); //get user input
			String fileName;
			
			System.out.print("Enter file location: ");
			fileName = in.nextLine();
			String fileNamecopy = fileName;			
			
			PasswordLengthCutter cut = new  PasswordLengthCutter();
			System.out.println("cutting down the list to 10 or less\n");
			total = cut.passCut(fileName);
			
			fileName = "D:\\Programs\\eclipse\\work-space\\filterforpass\\fillter\\src\\passcut\\"
					+ "cut"+fileName;
			File f = new File(fileName);
			
			//split  = total / 2; 
			split1 = (int) (total * 0.80);
			split2 = (int) (total * 0.20);
			System.out.println("80 split = " + split1);
			System.out.println("20 split = " + split2);
			
			writeGive(fileNamecopy, split1, f);
			writeNotGive(fileNamecopy, split1, f);
			in.close();
			
		}catch (Exception e){			
			e.printStackTrace(); //for debugging		
		}//end of try block		

		System.out.println("---------------------------------");
		muilt(split2);
		System.out.println("---------------------------------");
		
		
	}//end of main
	
}//end of class
