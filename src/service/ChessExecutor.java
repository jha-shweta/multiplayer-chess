package service;

import models.Board;
import models.Piece;
import models.Player;
import models.Position;

/**
 * Created by saurabh.jha on 04/02/17.
 */
public interface ChessExecutor {

    public boolean play(Player player, Board board, Piece piece, Position destination);

    public boolean isCheked(Player player, Board board);
}
