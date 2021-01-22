package com.qa.opencart.utils;

import java.util.Random;

public class GeneralUtil
{
	
	public static int getRandomNumber_Email()
	{
		int max = Constants.MAX_LIMIT_OF_RANDOM_NUMBER_EMAIL;
		Random rnd = new Random();
		int RN = rnd.nextInt(max);
		return RN;
	}
	
	public static int getRandomNumber_Phone()
	{
		int max = Constants.MAX_LIMIT_OF_RANDOM_NUMBER_PHONE;
		Random rnd = new Random();
		int RN = rnd.nextInt(max);
		return RN;
	}
}
