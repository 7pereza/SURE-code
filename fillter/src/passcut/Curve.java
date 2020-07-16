package passcut;

import java.util.Scanner;
import java.io.*;

/**
 * this is meatn to be run in the command line 
 * */
public class Curve {
	
	public static void main (String [] args) {
		
		//Scanner sc = new Scanner(System.in);
		
		//System.out.print("Enter the name of file to anaylze: ");
		
		//String name = sc.nextLine();
		//name = "D:\\Programs\\eclipse\\work-space\\filterforpass\\fillter\\src\\passcut\\" + name ;
		
		File f = new File(args[0]);
		
		//this will keep track of the number length for each password
		int n1=0, n2=0, n3=0, n4=0, n5=0, n6=0, n7=0, n8=0, n9=0, n10=0, total=0;
		try {
			
			//this will be used to read in the file 
			//is this Scanner does not work just do the bufferedreader
			Scanner read = new Scanner (new BufferedReader( new FileReader(f) ));
			
			while(read.hasNextLine() ) {
				total++;
				
				int num = read.nextLine().length();
				
				////switch block
				switch(num) {
				case 1: n1++; break;
				case 2: n2++; break;
				case 3: n3++; break;
				case 4: n4++; break;
				case 5: n5++; break;
				case 6: n6++; break;
				case 7: n7++; break;
				case 8: n8++; break;
				case 9: n9++; break;
				case 10: n10++; break;
				
				}
				
				/// end switch of block
			}//end if while block		
			
		} catch (FileNotFoundException e) {
			System.out.println("error in counter curve");
			e.printStackTrace();
		}//end if try-block
		
		System.out.println("------------------------------------------------");
		System.out.println("Name of file: " + args[0]);
		System.out.println("Passowrd with length 1 = " + n1);
		System.out.println("Passowrd with length 2 = " + n2);
		System.out.println("Passowrd with length 3 = " + n3);
		System.out.println("Passowrd with length 4 = " + n4);
		System.out.println("Passowrd with length 5 = " + n5);
		System.out.println("Passowrd with length 6 = " + n6);
		System.out.println("Passowrd with length 7 = " + n7);
		System.out.println("Passowrd with length 8 = " + n8);
		System.out.println("Passowrd with length 9 = " + n9);
		System.out.println("Passowrd with length 10 = " + n10);
		System.out.println("Total = " + total);
		
	}//end of main function
	

}//end if class
