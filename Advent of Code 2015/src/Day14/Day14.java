package Day14;
import java.io.*;
import java.util.*;
public class Day14 {
	public static void main(String[] args) {
		
		init();
		Reindeer[] reindeer = new Reindeer[arr.size()];
		int indx = 0;
		for(String s : arr) {
			String[] temp = s.split(" ");
			reindeer[indx] = new Reindeer(temp[0], Integer.parseInt(temp[3]), Integer.parseInt(temp[6]), Integer.parseInt(temp[13]));
			indx++;
		}
		
		int seconds = 11;
		Reindeer r = new Reindeer("Comet", 14, 10, 127);
		System.out.println(calcDist(r, seconds));
		
	}
	
	public static int calcDist(Reindeer r, int seconds) {
		int rate = r.getRate();
		int time = r.getTime();
		int cooldown = r.getCooldown();
		
		int total = 0;
		boolean cool = false;
		
		for(int count = 1; count <= seconds; count++) {
			if(!cool) {
				total += rate;
			}
			
			if(count % time == 0) {
				cool = true;
			}
			
			else {
				if(cool) {
					cooldown--;
					
					if(cooldown == 0) {
						cooldown = r.getCooldown();
						cool = false;
					}
				}
			}
		}
		
		return total;
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
		File f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day14/data.txt");
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