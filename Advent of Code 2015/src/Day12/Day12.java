package Day12;
import java.io.*;
import java.util.*;

public class Day12 {
	public static void main(String[] args) {
		init();
		String s = arr.get(0);
		String num = "";
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
				num += s.charAt(i);
			}

			else {
				if (num.length() > 0) {
					sum += Integer.parseInt(num);
					num = "";
				}
			}
		}

		System.out.println("Part 1 Solution: " + sum);

		String filtered = filter(s);
		String num2 = "";
		int sum2 = 0;
		for (int i = 0; i < filtered.length(); i++) {
			if (Character.isDigit(filtered.charAt(i)) || filtered.charAt(i) == '-') {
				num2 += filtered.charAt(i);
			}

			else {
				if (num2.length() > 0) {
					sum2 += Integer.parseInt(num2);
					num2 = "";
				}
			}
		}
		
		System.out.println("Part 2 Solution: " + sum2);
	}

	public static String filter(String s) {
		String res = s;
		for (int count = s.lastIndexOf('{'); count > 0; count--) {
			if (s.charAt(count) == '{') {
				char[] text = s.toCharArray();
				int close = findClosingParen(text, count);
				String sub = s.substring(count, close + 1);
				if (sub.contains(":\"red\"")) {
					res = s.substring(0, count) + s.substring(close + 1);
					s = res;
				}
			}
		}

		return res;
	}

	public static int findClosingParen(char[] text, int openPos) {
		int closePos = openPos;
		int counter = 1;
		while (counter > 0) {
			char c = text[++closePos];
			if (c == '{') {
				counter++;
			} 
			
			else if (c == '}') {
				counter--;
			}
		}
		return closePos;
	}

	public static ArrayList<String> arr = new ArrayList<String>();

	public static void readFile(Scanner sc) {
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			arr.add(line);
		}
	}

	public static void init() {
		File f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day12/data.txt");
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