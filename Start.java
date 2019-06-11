import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.*;

public class Start {
	
	public static ArrayList<LinkedHashMap<String,String>> input_data_file(String path,ArrayList<ArrayList> var) throws IOException
	{
		//System.out.println(var);

		ArrayList<LinkedHashMap<String, String>> map = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> map1 = new LinkedHashMap<String, String>();
		int size = var.size();
		List<String> first = new ArrayList();
		List<String> second = new ArrayList();
		List<String> third = new ArrayList();
		 		
		for (int i = 0; i < size; i++)
		{
			if (i < (size + 1)/2)
				first.addAll(var.get(i));
			else
				second.addAll(var.get(i));
		}
		
		
		BufferedReader in = new BufferedReader(new FileReader(path));
		String str=null;
		ArrayList<String> lines = new ArrayList<String>();
		while((str = in.readLine()) != null){
		    lines.add(str);
		}
		ArrayList<List<String>> lines1 = new ArrayList<List<String>>();
		String[] linesArray = lines.toArray(new String[lines.size()]);
		String[] arr1=new  String[linesArray.length] ;
		String[] arr2=new  String[lines.size()];
		List<String> values1 = null;
		
		for (int i=0;i<linesArray.length;i++)
		{	
		arr1=linesArray[i].split("\\||\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/");
			values1=Arrays.asList(arr1);
			lines1.add(values1);
		}
		
		for(int row=0;row<lines1.size();row++)
		{
			map1= new LinkedHashMap<>();
			for(int col=0;col<second.size();col++)
			{
				map1.put(second.get(col), lines1.get(row).get(col));
				
			}
			map.add(map1);
			
		}
		
		
		
      return map;
	}

	public static void xfr_data_file(String path, ArrayList<LinkedHashMap<String,String>> maps) throws IOException
	{
		
		
		Double total_marks []=new Double[maps.size()];
		Double avg_marks []=new Double[maps.size()];
		Double min_marks []=new Double[maps.size()];
		Double max_marks []=new Double[maps.size()];
		Integer id_no []=new Integer[maps.size()];
			rollup rlp=new rollup();
	     FileReader fileReader = new FileReader(path);
	        int count=0;
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        List<String> lines = new ArrayList<String>();
	        String line = null;
	        String arr[]=new String[lines.size()];
	        while ((line = bufferedReader.readLine()) != null) 
	        {
	            lines.add(line);
	        }	      
	        int index,index1,las_index,las_index1,index2;
	        String var[]=new String[lines.size()];
	        String var1[]=new String[lines.size()];
	        String var2[]=new  String[lines.size()];
	        String s;
	        bufferedReader.close();	         
	        arr=lines.toArray(new String[lines.size()]); 
	        for (int i=2;i<arr.length;i++)
	        {	
	        	if(!arr[i].equals("end;"))
	        	{
	        		if(arr[i].contains("::"))
	        		{
	        		index=arr[i].indexOf("::");	
	        		 var[i]=arr[i].substring(0, index);
	        		 var1[i]=arr[i].substring(index+2);        		 
	        		 if(var[i].contains("."))
	        		 {
	        			 index1=var[i].indexOf(".");
	        			 var[i]=var[i].substring(index1+1);
	        			// System.out.println(var[i]);
	        		 }
	        		}
	        	}	        	
	        }
	        for(int i=2;i<var.length-1;i++)
	        {
			      	if(var1[i].contains("sum"))
			      	{
			      	total_marks=rlp.sum(maps,var);
			      	}
			      	else if(var1[i].contains("avg"))
			      	{
			      		int n=3;
			      		avg_marks=rlp.avg(maps,var,n);
			      		
			      	}
			      	if(var1[i].contains("min"))
			      	{
			      	
			      		min_marks=rlp.min(maps,var);
			      		
			      	}
			      	
			      	if(var1[i].contains("max"))
			      	{
			      	
			      		max_marks=rlp.max(maps,var);
			      		
			      	}
			      	if(var1[i].contains("count"))
			      	{
			      	
			      		id_no=rlp.count(maps,var);
			      		
			      	}
	      	
	      	
	        }
	        
	        for(int i=0;i<maps.size();i++)
	        {
	        	System.out.println(total_marks[i]+"|"+avg_marks[i]+"|"+min_marks[i]+"|"+max_marks[i]+"|"+id_no[i]);
	        }
	        
	       
	    }   
		   
		    	  
	
	
		
		
        

	
	public static ArrayList<ArrayList>  read_file_dml(String path) throws Exception
	{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		 String line;         
         String pattern = "(.*?)\\s*\\((.*?)\\)\\s*(.*?);"; 
         // pattern for separtion of fields in dml file
         Pattern p = Pattern.compile(pattern);
         Matcher m;         
         ArrayList<String> datatype;
         datatype = new ArrayList<>();      
         ArrayList<String> delimiter;
          delimiter= new ArrayList<>();         
         ArrayList<String> column_name;
         column_name = new ArrayList<>();                   
         reader.readLine();
         line = reader.readLine();
         while (line != null && !line.equals("end")) {
            m = p.matcher(line);
            if (m.find()) {
                datatype.add(m.group(1));   //To capture 1st string
                delimiter.add(m.group(2).replace("\"", ""));
                
                column_name.add(m.group(3));    //To capture last string                              
         }
            line = reader.readLine();
         }        
         
        // display_dml(datatype,delimiter,column_name);
        ArrayList<ArrayList> delimiterColumnName =new ArrayList<ArrayList>();
        delimiterColumnName.add(delimiter);
        
        delimiterColumnName.add(column_name);
		return delimiterColumnName;

        
	}
	public static void display_dml(ArrayList<String> arrayList1,ArrayList<String> arrayList2,ArrayList<String> arrayList3)
	
	{

	    System.out.print(arrayList1);
	    System.out.println();
	    System.out.print(arrayList2);
	    System.out.println();
	    System.out.println(arrayList3);
	    System.out.println();
	                                    
	}
    public static void main(String args[]) throws Exception {
    	ArrayList<LinkedHashMap<String, String>> map = new ArrayList<LinkedHashMap<String, String>>();
    	ArrayList<ArrayList> var;
        var = new ArrayList<>(); 
        ArrayList<ArrayList> var1;
        var1 = new ArrayList<>(); 
        	String input_dml_path="input.dml.txt";
        	var=read_file_dml(input_dml_path);
        	String output_dml_path="output.dml.txt";
        	var1=read_file_dml(output_dml_path);
        	String input_path="input.dat.txt";
        	map=input_data_file(input_path,var);
        	String xfr_file="rule_form.xfr.txt";
        	xfr_data_file(xfr_file,map);
    }
}
