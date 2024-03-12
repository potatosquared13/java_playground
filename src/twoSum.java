import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        twoSum sol1 = new twoSum();
        int[] arr = {2, 5, 7, 10, 4, 12, 27, 11, 3, 0};
        System.out.println(Arrays.toString(sol1.twoSum(arr, 15)));
    }

    public int[] twoSum(int[] nums, int target) {
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
}
