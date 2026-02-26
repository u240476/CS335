import java.util.ArrayList;
import java.util.List;
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
    static List<Integer> dartsStats = new ArrayList<>();
    public static void main(String[] args){
        int game = Game.gettingGame();
        int score1 = game;
        int score2 = game;
        while (score1>0 && score2>0){ 
            score1 = updatingScore(score1, "Player 1");
            System.out.println("Player 1: " + score1);
            if(score1 == 0){
                break;
            }
            score2 = updatingScore(score2, "Player 2");
            System.out.println("Player 2: " + score2);
        }
        
        Stats.Statistics(dartsStats);
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
        Checkout.findCheckout(newscore);
        for(int i = 3; i>0; i--){
            int dart = 0;
            while (true) { 
                dart = sc1.nextInt();
                if(Darts.checkingValidDarts(dart)){
                    break;
                }else{
                    System.out.println("Invalid dart, please enter a valid dart:");
                }
            }
            newscore = score - dart; 
            if(newscore == 0 && Doubles.checkingValidDoubles(dart)){
                System.out.println("Congratulations you win!");
                storingStatistics(dart);
                return 0;
            } else if(newscore == 0 && !Doubles.checkingValidDoubles(dart)){
                System.out.println("You must finish on a double!");
                storingStatistics(0);
                return newscore+dart;
            } else if(newscore <= 1 && score != 0){
                System.out.println("bust!");
                storingStatistics(0);
                return newscore+dart;
            }else{
                score = newscore;
                Checkout.findCheckout(newscore);
                storingStatistics(dart);
            }
        }
        return newscore;
    }
    public static void storingStatistics(int dart){
        dartsStats.add(dart);
    }
}