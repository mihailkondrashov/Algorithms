package kondrashov.sorting;

import org.junit.jupiter.api.Assertions;

class SortingAlgorithmsTest {

    SortingAlgorithms<Integer> integerSortingAlgorithms = new SortingAlgorithms<>();
    int[] testIntArray = {5,7,1,3,4,2,6};
    int[] resultAscendingSortInt = {1, 2, 3, 4, 5, 6, 7 };
    int[] resultDescendingSortInt = {7, 6, 5, 4, 3, 2, 1 };
    Integer[] testIntegerArray = {5,7,1,3,4,2,6};
    Integer[] resultAscendingSortInteger = {1, 2, 3, 4, 5, 6, 7 };
    Integer[] resultDescendingSortInteger = {7, 6, 5, 4, 3, 2, 1 };


    @org.junit.jupiter.api.Test
    void bubbleSortDescending() {
        Integer[] temp = testIntegerArray.clone();
        integerSortingAlgorithms.bubbleSort(temp,SortingType.Descending);
        Assertions.assertArrayEquals(temp, resultDescendingSortInteger);
    }

    @org.junit.jupiter.api.Test
    void bubbleSortAscending() {
        Integer[] temp = testIntegerArray.clone();
        integerSortingAlgorithms.bubbleSort(temp,SortingType.Ascending);
        Assertions.assertArrayEquals(temp, resultAscendingSortInteger);
    }

    @org.junit.jupiter.api.Test
    void selectionSortDescending() {
        Integer[] temp = testIntegerArray.clone();
        integerSortingAlgorithms.selectionSort(temp,SortingType.Descending);
        Assertions.assertArrayEquals(temp, resultDescendingSortInteger);
    }

    @org.junit.jupiter.api.Test
    void selectionSortAscending() {
        Integer[] temp = testIntegerArray.clone();
        integerSortingAlgorithms.selectionSort(temp,SortingType.Ascending);
        Assertions.assertArrayEquals(temp, resultAscendingSortInteger);
    }

    @org.junit.jupiter.api.Test
    void insertionSortDescending() {
        Integer[] temp = testIntegerArray.clone();
        integerSortingAlgorithms.insertionSort(temp,SortingType.Descending);
        Assertions.assertArrayEquals(temp, resultDescendingSortInteger);
    }

    @org.junit.jupiter.api.Test
    void insertionSortAscending() {
        Integer[] temp = testIntegerArray.clone();
        integerSortingAlgorithms.insertionSort(temp,SortingType.Ascending);
        Assertions.assertArrayEquals(temp, resultAscendingSortInteger);
    }

    @org.junit.jupiter.api.Test
    void mergeSortAscending() {
        int[] temp = testIntArray.clone();
        integerSortingAlgorithms.mergeSort(temp,SortingType.Ascending);
        Assertions.assertArrayEquals(temp, resultAscendingSortInt);
    }

    @org.junit.jupiter.api.Test
    void mergeSortDescending() {
        int[] temp = testIntArray.clone();
        integerSortingAlgorithms.mergeSort(temp,SortingType.Descending);
        Assertions.assertArrayEquals(temp, resultDescendingSortInt);
    }

    @org.junit.jupiter.api.Test
    void quickSortDescending() {
        Integer[] temp = testIntegerArray.clone();
        integerSortingAlgorithms.quickSort(temp,SortingType.Descending);
        Assertions.assertArrayEquals(temp, resultDescendingSortInteger);
    }

    @org.junit.jupiter.api.Test
    void quickSortAscending() {
        Integer[] temp = testIntegerArray.clone();
        integerSortingAlgorithms.quickSort(temp,SortingType.Ascending);
        Assertions.assertArrayEquals(temp, resultAscendingSortInteger);
    }
}