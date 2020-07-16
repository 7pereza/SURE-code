package filecounter;

/*
 * this class will help count the number of passwords that in in each of the files
 * that i am generating from sample.py. the onlt thing i will have ti do is enter the name 
 * of the file without givening the muiilit at the end of the file 
 * */
import java.util.Scanner;
import java.io.*;

//3147_md5-26_

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
