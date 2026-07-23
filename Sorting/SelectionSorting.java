import java.util.Arrays;

public class SelectionSorting {

    public static void selectionSort(int[] nums){
        int i=0;
        while(i<nums.length-1){
            int j = i+1;
            int ind = i;
            int min = nums[i];
            while(j<nums.length){
                if(nums[j]<min){
                    min = nums[j];
                    ind =j ;
                }
                j++;
            }
            int temp = nums[ind];
            nums[ind]=nums[i];
            nums[i]=temp;
            i+=1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{25,31,18,30,23,26,25};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
