package com.ding;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class StringDup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringDup stringDup = new StringDup();
		stringDup.getMax("dingdingsss");
	}
	
	public char getMax2(String param0){
		ArrayList<Character> characters = new ArrayList<Character>();
		ArrayList<Integer> integers = new ArrayList<Integer>();
		for(int i=0; i < param0.length(); ++i){
			Character singleChar = param0.charAt(i);
			int keyIndex = getKey(characters, singleChar);
			if(keyIndex < 0){
				characters.add(singleChar);
				integers.add(1);
			}
			else{
				Integer currentValue = integers.get(keyIndex);
				currentValue++;
				integers.add(keyIndex, currentValue);
			}
				
				
		}
		
		Character maxChar = null;
		Integer maxNumber=0;
		for(int i =0; i < characters.size(); ++i){
			if(integers.get(i) > maxNumber){
				maxNumber = integers.get(i);
				maxChar = characters.get(i);
			}
		}
		
		return maxChar;
	}
	
	private int getKey(ArrayList<Character> characters,Character character){
		for(int i =0; i < characters.size(); ++i){
			if(characters.get(i).equals(characters)){
				return i;
			}
		}
		
		return -1;
	}
	
	public char getMax(String param0){
		HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();
		ArrayList<Character> characters = new ArrayList<Character>();
		ArrayList<Integer> intergers = new ArrayList<Integer>();
		for(int i=0; i < param0.length(); ++i){
			Character singleChar = param0.charAt(i);
			if(charCounts.containsKey(singleChar)){
				Integer value = charCounts.get(singleChar);
				value++;
				charCounts.put(singleChar, value);
			}
			else{
				charCounts.put(singleChar, 1);
			}
		}
		
		Character maxChar = null;
		Integer maxNumber=0;
		Iterator<Character> iterator = charCounts.keySet().iterator();
		while(iterator.hasNext()){
			Character singleChar = (Character) iterator.next();
			Integer value = charCounts.get(singleChar);
			if(value > maxNumber){
				maxNumber = value;
				maxChar = singleChar;
			}			
		}
		
		
		return maxChar;
		
	}

}
