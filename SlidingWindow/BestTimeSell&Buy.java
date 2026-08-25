class BestTimeBuySell {
    public static int maxProfit(int[] nums) {
        int l=0;
        int r = 1;
        int max =0;
        while(r<nums.length){
            if(nums[r]<=nums[l]){
                l=r;
                r++;
            }
            else{
                max = Math.max(max,nums[r]-nums[l]);
                r++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4,0,8};
        System.out.println(maxProfit(nums));
    }
}