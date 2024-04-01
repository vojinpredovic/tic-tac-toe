package TicTacToe;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private Scanner console;

    public HumanPlayer() {
        this.console = new Scanner(System.in);
    }

    public Move generateMove(Board board) {
        System.out.println("Enter row and column (0-2): ");
        int row = console.nextInt();
        int col = console.nextInt();
        return new Move(row, col, board.getTurn());
    }
}
