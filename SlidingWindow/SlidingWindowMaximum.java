package SlidingWindow;
import java.util.*;
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // Handle empty or edge case conditions
        if (nums == null || nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];

        Deque<Integer> queue = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        int ind = 0;

        while (right < nums.length) {
            // Remove smaller elements from the back of the queue
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.pollLast();
            }

            queue.addLast(right);

            // Remove indices that have fallen out of the left bound of the window
            if (left > queue.peekFirst()) {
                queue.pollFirst();
            }

            // Check if window has reached size k
            if (right + 1 >= k) {
                res[ind++] = nums[queue.peekFirst()];
                left += 1;
            }
            right += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[1,2,3,1,1,1,5,6];
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }

}
