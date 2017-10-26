package Day3;
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
    File f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day3/data.txt");
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
  
  public static int houses(String[] arr) {
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
	  
	  return houses;
  }
  
  public static int robo(String[] arr) {
	  int ns = 0;
	  int ew = 0;
	  int houses = 0;
	  
	  for(int i = 0; i < arr.length; i+= 2)
	  {
	    String s = arr[i];
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
	    
	  int nsr = 0;
	  int ewr = 0;
	  for(int i2 = 1; i2 < arr.length; i2+= 2)
	  {
	    String s = arr[i2];
	    if(s.equals("^")) {
	      nsr++;
	    }
	      
	    else if(s.equals("v")) {
	      nsr--;
	    }
	      
	    else if(s.equals(">")) {
	      ewr++;
	    }
	      
	    else if(s.equals("<")) {
	      ewr--;
	    }
	      
	    if(multiMap.containsKey(nsr)) {
	      if(multiMap.get(nsr).contains(ewr)) {
	          
	      }
	        
	      else {
	        houses++;
	        multiMap.get(nsr).add(ewr);
	      }
	    }
	      
	    else {
	      ArrayList<Integer> temp = new ArrayList<Integer>();
	      temp.add(ewr);
	      multiMap.put(nsr, temp);
	      houses++;
	    }
	  }
	    
	  return houses;
  }
  
  public static void main(String[] args)
  {
    init();
    System.out.println("Part 1 Solution: " + houses(arr));
    multiMap = new HashMap<Integer,ArrayList<Integer>>();
    System.out.println("Part 2 Solution: " + robo(arr));
  }
}