package com.lowLevelDesign.designPatterns.cricketMatch.models;

import lombok.Data;

@Data
public class Player {
    private String name;
    private int runs;
    private int ballsFaced;
    private int fours;
    private int sixes;

    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.ballsFaced = 0;
        this.fours = 0;
        this.sixes = 0;
    }

    public void addRuns(int runs) {
        this.runs += runs;
        this.ballsFaced++;
        if (runs == 4) {
            this.fours++;
        } else if (runs == 6) {
            this.sixes++;
        }
    }
}