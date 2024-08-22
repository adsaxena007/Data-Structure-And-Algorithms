public class _9_BestTimeToBuyStock2 {

    //    sell - buy = profit
    //    stock(index+1, false) - buy = profit

    Integer []memo1;
    Integer []memo2;
    public int calcMaxProfit(int [] prices, int index, boolean isBought){
        if(index == prices.length){
            return 0;
        }

        if(memo1[index] == null){
            memo1[index] = calcMaxProfit(prices, index + 1, false);
        }

        if(memo2[index] == null){
            memo2[index] = calcMaxProfit(prices, index + 1, true);
        }

        if(isBought){
            return  Math.max(prices[index] +  memo1[index],memo2[index]);
        } else{
            return Math.max(memo2[index] - prices[index] , memo1[index]);
        }

    }

    public int maxProfit(int[] prices) {
        memo1 = new Integer[prices.length];
        memo2 = new Integer[prices.length];
        return calcMaxProfit(prices, 0, false);
    }
}
