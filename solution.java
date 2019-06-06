import java.io.*;
import java.math.*;
import java.nio.file.Files;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import hackathon.XFR;

public class Solution {

   
	static ArrayList< LinkedHashMap<String,String>> convertInputToArrayList( LinkedHashMap<Integer,String> rawDataMap, LinkedHashMap<String,String> delimiterVariableInput) {
		ArrayList< LinkedHashMap<String,String>> listConvertedData= new ArrayList< LinkedHashMap<String,String>>();
		Set<String> keySet=delimiterVariableInput.keySet();
		String delimiter=new String();
		
		
		for(int i=0;i<rawDataMap.size();i++) {
			 LinkedHashMap<String,String> columnsMap= new  LinkedHashMap<String,String>();
			int keyIndex=keySet.size()-1;
			int previousDelimiterIndex=-1;
			for(String key:keySet) {
				String dataTypeDelimiter=delimiterVariableInput.get(key);
				String dataType=dataTypeDelimiter.substring(0, dataTypeDelimiter.indexOf("("));
				delimiter=dataTypeDelimiter.substring(dataTypeDelimiter.indexOf("(")+1, dataTypeDelimiter.indexOf(")"));
				
					if(delimiter.contains("|")) {
						delimiter="|";
						String col;
						if(previousDelimiterIndex==-1) {
							col=rawDataMap.get(i).substring(0,rawDataMap.get(i).indexOf(delimiter));
							previousDelimiterIndex=rawDataMap.get(i).indexOf(delimiter);
						}else {
							String sub=rawDataMap.get(i).substring(previousDelimiterIndex+1);
							int subDelimiterIndex=sub.indexOf(delimiter);
							col=sub.substring(0,subDelimiterIndex);
							previousDelimiterIndex+=sub.indexOf(delimiter);
						}
						columnsMap.put(key,col);
					}
					else if(delimiter.contains("?")) {
						delimiter="?";
						String col;
						if(previousDelimiterIndex==-1) {
							col=rawDataMap.get(i).substring(0,rawDataMap.get(i).indexOf(delimiter));
							previousDelimiterIndex=rawDataMap.get(i).indexOf(delimiter);
						}else {
							String sub=rawDataMap.get(i).substring(previousDelimiterIndex+1);
							int subDelimiterIndex=sub.indexOf(delimiter);
							col=sub.substring(0,subDelimiterIndex);
							previousDelimiterIndex+=sub.indexOf(delimiter);
						}
						columnsMap.put(key,col);
					}
					else if(delimiter.contains("*")) {
						delimiter="*";
						String col;
						if(previousDelimiterIndex==-1) {
							col=rawDataMap.get(i).substring(0,rawDataMap.get(i).indexOf(delimiter));
							previousDelimiterIndex=rawDataMap.get(i).indexOf(delimiter);
						}else {
							String sub=rawDataMap.get(i).substring(previousDelimiterIndex+1);
							int subDelimiterIndex=sub.indexOf(delimiter);
							col=sub.substring(0,subDelimiterIndex);
							previousDelimiterIndex+=sub.indexOf(delimiter);
						}
						columnsMap.put(key,col);
					}
					else if(delimiter.contains("/")) {
						delimiter="/";
						String col;
						if(previousDelimiterIndex==-1) {
							col=rawDataMap.get(i).substring(0,rawDataMap.get(i).indexOf(delimiter));
							previousDelimiterIndex=rawDataMap.get(i).indexOf(delimiter);
						}else {
							String sub=rawDataMap.get(i).substring(previousDelimiterIndex+1);
							int subDelimiterIndex=sub.indexOf(delimiter);
							col=sub.substring(0,subDelimiterIndex);
							previousDelimiterIndex+=sub.indexOf(delimiter);
						}
						columnsMap.put(key,col);
					}
					else if(delimiter.contains("_")) {
						delimiter="_";
						String col;
						if(previousDelimiterIndex==-1) {
							col=rawDataMap.get(i).substring(0,rawDataMap.get(i).indexOf(delimiter));
							previousDelimiterIndex=rawDataMap.get(i).indexOf(delimiter);
						}else {
							String sub=rawDataMap.get(i).substring(previousDelimiterIndex+1);
							int subDelimiterIndex=sub.indexOf(delimiter);
							col=sub.substring(0,subDelimiterIndex);
							previousDelimiterIndex+=sub.indexOf(delimiter);
						}
						columnsMap.put(key,col);
					}
					else if(delimiter.contains("-")) {
						delimiter="-";
						String col;
						if(previousDelimiterIndex==-1) {
							col=rawDataMap.get(i).substring(0,rawDataMap.get(i).indexOf(delimiter));
							previousDelimiterIndex=rawDataMap.get(i).indexOf(delimiter);
						}else {
							String sub=rawDataMap.get(i).substring(previousDelimiterIndex+1);
							int subDelimiterIndex=sub.indexOf(delimiter);
							col=sub.substring(0,subDelimiterIndex);
							previousDelimiterIndex+=sub.indexOf(delimiter);
						}
						columnsMap.put(key,col);
					}
					else if(delimiter.contains("n")) {
						delimiter=" ";//incase enter is not identified
						String col;
						if(previousDelimiterIndex==-1) {
							col=rawDataMap.get(i);
							previousDelimiterIndex=-1;
						}else {
							String sub=rawDataMap.get(i).substring(previousDelimiterIndex+2);
							//int subDelimiterIndex=sub.indexOf(delimiter);
							col=sub;
							previousDelimiterIndex=-1;// go to next line
						}
						columnsMap.put(key,col);
					}
				

				keyIndex--;
				
			}
			listConvertedData.add(columnsMap);
		}	
		
		return listConvertedData;
		
	}

    public static void main(String[] args) throws IOException {
    	String[] rawData = Files.readAllLines(new File("C:\\Users\\lt84136\\Downloads\\RawData.dat").toPath()).toArray(new String[0]);
    	String[] inputDML = Files.readAllLines(new File("C:\\Users\\lt84136\\Downloads\\inputDML.dml").toPath()).toArray(new String[0]);
    	String[] outputDML = Files.readAllLines(new File("C:\\Users\\lt84136\\Downloads\\outputDML.dml").toPath()).toArray(new String[0]);
    	String[] xfr = Files.readAllLines(new File("C:\\Users\\lt84136\\Downloads\\XFR.xfr").toPath()).toArray(new String[0]);
    	LinkedHashMap<String,String> delimiterVariableInput= new  LinkedHashMap<String,String>();
    	LinkedHashMap<String,String> delimiterVariableOutput= new  LinkedHashMap<String,String>();
    	
    	//rawDataMap
    	int rawDataItr=0;
    	LinkedHashMap<Integer,String> rawDataMap=new  LinkedHashMap<Integer,String>();
    	for(String line:rawData) {
    		rawDataMap.put(rawDataItr, line);
    		rawDataItr++;
    	}
    	
    	
    	
    	//for input DML delimiters
    	for(int i=0;i<inputDML.length;i++) {
    	    if(i!=0 && i!=inputDML.length-1) {
    	    	int indexOfSpace=inputDML[i].indexOf(" ");
    	    	int indexOfSemicolon=inputDML[i].indexOf(";");
    	    	String delimiter=inputDML[i].substring(0,indexOfSpace);
    	    	String variable=inputDML[i].substring(indexOfSpace+1,indexOfSemicolon);
    	    	delimiterVariableInput.put(variable, delimiter);
    	    }
    	}
    	
    	//converting rawDataMap to arrayList -- Harshit please refer
    	ArrayList< LinkedHashMap<String,String>> inputDataList = convertInputToArrayList(rawDataMap,delimiterVariableInput);
    	ArrayList< LinkedHashMap<String,String>> outputDataList = new ArrayList< LinkedHashMap<String,String>>();
    	
    	//for output DML delimiters
    	for(int i=0;i<outputDML.length;i++) {
    	    if(i!=0 && i!=outputDML.length-1) {
    	    	int indexOfSpace=outputDML[i].indexOf(" ");
    	    	int indexOfSemicolon=outputDML[i].indexOf(";");
    	    	String delimiter=outputDML[i].substring(0,indexOfSpace);
    	    	String variable=outputDML[i].substring(indexOfSpace+1,indexOfSemicolon);
    	    	delimiterVariableOutput.put(variable, delimiter);
    	    }
    	}
    	
    	//for XFR --Harshit
    	 LinkedHashMap<String,String> xfrMap= new  LinkedHashMap<String,String>();
    	 XFR xfrObj = new XFR();
    	int i=0;
    	while(i<xfr.length) {
    	    if(xfr[i].contains("out")){
    	    	if(xfr[i].contains("reformat")||xfr[i].contains("rollup")||xfr[i].contains("join")) {
    	    	xfrObj.solve(xfr,i,outputDataList,inputDataList);
    	    	}
    	    	i++; //increment i after each transformation function in XFR
    	}
    	
    	}
    	
    	
    	
    }
}
