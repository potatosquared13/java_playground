public class IndexOfLowestNum {
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
}
