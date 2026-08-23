import java.util.*;
class FourSum {

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> quad = new ArrayList<>();
    static int[] nums;
    public static List<List<Integer>> fourSum(int[] nums, int target) {


        Arrays.sort(nums);

        kSum(4, 0, target);

        return res;
    }

    private static  void kSum(int k, int start, long target) {

        if (k == 2) {

            int left = start;
            int right = nums.length - 1;

            while (left < right) {

                long sum = (long) nums[left] + nums[right];

                if (sum == target) {

                    List<Integer> temp = new ArrayList<>(quad);

                    temp.add(nums[left]);
                    temp.add(nums[right]);

                    res.add(temp);

                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right &&
                            nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                            nums[right] == nums[right + 1]) {
                        right--;
                    }

                }
                else if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }

            return;
        }

        for (int i = start;
             i <= nums.length - k;
             i++) {

            // Skip duplicate fixed elements
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            quad.add(nums[i]);

            kSum(
                    k - 1,
                    i + 1,
                    target - nums[i]
            );

            quad.remove(quad.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,0,0,1,2};
        System.out.println(fourSum(,0));
    }
}