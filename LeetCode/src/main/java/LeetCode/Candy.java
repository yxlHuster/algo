package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-11
 * Time: 下午5:32
 * To change this template use File | Settings | File Templates.
 */
public class Candy {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i-1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) { //avoid equal rating cases ?
                candies[i] = candies[i + 1] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < candies.length; i++) {
            result += candies[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] rates = {1,2,5,5,10};
        Candy candy = new Candy();
        System.out.println(candy.candy(rates));
    }

}
