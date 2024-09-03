package com.lowLevelDesign.designPatterns.cricketMatch.models;

import com.lowLevelDesign.designPatterns.cricketMatch.models.event.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Match {
    private Team team1;
    private Team team2;
    private String winner;
    private int noOfOvers;
    private int totalScore;
    private int totalWickets;
    private List<Over> overs;


    public void startMatch() {

        playInnings(team1, team2);
        int team1Score = totalScore;
        int team1Wickets = totalWickets;


        totalScore = 0;
        totalWickets = 0;
        overs = new ArrayList<>();


        playInnings(team2, team1);
        int team2Score = totalScore;
        int team2Wickets = totalWickets;

        determineWinner(team1Score, team2Score);
    }

    private void playInnings(Team battingTeam, Team bowlingTeam) {
        int wickets = 0;
        int overNo = 0;
        Player striker = battingTeam.getPlayers().get(wickets);
        Player nonStriker = battingTeam.getPlayers().get(wickets + 1);
        overs = new ArrayList<>();

        while (overNo < noOfOvers && wickets < 10) {
            Over over = new Over(bowlingTeam.getPlayers().get(overNo % 11), striker, nonStriker);
            for (int ball = 0; ball < 6; ball++) {
                Bowl bowl = getBowl();
                over.addBowl(bowl);
                if (bowl instanceof Run) {
                    int runs = ((Run) bowl).getRuns();
                    striker.addRuns(runs);
                    totalScore += runs;
                    if (runs == 1 || runs == 3) {
                        Player temp = striker;
                        striker = nonStriker;
                        nonStriker = temp;
                    }
                } else if (bowl instanceof Wicket) {
                    wickets++;
                    totalWickets++;
                    if (wickets < 10) {
                        striker = battingTeam.getPlayers().get(wickets + 1);
                    } else {
                        break;
                    }
                }
            }
            overs.add(over);
            Player temp = striker;
            striker = nonStriker;
            nonStriker = temp;
            overNo++;
            printOverSummary(over, overNo);
        }
    }

    public Bowl getBowl() {
        int max = 9;
        int rand = (int) (Math.random() * max);
        int eventNo = rand % max;
        switch (eventNo) {
            case 0:
                return new Run(0);
            case 1:
                return new Run(1);
            case 2:
                return new Run(2);
            case 3:
                return new Run(3);
            case 4:
                return new Run(4);
            case 5:
                return new Run(6);
            case 6:
                return new Wicket();
            case 7:
                return new Wide();
            case 8:
                return new NoBall();
            default:
                return new Run(0);
        }
    }

    public void printOverSummary(Over over, int overNo) {
        System.out.println("Over " + overNo);
        for (Bowl bowl : over.getBowls()) {
            System.out.println(bowl.getMessage());
        }
        System.out.println("Total Score :" + totalScore);
        System.out.println("Total Wickets: " + totalWickets);
        System.out.println("Striker:" + over.getStriker().getName() + ",Runs: " + over.getStriker().getRuns() + ",Balls: " + over.getStriker().getBallsFaced() + ",4s: " + over.getStriker().getFours() + ",6s: " + over.getStriker().getSixes());
        System.out.println("Non-Striker :" + over.getNonStriker().getName() + ",Runs: " + over.getNonStriker().getRuns() + ",Balls: " + over.getNonStriker().getBallsFaced() + ",4s: " + over.getNonStriker().getFours() + ",6s: " + over.getNonStriker().getSixes());
        System.out.println();
    }

    public void determineWinner(int team1Score, int team2Score) {
        if (team1Score > team2Score) {
            winner = team1.getName();
        } else if (team2Score > team1Score) {
            winner = team2.getName();
        } else {
            winner = "draw";
        }
        System.out.println("result : " + winner);
    }


}
