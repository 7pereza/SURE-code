package filecounter;

/*
 * this class will help count the number of passwords that in in each of the files
 * that i am generating from sample.py. The only thing i will have to do is enter the name 
 * of the file without giveing the last part at the end of the file.
 * - But this progam is not the usedable i mkae a more general java program called 'Count'
 * 	all you have to do is just enter the whole name of the file (inculding .txt)
 *	or you can also enter the whole path
 * */

import java.util.Scanner;
import java.io.*;


public class Count {
		
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		String name = "";
		
		System.out.print("Enter the name of the generate file to count: ");
		name = sc.nextLine().trim();
		
		//make 5 file object
		
		String [] list = {
				"15.txt",
				"2.txt",
				"3.txt",
				"5.txt",
				"10.txt"};		
		try {
			for(int i=0; i<5; i++) {
				
				BufferedReader read = new BufferedReader( new FileReader( 
						new File( "D:\\0School\\SURE\\project\\text_dataset\\sample\\" + name + list[i] ) ) );
				
				int linec = 0;
				
				while( read.readLine() != null ) {
					linec++;					
				}//end if while loop
				
				System.out.println("Total from file" + i + " = " + linec );
			}//end of forloop			
		}catch(Exception e) {			
			e.printStackTrace();
		}//end of try block
		
		sc.close();
	}//end of function 

}//end of class
