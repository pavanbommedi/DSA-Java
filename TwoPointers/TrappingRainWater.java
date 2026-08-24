class TrappingRainWater {
    //Maximum prefix and suffix solution
//    public int trap(int[] height) {
//        int n = height.length;
//        int[] prefix = new int[n];
//        int[] suffix = new int[n];
//        prefix[0]=0;
//        suffix[n-1]=0;
//        int max_prefix = height[0];
//        int max_suffix = height[n-1];
//        for(int i=1;i<n;i++){
//            max_prefix = Math.max(max_prefix,height[i]);
//            prefix[i]=max_prefix;
//        }
//        for(int i=n-2;i>=0;i--){
//            max_suffix=Math.max(max_suffix,height[i]);
//            suffix[i]=max_suffix;
//        }
//        int cn =0;
//        for(int i =0;i<n;i++){
//            if(height[i]<Math.min(prefix[i],suffix[i])){
//                cn+=Math.min(prefix[i],suffix[i])-height[i];
//            }
//        }
//        return cn;
//
//    }
    //Two-Pointer Solution
public static int trap(int[] height) {

    int n = height.length;

    int maxL=height[0];

    int maxR=height[n-1];

    int l=0;

    int r = n-1;

    int cn =0;

    while(l<r){

        if(maxL<maxR){

            l++;

            maxL=Math.max(height[l],maxL);

            cn+=maxL-height[l];

        }

        else{

            r--;

            maxR=Math.max(height[r],maxR);

            cn+=maxR-height[r];

        }

    }

    return cn;

}

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,2,3,1,0,4,3,2};
        System.out.println(trap(nums));
    }

}