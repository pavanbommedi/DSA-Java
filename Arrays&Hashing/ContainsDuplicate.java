import java.util.*;
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        //O(n) space O(n) time
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            if(!set.add(n)) return true;
        }
        return false;

        //O(1) space and O(nlogn) time
//        Arrays.sort(nums);
//        for(int i =0 ;i<nums.length-1;i++){
//            if(nums[i]==nums[i+1]) return true;
//        }
//        return false;

    }
    public static void main(String[] args) {
        int[] nums = new int[]{12,11,13,5,6};
        System.out.println(containsDuplicate(nums));


    }
}