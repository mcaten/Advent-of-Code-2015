import java.io.*;
import java.util.*;  
public class Day3
{
  public static String[] arr;
  public static Map<Integer,ArrayList<Integer>> multiMap = new HashMap<Integer,ArrayList<Integer>>();
  public static void readFile(Scanner sc)
  {
    while(sc.hasNextLine())
    {
      String line = sc.next();
      arr = line.split("");
    }
  }
  
  public static void init()
  {
    File f = new File("data.txt");
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
    int ns = 0;
    int ew = 0;
    int houses = 0;
    for(String s : arr)
    {
      if(s.equals("^")) {
        ns++;
      }
      
      else if(s.equals("v")) {
        ns--;
      }
      
      else if(s.equals(">")) {
        ew++;
      }
      
      else if(s.equals("<")) {
        ew--;
      }
      
      if(multiMap.containsKey(ns)) {
        if(multiMap.get(ns).contains(ew)) {
          
        }
        
        else {
          houses++;
          multiMap.get(ns).add(ew);
        }
      }
      
      else {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(ew);
        multiMap.put(ns, temp);
        houses++;
      }
    }
    
    System.out.println(houses);
  }
}