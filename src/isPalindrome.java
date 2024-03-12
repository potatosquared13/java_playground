public class isPalindrome {
    public boolean isPalindromeNumber(int x) {
        String nums = String.valueOf(x);
        StringBuilder newNum = new StringBuilder(nums).reverse();

        return nums.contentEquals(newNum);
    }

    public boolean isPalindromeInt(int x) {
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
    
    public static void main(String[] args) {
        isPalindrome sol1 = new isPalindrome();
        Boolean isPal = sol1.isPalindromeInt(131);
        System.out.println(isPal);
    }
}
