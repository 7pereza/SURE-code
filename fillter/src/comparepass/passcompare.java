package comparepass;
import java.io.*;
import java.util.Scanner;
//This java program was made to be run on my computer
//I made  more gernal one in folder 'com' it it just like this one
//but you can run that in the command line  easyer just do 
// java passcompare <file one> <file two> 

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
	 * ex) passsword...45
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
			System.out.println("\nIF is say no line beciasue of the scanner then 0 matches\n");
			e.printStackTrace();
			System.exit(0);
		}//end of try block		
		
		System.out.println("\nThe number of matchs: " + counter);
	}//end of function	
	
	
	public static void main(String[] args) {
		//asking user for the name of the file
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name of the not given: ");
		String notgive = "D:\\0School\\SURE\\project\\text_dataset\\notGive\\" + sc.nextLine().trim();
		//System.out.println(notgive);//testing
		System.out.print("Enter name of the sample generater: ");
		String compare =  "D:\\0School\\SURE\\project\\text_dataset\\sample\\" + sc.nextLine().trim() ; 
		
		File notg = new File(notgive);
		File com = new File(compare);
		
		//using this to see what password got match and were 
		//TODO FIXME need to rename the save file 
		File savem = new File("D:\\Programs\\eclipse\\work-space\\filterforpass\\fillter\\src\\saveMatchPass.txt");
		
		try {
			
			BufferedReader not = new BufferedReader( new FileReader(notg)); ///not that many
			BufferedReader cp = new BufferedReader( new FileReader(com));//this file can  be many 
			String str1 = "", str2 = ""; 
						
			FileWriter wr = new FileWriter(savem);
			//wr.write("test\n");//for debugging
			
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
				cp = new BufferedReader( new FileReader(com));// resetting the file back to start
								
			}//end of loop 1
			
			wr.close();						
			not.close();
			cp.close();			
		} catch(Exception e) {
			System.out.println("Something haooen when trying to read in the file");
			e.printStackTrace();			
		}// end of try-block		
		sc.close();			
		
		System.out.println("finshing the compareing ...");
		/*but e try lock here becuase where ther are z enter in the file is pop up a error
		 * which mean ther ther is not line in the text file*/
		betterMatches(savem);
		
		
	}//end if main()

	
}//end of class{}
