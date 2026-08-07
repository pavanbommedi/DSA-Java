import java.util.*;
public class TwoSum{
    public static int[] twoSum(int[] nums, int target) {
        // linear space and linear time
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[]{map.get(need),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};


    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,5,6};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));

    }
}