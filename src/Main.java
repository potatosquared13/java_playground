import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

    }

    public static int indexOfLowestNum(int[] arr) {
        // assume first element is the lowest number
        // iterate through array and compare elements
        if (arr.length < 1) {
            return -1;
        }

        int lowestNumber = arr[0];
        int lowestIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < lowestNumber) {
                lowestNumber = arr[i];
                lowestIndex = i;
            }
        }

        return lowestIndex;
    }

    public static int countUniqueWords(String sentence) {
        String[] words = sentence.toLowerCase().split(" "); // Split by spaces and convert to lowercase
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words)); // Add words to HashSet for uniqueness
        return uniqueWords.size(); // Return the size of the HashSet (number of unique words)
    }

    public static int addAllNumbersInArray(int[] arr) {
        int count = 0;

        if(arr.length == 1) return arr[0];

        for (int digit : arr) {
            count += digit;
        }

        return count;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static boolean isPalindromeNumber(int x) {
        String nums = String.valueOf(x);
        StringBuilder newNum = new StringBuilder(nums).reverse();

        return nums.contentEquals(newNum);
    }

    public static boolean isPalindromeInt(int x) {
        int container = 0;
        int nums = x;

        if(nums < 0 || (nums % 10 == 0 && nums != 0))
            return false;

        while (nums > 0) {
            int digit = nums % 10;
            container = container * 10 + digit;
            nums /= 10;
        }

        return x == container;
    }

    public static boolean hasDuplicates(int[] arr) {
        // If empty array
        if(arr.length == 0) return false;

        // Implement a program to check if two arrays have the same elements (ignoring order) using HashSets.
        HashSet<Integer> map = new HashSet<>();

        for (int num : arr) {
            if (map.contains(num)) return true;
            map.add(num);
        }

        return false;
    }
}