import java.util.*;
public class ThreeSum{
        public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int i=0;
            List<List<Integer>> res = new ArrayList<>();
            while(i<nums.length-2){
                if (i > 0 && nums[i] == nums[i - 1]) {
                    i++;
                    continue;
                }
                int target = -(nums[i]);
                int j = i+1;
                int k = nums.length-1;
                while(j<k){
                    int sum = nums[j]+nums[k];
                    if(sum==target){
                        res.add(List.of(nums[i],nums[j],nums[k]));
                        while(j<k && nums[j]==nums[j+1]) j++;
                        while(j<k && nums[k]==nums[k-1]) k--;

                        j++;
                        k--;
                    }
                    else if(sum<target) j++;
                    else k--;
                }
                i++;
            }
            return res;
        }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,2,3,4,5,-4,-3,0,0,-4};
        System.out.println((threeSum(nums)));
    }
}