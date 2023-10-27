package book;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int answer = 0;

        int[] lowPrices = new int[prices.length];
        int lowPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            lowPrice = Integer.min(lowPrice, prices[i]);
            lowPrices[i] = lowPrice;
        }

        for (int i = 0; i < prices.length; i++) {
            int profit = (prices[i] - lowPrices[i]);
            answer = Integer.max(answer, profit);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
