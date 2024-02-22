package CollectionsExercise.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main ( String[] args ) {
        int[] toSort = {1,-5,0,12, 543,908, -9, -6, 6598};
        printArr(toSort);
    }

    public static void quickSort ( int[] array, int leftInd, int rightInd ) {
        int pivot = array[rightInd];
        int leftPointer = leftInd;
        int rightPointer = rightInd;

        while(leftPointer < rightPointer)
        {
            while(array[leftPointer] <= pivot && leftPointer < rightPointer)
            {
                leftPointer++;
            }
            while(array[rightPointer] >= pivot && leftPointer < rightPointer)
            {
                rightPointer++;
            }
            swap(array,leftPointer, rightPointer);
        }
        swap(array, leftPointer, rightInd);
        quickSort(array, leftInd, leftPointer - 1);
        quickSort(array, leftPointer + 1, leftPointer - 1);
    }
    private static void swap (int[] array, int ind1, int ind2)
    {
        int temp;
        temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

    public static void printArr ( int[] array ) {
        for(int i:array)
        {
            System.out.print(i + " ");
        }
    }
}
