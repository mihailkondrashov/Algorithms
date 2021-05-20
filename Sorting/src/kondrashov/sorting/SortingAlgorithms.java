package kondrashov.sorting;

import java.util.*;

public class SortingAlgorithms <E extends Comparable<E>>{

    /**
     * Bubble sorting algorithm
     * @param array Source array
     * @param sortingType Type of sorting (Ascending or Descending)
     */
    public void bubbleSort(E[] array, SortingType sortingType){
        boolean needSorting = true;
        if(sortingType.equals(SortingType.Ascending)){
            while(needSorting) {
                needSorting = false;
                for (int i = 1; i < array.length; i++) {
                    int resultCompare = array[i].compareTo(array[i - 1]);
                    if (resultCompare < 0) {
                        swap(array, i - 1, i);
                        needSorting = true;
                    }
                }
            }
        }
        else{
            while(needSorting) {
                needSorting = false;
                for (int i = 1; i < array.length; i++) {
                    int resultCompare = array[i].compareTo(array[i - 1]);
                    if (resultCompare > 0) {
                        swap(array, i - 1, i);
                        needSorting = true;
                    }
                }
            }
        }
    }

    /**
     * Selection sorting algorithm
     * @param array Source array
     * @param sortingType Type of sorting (Ascending or Descending)
     */
    public void selectionSort(E[] array, SortingType sortingType){
        if(sortingType.equals(SortingType.Ascending)){
            for (int sortedIndex = 0; sortedIndex < array.length; sortedIndex++){
                int min = min(array, sortedIndex, array.length);
                swap(array, sortedIndex, min);
            }
        }
        else{
            for (int sortedIndex = 0; sortedIndex < array.length; sortedIndex++){
                int max = max(array, sortedIndex, array.length);
                swap(array, sortedIndex, max);
            }
        }
    }

    /**
     * Insertion sorting algorithm
     * @param array Source array
     * @param sortingType Type of sorting (Ascending or Descending)
     */
    public void insertionSort(E[] array, SortingType sortingType){
        if(sortingType.equals(SortingType.Ascending)) {
            for (int i = 1; i < array.length; i++) {
                int j = i;
                E value = array[i];
                while(j > 0 && value.compareTo(array[j-1]) < 0){
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = value;
            }
        }
        else{
            for (int i = 1; i < array.length; i++) {
                int j = i;
                E value = array[i];
                while(j > 0 && value.compareTo(array[j-1]) > 0){
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = value;
            }
        }
    }

    /**
     * Merge sorting algorithm
     * @param array Source array
     * @param sortingType Type of sorting (Ascending or Descending)
     */
    public void mergeSort(int[] array, SortingType sortingType){
        if(array != null){
            int[] resultArray = mergeSortImpl(array, sortingType);
            System.arraycopy(resultArray, 0 ,array, 0 , array.length);
        }
        else{
            throw new IllegalArgumentException("Array should not be null");
        }
    }

    /**
     * Merge sorting algorithm
     * @param array Source array
     * @param sortingType Type of sorting (Ascending or Descending)
     * @return Sorting array
     */
    private int[] mergeSortImpl(int[] array, SortingType sortingType) {
        if(array.length > 1){
            int divider = (array.length)/2;
            int[] leftArray = new int[divider];
            int[] rightArray = new int [array.length - divider];
            System.arraycopy(array,0,leftArray,0,divider);
            System.arraycopy(array,divider,rightArray,0,array.length - divider);

            leftArray = mergeSortImpl(leftArray, sortingType);
            rightArray = mergeSortImpl(rightArray, sortingType);
            return mergeArrays(leftArray, rightArray, sortingType);
        }
        return array;
    }

    /**
     * Merging two arrays
     * @param firstArray First Array
     * @param secondArray Second array
     * @param sortingType Type of sorting (Ascending or Descending)
     * @return Merged array
     */
    private int[] mergeArrays(int[] firstArray, int[] secondArray, SortingType sortingType) {
        int flagLeftArray = 0;
        int flagRightArray = 0;
        int [] resultArray = new int [(firstArray.length+secondArray.length)];
        for(int i = 0; i < resultArray.length; i++){
            if(sortingType.equals(SortingType.Ascending)){
                if((flagLeftArray < firstArray.length && flagRightArray < secondArray.length && firstArray[flagLeftArray] < secondArray[flagRightArray]) || flagRightArray == secondArray.length){
                    resultArray[i] = firstArray[flagLeftArray];
                    flagLeftArray++;
                }
                else if((flagRightArray < secondArray.length && flagLeftArray < firstArray.length && firstArray[flagLeftArray] > secondArray[flagRightArray]) || flagLeftArray == firstArray.length){
                    resultArray[i] = secondArray[flagRightArray];
                    flagRightArray++;
                }
            }
            else{
                if((flagLeftArray < firstArray.length && flagRightArray < secondArray.length && firstArray[flagLeftArray] > secondArray[flagRightArray]) || flagRightArray == secondArray.length){
                    resultArray[i] = firstArray[flagLeftArray];
                    flagLeftArray++;
                }
                else if((flagRightArray < secondArray.length && flagLeftArray < firstArray.length && firstArray[flagLeftArray] < secondArray[flagRightArray]) || flagLeftArray == firstArray.length){
                    resultArray[i] = secondArray[flagRightArray];
                    flagRightArray++;
                }
            }
        }
        return resultArray;
    }

    /**
     * Quick sorting algorithm
     * @param array Source array
     * @param sortingType Type of sorting (Ascending or Descending)
     */
    public void quickSort(E[] array, SortingType sortingType){
        if(array!=null){
            quickSortImpl(array, 0 , array.length-1, sortingType);
        }
        else{
            throw new IllegalArgumentException("Array should not be null");
        }
    }

    /**
     * Quick Sorting algorithm
     * @param array Source array
     * @param start Start index
     * @param end End index
     * @param sortingType Type of sorting (Ascending or Descending)
     */
    private void quickSortImpl(E[] array, int start, int end, SortingType sortingType) {
        if(array.length > 1) {
            Random random = new Random();
            int indexOfSupportElement = random.nextInt((end+1) - start) + start;
            E valueOfSupportElement = array[indexOfSupportElement];
            int left = start;
            int right = end;
            do{
                if(sortingType.equals(SortingType.Ascending)) {
                    while (array[left].compareTo(valueOfSupportElement) < 0) {
                        left++;
                    }
                    while (array[right].compareTo(valueOfSupportElement) > 0) {
                        right--;
                    }
                }
                else{
                    while (array[left].compareTo(valueOfSupportElement) > 0) {
                        left++;
                    }
                    while (array[right].compareTo(valueOfSupportElement) < 0) {
                        right--;
                    }
                }
                if(left <= right){
                    if(left < right){
                        swap(array, left,right);
                    }
                    left++;
                    right--;
                }
            }
            while(left<=right);

            if(left < end){
                quickSortImpl(array,left, end, sortingType);
            }
            if(start < right){
                quickSortImpl(array,start, right, sortingType);
            }
        }
    }


    private void swap(E[] array, int firstIndex, int secondIndex) {
        E temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    /**
     *Search index of minimum value for source array
     * @param array Source array
     * @param startIndex The starting index for the search
     * @param endIndex End index for search
     * @return The index of the minimum value
     */
    private int min(E[] array, int startIndex, int endIndex){
        int min = startIndex;
        for (int i = startIndex + 1; i < endIndex; i++){
            int resultCompare = array[min].compareTo(array[i]);
            if(resultCompare > 0){
                min=i;
            }
        }
        return min;
    }

    /**
     *Search index of maximum value for source array
     * @param array Source array
     * @param startIndex The starting index for the search
     * @param endIndex End index for search
     * @return The index of the maximum value
     */
    private int max(E[] array, int startIndex, int endIndex){
        int max = startIndex;
        for (int i =startIndex+1; i < endIndex; i++){
            int resultCompare = array[max].compareTo(array[i]);
            if(resultCompare < 0){
                max=i;
            }
        }
        return max;
    }
}
