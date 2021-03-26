/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aicampanella2;

import gipf_game.Gipf_Game;
import java.util.ArrayList;

/**
 *
 * @author rosemarycampanella
 */
public class Node {
    
    private ArrayList<Node> children;
    private Gipf_Game gameState;
    private int childNum;
    
    public Node(Gipf_Game gs) {
        
        this.children = new ArrayList<Node>();
        this.gameState = new Gipf_Game(gs);
        this.childNum = 0;
    }
    
    public void addChild(Node n) {
        this.children.add(n);
        this.childNum++;
    }
    
    public ArrayList<Node> getChildren() {
        return this.children;
    }
    
    public Gipf_Game getGameState() {
        return this.gameState;
    }
    
    public int getChildNum() {
        return this.childNum;
    }
    
    
}
