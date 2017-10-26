package Day2;
import java.io.*;
import java.util.*;
public class Day2
{
  public static ArrayList<String> arr = new ArrayList<String>();
  public static void readFile(Scanner sc)
  {
    while(sc.hasNextLine())
    {
      String line = sc.nextLine();
      arr.add(line);
    }
  }
  
  public static void init()
  {
    File f = new File("C:/Users/MCATEN/eclipse-workspace/Advent of Code 2015/src/Day2/data.txt");
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
  
  public static void main(String[] args)
  {
    init();
    int total = 0;
    for(String s : arr)
    {
      int length = Integer.parseInt(s.substring(0, s.indexOf("x")));
      int width = Integer.parseInt(s.substring(s.indexOf("x") + 1, s.lastIndexOf("x")));
      int height = Integer.parseInt(s.substring(s.lastIndexOf("x") + 1));
      
      int[] sides = {length, width, height};
      Arrays.sort(sides);
      
      int extra = sides[1] * sides[0];
      int sa = (2 * length * width + 2 * width * height + 2 * height * length) + extra;
      
      total += sa;
    }
 
    System.out.println("Part 1 Solution: " + total);
    
    int total2 = 0;
    //System.out.println(arr.size());
    for(String s : arr)
    {
      int length = Integer.parseInt(s.substring(0, s.indexOf("x")));
      int width = Integer.parseInt(s.substring(s.indexOf("x") + 1, s.lastIndexOf("x")));
      int height = Integer.parseInt(s.substring(s.lastIndexOf("x") + 1));
      
      int[] sides = {length, width, height};
      Arrays.sort(sides);
      
      int bow = length * width * height;
      int a = (sides[0] * 2 + sides[1] * 2) + bow;
      
      total2 += a;
    }
 
    System.out.println("Part 2 Solution: " + total2);
  }
}