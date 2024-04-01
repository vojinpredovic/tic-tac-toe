package TicTacToe;

import java.util.List;

public class RandomPlayer implements Player{

    public Move generateMove(Board b) {
        return MoveUtility.generateRandomMove(b);
    }
}
