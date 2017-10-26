package Day4;
import java.io.*;
import java.util.*; 
import java.security.*;
public class Day4
{
  public static void main(String[] args)
  {
    String part = "yzbqklnj";
    int num = 0;
    String t = MD5(part + num);
    while(!t.substring(0, 5).equals("00000")) {
      num++;
      t = MD5(part + num);
    }
    
    System.out.println(num);
  }
  
  public static String MD5(String md5) {
   try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
       }
        return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
}
}