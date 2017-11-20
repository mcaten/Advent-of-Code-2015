package Day14;

import java.io.*;
import java.util.*;

public class Day14 {
	public static void main(String[] args) {

		init();
		Reindeer[] reindeer = new Reindeer[arr.size()];
		int indx = 0;
		for (String s : arr) {
			String[] temp = s.split(" ");
			reindeer[indx] = new Reindeer(temp[0], Integer.parseInt(temp[3]), Integer.parseInt(temp[6]),
					Integer.parseInt(temp[13]));
			indx++;
		}

		int far = 0;
		for (int count = 0; count < 2503; count++) {
			int max = 0;
			int ind = 0;

			for (int i = 0; i < reindeer.length; i++) {
				int d = calcDist(reindeer[i], count + 1);
				if (d > max) {
					far = d;
					max = d;
					ind = i;
				}
			}

			reindeer[ind].addPoint();
		}

		int p = 0;
		for (Reindeer r : reindeer) {
			int e = r.getPoints();

			if (e > p) {
				p = e;
			}
		}

		System.out.println("Part 1 Solution: " + far);
		System.out.println("Part 2 Solution: " + p);

	

	}

	public static int calcDist(Reindeer r, int seconds) {
		int rate = r.getRate();
		int time = r.getTime();
		int cooldown = r.getCooldown();
		int total = 0;

		for (int count = 1; count <= seconds; count++) {
			if (time > 0) {
				total += rate;
				time--;
			}

			else if (time == 0) {
				time = r.getTime();
				count += cooldown;
				count--;
			}
			// System.out.println(count + " " + total);
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