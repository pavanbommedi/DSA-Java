    import java.util.Arrays;

    public class InsertionSorting {

        public static void insertionSort(int[] nums){
            int n = nums.length;
            for(int i = 1 ; i<n;i++){
                int j = i-1;
                int key = nums[i];

                while(j>=0  && key<nums[j]){
                    nums[j+1]=nums[j];
                    j-=1;
                }
                nums[j+1]=key;
            }
        }
        public static void main(String[] args) {
            int[] nums = new int[]{12,11,13,5,6}
            insertionSort(nums);
            System.out.println(Arrays.toString(nums));
        }

    }
