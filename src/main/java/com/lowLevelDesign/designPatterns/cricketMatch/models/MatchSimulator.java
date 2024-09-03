package com.lowLevelDesign.designPatterns.cricketMatch.models;

import java.util.ArrayList;
import java.util.List;

public class MatchSimulator {

    public static void main(String[] args) {
        int noOfPlayerTeam1 = 11;
        int noOfPlayersTeam2 = 11;
        int noOfOvers = 20;
        int isTeam1Batting = 1;

        List<Player> team1Players = new ArrayList<>();
        List<Player> team2Players = new ArrayList<>();
        for (int i = 0; i < noOfPlayerTeam1; i++) {
            team1Players.add(new Player("Player" + (i + 1)));
        }
        for (int i = 0; i < noOfPlayersTeam2; i++) {
            team2Players.add(new Player("Player" + (i + 1)));
        }
        Team team1 = new Team("Team1", team1Players, isTeam1Batting == 1 ? Activity.BATTING : Activity.BOWLING);
        Team team2 = new Team("Team2", team2Players, isTeam1Batting == 1 ? Activity.BOWLING : Activity.BATTING);

        Match match = new Match(team1, team2, null, noOfOvers, 0, 0, new ArrayList<>());
        match.startMatch();
    }
}