package Day15;
import java.io.*;
import java.util.*;
public class Day15 {
	public static void main(String[] args) {

		init();
		
		
	}

	public static HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();
	public static ArrayList<String> arr = new ArrayList<String>();

	public static void readFile(Scanner sc) {
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			arr.add(line);
		}
	}

	public static void init() {
		File f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day15/data.txt");
		BufferedReader input1 = null;
		Scanner input = null;
		try {
			input1 = new BufferedReader(new FileReader(f));
			input = new Scanner(input1);
			readFile(input);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		input.close();

		try {
			input1.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}