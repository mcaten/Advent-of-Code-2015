package Day15;
import java.io.*;
import java.util.*;
public class Day15P1 {
	public static void main(String[] args) {

		init();
		Ingredient[] i = new Ingredient[arr.size()];
		int indx = 0;
		for (String s : arr) {
			String[] temp = s.split(" ");
			i[indx] = new Ingredient(temp[0].substring(0, temp[0].length() - 1), Integer.parseInt(temp[2].substring(0, temp[2].length() - 1)), Integer.parseInt(temp[4].substring(0, temp[4].length() - 1)),
					Integer.parseInt(temp[6].substring(0, temp[6].length() - 1)), Integer.parseInt(temp[8].substring(0, temp[8].length() - 1)), Integer.parseInt(temp[10]));
			indx++;
		}
		
		int[][] perm = multichoose(100, i.length);
		
		int maxScore = 0;
		for(int row = 0; row < perm.length; row++) {
			int[] temp = perm[row];
			int score = calcScore(temp, i);
			
			if(score > maxScore) {
				maxScore = score;
			}
		}
		
		
		System.out.println("Part 1 Solution: " + maxScore);
	}
	
	public static int calcScore(int[] dist, Ingredient[] i) {
		int[] ind = new int[4];
		
		for(int count = 0; count < i.length; count++) {
			ind[0] += (i[count].getCapacity() * dist[count]);
			ind[1] += (i[count].getDurability() * dist[count]);
			ind[2] += (i[count].getFlavor() * dist[count]);
			ind[3] += (i[count].getTexture() * dist[count]);
		}
		
		int score = 1;
		for(int j = 0; j < ind.length; j++) {
			
			if(ind[j] < 0) {
				ind[j] = 0;
			}
			
			score *= ind[j];
		}
		
		return score;
	}
	
	public static int[][] multichoose(int k, int n) {

	    if (k < 0 || n < 0) return null;
	    if (k == 0) return new int[1][n];
	    if (n == 0) return new int[0][0];

	    if (n == 1) {
	        int[][] result = new int[1][1];
	        result[0][0] = k;
	        return result;
	    }

	    int[][] arr = multichoose(k, n - 1);
	    int[][] arr2 = multichoose(k - 1, n);
	    List<int[]> out = new ArrayList<>();

	    for (int i = 0; i < arr.length; i++) {
	        int[] trans = new int[arr[i].length + 1];
	        trans[0] = 0;
	        System.arraycopy(arr[i], 0, trans, 1, arr[i].length);
	        out.add(trans);
	    }

	    for (int i = 0; i < arr2.length; i++) {
	        arr2[i][0]++;
	        out.add(arr2[i]);
	    }

	    return out.toArray(new int[0][0]);
	}
	
	public static void printArr(int[][] i) {
		
		for(int r = 0; r < i.length; r++) {
			for(int c = 0; c < i[r].length; c++) {
				System.out.println(i[r][c]);
			}
			System.out.println("");
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
