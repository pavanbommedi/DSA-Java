import java.util.*;
class Pair{
    int val;
    int idx;
    Pair(int val,int idx){
        this.val = val;
        this.idx=idx;
    }
}
public class SmallerCount {
    static int[] counts;
    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts =  new int[n];
        Pair[] arr = new Pair[n];
        for(int i =0;i<n;i++){
            counts[i]=0;
            arr[i] = new Pair(nums[i],i);
        }
        mergeSort(arr,0,n-1);
        List<Integer> cnts = new ArrayList<>();
        for(int i=0;i<n;i++) cnts.add(counts[i]);
        return cnts;

    }
    public static  void mergeSort(Pair[] arr,int left,int right){
        if(left>=right) return;
        int mid  = left+(right-left)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    public static void merge(Pair[] arr,int low,int mid,int high){
        int i = low;
        int j = mid+1;
        int rightCount=0;
        int ind=0;
        Pair[] temp = new Pair[high-low+1];
        while(i<=mid && j<=high){
            if(arr[j].val>=arr[i].val){
                counts[arr[i].idx]+=rightCount;
                temp[ind++]=arr[i++];

            }
            else{
                rightCount++;
                temp[ind++]=arr[j++];


            }
        }
        while(i<=mid){
            counts[arr[i].idx]+=rightCount;
            temp[ind++]=arr[i++];

        }
        while(j<=high) temp[ind++]=arr[j++];
        for(int a = 0;a<high-low+1;a++){
            arr[low+a]=temp[a];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1,8,3};
        countSmaller(nums);
    }
}