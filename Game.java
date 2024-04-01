package TicTacToe;

public class Game {
    private Board board;
    private Player p1;
    private Player p2;

    public Game(Player p1, Player p2) {
        this.board = new Board();
        this.p1 = p1;
        this.p2 = p2;
    }

    public int play() {
        int randomNumber = (int) (Math.random() * 2) + 1;

        if (randomNumber == 1) {
            while (isEnd() == 0) {
                board.makeMove(p2.generateMove(board));
                System.out.println(toString());
                if (isEnd() != 0) {
                    break;
                }
                board.makeMove(p1.generateMove(board));
            }

            System.out.println(toString());
        } else {
            while (isEnd() == 0) {
                System.out.println(toString());
                board.makeMove(p1.generateMove(board));
                if (isEnd() != 0) {
                    break;
                }
                board.makeMove(p2.generateMove(board));
            }
    
            System.out.println(toString());
        }

        if (isEnd() == 1) {
            System.out.println("Victory for X");
            return 1;
        } else if (isEnd() == 2) {
            System.out.println("Victory for O");
            return 2;
        } else {
            System.out.println("Draw");
            return 3;
        }
    }

    public int isEnd() {
        return board.isEnd();
    }

    public void makeMove(Move m) {
        board.makeMove(m);
    }

    public String toString() {
        return board.toString();
    }
}
