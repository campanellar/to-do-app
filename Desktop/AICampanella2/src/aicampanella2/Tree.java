/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aicampanella2;

import gipf_game.Gipf_Game;

/**
 *
 * @author rosemarycampanella
 */
public class Tree {
    
    private Node root = null;
    
    Tree(Gipf_Game g) {
        this.root = new Node(g);
    }
    
    public Node getRoot() {
        return this.root;
    }
    
    public void setRoot(Node n) {
        this.root = new Node(n.getGameState());
    }
}
