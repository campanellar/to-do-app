/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aicampanella2;

import gipf_game.Gipf_Game;

/**
 *
 * @author stuetzlec
 */
public class AICampanella2 {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        // Initialize the game with a random seed
        Gipf_Game g = new Gipf_Game( 85 );
        
        // Play the game with two agents
        System.out.println("Result: " + 
                g.playGame(new Random_Agent(g), 
                        new Player_Agent(g)) );
        //Player_Agent p = new Player_Agent(g);
        //p.moveTree();
        
        // testing copy constructor
        // GipfGame g2 = new GipfGame(g);
    }*/
    public static void main(String[] args) {
        // Initialize the game with a random seed
        Gipf_Game g = new Gipf_Game( 85 );
        
        // Play the game with two agents
        System.out.println("Result: " + 
                g.playGame(new Random_Agent(g), 
                        new Random_Agent(g)) );
        
        Player_Agent player = new Player_Agent(g);
        
        // testing copy constructor
        // GipfGame g2 = new GipfGame(g);
    }

     
}
