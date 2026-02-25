import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
/** main class for the dart game, it will ask the user which game they are playing 
 * and then update the score for each player until one of them wins by reaching exactly 
 * 0 with a double. It also uses the Checkout class to find the checkout options for
 *  the current score.
 * @author Josh Reynolds
 * @version 1.0
 * @since 25/02/2026
 */
public class Finish{
    /** Main method to run the dart game, it will ask the user which game they are playing 
     * and then update the score for each player until one of them wins by reaching exactly 
     * 0 with a double.
     * @param args
     */
    public static void main(String[] args){
        int game = gettingGame();
        int score1 = game;
        int score2 = game;
        do { 
            score1 = updatingScore(score1, "Player 1");
            System.out.println("Player 1: " + score1);
            if(score1 == 0){
                break;
            }
            score2 = updatingScore(score2, "Player 2");
            System.out.println("Player 2: " + score2);
        } while (score1>0 && score2>0);
        
    }
    /**
     * gets the game number from the user, it must be 301, 401, or 501. 
     * If the user inputs an invalid number, it will throw an IllegalArgumentException.
     * @return the game number
     */
    public static int gettingGame(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("please input which game you are playing");
        int num = sc1.nextInt();
        if(num != 301 && num != 401 && num != 501){
            throw new IllegalArgumentException("Game must be 301,401 or 501");
        }
        return num;

    }
    /**
     * this method will check if the player has won by reaching exactly 0 
     * with a double, if the player has busted by going below 0 or reaching 1, 
     * or if the player is still in the game and update the score accordingly.
     * @param score
     * @param player
     * @return newscore after the player has thrown their three darts,
     */
    public static int updatingScore(int score, String player){
        System.out.println( player + ", please input your three darts:");
        Scanner sc1 = new Scanner(System.in);
        int newscore = score;
        findCheckout(newscore);
        for(int i = 3; i>0; i--){
            int dart = sc1.nextInt();
            newscore = score - dart; 
            if(newscore == 0 && checkingValidDoubles(dart)){
                System.out.println("Congratulations you win!");
                return 0;
            } else if(newscore == 0 && !checkingValidDoubles(dart)){
                System.out.println("You must finish on a double!");
                return newscore+dart;
            } else if(newscore <= 1 && score != 0){
                System.out.println("bust!");
                return newscore+dart;
            }else{
                score = newscore;
                findCheckout(newscore);
            }
        }
        return newscore;
    }
    /**
     * this method checks if the dart thrown is a valid double
     * @param dart
     * @return boolean
     */
    public static boolean checkingValidDoubles(int dart){
        int[] validDoubles = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,50}; 
        for(int i: validDoubles){
            if(dart == i){
                return true;
            }
        }
        return false;
    }
    /**
     * this method uses the Checkout class to find the checkout options 
     * for the current score if any and prints them out to the user.
     * @param score
     */
    public static void findCheckout(int score){
        if(score > 170){
            return;
        }
        Map<Integer, String[]> checkoutMap = Checkout.findCheckout();
        String[] checkout = checkoutMap.get(score);
        if(checkout != null){
            System.out.println("Checkout options for " + score + ": " + Arrays.toString(checkout));
        }
    }
}