package com.company;

import java.util.Random;

public class Util {
	
	public static int [] createRandomArray(int length) {
		  int n =length;
	      int[] array = new int[n];
	      Random r = new Random(length);
	      for(int i =0;i<length;i++){
	        array[i] = r.nextInt(100)+1;
	      }
	      return array;
	}

}
