// 1. Write a HashMap to store student IDs as keys and their names as values. Print all the student information.
// 2. Implement a program to check if two arrays have the same elements (ignoring order) using HashSets.
// 3. Given a HashMap of employee IDs and their departments, write code to find all employees in a specific department.
// 4. Design a program to count the frequency of each word in a given text file using HashMaps.
// 5. Create a simple phone directory application using HashMaps to store names and phone numbers. Allow searching by name.
// 6. Simulate a shopping cart using a HashMap. Keys are product IDs and values are quantities.
// 7. Implement a program to find the longest common substring of two strings using Hashing. (Hint: Rabin-Karp algorithm)
// 8. Design a cache system using HashMaps to store frequently accessed data and improve performance.
// 9 Write code to find the first non-repeating character in a given String using HashSets.
// 10. Implement a program to check if a string is an anagram of another string (uses same characters) using character counts in HashMaps.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        frequencyCounter(new int[] {3, 3, 4, 5, 6, 6, 6, 6, 6}).forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }

    // Write a function that takes a list of integers and returns a HashMap with the frequency count of each integer.
    public static HashMap<Integer, Integer> frequencyCounter(int[] num) {
        // { 3, 3, 4, 5, 6, 6, 6, 6, 6 }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < num.length; i++) {
            if(map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i]) + 1);
            } else {
                map.put(num[i], 1);
            }
        }

        return map;
    }

    // Write a Java program that calculates and prints the factorial of a given number.
    public static int factorial(int num) {
        int result = num;

        if (num == 0) return 1;  // 0! is 1

        if (num < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers");

        for (int i = num - 1; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    public static int romanToInt(String s) {
        // I = 1
        // V = 5
        // Sample input = IV
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentValue = map.get(s.charAt(i));

            if (i < s.length() - 1 && map.get(s.charAt(i + 1)) > currentValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        return result;
    }

    public static int findLargestNumber(int[] arr) {
        // assume first is largest
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) largest = arr[i];
        }

        return largest;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) return new int[]{map.get(complement), i};

            map.put(arr[i], i);
        }

        return new int[]{};
    }

    public static boolean isPalindrome(String message) {
        StringBuilder reversed = new StringBuilder(message);
        String reverseMessage = reversed.reverse().toString().toLowerCase();
        return message.toLowerCase().equals(reverseMessage);
    }

    public static int maxValueInArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static String reverseString(String message) {
        StringBuilder reversed = new StringBuilder(message);
        return reversed.reverse().toString();
    }

    public int indexOfLowestNum(int[] arr) {
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

        if (arr.length == 1) return arr[0];

        for (int digit : arr) {
            count += digit;
        }

        return count;
    }

    public static boolean isPalindromeNumber(int x) {
        String nums = String.valueOf(x);
        StringBuilder newNum = new StringBuilder(nums).reverse();

        return nums.contentEquals(newNum);
    }

    public static boolean isPalindromeInt(int x) {
        int container = 0;
        int nums = x;

        if (nums < 0 || (nums % 10 == 0 && nums != 0))
            return false;

        while (nums > 0) {
            int digit = nums % 10;
            container = container * 10 + digit;
            nums /= 10;
        }

        return x == container;
    }

    // 2. Implement a program to check if two arrays have the same elements (ignoring order) using HashSets.
    public static boolean hasDuplicates(int[] arr) {
        // If empty array
        if (arr.length == 0) return false;

        // Implement a program to check if two arrays have the same elements (ignoring order) using HashSets.
        HashSet<Integer> map = new HashSet<>();

        for (int num : arr) {
            if (map.contains(num)) return true;
            map.add(num);
        }

        return false;
    }

    // 3. Given a HashMap of employee IDs and their departments, write code to find all employees in a specific department.
    public static void employeeProblem() {
        Employee emp1 = new Employee(111, "John", "Principal");
        Employee emp2 = new Employee(112, "Jane", "Teacher");
        Employee emp3 = new Employee(113, "Derrick", "HR");
        Employee emp4 = new Employee(114, "Paul", "Finance");
        Employee emp5 = new Employee(115, "Lourdes", "Finance");

        HashMap<Integer, Employee> map = new HashMap<>();
        map.put(emp1.getEmpID(), emp1);
        map.put(emp2.getEmpID(), emp2);
        map.put(emp3.getEmpID(), emp3);
        map.put(emp4.getEmpID(), emp4);
        map.put(emp5.getEmpID(), emp5);

        for (Employee emp : map.values()) {
            System.out.println("Employee ID: " + emp.getEmpID() + " || Employee Name: " + emp.getEmpName() + " || Department: " + emp.getDepartment() + " Hash: ");
        }
    }

    // 4. Design a program to count the frequency of each word in a given text file using HashMaps.
    public static void wordFrequency(String sentence) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = sentence.toLowerCase().split(" ");

        int counter = 1;

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, counter);
            }
        }

        for (String word : map.keySet()) {
            System.out.println(word.toUpperCase() + " - Freq: " + map.get(word));
        }
    }
}


