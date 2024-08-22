import java.util.Arrays;

public class _24_Candy {
    public int candy(int[] ratings) {

        int [] candies = new int[ratings.length];

        for(int i=0;i< ratings.length;i++){
            if(i==0){
                candies[i] = 1;
            }else{
                if (ratings[i]>ratings[i-1]){
                    candies[i]  = candies[i-1] + 1;
                }else{
                    candies[i]=1;
                }
            }
        }

        for(int i = ratings.length-1; i>=0; i--){
            if(i == ratings.length-1){
                continue;
            }else {
                if((ratings[i] > ratings[i+1]) && (candies[i] <= candies[i+1]) ){
                    candies[i] = candies[i] + (candies[i+1] - candies[i] + 1);
                }
            }
        }

        int sum =0 ;
        for(int candy: candies)
            sum = sum + candy;

        return sum;

    }

    public static void main(String[] args) {
        _24_Candy obj = new _24_Candy();
        System.out.println(obj.candy(new int[]{1,0,2}));

    }
}
