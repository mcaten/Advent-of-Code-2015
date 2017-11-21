package Day16;
import java.io.*;
import java.util.*;
public class Day16 {
	public static void main(String[] args) {

		init();
		String[] crit = {"children:", "cats:", "samoyeds:", "pomeranians:", "akitas", "vizslas:", "goldfish", "trees:", "cars:", "perfumes:"};
		HashMap<String, Integer> realSue = new HashMap<String, Integer>();
		realSue.put("children:", 3);
		realSue.put("cats:", 7);
		realSue.put("samoyeds:", 2);
		realSue.put("pomeranians:", 3);
		realSue.put("akitas", 0);
		realSue.put("vizslas:", 0);
		realSue.put("goldfish", 5);
		realSue.put("trees:", 3);
		realSue.put("cars:", 2);
		realSue.put("perfumes:", 1);
		
		for(String s : arr) {
			String[] sp = s.split(" ");
			HashMap<String, Integer> tempSue = new HashMap<String, Integer>();
			int sNum = Integer.parseInt(sp[1].substring(0, sp[1].length() - 1));
			tempSue.put(sp[2], Integer.parseInt(sp[3].substring(0, sp[3].length() - 1)));
			tempSue.put(sp[4], Integer.parseInt(sp[5].substring(0, sp[5].length() - 1)));
			tempSue.put(sp[6], Integer.parseInt(sp[7]));
			
			if(realSue.get(sp[2]) == tempSue.get(sp[2]) && realSue.get(sp[4]) == tempSue.get(sp[4]) && realSue.get(sp[6]) == tempSue.get(sp[6])) {
				System.out.println("Part 1 Solution: " + sNum);
			}
		}
		
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
		File f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day16/data.txt");
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
