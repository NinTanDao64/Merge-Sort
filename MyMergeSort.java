/* HW 10 
   The following program is the class definition for a MyMergeSort object that
   uses a recursive divide and conquer algorithm to sort an array of numbers.
   Student: Tan Dao
   Class: CSC 130 (Tues/Thurs 10:30-11:45AM)
*/

import java.util.*;
import java.io.*;

public class MyMergeSort {
    
    //API declarations
    private double[] array;
    private double[] tempArray;
    private int length;
    
    //Main program
    public static void main(String args[]){
        //Prompts user for amount of numbers to populate into the array, then
        //creates an array of that size
        Scanner console = new Scanner(System.in);
        System.out.print("How many numbers would you like to sort? ");
        int numberOfNums = console.nextInt(); 
        double[] inputArr = new double[numberOfNums];
        
        //Populates the array
        for(int i = 0; i < numberOfNums; i++) {
            System.out.print("Enter a value to be inserted into index " + i + ": ");
            inputArr[i] = console.nextInt();
        }
        
        //Sorts the array using merge sort, then prints the sorted result as well
        //as the median value
        MyMergeSort mms = new MyMergeSort();
        mms.sort(inputArr);
        System.out.print("The sorted result is: ");
        for(double i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        double median = median(inputArr, numberOfNums);
        System.out.print("The median is: " + median);
    }
    
    //Performs a merge sort on the MyMergeSort object 
    public void sort(double inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempArray = new double[length];
        doMergeSort(0, length - 1);
    }
    
    //Recursively sorts left and right halves of the array separately, then merges them 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    
    //Method to merge both halves into a sorted array
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempArray[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        //Empty out remaining numbers in both left and right halves
        while (i <= middle) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
 
    }
    
    //Method to calculate median
    public static double median(double[] data, int size) {
       double evenMedian1;
       double evenMedian2;
       if (size % 2 == 0) {
            evenMedian1 = data[data.length / 2];
            evenMedian2 = data[(data.length / 2) - 1];
            return (evenMedian1 + evenMedian2) / 2;
       } else {
            return data[data.length / 2];
       }
    }
}