import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class rollup {
	 
	rollup()
	{
		//System.out.println("Welcome to Rollup Component");
	}
	public static Double[]  sum(ArrayList<LinkedHashMap<String,String>> maps,String Output[])
	{
		
		//System.out.println("Executing Sum Function based on XFR");
		Double total_marks1 []=new Double[maps.size()];
		Double total_marks2 []=new Double[maps.size()];
		Double total_marks3 []=new Double[maps.size()];
		Double total_marks []=new Double[maps.size()];
		for(int i=0;i<maps.size();i++)
		{
			
		total_marks1[i]=Double.parseDouble(maps.get(i).get("Physics"));
				total_marks2[i]=Double.parseDouble(maps.get(i).get("Chemistry"));
						total_marks3[i]=Double.parseDouble(maps.get(i).get("Maths"));	
		 total_marks[i]=total_marks1[i]+total_marks2[i]+total_marks3[i];	
		}
		/*
		for(int i=0;i<total_marks.length;i++)
		{
			System.out.println(total_marks[i]);
		}*/
		
		return total_marks;
		
	}
	public static Double[]  avg(ArrayList<LinkedHashMap<String,String>> maps,String Output[],Integer count)
	{
	//	System.out.println("Executing avg Function based on XFR");
		Double avg_marks1 []=new Double[maps.size()];
		Double avg_marks2 []=new Double[maps.size()];
		Double avg_marks3 []=new Double[maps.size()];
		Double avg_marks []=new Double[maps.size()];
		for(int i=0;i<maps.size();i++)
		{
			
			avg_marks1[i]=Double.parseDouble(maps.get(i).get("Physics"));
			avg_marks2[i]=Double.parseDouble(maps.get(i).get("Chemistry"));
			avg_marks3[i]=Double.parseDouble(maps.get(i).get("Maths"));	
			avg_marks[i]=(avg_marks1[i]+avg_marks2[i]+avg_marks3[i])/count;	
		}
		/*
		for(int i=0;i<avg_marks.length;i++)
		{
			System.out.println(avg_marks[i]);
		}*/
		return avg_marks;
		
	}
	public static Double[]  min(ArrayList<LinkedHashMap<String,String>> maps,String Output[])
	{
		//System.out.println("Executing min Function based on XFR");
		Double marks1 []=new Double[maps.size()];
		Double marks2 []=new Double[maps.size()];
		Double marks3 []=new Double[maps.size()];
		
		ArrayList<Double> lines = new ArrayList<Double>();

		Double min_marks []=new Double[maps.size()];
		for(int i=0;i<maps.size();i++)
		{	
			
			lines.add(Double.parseDouble(maps.get(i).get("Physics")));
			lines.add(Double.parseDouble(maps.get(i).get("Chemistry")));
			lines.add(Double.parseDouble(maps.get(i).get("Maths")));	
			Collections.sort(lines);
			min_marks[i]=lines.get(0);
			lines=new ArrayList<Double>();
			
		}
		/*
		for(int i=0;i<marks.length;i++) 
		{

			System.out.println(marks[i]);
	
			
		}*/
		return min_marks;
		
	}
	public static Double[]  max(ArrayList<LinkedHashMap<String,String>> maps,String Output[])
	{
		//System.out.println("Executing max Function based on XFR");
		Double marks1 []=new Double[maps.size()];
		Double marks2 []=new  Double[maps.size()];
		Double marks3 []=new  Double[maps.size()];
		
		ArrayList< Double> lines = new ArrayList< Double>();
		ArrayList< Double> lines1 = new ArrayList< Double>();
		 Double max_marks []=new  Double[maps.size()];
		for(int i=0;i<maps.size();i++)
		{
			
			lines.add(Double.parseDouble(maps.get(i).get("Physics")));
			lines.add(Double.parseDouble(maps.get(i).get("Chemistry")));
			lines.add(Double.parseDouble(maps.get(i).get("Maths")));	
			Collections.sort(lines);
			max_marks[i]=lines.get(lines.size()-1);
			lines=new ArrayList<Double>();
		}
	
		/*
		for(int i=0;i<maps.size();i++)
		{
			  
		System.out.println(marks[i]);
			
		}
		//System.out.println(Arrays.toString(marks));
		
		*/
		return max_marks;
		
		
	}
	public static Integer[]  count(ArrayList<LinkedHashMap<String,String>> maps,String Output[])
	{
		//System.out.println("Executing count Function based on XFR");
		ArrayList<Integer> id = new ArrayList<Integer>();
		Integer id_no []=new Integer[maps.size()];
		for(int i=0;i<maps.size();i++)
		{				
			id.add(Integer.parseInt(maps.get(i).get("id_no")));
			id_no[i]=id.get(i);
		}
		
		return id_no;
	
	}

	public static void main(String[] args) {
		
		

	}

}
