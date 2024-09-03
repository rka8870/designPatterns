package com.lowLevelDesign.designPatterns.cricketMatch.models;

import com.lowLevelDesign.designPatterns.cricketMatch.models.event.Bowl;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Over {
    private List<Bowl> bowls;
    private Player bowler;
    private Player striker;
    private Player nonStriker;

    public Over(Player bowler, Player striker, Player nonStriker) {
        this.bowler = bowler;
        this.striker = striker;
        this.nonStriker = nonStriker;
        this.bowls = new ArrayList<>();
    }

    public void addBowl(Bowl bowl) {
        bowls.add(bowl);
    }

    public void printOverSummary() {
        // Print summary of the over
    }
}