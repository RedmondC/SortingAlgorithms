import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *			10	100	1000	FewUniq NearSort Reversed Sorted
 	Insertion	8980	94939	4799974	3402120	27940	295080	1425
	Select		6842	117034	2445033	1441760	591942	1414176	264575
	Quick		12829	27808	377318	123734	122879	975767	443333
	Merg(It)	11690	52458	567513	196813	177126	169984	155984
	Merge(Re)	20098	86985	751535	158231	125577	163748	157426
 
 *	a. Which of the sorting algorithms does the order of input have an impact on? Why?
 		All of them. Every sorting algorithm is impacted by the size of n the only difference is to what degree, this is due to 
		all sortign algorithms necessarily look at all elements of the array being sorted, thus the magnitude will always have 
		an impact.
 * 	b. Which algorithm has the biggest difference between the best and worst performance, based
 *	on the type of input, for the input of size 1000? Why?
 		Insertion Sort was the most affected by the change in data input this is a biproduct of insertion sort placing a single 
		element each time, this sorting algorithm works perfectly for almost sorted arrays but struggles with large unsorted 
		arrays.
 *	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
 *	based on the input size? Please consider only input files with random order for this answer.
 *		For the worst scalability Insertion sort is the clear winner (or loser in this case) as again it is only 
 *		placing a single element and unlike selection sort it does not have a growing finished arrray at the beginning of the
 * 		sorting array thus making it (in my test) 2 times slower.
 * 		For the best scalability Quick sort was my winner as it has a low worst case running time and is efficient at all 
 *		sizes assuming the array is randomly sorted.
 *	d. Did you observe any difference between iterative and recursive implementations of merge
 *	sort?
 *		I found that the iterative approach worked faster for normally randomised arrays. For nearly ordered and few unique
 		merge sort iterative seriously lagged behind its recursive counterpart. I then observed no considerable winner in my 
		reverse order and sorted test files.
 *	e. Which algorithm is the fastest for each of the 7 input files?
 *		1. Select
 *		2. Quick
 *		3. Quick
 * 		4. Quick
 *		5. Insertion
 *		6. Insertion
 *		7. Insertion
 *		
 *  @author Colin Redmond 18319775
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ......................................................

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    @Test
    public void testInsertS()
    {
    	double[] testStringArray = new double[5];
    	testStringArray[0] = 2.7;
    	testStringArray[1] = 3;
    	testStringArray[2] = 6;
	 	testStringArray[3] = 6.9;
	 	testStringArray[4] = 1;
	 	assertTrue(Arrays.equals(new double[] {1,2.7,3,6,6.9}, SortComparison.insertionSort(testStringArray)));
	 	
    	testStringArray[0] = 200.7;
    	testStringArray[1] = 36;
    	testStringArray[2] = 7;
	 	testStringArray[3] = 4.21;
	 	testStringArray[4] = 1.1;
	 	assertTrue(Arrays.equals(new double[] {1.1,4.21,7,36,200.7}, SortComparison.insertionSort(testStringArray)));
    }
    @Test
    public void testSelectS()
    {
    	double[] testStringArray = new double[5];
    	testStringArray[0] = 2.7;
    	testStringArray[1] = 3;
    	testStringArray[2] = 6;
	 	testStringArray[3] = 6.9;
	 	testStringArray[4] = 1;
	 	assertTrue(Arrays.equals(new double[] {1,2.7,3,6,6.9}, SortComparison.selectionSort(testStringArray)));
	 	
    	testStringArray[0] = 200.7;
    	testStringArray[1] = 36;
    	testStringArray[2] = 7;
	 	testStringArray[3] = 4.21;
	 	testStringArray[4] = 1.1;
	 	assertTrue(Arrays.equals(new double[] {1.1,4.21,7,36,200.7}, SortComparison.selectionSort(testStringArray)));
    }
    @Test
    public void testQuickS()
    {
    	double[] testStringArray = new double[5];
    	testStringArray[0] = 2.7;
    	testStringArray[1] = 3;
    	testStringArray[2] = 6;
	 	testStringArray[3] = 6.9;
	 	testStringArray[4] = 1;
	 	assertTrue(Arrays.equals(new double[] {1,2.7,3,6,6.9}, SortComparison.quickSort(testStringArray)));
	 	
    	testStringArray[0] = 200.7;
    	testStringArray[1] = 36;
    	testStringArray[2] = 7;
	 	testStringArray[3] = 4.21;
	 	testStringArray[4] = 1.1;	
	 	assertTrue(Arrays.equals(new double[] {1.1,4.21,7,36,200.7}, SortComparison.quickSort(testStringArray)));
    }
    @Test
    public void testMergeItS()
    {
    	double[] testStringArray = new double[5];
    	testStringArray[0] = 2.7;
    	testStringArray[1] = 3;
    	testStringArray[2] = 6;
	 	testStringArray[3] = 6.9;
	 	testStringArray[4] = 1;
	 	assertTrue(Arrays.equals(new double[] {1,2.7,3,6,6.9}, SortComparison.mergeSortIterative(testStringArray)));
	 	
    	testStringArray[0] = 200.7;
    	testStringArray[1] = 36;
    	testStringArray[2] = 7;
	 	testStringArray[3] = 4.21;
	 	testStringArray[4] = 1.1;
	 	assertTrue(Arrays.equals(new double[] {1.1,4.21,7,36,200.7}, SortComparison.mergeSortIterative(testStringArray)));
    }
    @Test
    public void testMergeReS()
    {
    	double[] testStringArray = new double[5];
    	testStringArray[0] = 2.7;
    	testStringArray[1] = 3;
    	testStringArray[2] = 6;
	 	testStringArray[3] = 6.9;
	 	testStringArray[4] = 1;
	 	assertTrue(Arrays.equals(new double[] {1,2.7,3,6,6.9}, SortComparison.mergeSortRecursive(testStringArray)));
	 	
    	testStringArray[0] = 200.7;
    	testStringArray[1] = 36;
    	testStringArray[2] = 7;
	 	testStringArray[3] = 4.21;
	 	testStringArray[4] = 1.1;
	 	assertTrue(Arrays.equals(new double[] {1.1,4.21,7,36,200.7}, SortComparison.mergeSortRecursive(testStringArray)));
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {

    	double[] testStringArray = null;
    	assertEquals("Checking an empty array insertionSort", null, SortComparison.insertionSort(testStringArray));
    	assertEquals("Checking an empty array quickSort", null, SortComparison.quickSort(testStringArray));
    	assertEquals("Checking an empty array mergeSortIterative", null, SortComparison.mergeSortIterative(testStringArray));
    	assertEquals("Checking an empty array mergeSortRecursive", null, SortComparison.mergeSortRecursive(testStringArray));
    	assertEquals("Checking an empty array selectionSort", null, SortComparison.selectionSort(testStringArray));
    }
    
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
    	String[] inputFiles = {"numbers10.txt",
				    			"numbers100.txt",
				    			"numbers1000.txt",
				    			"numbers1000Duplicates.txt",
				    			"numbersNearlyOrdered1000.txt",
				    			"numbersReverse1000.txt",
				    			"numbersSorted1000.txt"};
		
    	for(int i = 0; i < inputFiles.length; i++) {
    		double[] doubles = SortComparison.getDoubles(inputFiles[i]);
    		
    		long start = System.nanoTime();
    		SortComparison.insertionSort(doubles);
    		long end = System.nanoTime();
    		System.out.println("Insertion Sort test " + inputFiles[i] + " ran in " + (end-start));
    		
    	}
    	System.out.println();
    	
    	for(int i = 0; i < inputFiles.length; i++) {
    		double[] doubles = SortComparison.getDoubles(inputFiles[i]);
    		
    		long start = System.nanoTime();
    		SortComparison.selectionSort(doubles);
    		long end = System.nanoTime();
    		System.out.println("Selection Sort test " + inputFiles[i] + " ran in " + (end-start));
    		
    	}
    	System.out.println();
    	
    	for(int i = 0; i < inputFiles.length; i++) {
    		double[] doubles = SortComparison.getDoubles(inputFiles[i]);
    		
    		long start = System.nanoTime();
    		SortComparison.quickSort(doubles);
    		long end = System.nanoTime();
    		System.out.println("Quick Sort test " + inputFiles[i] + " ran in " + (end-start));
    		
    	}
    	
    	System.out.println();
    	
    	for(int i = 0; i < inputFiles.length; i++) {
    		double[] doubles = SortComparison.getDoubles(inputFiles[i]);
    		
    		long start = System.nanoTime();
    		SortComparison.mergeSortIterative(doubles);
    		long end = System.nanoTime();
    		System.out.println("Merge (It) Sort test " + inputFiles[i] + " ran in " + (end-start));
    		
    	}
    	System.out.println();
    	
    	for(int i = 0; i < inputFiles.length; i++) {
    		double[] doubles = SortComparison.getDoubles(inputFiles[i]);
    		
    		long start = System.nanoTime();
    		SortComparison.mergeSortRecursive(doubles);
    		long end = System.nanoTime();
    		System.out.println("Merge (Re) Sort test " + inputFiles[i] + " ran in " + (end-start));

    	}
    	System.out.println();
        
    }

}
