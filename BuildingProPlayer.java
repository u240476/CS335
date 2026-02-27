package com.example;
public class BuildingProPlayer{

      public static double[] ChoosingPlayer(String player){
          switch (player) {
              case "Luke Littler" ->
              {
                  double TriplePercentage = 47.6;
                  double NumberPercentage = 45.4;
                  double leftPercentage = 3.5;
                  double rightPercentage = 3.5;
                  double checkoutPercentage = 64.2;
                  double checkoutNumberPercentage = 17.9;
                  double outPercentage = 17.9;
                  double twentyChance = 80.0;
                  double nineteenChance = 15.0;
                  double eighteenChance = 5.0;
                  return new double[]{TriplePercentage, NumberPercentage, leftPercentage, rightPercentage, checkoutPercentage, checkoutNumberPercentage, outPercentage, twentyChance, nineteenChance, eighteenChance};
              }
              case "Luke Humphries" ->
              {
                  double TriplePercentage = 44.0;
                  double NumberPercentage = 48.6;
                  double leftPercentage = 3.7;
                  double rightPercentage = 3.7;
                  double checkoutPercentage = 67.0;
                  double checkoutNumberPercentage = 16.5;
                  double outPercentage = 16.5;
                  double twentyChance = 80.0;
                  double nineteenChance = 15.0;
                  double eighteenChance = 5.0;
                  return new double[]{TriplePercentage, NumberPercentage, leftPercentage, rightPercentage, checkoutPercentage, checkoutNumberPercentage, outPercentage, twentyChance, nineteenChance, eighteenChance};
              }     case "Michael van Gerwen" ->
              {
                  double TriplePercentage = 48.0;
                  double NumberPercentage = 42.0;
                  double leftPercentage = 5.0;
                  double rightPercentage = 5.0;
                  double checkoutPercentage = 39.0;
                  double checkoutNumberPercentage = 30.5;
                  double outPercentage = 30.5;
                  double twentyChance = 80.0;
                  double nineteenChance = 15.0;
                  double eighteenChance = 5.0;
                 return new double[]{TriplePercentage, NumberPercentage, leftPercentage, rightPercentage, checkoutPercentage, checkoutNumberPercentage, outPercentage, twentyChance, nineteenChance, eighteenChance};
              }     default -> throw new IllegalArgumentException("Invalid player name");
          }
        }
}
