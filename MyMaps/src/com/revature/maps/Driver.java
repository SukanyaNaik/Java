package com.revature.maps;

import java.util.HashMap;
import java.util.Map;

public class Driver {

	public static void main(String[] args) {
		HashMap<String, String> dictionary = new HashMap<String, String>();

		dictionary.put("Outgoing", "Extroverted in nature");
		dictionary.put("Intelligient", "Sharp witted");
		dictionary.put("Timid", "Introverted in nature");
		dictionary.put("Shy", "Introverted in nature");
		dictionary.put("Intelligient", "Smart");
		String str = dictionary.put("Outgoing", "Bold");
		
		System.out.println("Str = " + str);
		System.out.println(dictionary);
		
		// HashMap will have no particular order
		// LinkedMap will maintain order (of insertion)
		// TreeMap will sort KEYS by natural order (alphabetically for Strings)
		
		System.out.println("The Keys are - ");
		for(String word : dictionary.keySet()) {
			System.out.println(word);
		}
		System.out.println("\n");
		System.out.println("The Values are - ");
		for(String word : dictionary.values()) {
			System.out.println(word);
		}
		System.out.println("\n");
		for(Map.Entry<String, String> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue() + "\n");
		}
		
		System.out.println("\nSize = " + dictionary.size());
			
	}

}
