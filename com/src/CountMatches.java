/**
 * This is just to count the number of match there are in the compare file that is produced. 
 * the same function is in <passcompare>.But i am make this program because it it taking to long 
 * to count. <passcompare> has a total of three while loops that it is going to use .
 * there is a while loop that has a while loop inside of it and that is making it take longer 
 * 
 * To use this just give the file name after calling the java command 
 * example) java CountMatches <FileName>
 * */

import java.util.Scanner;
import java.io.*;


//using string [] args for the the server
public class CountMatches {

	public static void main(String[] args) {
		int counter = 1; 
		
		try {
			
			
			Scanner file1 = new Scanner ( new BufferedReader( new FileReader( new File ( args[0]) ) ) );
			Scanner file2 = new Scanner ( new BufferedReader( new FileReader( new File ( args[0]) ) ) );
			String str1 = "";
			String str2 = "";
			
			
			file2.nextLine();//make this one step ahead then file1 scanner
			
			System.out.println("Starting to count file....");
			while(file2.hasNextLine()) {
				str1 = file1.next();//get the first word
				str2 = file2.next();
				
				file1.nextLine();//skipping the rest if the line
				file2.nextLine();
				
				if( !(str1.equals(str2)) ) {
					counter++;						
				}			
								
			}//end loop 1
			file1.close();
			file2.close();			
			
		} catch (Exception e) {	
			System.out.println("Something happen when counting !?!?!?!?!!");
			//e.printStackTrace();
		}//end of try block		
		
		System.out.println("File name..." + args[0]);
		System.out.println("\nThe number of matchs: " + counter);
		System.out.println("--------------------------------------------------------------------");
		
		
	}//end of function

}//end if class
