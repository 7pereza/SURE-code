/*
 * this will just go though the data-set and will look at each password to see
 * the length of each password if the that length is 10 or short it will be save 
 * to a file
 * 
 */

import java.io.*;

public class PasswordLengthCutter {
	
	public int passCut(String name) {
		int tcounter = 0;//this is to see how many password were kept
		File f = new File("D:\\Programs\\eclipse\\work-space\\filterforpass\\fillter\\src\\dataset\\"+ name );
		try {	
			BufferedReader sc = new BufferedReader(new FileReader(f));
			
			File makef = new File("D:\\Programs\\eclipse\\work-space\\filterforpass\\fillter\\src\\passcut\\" + "cut" + name);
			FileWriter w = new FileWriter(makef);
			System.out.println("Making new file called: " + makef.getName() );
			tcounter = 0;
			
			System.out.println("Writing to file ...");
			String check = "";
			
			while( (check = sc.readLine()) != null) {
				
				//System.out.println(num +"..."+check + "..." + check.length());//for debugging
				if(check.length() <= 10) {
					tcounter++;
					w.write(check+"\n");
				}				
			}//end of loop
			
			System.out.println("Writing to file Done.");
			sc.close();
			w.close();
			
			System.out.println("\nThis many password were kept: " + tcounter+"\n");
		} catch(Exception e) {
			System.out.println("Something happen cutting down the file ");
			e.printStackTrace();//for debugging 
		}
		
		return tcounter;
		
	} //end of passCut()
	

}//end of class
