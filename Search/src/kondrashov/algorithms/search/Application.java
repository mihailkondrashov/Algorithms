package kondrashov.algorithms.search;

public class Application {
    public static void main(String[] args) {
    SearchAlgorithms<Integer> searchAlgorithms = new SearchAlgorithms<Integer>();

        Integer[] array = {1,2,3,4};

        System.out.println(searchAlgorithms.linearSearch(array,5));
        System.out.println(searchAlgorithms.linearSearch(array,4));
        System.out.println(searchAlgorithms.binarySearch(array,5));
        System.out.println(searchAlgorithms.binarySearch(array,1));
        System.out.println(searchAlgorithms.binarySearchRecursion(array,5));
        System.out.println(searchAlgorithms.binarySearchRecursion(array,2));
    }
}
