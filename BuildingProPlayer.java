package com.example;
public class BuildingProPlayer{

      public static double[] ChoosingPlayer(String player){
          switch (player) {
              case "Luke Littler" ->
              {
                  double TriplePercentage = 47.6;
                  double NumberPercentage = 42.4;
                  double leftPercentage = 5.0;
                  double rightPercentage = 5.0;
                  double checkoutPercentage = 75.5;
                  double checkoutNumberPercentage = 12.5;
                  double outPercentage = 12.0;
                  double twentyChance = 80.0;
                  double nineteenChance = 10.0;
                  double eighteenChance = 10.0;
                  return new double[]{TriplePercentage, NumberPercentage, leftPercentage, rightPercentage, checkoutPercentage, checkoutNumberPercentage, outPercentage, twentyChance, nineteenChance, eighteenChance};
              }
              case "Luke Humphries" ->
              {
                  double TriplePercentage = 47.6;
                  double NumberPercentage = 42.4;
                  double leftPercentage = 5.0;
                  double rightPercentage = 5.0;
                  double checkoutPercentage = 75.5;
                  double checkoutNumberPercentage = 12.5;
                  double outPercentage = 12.0;
                  double twentyChance = 80.0;
                  double nineteenChance = 10.0;
                  double eighteenChance = 10.0;
                  return new double[]{TriplePercentage, NumberPercentage, leftPercentage, rightPercentage, checkoutPercentage, checkoutNumberPercentage, outPercentage, twentyChance, nineteenChance, eighteenChance};
              }     case "Michael van Gerwen" ->
              {
                  double TriplePercentage = 47.6;
                  double NumberPercentage = 42.4;
                  double leftPercentage = 5.0;
                  double rightPercentage = 5.0;
                  double checkoutPercentage = 75.5;
                  double checkoutNumberPercentage = 12.5;
                  double outPercentage = 12.0;
                  double twentyChance = 80.0;
                  double nineteenChance = 10.0;
                  double eighteenChance = 10.0;
                 return new double[]{TriplePercentage, NumberPercentage, leftPercentage, rightPercentage, checkoutPercentage, checkoutNumberPercentage, outPercentage, twentyChance, nineteenChance, eighteenChance};
              }     default -> throw new IllegalArgumentException("Invalid player name");
          }
        }
}