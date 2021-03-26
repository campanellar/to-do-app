/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aicampanella2;

import gipf_game.Gipf_Game;
import gipf_game.Gipf_Playable;
import gipf_game.Run;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Justin
 */
public class Player_Agent implements Gipf_Playable{
    
    String[] edgeSpots;
    Gipf_Game game;
    Integer[][] state = new Integer[9][];
    private Tree tree;
    private char[] letterValues = "abcdefghi".toCharArray();
    int maxEval;
    String moveStartLocation;
    Integer moveDir;
    
    public final String[] legalEdgeSpotMoves = {"e 1 0", "e 9 3", "d 1 0", "d 1 1", "d 8 3", "d 8 2", 
        "f 1 0", "f 1 5", "f 8 3", "f 8 4", "c 1 0", "c 1 1", "c 7 3", "c 7 2", "g 1 0", "g 1 5", 
        "g 7 3", "g 7 4", "b 1 0", "b 1 1", "b 6 3", "b 6 2", "h 1 0", "h 1 5", "h 6 3", "h 6 4", 
        "a 1 1", "a 5 2", "i 1 5", "i 5 4", "a 2 1", "a 2 2", "a 3 1", "a 3 2", "a 4 1", "a 4 2", 
        "i 2 4", "i 2 5", "i 3 4", "i 3 5", "i 4 4", "i 4 5"};

    public Player_Agent(Gipf_Game g) {
       this.edgeSpots = g.getEdgeSpots();
       this.game = g;
       this.tree = new Tree(g);
       buildTree();
       this.setState(game.getBoardCopy());
       this.moveTree();
    }
    
    //creates a copy of the currentstate of the board
    private void setState(Integer[][] s){
        state = s;
    }
    
    public void buildTree() {
        String spot = "";
        
        for(int i = 0; i < this.legalEdgeSpotMoves.length; i++) {
            spot = legalEdgeSpotMoves[i];
            
            if(!isColumnFull(spot)) {
                Gipf_Game g = new Gipf_Game(this.game);
                g.makeMove(spot, g.getPiecesLeft(0));
                tree.getRoot().addChild(new Node(g));
                System.out.println("Move " + spot + " added to tree");
            }
        }
    }
    
    public boolean isColumnFull(String spot) {
        
        String[] pMove = spot.split(" ");
        String c = pMove[0];
        Integer col = Arrays.binarySearch(this.letterValues, c.charAt(0));
        Integer pos = Integer.parseInt(pMove[1]) - 1;
        Integer dir = Integer.parseInt(pMove[2]);
        int counter = 0;
        
        //length of the column
        for(int i = 0; i < this.game.getBoardCopy().length; i++) {
            for(int j = 0; j < this.game.getBoardCopy()[col].length; j++) {
                if (!this.game.getBoardCopy()[col][pos].equals(Gipf_Game.EMPTY))
                    counter++;
            }
        }
        
        if(counter >= this.game.getBoardCopy()[col].length)
            return true;
        else
            return false;
    }
        
    //create tree of depth one and find child with best eval value
    //change to private
    public void moveTree(){
        this.maxEval = 0;
        this.moveStartLocation = this.game.edgeSpots[0];
        this.moveDir = 1;
        
        System.out.println("_________________________________________________");
        //this.game.printBoard();
        //this.game.makeMove(this.game.edgeSpots[0], 1);
        //loop to make one move at each of the starting locations
        /*for(int i = 0; i < 4; i++){
            //System.out.println(this.game.edgeSpots[i]);
            
            
            this.game.printBoard();
        }*/
    }

    @Override
    public String makeGipfMove(int curPlayer) {
        //makes tree to find move
        //moveTree();
        System.out.println("We make a move");
        //System.out.println(moveStartLocation+ " " + Integer.toString(moveDir));
        //applies the move that was decided
        return moveStartLocation+ " " + Integer.toString(moveDir);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}