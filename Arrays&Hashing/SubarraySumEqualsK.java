import java.util.*;
class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int cn =0;
        for(int n:nums){
            sum+=n;
            int diff = sum-k;
            // cn+=map.getOrDefault(diff,0);
            // map.put(sum,1+map.getOrDefault(sum,0));
            if(map.containsKey(diff))cn+=map.get(diff);
            if(map.containsKey(sum))map.put(sum,map.get(sum)+1);
            else map.put(sum,1);
        }
        return cn;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,1,1,1,1};
        int k = 3;
        System.out.println(subarraySum(nums,k));
    }
}