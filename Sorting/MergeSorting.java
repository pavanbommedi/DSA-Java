import java.util.Arrays;
//Divide and Conquer
public class MergeSorting {

    static void mergeSort(int[] nums,int low,int high){
        if(low==high) return; //A single element (or empty array) is already sorted.

        int mid = low + (high - low) / 2; //Prevents integer overflow.
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    static void merge(int[] nums,int low,int mid,int high){
        int left = low;
        int right = mid+1;
        int ind =0;
        int[] temp = new int[high-low+1];
        //During merging, you cannot overwrite the original array 
        // because you still need its remaining elements for comparison.
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp[ind]=nums[left];
                ind++;
                left++;
            }
            else{
                temp[ind]=nums[right];
                ind++;
                right++;
            }
        }
        while(left<=mid){
            temp[ind]=nums[left];
            ind++;
            left++;
        }
        while(right<=high){
            temp[ind]=nums[right];
            ind++;
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp[i-low]; //because temp always starts from index 0.
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{12,11,13,5,6};
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
