class ContainerMostWater {
    public static int maxArea(int[] height) {
        int max =0;
        int i =0;
        int j =height.length-1;
        while(i<j){
            int min = Math.min(height[i],height[j]);
            max = Math.max(max,min*(j-i));
            if(height[i]>=height[j]) j--;
            else i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,3,8,7};
        System.out.println(maxArea(height));
    }
}