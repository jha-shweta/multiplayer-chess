package models;

import commons.Constants;

/**
 * Created by saurabh.jha on 04/02/17.
 */
public class Pawn extends Piece{

    @Override
    public boolean move(Board board, Position destination) {
        if (!validate(board, destination))
            return false;
        return true;
    }

    public boolean validate(Board board, Position destination){
        if (!super.validate(board, destination))
            return false;
        if (destination.getX() == currentPosition.getX() + 1 && destination.getY() == currentPosition.getY())
            return true;
        if (destination.getX() == currentPosition.getX() + 1 && destination.getY() == currentPosition.getY() + 1)
            return true;
        return false;
    }
}
