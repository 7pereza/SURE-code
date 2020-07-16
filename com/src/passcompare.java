import java.io.*;
import java.util.Scanner;

/* to make sure that i can use this on the server b/c i have a more up-to-date java on my computer 
the server has 
version "1.8.0_252"
OpenJDK Runtime Environment (build 1.8.0_252-b09)
OpenJDK 64-Bit Server VM (build 25.252-b09, mixed mode)
or just java 8 in short 

to make sure it can run .class file on th server do:

javac --release 8 passcompare.java
in the command line

*/

public class passcompare {
	/**
	 * This function it to better compare the match 
	 * it will go through the save file called 'saveMatchPass.txt' 
	 * and will only take the first word of the lines
	 * it will need two words one of those word is going to be ahead of the other word
	 * with those two word it will do a string .equals() 
	 * - the counter will only go up if the two words are not the same
	 * - had to just give the counter a +1
	 * 
	 * - finally one small detail is how the word is set up when trying to compare the word 
	 * in the start of the line is the word then there is  three(3) dot followed by a number 
	 * ex) password...45
	 * this is to help tell the different when there are to of the same passwords in differ line 
	 * ex)	password...45
	 * 		password...46
	 * this has to count as two different things because the percent is out of the total of the un-give data-set
	 * */
	public static void betterMatches(File f) {
		int counter = 1; 
		
		try {
			Scanner file1 = new Scanner(f);
			Scanner file2 = new Scanner(f);
			String str1 = "";
			String str2 = "";
			
			
			file2.nextLine();//make this one step ahead then file1 scanner
			
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
			System.out.println("something hapen in the betterMacthes function");
			e.printStackTrace();
		}//end of try block		
		
		System.out.println("\nThe number of matchs: " + counter);
	}//end of function	
	
	/**
	 * Going to be using the args to make it work better in the command line 
	 * the two thing thing to pass is the name of the file notgive 
	 * and the sample file that i am comparing with
	 * 
	 * */
	public static void main(String[] args) {		
		
		File notg = new File(args[0]);//this should be the not givin file 
		File com = new File(args[1]);//this should be the sample file 
		
		//using this to see what password got match and were 
		
		File savem = new File(".//compared-" + com.getName() );//to save the matches
		
		try {
			
			BufferedReader not = new BufferedReader( new FileReader(notg)); ///not that many
			BufferedReader cp = new BufferedReader( new FileReader(com));//this file can  be many 
			String str1 = "", str2 = ""; 
						
			FileWriter wr = new FileWriter(savem);
		
			
			System.out.println("Starting to compare ...");
			int file1 = 0; //line tracker 
			int file2 = 0;
			
			while ((str1 = not.readLine()) != null) {
				file1++;
				file2 = 0;//resetting number 
								
				while( (str2 = cp.readLine()) != null) {
					//System.out.println(str1 +".."+str2);//debugging to see every comparisons
					file2++;
					
					if(str1.equals(str2)) {
						//there is no space in the three dot to make it once word
						String entrie = str1 +"..." + file1 +" ... "+str2 + " in line:" + file2;
						//System.out.println(entrie);//for debugging to the console  
						wr.write(entrie + "\n");
					}					
				}//end of loop2	
				cp.close();
				cp = new BufferedReader( new FileReader(com));// resetting the file back to start
								
			}//end of loop 1
			
			
			wr.close();						
			not.close();
			
		} catch(Exception e) {
			System.out.println("Something happen when trying to read in the file");
			e.printStackTrace();			
		}// end of try-block		
		//sc.close();			
		
		System.out.println("finshing the compareing ...");
		betterMatches(savem);
	}//end if main()

	
}//end of class{}
