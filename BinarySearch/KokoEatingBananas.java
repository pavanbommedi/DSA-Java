class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(Integer n : piles) right=Math.max(right,n);
        int min = right;
        while(left<=right){
            int k = (left+right)/2;
            int sum = 0;
            for(Integer n : piles) sum+=Math.ceil((double)n/k);
            if(sum<=h){
                min = Math.min(min,k);
                right = k-1;
            }
            else left=k+1;
        }
        return min;
    }
}