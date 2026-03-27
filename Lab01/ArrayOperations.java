import java.util.Arrays;

public class ArrayOperations {
    public static void main(String[] args) {

        int[] my_array1 = { 1001, 2035, 2314, 1456, 1967, 1789, 1890, 1678, 2000, 1543 };

        System.out.println("Original Array: " + Arrays.toString(my_array1));

        Arrays.sort(my_array1);
        System.out.println("Sorted Array:   " + Arrays.toString(my_array1));

        int sum = 0;
        for (int num : my_array1) {
            sum += num;
        }

        double average = (double) sum / my_array1.length;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}