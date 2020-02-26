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
