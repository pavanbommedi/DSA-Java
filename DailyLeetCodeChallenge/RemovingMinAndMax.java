package DailyLeetCodeChallenge;
//AUG 30 2026
//Greedy
class RemoveMinAndMax {
    public static int minimumDeletions(int[] nums) {
        int min_idx=-1;
        int max_idx=-1;
        int max_val=Integer.MIN_VALUE;
        int min_val=Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            if(nums[i]>max_val){
                max_val = nums[i];
                max_idx=i;
            }
            if(nums[i]<min_val){
                min_val=nums[i];
                min_idx=i;
            }

        }
        int min = Math.min(min_idx,max_idx);
        int max=Math.max(max_idx,min_idx);
        return Math.min(Math.min(max+1,(nums.length-1)-min+1),(min+1)+(nums.length-1)-max+1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(minimumDeletions(nums));
    }
}