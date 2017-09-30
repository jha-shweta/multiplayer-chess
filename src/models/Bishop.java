package models;

/**
 * Created by saurabh.jha on 04/02/17.
 */
public class Bishop extends Piece {

    @Override
    public boolean move(Board board, Position destination) {
        if (!validate(board, destination))
            return false;
        return true;
    }

    public boolean validate(Board board, Position destination){
        if (!super.validate(board, destination))
            return false;
        if (Math.abs(destination.getX() - currentPosition.getX()) == Math.abs(destination.getY() - currentPosition.getY()))
            return true;
        return false;
    }
}
