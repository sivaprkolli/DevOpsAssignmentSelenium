package com.automation.DevOpsAssignment;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class CommonFunctions {

	public static int randomNumber() {
		Random objGenerator = new Random();
		int randomNumber = objGenerator.nextInt(100000);
		System.out.println("Random No : " + randomNumber);
		return randomNumber;
	}
	
	public static String formatAsTable(List<List<String>> rows)
	{
	    int[] maxLengths = new int[rows.get(0).size()];
	    for (List<String> row : rows)
	    {
	        for (int i = 0; i < row.size(); i++)
	        {
	            maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
	        }
	    }

	    StringBuilder formatBuilder = new StringBuilder();
	    for (int maxLength : maxLengths)
	    {
	        formatBuilder.append("%-").append(maxLength + 2).append("s");
	    }
	    String format = formatBuilder.toString();

	    StringBuilder result = new StringBuilder();
	    for (List<String> row : rows)
	    {
	        result.append(String.format(format, row.toArray(new String[0]))).append("\n");
	    	//result.append(row.toArray(new String[0])).append("\n");
	    }
	    return result.toString();
	}

}
