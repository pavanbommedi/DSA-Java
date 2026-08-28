class MinSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int sum =0;
        int min =Integer.MAX_VALUE;
        boolean flag=false;
        for(int right =0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                flag = true;
                min = Math.min(min,(right-left+1));
                sum-=nums[left];
                left++;
            }
        }
        if(flag)return min;
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[2,3,1,4,3];
        System.out.println(minSubArrayLen(7,nums));
    }
}