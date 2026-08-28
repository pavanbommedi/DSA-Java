import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindKClosetElements {
    //O(logn+k) -> BinarySearch + Two pointer solution
//    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
//        // Step 1: Binary search to find the index of the closest element to x
//        int idx = binarySearch(arr, x);
//
//        // Step 2: Initialize two pointers around the closest element
//        int left = idx - 1;
//        int right = idx;
//
//        // Step 3: Expand the window outward to collect K elements
//        while (right - left -1 < k) {
//            if (left < 0) {
//                right++;
//            } else if (right >= arr.length) {
//                left--;
//            } else {
//                // Compare distances; pick left side if it is closer or tied
//                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
//                    left--;
//                } else {
//                    right++;
//                }
//            }
//        }
//
//        // Step 4: Build the result list from left + 1 to right - 1
//        List<Integer> result = new ArrayList<>();
//        for (int i = left+1; i <right; i++) {
//            result.add(arr[i]);
//        }
//
//        return result;
//    }
//
//    private static int binarySearch(int[] arr, int target) {
//        int low = 0;
//        int high = arr.length - 1;
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (arr[mid] == target) {
//                return mid;
//            } else if (arr[mid] < target) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        // If target doesn't exist, low is the optimal upper bound / insertion point
//        return low;
//    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x){
        int left = 0;
        int right = arr.length -k;
        List<Integer> res =  new ArrayList<>();
        while(left<right){
            int mid = (right-left)/2 + left;
            if(x-arr[mid]>arr[mid+k]-x) left = mid+1;
            else right = mid;
        }
        for(int i =left;i<left+k;i++) res.add(arr[i]);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(findClosestElements(arr,4,3));
    }

}
