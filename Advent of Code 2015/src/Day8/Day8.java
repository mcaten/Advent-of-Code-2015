package Day8;
import java.io.*;
import java.util.*; 
import org.apache.commons.lang.*; //Note: Must install Apache Commons Lang Library
public class Day8
{
  public static void main(String[] args)
  {
    init();
    
    int literalCount = 0;
    int memCount = 0;
    int indx = 0;
    for(String s : arr) {
      for(int i = 0; i < s.length(); i++) {
        if(s.charAt(i) == ' ') {
          
        } 
        
        else {
          literalCount++;
        }
      }
      
      String temp = s.substring(1, s.length() - 1);
      temp = temp.replace("\\\\", "A");
      temp = temp.replace("\\\"", "B");
      
      
      for(int i2 = 0; i2 <= temp.length() - 2; i2++) {
        if(temp.charAt(i2 + 1) == 'x' && temp.substring(i2, i2 + 1).equals("\\")) {
          
          if((int) temp.charAt(i2 + 2) > 102) {
            break;
            
          }
          
          else {
            int hex = Integer.parseInt(temp.substring(i2 + 2, i2 + 4), 16);
            temp = temp.replace(temp.substring(i2, i2 + 4), "C");
          }
        }
      }
      
      memCount += (temp.length());
    }

    System.out.println("Part 1 Solution: " + (literalCount - memCount));
    
    int literal2 = 0;
    int memory2 = 0;
    for(String s : arr) {
    	literal2 += s.length();
    	
    }
    
    for(String s : arr) {
    	String e = StringEscapeUtils.escapeJava(s);
    	memory2 += e.length() + 2;
    	
    }
    System.out.println("Part 2 Solution: " + (memory2 - literal2));
    
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
    File f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day8/data.txt");
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