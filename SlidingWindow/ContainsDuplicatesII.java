import java.util.*;
class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int i =0;
        Set<Integer> set = new HashSet<>();
        while(i<nums.length){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size()>k) set.remove(nums[i-k]);
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums,2));
    }
}