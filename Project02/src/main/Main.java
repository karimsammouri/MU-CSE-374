package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import structures.DoublingArray;
import structures.IncrementalArray;
import structures.RemovalArray;
import structures.StopWatch;
import structures.SwappyArray;

/**
 * This class implements several static methods as per the specifications.
 * @author Karim Sammouri
 */
public class Main {

	public static void main(String[] args) {

//		RemovalArray<Integer> array1 = new IncrementalArray<>();
//		runExperiments(array1, "incremental.csv");
//
//		RemovalArray<Integer> array2 = new DoublingArray<>();
//		runExperiments(array2, "doubling.csv");
//
//		swappyArrayTest();
//
//		RemovalArray<Integer> array3 = new DoublingArray<>();
//		runExperiments2(array3, "doublingRemove.csv");
//		RemovalArray<Integer> array4 = new SwappyArray<>();
//		runExperiments2(array4, "swappyRemove.csv");
//
//		List<Integer> L = new LinkedList<>();
//		runExperiments3(L, "linkedList.csv");
//		List<Integer> L2 = new ArrayList<>();
//		runExperiments3(L2, "arrayList.csv");
	}

	//-----------------------------------------------------------------------
	// The following three methods are for section 2 of the specifications:
	
	/**
	 * Adds the numbers 1 to n to the given array.
	 * @param array Array into which to add numbers.
	 * @param n Upper bound of series of numbers.
	 */
	public static void addToArray(RemovalArray<Integer> array, int n) {
		for (int i = 1; i <= n; i++) {
			array.add(i);
		}
	}
	
	/**
	 * Measures how long it will take to add numbers 1 to n to the given array.
	 * @param array Array into which to add numbers.
	 * @param n Upper bound of series of numbers.
	 * @return Elapsed time during addition of numbers.
	 */
	public static double measureTime(RemovalArray<Integer> array, int n) {
		StopWatch watch = new StopWatch();
		addToArray(array, n);
		return watch.elapsedTime();
	}
	
	/**
	 * Runs ten trials of addition experiment to compare performance of IncrementalArray against DoublingArray as per the specifications.
	 * @param array Initial array to be used.
	 * @param fileName File onto which to write the results.
	 */
	public static void runExperiments(RemovalArray<Integer> array,
			String fileName) {
		String results[][] = new String[20][11];
		// Store results of trial in two dimensional array.
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				if (i == 0) {
					results[j][0] = ((j + 1) * 20000) + "";
				}
				// Run experiment and store result.
				results[j][i + 1] = measureTime(array, 20000) + "";
			}
			// Create new array for every trial.
			if (array instanceof IncrementalArray) {
				array = new IncrementalArray<Integer>();
			} else if (array instanceof DoublingArray) {
				array = new DoublingArray<Integer>();
			}
		}
		// Print results stored in two dimensional array to file.
		File file = new File(fileName);
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			for (String[] x : results) {
				for (String y : x) {
					writer.append(y + ",");
				}
				writer.append("\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//-----------------------------------------------------------------------
	// The following four methods are for section 3 of the specifications:
	
	/**
	 * Test for SwappyArray as requested by the specifications.
	 */
	public static void swappyArrayTest() {
		SwappyArray<Integer> array = new SwappyArray<>();
		array.array = new Object[]{4, 6, 2, 9, 10, 12, 13, 15};
		System.out.println(array);
		array.size = 8;
		System.out.println(array.remove(4));
		System.out.println(array);
		System.out.println(array.remove(0));
		System.out.println(array);
		System.out.println(array.remove(5));
		System.out.println(array);
		System.out.println(array.size);
		System.out.println(array.remove(5));
		System.out.println(array);
		System.out.println(array.size);
	}
	
	/**
	 * Removes every element from the given array until it's empty.
	 * @param array Array whose elements to remove.
	 */
	public static void removeFromArray(RemovalArray<Integer> array) {
		boolean flag = true;
		while (flag) {
			flag = array.remove(0);
		}
	}

	/**
	 * Measures how long it will take to remove all the elements from the given array.
	 * @param array Array whose elements to remove.
	 * @return Elapsed time during removal of elements.
	 */
	public static double measureTime2(RemovalArray<Integer> array) {
		StopWatch watch = new StopWatch();
		removeFromArray(array);
		return watch.elapsedTime();
	}
	
	/**
	 * Runs ten trials of removal experiment to compare performance of DoublingArray against SwappyArray as per the specifications.
	 * @param array Initial array to be used.
	 * @param fileName File onto which to write the results.
	 */
	public static void runExperiments2(RemovalArray<Integer> array,
			String fileName) {
		String results[][] = new String[20][11];
		// Store results of trials in two dimensional array.
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				if (i == 0) {
					results[j][0] = Math.pow(j + 1, 3) + "";
				}
				// If array is SwappyArray, use DoublingArray to add elements to SwappyArray as SwappyArray has no add() method.
				if (array instanceof SwappyArray) {
					RemovalArray<Integer> temp = new DoublingArray<>();
					addToArray(temp, (int) Math.pow(j + 1, 3));
					// After adding elements to temporary DoublingArray, set array variable of SwappyArray to be array of DoublingArray, which is filled with elements.
					((SwappyArray<Integer>)array).array = ((DoublingArray<Integer>)temp).array;
				} else if (array instanceof DoublingArray) {
					addToArray(array, (int) Math.pow(j + 1, 3));
				}
				// Run experiment and store result.
				results[j][i + 1] = measureTime2(array) + "";
			}
			// Create new array for every trial.
			if (array instanceof DoublingArray) {
				array = new DoublingArray<Integer>();
			} else if (array instanceof SwappyArray) {
				array = new SwappyArray<Integer>();
			}
		}
		// Print results stored in two dimensional array to file.
		File file = new File(fileName);
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			for (String[] x : results) {
				for (String y : x) {
					writer.append(y + ",");
				}
				writer.append("\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//-----------------------------------------------------------------------
	// The following four methods are for section 4 of the specifications:
	
	/**
	 * Returns the sum of the elements in a list.
	 * @param L List to traverse.
	 * @return Sum of the elements in a list.
	 */
	public static int getSum(List<Integer> L) {
		int total = 0;
		for (int i = 0; i < L.size(); i++)
			total += L.get(i);
		return total;
	}

	/**
	 * Measures how long it will take to get sum of the elements of a given List.
	 * @param L List whose elements to traverse.
	 * @return Elapsed time during traversing of elements.
	 */
	public static double measureTime3(List<Integer> L) {
		StopWatch watch = new StopWatch();
		getSum(L);
		return watch.elapsedTime();
	}
	
	/**
	 * Adds the numbers 1 to n to the given List.
	 * @param L List into which to add numbers.
	 * @param n Upper bound of series of numbers.
	 */
	public static void addToList(List<Integer> L, int n) {
		for (int i = 1; i <= n; i++) {
			L.add(i);
		}
	}
	
	/**
	 * Runs ten trials of getSum() experiment to compare performance of LinkedList against ArrayList as per the specifications.
	 * @param L Initial List to be used.
	 * @param fileName File onto which to write the results.
	 */
	public static void runExperiments3(List<Integer> L,
			String fileName) {
		String results[][] = new String[20][11];
		// Store results of trials in two dimensional array.
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				if (i == 0) {
					results[j][0] = ((j + 1) * 10000) + "";
				}
				addToList(L, 10000);
				// Run experiment and store result.
				results[j][i + 1] = measureTime3(L) + "";
			}
			// Create new List for every trial.
			if (L instanceof LinkedList) {
				L = new LinkedList<Integer>();
			} else if (L instanceof ArrayList) {
				L = new ArrayList<Integer>();
			}
		}
		// Print results stored in two dimensional array to file.
		File file = new File(fileName);
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			for (String[] x : results) {
				for (String y : x) {
					writer.append(y + ",");
				}
				writer.append("\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}