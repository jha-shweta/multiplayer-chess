package models;

/**
 * Created by saurabh.jha on 04/02/17.
 */
public class Rook extends Piece {

    @Override
    public boolean move(Board board, Position destination) {
        if (!validate(board, destination))
            return false;
        return true;
    }

    public Rook(){

    }

    public boolean validate(Board board, Position destination){
        if (!super.validate(board, destination))
            return false;
        if (destination.getX() == currentPosition.getX() || destination.getY() == currentPosition.getY())
            return true;
        return false;
    }
}
