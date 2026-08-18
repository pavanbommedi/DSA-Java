class BestTimeStocksII {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int i=0;
        while(i<n-1){
            if(prices[i+1]>prices[i]) profit+=prices[i+1]-prices[i];
            i++;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}