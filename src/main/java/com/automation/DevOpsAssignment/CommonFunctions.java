package com.automation.DevOpsAssignment;

import java.util.Random;

import org.testng.annotations.Test;

public class CommonFunctions {

	public static int randomNumber() {
		Random objGenerator = new Random();
		int randomNumber = objGenerator.nextInt(100000);
		System.out.println("Random No : " + randomNumber);
		return randomNumber;
	}

}
