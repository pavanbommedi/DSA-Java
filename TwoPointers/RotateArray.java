import java.util.Arrays;

class RotateArray {
    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        // Reverse entire array
        reverse(nums, 0, nums.length - 1);

        // Reverse first k elements
        reverse(nums, 0, k - 1);

        // Reverse remaining elements
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}