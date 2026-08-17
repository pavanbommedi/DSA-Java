import java.util.*;
class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int max = 0;

        for (int n : set) {

            // n is the beginning of a sequence
            if (!set.contains(n - 1)) {

                int len = 1;

                while (set.contains(n + len)) {
                    len++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

    }
}