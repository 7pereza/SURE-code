/* This is to be use in the server do java Counterpass (file name )
 * I made this java program to help me counter the number of password in the file
 *  */
import java.util.Scanner;
import java.io.*;


public class CounterPass {

	public static void main(String[] args) {		
		
		try {
			Scanner sc = new Scanner(new BufferedReader(new FileReader(new File (args[0]) ) ) );
			int count = 0;
			
			while(sc.hasNextLine()) {
				sc.nextLine();
				count++;
			}
			
			System.out.println(args[0] + " has..." + count);
		}catch(Exception e) {
			System.out.println("Something happen when reading the file");
			e.printStackTrace();
		}//end if try block		

	}//end of main

}//end of class
