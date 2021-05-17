package kondrashov.algorithms.search;

import java.util.Arrays;

public class SearchAlgorithms<E extends Comparable<E>> {

    public int linearSearch(E[] array, E searchObject){
        for (int i = 0; i < array.length; i++){
            if(searchObject.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(E[] array, E searchObject){
        int minIndex = 0;
        int maxIndex = array.length-1;

        while (minIndex<=maxIndex){
            int currentIndex = (maxIndex+minIndex)/2;
            int resultOfCompare = searchObject.compareTo(array[currentIndex]);
            if (resultOfCompare == 0){
                return currentIndex;
            }
            else if (resultOfCompare > 0){
                minIndex = currentIndex+ 1;
            }
            else{
                maxIndex = currentIndex-1;
            }
        }
        return -1;
    }

    public int binarySearchRecursion(E[] array, E searchObject){

        if(array.length<2){
            if(searchObject.equals(array[0])){
                return 0;
            }
            return -1;
        }

        int minIndex = 0;
        int maxIndex = array.length-1;
        int currentIndex = (maxIndex+minIndex)/2;
        int resultOfCompare = searchObject.compareTo(array[currentIndex]);
        if (resultOfCompare == 0){
            return currentIndex;
        }
        else if (resultOfCompare > 0){
            int index = binarySearchRecursion(Arrays.copyOfRange(array,currentIndex+ 1, maxIndex+1), searchObject);
            return index == -1 ? -1 : currentIndex+1+index;
        }
        else{
            return binarySearchRecursion(Arrays.copyOfRange(array,minIndex, currentIndex), searchObject);
        }
    }


}
