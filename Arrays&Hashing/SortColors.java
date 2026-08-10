import java.util.Arrays;
//Dutch National Flag
//3 values + in-place + one pass + O(1) → think Dutch National Flag / 3-way partition.
public class SortColors{
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1) mid++;
            else{
                swap(nums,mid,high);
                high--;
            }
        }

    }
    static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,0,1,0,1,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}