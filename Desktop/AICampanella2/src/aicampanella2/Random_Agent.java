package aicampanella2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gipf_game.Gipf_Game;
import gipf_game.Gipf_Playable;
import java.util.Random;

/**
 *
 * @author stuetzlec
 */
public class Random_Agent implements Gipf_Playable {

    String[] edgeSpots;
    String[] columns;
    Random rng;

    public Random_Agent(Gipf_Game g) {
        this.edgeSpots = g.getEdgeSpots();
        //this.columns = g.getColumns();
        rng = new Random(37);
    }

    @Override
    public String makeGipfMove(int curPlayer) {
        System.out.println("opponent move");
        String startLocation = edgeSpots[rng.nextInt(edgeSpots.length)];
        Integer dir = rng.nextInt(6);
        return startLocation + " " + Integer.toString(dir);
        //return "i 1 5";
    }

}
