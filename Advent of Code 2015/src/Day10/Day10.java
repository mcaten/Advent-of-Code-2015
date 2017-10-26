package Day10;
import java.io.*;
import java.util.*; 
public class Day10
{
  public static void main(String[] args)
  {
    int max = 50;
    String s = "1321131112";
    String res = "";
    for(int count = 0; count < max; count++) {
        res = lookSay(s);
        s = res;
        
        if(count == 39) {
        	System.out.println("Part 1 Solution: " + s.length());
        }
        
        else if(count == 49) {
        	System.out.println("Part 2 Solution: " + s.length());
        }
    }
   
  }
  
  public static String lookSay(String input) {
    
    if(input.length() == 1) {
      return "1" + input;
    }
    
    else {
      int start = 0; 
      int count = 1;
      String res = "";
      
      while(start < input.length()) {
        if(start + 1 < input.length() && Character.getNumericValue(input.charAt(start)) == Character.getNumericValue(input.charAt(start + 1))) {
          count++;
        }
        
        else if(start + 1 >= input.length()) {
          res += count + "" + Character.getNumericValue(input.charAt(start));
        }
        
        else {
          res += count + "" + Character.getNumericValue(input.charAt(start));
          count = 1;
        }
        start++;
      }
      
      input = res;
      return res;
    }
  }
}