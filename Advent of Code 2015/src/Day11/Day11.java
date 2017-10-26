package Day11;
import java.io.*;
import java.util.*; 
public class Day11
{
  public static boolean once = false;
  public static void main(String[] args)
  {
    String pass = "vzbxkghb";
    int num  = 0;
    char[] p1 = pass.toCharArray();
    int[] password = new int[p1.length];
    int indx = 0;
    for(char c : p1) {
      password[indx] = (int)c;
      indx++;
    }
    
    boolean f = false;
    while(num < 2) {
      password = increment(password);
      f = isNew(password);
      if(f) {
        num++;
        System.out.print("Part " + num + " Solution: ");
        printArr(password);
      }
      if(once) {
        break;
      }
    }

  }
  
  public static void printArr(int[] a) {
	  for(int i : a) {
		  System.out.print((char)i);
	  }
	  
	  System.out.println("");
  }
  
  public static boolean isNew(int[] arr) {
    
    boolean found1 = false;
    for(int count = 0; count < arr.length - 2; count++) {
      if(((arr[count] + 1) == (arr[count + 1])) && ((arr[count + 1] + 1) == (arr[count + 2]))) {
        found1 = true;
      }
    }
    
    boolean found2 = true;
    for(int count2 = 0; count2 < arr.length; count2++) {
      if(arr[count2] == 105 || arr[count2] == 111 || arr[count2] == 108) {
        found2 = false;
        break;
      }
    }
    
    boolean found3 = false;
    int rep1 = 0;
    for(int count3 = 0; count3 < arr.length - 1; count3++) {
      if(arr[count3] == arr[count3 + 1]) {
        rep1++;
        count3++;
      }
    }
    
    if(rep1 >= 2) {
      found3 = true;
    }
   
    return found1 && found2 && found3;
    
  }
  
  public static int[] increment(int[] arr) {
    
    if(arr[arr.length - 1] == 122) {
      arr[arr.length - 1] = 97;
      
      if(arr[arr.length - 2] == 122) {
        arr[arr.length - 2] = 97;
        
        if(arr[arr.length - 3] == 122) {
          arr[arr.length - 3] = 97;
          
          if(arr[arr.length - 4] == 122) {
            arr[arr.length - 4] = 97;
            
            if(arr[arr.length - 5] == 122) {
              arr[arr.length - 5] = 97;
              
              if(arr[arr.length - 6] == 122) {
                arr[arr.length - 6] = 97;
                
                if(arr[arr.length - 7] == 122) {
                  arr[arr.length - 7] = 97;
                  
                  if(arr[arr.length - 8] == 122) {
                    arr[arr.length - 8] = 97;
                    once = true;
                  }
                  
                  else {
                    arr[arr.length - 8]++;
                  }
                }
                
                else {
                  arr[arr.length - 7]++;
                }
              }
              
              else {
                arr[arr.length - 6]++;
              }
            }
            
            else {
              arr[arr.length - 5]++;
            }
          }
          
          else {
            arr[arr.length - 4]++;
          }
        }
        
        else {
          arr[arr.length - 3]++;
        }
      }
      
      else {
        arr[arr.length - 2]++;
      }
    }
    
    else {
    	arr[arr.length - 1]++;
    }
    return arr;
  }
  
}