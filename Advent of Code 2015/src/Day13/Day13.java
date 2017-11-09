package Day13;
import java.io.*;
import java.util.*;
public class Day13 {
	public static void main(String[] args) {
		init(1);
		HashMap<Integer, String> keys = new HashMap<Integer, String>();
		keys.put(0, "Alice");
		keys.put(1, "Bob");
		keys.put(2, "Carol");
		keys.put(3, "David");
		keys.put(4, "Eric");
		keys.put(5, "Frank");
		keys.put(6, "George");
		keys.put(7, "Mallory");

		for (String s : arr) {
			String[] sp = s.split(" ");

			if (map.containsKey(sp[0])) {
				if (sp[2].equals("lose")) {
					map.get(sp[0]).put(sp[10].substring(0, sp[10].length() - 1), -Integer.parseInt(sp[3]));
				}

				else {
					map.get(sp[0]).put(sp[10].substring(0, sp[10].length() - 1), Integer.parseInt(sp[3]));
				}
			}

			else {
				HashMap<String, Integer> temp = new HashMap<String, Integer>();
				if (sp[2].equals("lose")) {
					temp.put(sp[10].substring(0, sp[10].length() - 1), -Integer.parseInt(sp[3]));
				}

				else {
					temp.put(sp[10].substring(0, sp[10].length() - 1), Integer.parseInt(sp[3]));
				}
				map.put(sp[0], temp);
			}
		}

		ArrayList<String> permutations = permutation("01234567");
		int max = 0;

		for (String s : permutations) {
			int dist = 0;
			int f = Character.getNumericValue(s.charAt(0));
			int sec = Character.getNumericValue(s.charAt(1));
			int t = Character.getNumericValue(s.charAt(2));
			int fo = Character.getNumericValue(s.charAt(3));
			int fi = Character.getNumericValue(s.charAt(4));
			int si = Character.getNumericValue(s.charAt(5));
			int se = Character.getNumericValue(s.charAt(6));
			int ei = Character.getNumericValue(s.charAt(7));

			dist += map.get(keys.get(f)).get(keys.get(sec));
			dist += map.get(keys.get(f)).get(keys.get(ei));

			dist += map.get(keys.get(sec)).get(keys.get(t));
			dist += map.get(keys.get(sec)).get(keys.get(f));

			dist += map.get(keys.get(t)).get(keys.get(sec));
			dist += map.get(keys.get(t)).get(keys.get(fo));

			dist += map.get(keys.get(fo)).get(keys.get(t));
			dist += map.get(keys.get(fo)).get(keys.get(fi));

			dist += map.get(keys.get(fi)).get(keys.get(fo));
			dist += map.get(keys.get(fi)).get(keys.get(si));

			dist += map.get(keys.get(si)).get(keys.get(fi));
			dist += map.get(keys.get(si)).get(keys.get(se));

			dist += map.get(keys.get(se)).get(keys.get(si));
			dist += map.get(keys.get(se)).get(keys.get(ei));

			dist += map.get(keys.get(ei)).get(keys.get(se));
			dist += map.get(keys.get(ei)).get(keys.get(f));

			if (dist > max) {
				max = dist;
			}
		}

		System.out.println("Part 1 Solution: " + max);

		keys.put(8, "Me");
		map = new HashMap<String, HashMap<String, Integer>>();
		init(2);
		for (String s : arr) {
			String[] sp = s.split(" ");

			if (map.containsKey(sp[0])) {
				if (sp[2].equals("lose")) {
					map.get(sp[0]).put(sp[10].substring(0, sp[10].length() - 1), -Integer.parseInt(sp[3]));
				}

				else {
					map.get(sp[0]).put(sp[10].substring(0, sp[10].length() - 1), Integer.parseInt(sp[3]));
				}
			}

			else {
				HashMap<String, Integer> temp = new HashMap<String, Integer>();
				if (sp[2].equals("lose")) {
					temp.put(sp[10].substring(0, sp[10].length() - 1), -Integer.parseInt(sp[3]));
				}

				else {
					temp.put(sp[10].substring(0, sp[10].length() - 1), Integer.parseInt(sp[3]));
				}
				map.put(sp[0], temp);
			}
		}

		ArrayList<String> permutations2 = permutation("012345678");
		int max2 = 0;

		for (String s : permutations2) {
			int dist = 0;
			int f = Character.getNumericValue(s.charAt(0));
			int sec = Character.getNumericValue(s.charAt(1));
			int t = Character.getNumericValue(s.charAt(2));
			int fo = Character.getNumericValue(s.charAt(3));
			int fi = Character.getNumericValue(s.charAt(4));
			int si = Character.getNumericValue(s.charAt(5));
			int se = Character.getNumericValue(s.charAt(6));
			int ei = Character.getNumericValue(s.charAt(7));
			int ni = Character.getNumericValue(s.charAt(8));

			dist += map.get(keys.get(f)).get(keys.get(sec));
			dist += map.get(keys.get(f)).get(keys.get(ni));

			dist += map.get(keys.get(sec)).get(keys.get(t));
			dist += map.get(keys.get(sec)).get(keys.get(f));

			dist += map.get(keys.get(t)).get(keys.get(sec));
			dist += map.get(keys.get(t)).get(keys.get(fo));

			dist += map.get(keys.get(fo)).get(keys.get(t));
			dist += map.get(keys.get(fo)).get(keys.get(fi));

			dist += map.get(keys.get(fi)).get(keys.get(fo));
			dist += map.get(keys.get(fi)).get(keys.get(si));

			dist += map.get(keys.get(si)).get(keys.get(fi));
			dist += map.get(keys.get(si)).get(keys.get(se));

			dist += map.get(keys.get(se)).get(keys.get(si));
			dist += map.get(keys.get(se)).get(keys.get(ei));

			dist += map.get(keys.get(ei)).get(keys.get(se));
			dist += map.get(keys.get(ei)).get(keys.get(ni));

			dist += map.get(keys.get(ni)).get(keys.get(ei));
			dist += map.get(keys.get(ni)).get(keys.get(f));

			if (dist > max2) {
				max2 = dist;
			}
		}

		System.out.println("Part 2 Solution: " + max2);
	}

	public static ArrayList<String> permutation(String s) {
		// The result
		ArrayList<String> res = new ArrayList<String>();
		// If input string's length is 1, return {s}
		if (s.length() == 1) {
			res.add(s);
		} else if (s.length() > 1) {
			int lastIndex = s.length() - 1;
			// Find out the last character
			String last = s.substring(lastIndex);
			// Rest of the string
			String rest = s.substring(0, lastIndex);
			// Perform permutation on the rest string and
			// merge with the last character
			res = merge(permutation(rest), last);
		}
		return res;
	}

	/**
	 * @param list
	 *            a result of permutation, e.g. {"ab", "ba"}
	 * @param c
	 *            the last character
	 * @return a merged new list, e.g. {"cab", "acb" ... }
	 */
	public static ArrayList<String> merge(ArrayList<String> list, String c) {
		ArrayList<String> res = new ArrayList<String>();
		// Loop through all the string in the list
		for (String s : list) {
			// For each string, insert the last character to all possible postions
			// and add them to the new list
			for (int i = 0; i <= s.length(); ++i) {
				String ps = new StringBuffer(s).insert(i, c).toString();
				res.add(ps);
			}
		}
		return res;
	}

	public static HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();
	public static ArrayList<String> arr = new ArrayList<String>();

	public static void readFile(Scanner sc) {
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			arr.add(line);
		}
	}

	public static void init(int num) {
		File f = null;
		if (num == 1) {
			f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day13/data.txt");
		}

		else if (num == 2) {
			f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day13/data2.txt");
		}
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