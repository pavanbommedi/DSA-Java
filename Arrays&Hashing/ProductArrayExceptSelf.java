import java.util.Arrays;

class ProductArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int prefix =1;
        int postfix = 1;
        for(int i=0;i<n;i++){
            res[i]=prefix;
            prefix*=nums[i];
        }
        for(int i=n-1;i>=0;i--){
            res[i]*=postfix;
            postfix = postfix*nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}