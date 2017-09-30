package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saurabh.jha on 04/02/17.
 */
public class Player {

    private final int id;
    private final String name;
    private final int colourType;
    private Map<String, Piece> pieces = new HashMap<>();
    private int score;

    public Player(int id, String name, int colourType){
        this.id = id;
        this.name = name;
        this.colourType = colourType;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getColourType() {
        return colourType;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Map<String, Piece> getPieces() {
        return pieces;
    }

    public void setPieces(Map<String, Piece> pieces) {
        this.pieces = pieces;
    }
}
