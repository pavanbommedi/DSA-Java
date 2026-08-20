class FirstPositiveInteger {
    public static int  firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++) if(nums[i]<0) nums[i]=0;
        for(int n : nums){
            if(n==0 || Math.abs(n)-1>len-1) continue;
            else if(nums[Math.abs(n)-1]==0) nums[Math.abs(n)-1]=0-(len+1);
            else if(nums[Math.abs(n)-1]<0) continue;
            else nums[Math.abs(n)-1]=0-nums[Math.abs(n)-1];
        }
        for(int i=1;i<=len;i++){
            if(nums[i-1]>=0) return i;
        }
        return len+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,-1,3,2,4};
        System.out.println(firstMissingPositive(nums));
    }
}