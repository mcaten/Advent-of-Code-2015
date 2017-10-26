package Day5;
import java.io.*;
import java.util.*; 
public class Day5
{
  public static void main(String[] args)
  {
    init();
    int niceCount = 0;
    for(String s : arr) {
    	if(isNice(s)) {
    		niceCount++;
    	}
    }
    
    System.out.println("Part 1 Solution: " + niceCount);
    
    int niceCount2 = 0;
    for(String s : arr) {
      if(isNice2(s)) {
        niceCount2++;
      }
    }
    
    System.out.println("Part 2 Solution: " + niceCount2);
  }
  
  public static boolean isNice(String sample) {
	  boolean nice = true;
	  
	  int vowel = 0;
	  for(int i = 0; i < sample.length(); i++) {
	      if(sample.charAt(i) == 'a' || sample.charAt(i) == 'e' || sample.charAt(i) == 'i' || sample.charAt(i) == 'o' || sample.charAt(i) == 'u') {
	    	  vowel++;
	      }
	  }
	  
	  if(vowel < 3) {
		  return false;
	  }
	  
	  boolean found2 = false;
	  for(int i = 0; i < sample.length() - 1; i++) {
	      if(sample.charAt(i) == sample.charAt(i + 1)) {
	    	  found2 = true;
	    	  break;
	      }
	  }
	  
	  boolean found3 = sample.contains("ab") || sample.contains("cd") || sample.contains("pq") || sample.contains("xy");
	  
	  if(!found2 || found3) {
		  return false;
	  }
	  
	  return true;
  }
  
  public static boolean isNice2(String sample) {
    boolean nice = true;
    
    boolean found = false;
    for(int i = 0; i < sample.length() - 2; i++) {
      
      String l = sample.substring(i, i + 2);
      int num = sample.indexOf(l, i + 2);
      
      if(num != -1) {
    	  found = true;
    	  break;
      }
    }
    
    boolean found2 = false;
    for(int i2 = 0; i2 < sample.length() - 2; i2++) {
      char ch = sample.charAt(i2);
      
      if(ch == sample.charAt(i2 + 2)) {
        found2 = true;
        break;
      }
    }
    
    if(!found || !found2) {
      nice = false;
    }
    
    return nice;
  }
  
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
    File f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day5/data.txt");
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