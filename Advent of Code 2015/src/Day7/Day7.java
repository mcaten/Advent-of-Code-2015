package Day7;
import java.io.*;
import java.util.*; 
public class Day7
{
  public static Map<String, Integer> map = new HashMap<String, Integer>();
  public static void main(String[] args)
  {
    init();
    while(arr.size() != 0) {
      
      int indx = hasOne(arr);
      String[] sp = arr.get(indx).split(" ");
      
      if(sp[0].equals("NOT")) {
        int value = ~map.get(sp[1]);
        map.put(sp[3], value);
        arr.remove(indx);
      }
      
      else if(isDigit(sp[0]) && sp.length == 3) {
        map.put(sp[2], Integer.parseInt(sp[0]));
        arr.remove(indx);
      }
      
      else if(isDigit(sp[0]) && sp[1].equals("AND")) {
        int value = Integer.parseInt(sp[0]) & map.get(sp[2]);
        map.put(sp[4], value);
        arr.remove(indx);
      }
      
      else if(sp[1].equals("AND")) {
        int value = map.get(sp[0]) & map.get(sp[2]);
        map.put(sp[4], value);
        arr.remove(indx);
      }
      
      else if(sp[1].equals("OR")) {
        int value = map.get(sp[0]) | map.get(sp[2]);
        map.put(sp[4], value);
        arr.remove(indx);
      }
      
      else if(sp[1].equals("RSHIFT")) {
        int value = map.get(sp[0]) >> Integer.parseInt(sp[2]);
        map.put(sp[4], value);
        arr.remove(indx);
     }
      
      else if(sp[1].equals("LSHIFT")) {
        int value = map.get(sp[0]) << Integer.parseInt(sp[2]);
        map.put(sp[4], value);
        arr.remove(indx);
      }
      
      else if(sp.length == 3 && sp[1].equals("->")) {
        int value = map.get(sp[0]);
        map.put(sp[2], value);
        arr.remove(indx);
        
      }
    }
    
    System.out.println("Part 1 Solution: " + map.get("a"));
    
    arr = new ArrayList<String>();
    map = new HashMap<String, Integer>();
    init2();
    while(arr.size() != 0) {
      
      int indx = hasOne(arr);
      String[] sp = arr.get(indx).split(" ");
      
      if(sp[0].equals("NOT")) {
        int value = ~map.get(sp[1]);
        map.put(sp[3], value);
        arr.remove(indx);
      }
      
      else if(isDigit(sp[0]) && sp.length == 3) {
        map.put(sp[2], Integer.parseInt(sp[0]));
        arr.remove(indx);
      }
      
      else if(isDigit(sp[0]) && sp[1].equals("AND")) {
        int value = Integer.parseInt(sp[0]) & map.get(sp[2]);
        map.put(sp[4], value);
        arr.remove(indx);
      }
      
      else if(sp[1].equals("AND")) {
        int value = map.get(sp[0]) & map.get(sp[2]);
        map.put(sp[4], value);
        arr.remove(indx);
      }
      
      else if(sp[1].equals("OR")) {
        int value = map.get(sp[0]) | map.get(sp[2]);
        map.put(sp[4], value);
        arr.remove(indx);
      }
      
      else if(sp[1].equals("RSHIFT")) {
        int value = map.get(sp[0]) >> Integer.parseInt(sp[2]);
        map.put(sp[4], value);
        arr.remove(indx);
     }
      
      else if(sp[1].equals("LSHIFT")) {
        int value = map.get(sp[0]) << Integer.parseInt(sp[2]);
        map.put(sp[4], value);
        arr.remove(indx);
      }
      
      else if(sp.length == 3 && sp[1].equals("->")) {
        int value = map.get(sp[0]);
        map.put(sp[2], value);
        arr.remove(indx);
        
      }
    }
    
    System.out.println("Part 2 Solution: " + map.get("a"));
    
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
  
  public static int hasOne(ArrayList<String> arr) {
    
    for(int i = 0; i < arr.size(); i++) {
      String[] temp = arr.get(i).split(" ");
      
      if(isDigit(temp[0]) && temp.length == 3) {
          return i;
      }
      
      else if(temp[0].equals("NOT") && map.containsKey(temp[1])) {
        return i;
      }
      
      else if(map.containsKey(temp[0]) && temp[1].equals("RSHIFT")) {
        return i;
      }
      
      else if(map.containsKey(temp[0]) && temp[1].equals("LSHIFT")) {
        return i;
      }
      
      else if(map.containsKey(temp[0]) && map.containsKey(temp[2])) {
        return i;
      }
      
      else if(isDigit(temp[0]) && map.containsKey(temp[2])) {
        return i;
      }
      
      else if(temp.length == 3 && temp[1].equals("->") && arr.size() == 1) {
        return i;
      }
    }
    return -1;
  }
  
  public static boolean isDigit(String s) {
    try{
      int p = Integer.parseInt(s);
      return true;
    }
    
    catch(Exception e) {
      return false;
    }
  }
  
  public static void init()
  {
    File f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day7/data.txt");
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
  
  public static void init2()
  {
    File f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day7/data2.txt");
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