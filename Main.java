/**
 * MergeSort java implementation
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {159, 170, 141, 165, 119, 169, 102, 195, 142, 142};

        // Call merge sort
        int[] nums = mergeSort(arr);

        // Print out result to console
        for (int num: nums) {
            System.out.print(num + " ");
        }
        
    } // end main
    
    // Mergesort will be called recursively until divided into one element per array
    static int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;

        int middleIndex = arr.length/2;

        int[] leftArray = Arrays.copyOfRange(arr, 0, middleIndex);
        int[] rightArray = Arrays.copyOfRange(arr, middleIndex, arr.length);

        return merge(mergeSort(leftArray), mergeSort(rightArray));
    } // end mergeSort


    // Merge sorted arrays
    static int[] merge(int[] leftArr, int[] rightArr) {
        int[] merged = new int[leftArr.length+rightArr.length];
        int mergedIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                merged[mergedIndex] = leftArr[leftIndex];
                leftIndex++;
            } else {
                merged[mergedIndex] = rightArr[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        // Add remaining elements to the array
        if (leftIndex == leftArr.length) {
            for (int i = rightIndex; i < rightArr.length; i++) {
                merged[mergedIndex++] = rightArr[i];
            }
        } else {
            for (int i = leftIndex; i < leftArr.length; i++) {
                merged[mergedIndex++] = leftArr[i];
            }
        }

        // Return sorted and merged array
        return merged;

    } // end merge


} // end class