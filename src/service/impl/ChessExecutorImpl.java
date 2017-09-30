package service.impl;

import models.Board;
import models.Piece;
import models.Player;
import models.Position;
import service.ChessExecutor;

/**
 * Created by saurabh.jha on 04/02/17.
 */
public class ChessExecutorImpl implements ChessExecutor {
    @Override
    public boolean play(Player player, Board board, Piece piece, Position destination) {
        if (!piece.move(board, destination))
            return false;
        if (board.getBoard()[destination.getX()][destination.getY()].getId() == player.getId())
            return false;
        board.getBoard()[destination.getX()][destination.getY()] = piece;
        return true;
    }

    @Override
    public boolean isCheked(Player player, Board board) {
        return false;
    }


}
