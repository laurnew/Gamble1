import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * TopTen class reads and writes to a file in order to
 * keep track of the top ten players of the game
 * 
 * @author Lauren Weiser, Emma Delucchi, Katrina Baber
 *
 */


public class TopTen {
	static ArrayList<String> text = new ArrayList<String>();
	
	/** empties fills the top ten list with lines of "empties"
	 * to show that those lines do not hold any high scores
	 * @throws IOException
	 */
	
	public void empties() throws IOException{
		int numSides = 6;
		@SuppressWarnings("resource")
		FileWriter file = new FileWriter("src/topten.txt");
		BufferedWriter writer = new BufferedWriter(file);
		
		for(int i = 1; i <= numSides +7; i++){
			writer.write("empty");
			writer.newLine();
		}
		
		writer.close();
		file.close();
	}
	
	/** readtopten reads topten.txt and put the info
	 * into an array
	 * @throws FileNotFoundException 
	 */
	
	public static void readtopten() throws FileNotFoundException{
		Scanner sc = new Scanner(new File("src/topten.txt"));
		while(sc.hasNextLine()){
			text.add(sc.nextLine());
		}
	}
	
	/** writetopten writes new info into topten.txt
	 * @throws IOException 
	 * 
	 */
	
	public static void writetopten() throws IOException{
		FileWriter file = new FileWriter("src/topten.txt");
		BufferedWriter writer = new BufferedWriter(file);
		for(String s: text){
			writer.write(s);
			writer.newLine();
		}
		writer.close();
		file.close();
		
	}
		}
