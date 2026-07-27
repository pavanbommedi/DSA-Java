import java.util.Arrays;
//Hoare's Partition Scheme (first element as pivot).
//Quick Sort doesn't sort the array directly. It places one element (the pivot) 
// into its final correct position, then recursively sorts the left and right parts.
public class QuickSorting {

    static void quickSort(int[] nums,int low,int high){
        if(low<high){ //Only arrays with 2 or more elements need sorting.
            int partIndex = partition(nums,low,high);
            quickSort(nums,low,partIndex-1); //Smaller group
            quickSort(nums, partIndex+1, high);//Larger group
        }
    }
     
    static int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        int i = low;
        int j = high;
        while(i<j){
            while(nums[i]<=pivot && i<=high-1){ //As long as numbers belong on the LEFT,keep moving.
                i++; //stop only when Found something greater than pivot.
            }
            while(nums[j]>pivot && j>=low+1){ //As long as numbers belong on the RIGHT,keep moving.
                j--; //stop only when Found something lesser than pivot.
            }
            if(i<j){
                swap(nums,i,j); 
            }
        }
        swap(nums,low,j); //Pivot has reached its final sorted position.
        return j; //After partition returns, pivot will never move again
    }

    static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12,11,13,5,6};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}

//Why Quick Sort is Fast
//Because partition itself partially sorts the array.
//Quick sort is not stable
//Merge Sort divides first and merges later. 
// Quick Sort partitions first, fixes the pivot immediately, 
// 
and never touches that pivot again.