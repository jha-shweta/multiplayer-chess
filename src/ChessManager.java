import commons.Constants;
import models.*;
import service.ChessExecutor;
import service.impl.ChessExecutorImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saurabh.jha on 04/02/17.
 */
public class ChessManager {
    private Player winner;
    private Player player1;
    private Player player2;
    private Board board;
    private ChessExecutor chessExecutor;

    ChessManager(){
        init();
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }


    private void init(){
        board = new Board();
        Piece[][] pieces = new Piece[Constants.MAX_SIZE][Constants.MAX_SIZE];
        player1 = new Player(1, "player1", Constants.WHITE_COLOUR);
        player2 = new Player(2, "player2", Constants.BLACK_COLOUR);
        for (int i = 0; i < Constants.MAX_SIZE; i++){
            for (int j = 0; j < Constants.MAX_SIZE; j++){
                allocatePieces(i, j, pieces);
            }
        }
        board.setBoard(pieces);
        chessExecutor = new ChessExecutorImpl();
    }

    private void allocatePieces(int i, int j, Piece[][] pieces) {
        if (i == 0){
            if (j == 0 || j == Constants.MAX_SIZE - 1){
                Piece rook = new Rook();
                rook.setId(1);
                rook.setName("rook");
                rook.setColour(Constants.WHITE_COLOUR);
                player1.getPieces().put(player1.getName() + rook.getName(), rook);
                pieces[i][j] = rook;
            } else if (j == 1 || j == Constants.WHITE_COLOUR - 2){
                Piece knight = new Knight();
                knight.setId(1);
                knight.setName("knight");
                knight.setColour(Constants.WHITE_COLOUR);
                player1.getPieces().put(player1.getName() + knight.getName(), knight);
                pieces[i][j] = knight;
            } else if (j == 2 || j == Constants.BLACK_COLOUR - 3){
                Piece bishop = new Bishop();
                bishop.setId(1);
                bishop.setName("bishop");
                bishop.setColour(Constants.WHITE_COLOUR);
                player1.getPieces().put(player1.getName() + bishop.getName(), bishop);
                pieces[i][j] = bishop;
            } else if (j == 3){
                Piece queen = new Queen();
                queen.setId(1);
                queen.setName("queen");
                queen.setColour(Constants.WHITE_COLOUR);
                player1.getPieces().put(player1.getName() + queen.getName(), queen);
                pieces[i][j] = queen;
            } else if (j == 4){
                Piece king = new King();
                king.setId(1);
                king.setName("king");
                king.setColour(Constants.WHITE_COLOUR);
                player1.getPieces().put(player1.getName() + king.getName(), king);
                pieces[i][j] = king;
            }
        } else if (i == 1){
            Piece pawn = new Pawn();
            pawn.setId(1);
            pawn.setColour(Constants.WHITE_COLOUR);
            player1.getPieces().put(player1.getName() + pawn.getName(), pawn);
            pieces[i][j] = pawn;
        } else if (i == Constants.MAX_SIZE - 2){
            Piece pawn = new Pawn();
            pawn.setId(1);
            pawn.setColour(Constants.WHITE_COLOUR);
            player2.getPieces().put(player2.getName() + pawn.getName(), pawn);
            pieces[i][j] = pawn;
        } else if (i == Constants.MAX_SIZE - 1){
            if (j == 0 || j == Constants.MAX_SIZE - 1){
                Piece rook = new Rook();
                rook.setId(2);
                rook.setName("rook");
                rook.setColour(Constants.WHITE_COLOUR);
                player2.getPieces().put(player2.getName() + rook.getName(), rook);
                pieces[i][j] = rook;
            } else if (j == 1 || j == Constants.WHITE_COLOUR - 2){
                Piece knight = new Knight();
                knight.setId(2);
                knight.setName("knight");
                knight.setColour(Constants.WHITE_COLOUR);
                player2.getPieces().put(player2.getName() + knight.getName(), knight);
                pieces[i][j] = knight;
            } else if (j == 2 || j == Constants.BLACK_COLOUR - 3){
                Piece bishop = new Bishop();
                bishop.setId(2);
                bishop.setName("bishop");
                bishop.setColour(Constants.WHITE_COLOUR);
                player2.getPieces().put(player2.getName() + bishop.getName(), bishop);
                pieces[i][j] = bishop;
            } else if (j == 3){
                Piece queen = new Queen();
                queen.setId(2);
                queen.setName("queen");
                queen.setColour(Constants.WHITE_COLOUR);
                player2.getPieces().put(player2.getName() + queen.getName(), queen);
                pieces[i][j] = queen;
            } else if (j == 4){
                Piece king = new King();
                king.setId(2);
                king.setName("king");
                king.setColour(Constants.WHITE_COLOUR);
                player2.getPieces().put(player2.getName() + king.getName(), king);
                pieces[i][j] = king;
            }

        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean play(int playerId, String pieceName, int xPostion, int yPosition){
        Position position = new Position();
        position.setX(xPostion);
        position.setY(yPosition);
        if (playerId == 1){
            Piece piece = player1.getPieces().get(player1.getName() + pieceName);
            Piece destinationPiece = board.getBoard()[xPostion][yPosition];
            if (chessExecutor.play(player1, board, piece, position)){
                player2.getPieces().remove(player2.getName() + destinationPiece.getName());
            }
        }
        return true;
    }

    public Board getBoard() {
        return board;
    }
}
