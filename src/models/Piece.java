package models;

import commons.Constants;

/**
 * Created by saurabh.jha on 04/02/17.
 */
public abstract class Piece {
    private int id;
    private String name;
    private int colour;
    Position currentPosition = new Position();

    public boolean validate(Board board, Position destination){
        if(destination.getX() < 0 || destination.getY() >= Constants.MAX_SIZE ||
                destination.getY() < 0 || destination.getY() >= Constants.MAX_SIZE)
            return false;
        return true;
    }

    public abstract boolean move(Board board, Position destination);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }
}
