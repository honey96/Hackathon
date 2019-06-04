package harshit; 

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String args[]) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.dml"));
            String line;
            
            String pattern = "(.*?)\\s*\\((.*?)\\)\\s*(.*?);";
            Pattern p = Pattern.compile(pattern);
            Matcher m;
            
            ArrayList<String> firstArr;
            firstArr = new ArrayList<>();
            
            ArrayList<String> midArr;
            midArr = new ArrayList<>();
            
            ArrayList<String> lastArr;
            lastArr = new ArrayList<>();
            
            reader.readLine();
            line = reader.readLine();
            while (line != null && !line.equals("end")) {
               m = p.matcher(line);
               if (m.find()) {
                   firstArr.add(m.group(1));   //To capture 1st string
                   midArr.add(m.group(2));     //To capture within brackets
                   lastArr.add(m.group(3));    //To capture last string
               }
               line = reader.readLine();
            }
            
            //Print 1st array-list
            firstArr.stream().forEach((s) -> {
                System.out.print(s + " ");
            });
            System.out.println();
            
            //Print 2nd array-list
            midArr.stream().forEach((s) -> {
                System.out.print(s + " ");
            });
            System.out.println();
            
            //Print 3rd array-list
            lastArr.stream().forEach((s) -> {
                System.out.print(s + " ");
            });
            System.out.println();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}