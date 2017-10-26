package Day1;
import java.io.*;
import java.util.*;
public class Day1
{
	public static void main(String[] args)
    {
    	init();
    	System.out.println("Part 1 Solution: " + countFloors(data));
    	System.out.println("Part 2 Solution: " + findBasement(data));
    }
	
    public static int countFloors(String str)
    {
      if(str.length() <= 0)
      {
        return 0;
      }
      
      else
      {
        if(str.charAt(0) == '(')
        {
          return 1 + countFloors(str.substring(1));
        }
        
        else if(str.charAt(0) == ')')
        {
          return -1 + countFloors(str.substring(1));
        }
        
        return 0;
      }
    }
    
    public static int findBasement(String str)
    {
      int curfloor = 0;
      for(int i = 0; i < str.length(); i++)
      {
        if(str.charAt(i) == '(')
        {
          curfloor++;
        }
        
        else
        {
          curfloor--;
        }
        
        if(curfloor < 0)
        {
          return i + 1;
        }
      }
      
      return -1;
    }
    
    public static String data = "";
    public static void readFile(Scanner sc)
    {
      while(sc.hasNextLine())
      {
        String line = sc.nextLine();
        data += line;
      }
    }
    
    public static void init()
    {
      File f = new File("C:/Users/MCATEN/eclipse-workspace/Advent of Code 2015/src/Day1/data.txt");
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
