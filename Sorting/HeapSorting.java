    import java.util.Arrays;

    public class HeapSorting {
        static void heapSort(int[] arr){
            int n = arr.length;
            for(int i=n/2-1;i>=0;i--){
                heapify(arr,n,i);
            }
            for(int i=n-1;i>0;i--){
                swap(arr,i,0);
                heapify(arr,i,0);
            }
        }

        static void heapify(int[] arr, int n,int i){
            int largest = i;
            int left = 2*i+1;
            int right = 2*i+2;
            if(left<n && arr[left]>arr[largest]) largest = left;
            if(right<n && arr[right]>arr[largest]) largest = right;
            if(largest!=i){
                swap(arr,i,largest);
                heapify(arr,n,largest);
            }

        }
        static void swap(int[] arr,int i,int j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        public static void main(String[] args){
            int[] arr = new int[]{12,13,9,6,11,7,5};
            heapSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
