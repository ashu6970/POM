package com.qa.base;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;





public class RandomString {
	
	/*public static void givenList_whenNumberElementsChosen_shouldReturnRandomElementsNoRepeat() {
	    Random rand = new Random();
	    List<String> givenList = Lists.newArrayList("/home/fourtek/Downloads/File Format/strings.po", "/home/fourtek/Downloads/File Format/wow_calendar.xml", "three", "four");
	 
	    int numberOfElements = 1;
	 
	    for (int i = 0; i < numberOfElements; i++) {
	        int randomIndex = rand.nextInt(givenList.size());
	        String randomElement = givenList.get(randomIndex);
	        System.out.println(randomElement);
	       
	    }
	    }*/

	public static String local(String location)
	{
		System.out.println(location);	
		return location;
	}
	
	public static void main(String[] args) {
		
		RandomString r =new RandomString();
		Random rand = new Random();
	    List<String> givenList = Lists.newArrayList("/home/fourtek/Downloads/File Format/strings.po", "/home/fourtek/Downloads/File Format/wow_calendar.xml", "three", "four");
	 
	    int numberOfElements = 1;
	 
	    for (int i = 0; i < numberOfElements; i++) {
	        int randomIndex = rand.nextInt(givenList.size());
	        String randomElement = givenList.get(randomIndex);
	        RandomString.local(String.valueOf(randomElement));
	}
	}
	}


