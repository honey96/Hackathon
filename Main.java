package harshit; 

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class main {
    public static void main(String args[]) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("//home//honey//input.dml"));
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
            
            
            
            int count=0;
            reader.readLine();
            line = reader.readLine();
            while (line != null && !line.equals("end")) {
               m = p.matcher(line);
               if (m.find()) {
                   firstArr.add(m.group(1));   //To capture 1st string
                   midArr.add(m.group(2));     //To capture within brackets
                   lastArr.add(m.group(3));    //To capture last string
                   count+=1;
                  
                   
            }
               line = reader.readLine();
            }
            
            for(int i=0;i<firstArr.size();i++)  
            {  
             System.out.print(firstArr.get(i)+" ");     
            }
            
            System.out.println();
            for(int i=0;i<midArr.size();i++)  
            {  
             System.out.print(midArr.get(i)+" ");     
            }
            
            System.out.println();
            
            
            for(int i=0;i<lastArr.size();i++)  
            {  
            	
             System.out.print(lastArr.get(i)+" ");     
            }  
            System.out.println();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
