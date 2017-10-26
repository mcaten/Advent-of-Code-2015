package Day6;
import java.io.*;
import java.util.*; 
public class Day6
{
  public static boolean[][] lights1 = new boolean[1000][1000];
  public static int[][] lights2 = new int[1000][1000];
  public static void main(String[] args)
  {
    init();
    for(String s : arr) {
      String[] sp = s.split(" ");
      
      
      if(sp[0].equals("toggle")) {
        int x1 = Integer.parseInt(sp[1].substring(0, sp[1].indexOf(",")));
        int x2 = Integer.parseInt(sp[3].substring(0, sp[3].indexOf(",")));
        
        int y1 = Integer.parseInt(sp[1].substring(sp[1].indexOf(",") + 1));
        int y2 = Integer.parseInt(sp[3].substring(sp[3].indexOf(",") + 1));
        
        for(int row = x1; row <= x2; row++) {
          for(int col = y1; col <= y2; col++) {
            if(lights1[row][col]) {
              lights1[row][col] = false;
            }
            
            else {
              lights1[row][col] = true;
            }
           }
        } 
      }
      
      else if(sp[1].equals("on")) {
        
        int x1 = Integer.parseInt(sp[2].substring(0, sp[2].indexOf(",")));
        int x2 = Integer.parseInt(sp[4].substring(0, sp[4].indexOf(",")));
        
        int y1 = Integer.parseInt(sp[2].substring(sp[2].indexOf(",") + 1));
        int y2 = Integer.parseInt(sp[4].substring(sp[4].indexOf(",") + 1));
        
        for(int row = x1; row <= x2; row++) {
          for(int col = y1; col <= y2; col++) {
            lights1[row][col] = true;
          }
        }
      }
      
      else if(sp[1].equals("off")) {
        int x1 = Integer.parseInt(sp[2].substring(0, sp[2].indexOf(",")));
        int x2 = Integer.parseInt(sp[4].substring(0, sp[4].indexOf(",")));
        
        int y1 = Integer.parseInt(sp[2].substring(sp[2].indexOf(",") + 1));
        int y2 = Integer.parseInt(sp[4].substring(sp[4].indexOf(",") + 1));
        
        for(int row = x1; row <= x2; row++) {
          for(int col = y1; col <= y2; col++) {
            lights1[row][col] = false;
          }
        }
      }
    }
    
    System.out.println("Part 1 Solution: " + countLights(lights1));
    
    for(String s : arr) {
        String[] sp = s.split(" ");
        
        if(sp[0].equals("toggle")) {
          int x1 = Integer.parseInt(sp[1].substring(0, sp[1].indexOf(",")));
          int x2 = Integer.parseInt(sp[3].substring(0, sp[3].indexOf(",")));
          
          int y1 = Integer.parseInt(sp[1].substring(sp[1].indexOf(",") + 1));
          int y2 = Integer.parseInt(sp[3].substring(sp[3].indexOf(",") + 1));
          
          for(int row = x1; row <= x2; row++) {
            for(int col = y1; col <= y2; col++) {
              lights2[row][col] += 2;
             }
          } 
        }
        
        else if(sp[1].equals("on")) {
          
          int x1 = Integer.parseInt(sp[2].substring(0, sp[2].indexOf(",")));
          int x2 = Integer.parseInt(sp[4].substring(0, sp[4].indexOf(",")));
          
          int y1 = Integer.parseInt(sp[2].substring(sp[2].indexOf(",") + 1));
          int y2 = Integer.parseInt(sp[4].substring(sp[4].indexOf(",") + 1));
          
          for(int row = x1; row <= x2; row++) {
            for(int col = y1; col <= y2; col++) {
              lights2[row][col]++;
            }
          }
        }
        
        else if(sp[1].equals("off")) {
          int x1 = Integer.parseInt(sp[2].substring(0, sp[2].indexOf(",")));
          int x2 = Integer.parseInt(sp[4].substring(0, sp[4].indexOf(",")));
          
          int y1 = Integer.parseInt(sp[2].substring(sp[2].indexOf(",") + 1));
          int y2 = Integer.parseInt(sp[4].substring(sp[4].indexOf(",") + 1));
          
          for(int row = x1; row <= x2; row++) {
            for(int col = y1; col <= y2; col++) {
              if(lights2[row][col] - 1 >= 0) {
                 lights2[row][col]--;
              }
            }
          }
        }
      }
      
        System.out.println("Part 2 Solution: "  + countLights(lights2));  
    
  }
  
  public static int countLights(boolean[][] arr) {
    
    int count = 0;
    for(int row = 0; row < arr.length; row++) {
      for(int col = 0; col < arr[row].length; col++) {
        if(arr[row][col]) {
          count++;
        }
      }
    }
    
    return count;
  }
  
  public static int countLights(int[][] arr) {
	    
	    int count = 0;
	    for(int row = 0; row < arr.length; row++) {
	      for(int col = 0; col < arr[row].length; col++) {
	          count += lights2[row][col];
	      }
	    }
	    
	    return count;
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
    File f = new File("C:/Users/MCATEN/Downloads/Advent-of-Code-2015/Advent of Code 2015/src/Day6/data.txt");
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