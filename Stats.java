import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
  
public class Stats{
    static ArrayList<Integer> dartsStats1 = new ArrayList<>();
    static ArrayList<Integer> dartsStats2 = new ArrayList<>();

    public static void Statistics(List <Integer> dartsStats){
        dartsStats1.clear();
        dartsStats2.clear();   
        int j = 0;
        for(int i = 0; i < dartsStats.size(); i++){
            if (j < 3){
                dartsStats1.add(dartsStats.get(i));
                j++;
            }
            else if (j >= 3 &&  j< 6){
                dartsStats2.add(dartsStats.get(i));
                j++;
            }
            else if(j == 6){
                dartsStats1.add(dartsStats.get(i));
                j = 1;
            }
        }
        StatisticsHelper(dartsStats1, "Player 1");
        StatisticsHelper(dartsStats2, "Player 2");
    }
        
    public static void StatisticsHelper(ArrayList<Integer> dartsStats, String playerName){
        int[] dartsStatsArray = new int[dartsStats.size()];
        for(int i = 0; i< dartsStats.size(); i++){
            dartsStatsArray[i] = dartsStats.get(i);
        }
        double threeDartAverage = 0;
        for(int i: dartsStatsArray){
            threeDartAverage += i;
        }
        if(dartsStatsArray.length == 0){
            threeDartAverage = 0;
        }
        threeDartAverage /= (dartsStatsArray.length);
        threeDartAverage = Math.round(threeDartAverage*3);
        
        int TripleTwentyCount = Collections.frequency(dartsStats, 60);
        int bullseyeCount = Collections.frequency(dartsStats, 50);

        System.out.println(playerName + "'s Three dart average: " + threeDartAverage);
        System.out.println(playerName + " hit: " + bullseyeCount + " bullseyes");
        System.out.println(playerName + " hit: " + TripleTwentyCount + " triple twenties");
    }
}