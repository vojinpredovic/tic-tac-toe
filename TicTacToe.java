package TicTacToe;

import java.util.Scanner;

import javax.swing.JFrame;

public class TicTacToe {
    public static void main(String[] args) {
        Player p1 = new HumanPlayer();
        Player p2 = new RandomPlayer();

        Game g = new Game(p1, p2);
        while (g.isEnd() == 0) {
            g.play();
        }
    }
}
