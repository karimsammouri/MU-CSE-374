package main;

import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 * This class implements the methods specified as per the assignment document.
 * @author Karim Sammouri
 */
public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Observing mystery()'s time complexity:");
		int[] array1 = new int[0];
		System.out.println(array1.length + ": " + mystery(array1));
		int[] array2 = new int[500];
		System.out.println(array2.length + ": " + mystery(array2));
		int[] array3 = new int[1000];
		System.out.println(array3.length + ": " + mystery(array3));
		int[] array4 = new int[1500];
		System.out.println(array4.length + ": " + mystery(array4));
		int[] array5 = new int[2000];
		System.out.println(array5.length + ": " + mystery(array5));
		int[] array6 = new int[2500];
		System.out.println(array6.length + ": " + mystery(array6));
		int[] array7 = new int[3000];
		System.out.println(array7.length + ": " + mystery(array7));
		int[] array8 = new int[3500];
		System.out.println(array8.length + ": " + mystery(array8));
		int[] array9 = new int[4000];
		System.out.println(array9.length + ": " + mystery(array9));
		int[] array10 = new int[4500];
		System.out.println(array10.length + ": " + mystery(array10));
		int[] array11 = new int[5000];
		System.out.println(array11.length + ": " + mystery(array11));
		int[] array12 = new int[5500];
		System.out.println(array12.length + ": " + mystery(array12));
		int[] array13 = new int[6000];
		System.out.println(array13.length + ": " + mystery(array13));
		int[] array14 = new int[6500];
		System.out.println(array14.length + ": " + mystery(array14));
		int[] array15 = new int[7000];
		System.out.println(array15.length + ": " + mystery(array15));
		int[] array16 = new int[7500];
		System.out.println(array16.length + ": " + mystery(array16));
		int[] array17 = new int[8000];
		System.out.println(array17.length + ": " + mystery(array17));
		int[] array18 = new int[8500];
		System.out.println(array18.length + ": " + mystery(array18));
		int[] array19 = new int[9000];
		System.out.println(array19.length + ": " + mystery(array19));
		int[] array20 = new int[9500];
		System.out.println(array20.length + ": " + mystery(array20));
		int[] array21 = new int[10000];
		System.out.println(array21.length + ": " + mystery(array21));
	}

	// As the number of elements grow incrementally, the number of times the loop 
	//runs seems to grow in a quadratic fashion. So the theta of Mystery seems to 
	//be in the order of x^2 (O(x^2)).
	//
	// Looking at the code, one would expect it to have a time complexity of theta 
	//of n because of the single loop. However, looking deeper, one would realize 
	//that the code actually behaves as if it had a double loop (Θ(n^2)). The code 
	//simulates a double loop by keeping two index variables, one (i) that keeps track 
	//of the element the for loop is on and another (index) that keeps track of 
	//every subsequent element after that. The code achieves this by incrementing the "i"
	//variable only when "index" reaches the end of the array, thus simulating an outer and 
	//an inner nested loop with one loop.
	
	public static ImmutablePair<Boolean, Integer> mystery(int[] array) {
		int count = 0;
		int index = 1;
		boolean answer = true;
		for (int i = 0; i < array.length - 1;) {
			count++;
			if (index == array.length) {
				i = i + 1;
				index = i + 1;
			} else {
				if (array[i] >= array[index])
					answer = false;
				index = index + 1;
			}
		}
		ImmutablePair<Boolean, Integer> result = new ImmutablePair<>(answer,
				count);
		return result;
	}

	public static int trickyhobbitses(int[] array) {
		int count = 0;
		int index1 = 1;
		int index2 = 2;
		for (int i = 0; i < array.length - 1;) {
			count++;
			if (index1 == array.length) {
				i = i + 1;
				index1 = i + 1;
				index2 = index1 + 1;
			} else if (index2 == array.length) {
				index1 = index1 + 1;
				index2 = index1 + 1;
			} else {
				index2 = index2 + 1;
			}
		}
		return count;
	}
}
