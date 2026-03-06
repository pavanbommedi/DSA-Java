class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int n : weights){
            left = Math.max(n,left);
            right += n;
        }
        int min = right;
        while(left<=right){
            int cap = (left+right)/2;
            int currcap = 0;
            int day=1;
            for(int n : weights){
                if(currcap+n > cap){
                    day+=1;
                    currcap = 0;
                }
                currcap+=n;
            }
            if(day<=days){
                min=Math.min(min,cap);
                right = cap -1;
            }
            else left = cap+1;
        }
        return min;
        
    }
}