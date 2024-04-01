package TicTacToe;

import java.util.List;

public class MoveUtility {

    public static Move checkBlock(Board b) {
        List<Move> moves = b.getPossibleMoves();

        return null;
    }

    public static Move checkWin(Board b) {
        List<Move> moves = b.getPossibleMoves();

        return null;
    }

    public static Move generateRandomMove(Board b) {
        List<Move> moves = b.getPossibleMoves();

        return moves.get((int) (Math.random() * moves.size()));
    }
}
