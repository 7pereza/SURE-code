package dataset;

import java.util.Scanner;
import java.io.*;

/**
 * RUN this in the command line, using the String [] args to get user input
 *
 * This is to count the differnt number of password length in the text file 
 * but with this program it will count up to a password length of 20 not 10
 * like the other 'Curve.java' program
 * This java program is better then the other 'Curve.java' that i made because it can go higher 
 * */

public class Curve {
	//to keep trin the number of that password length
	public static int n1=0, n2=0, n3=0, n4=0, n5=0, n6=0, n7=0, n8=0, n9=0, n10=0,
			n11=0, n12=0, n13=0, n14=0, n15=0, n16=0, n17=0, n18=0, n19=0, n20=0, n20plus=0, total=0;
	
	public static void main (String [] args) {
				
		File f = new File(args[0]);
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
				case 11: n11++; break;
				case 12: n12++; break;
				case 13: n13++; break;
				case 14: n14++; break;
				case 15: n15++; break;
				case 16: n16++; break;
				case 17: n17++; break;
				case 18: n18++; break;
				case 19: n19++; break;
				case 20: n20++; break;
				default: n20plus++; break;
				
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
		System.out.println("Passowrd with length 11 = " + n11);
		System.out.println("Passowrd with length 12 = " + n12);
		System.out.println("Passowrd with length 13 = " + n13);
		System.out.println("Passowrd with length 14 = " + n14);
		System.out.println("Passowrd with length 15 = " + n15);
		System.out.println("Passowrd with length 16 = " + n16);
		System.out.println("Passowrd with length 17 = " + n17);
		System.out.println("Passowrd with length 18 = " + n18);
		System.out.println("Passowrd with length 19 = " + n19);
		System.out.println("Passowrd with length 20 = " + n20);
		
		System.out.println("Password with length 20+ = " + n20plus);
		System.out.println("Total = " + total);
		
	}//end of main function
	

}//end if class
