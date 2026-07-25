import java.util.Arrays;

public class BubbleSorting {

    public static void bubbleSort(int[] nums){
        int n = nums.length;
        for(int i = n-1; i>=1; i--){
            for(int j = 0; j<i;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
            int[] nums = new int[]{12,11,13,5,6};
            bubbleSort(nums);
            System.out.println(Arrays.toString(nums));
    }

}
