package com.revature.collection3;

import java.util.ArrayList;
import java.util.Iterator;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for(int i = 0; i < 5; i++) {
			arrayList.add(i);
		}
		
		Iterator<Integer> itr = arrayList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
