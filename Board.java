package TicTacToe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private Tile[][] board;

    public Board() {
        board = new Tile[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Tile();
            }
        }
    }

    public Tile getTile(int x, int y) {
        return board[x][y];
    }

    public void reset() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].setValue(0);
            }
        }
    }

    public List<Move> getPossibleMoves() {
        List<Move> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getValue() == 0) {
                    Move temp = new Move(i, j, getTurn());
                    result.add(temp);
                }
            }
        }

        return result;
    }

    public int isEnd() {
        // 0 if ongoing, 1 if X win, 2 if O win, 3 if tied

        // horizontal win for x
        for (int i = 0; i < board.length; i++) {
            if (board[i][0].getValue() == 1 && board[i][1].getValue() == 1 && board[i][2].getValue() == 1) {
                return 1;
            }
        }

        // horizontal win for o
        for (int i = 0; i < board.length; i++) {
            if (board[i][0].getValue() == 2 && board[i][1].getValue() == 2 && board[i][2].getValue() == 2) {
                return 2;
            }
        }

        // vertical win for x
        for (int i = 0; i < board.length; i++) {
            if (board[0][i].getValue() == 1 && board[1][i].getValue() == 1 && board[2][i].getValue() == 1) {
                return 1;
            }
        }

        // vertical win o
        for (int i = 0; i < board.length; i++) {
            if (board[0][i].getValue() == 2 && board[1][i].getValue() == 2 && board[2][i].getValue() == 2) {
                return 2;
            }
        }

        // diagnol win for x
        if (board[0][0].getValue() == 1 && board[1][1].getValue() == 1 && board[2][2].getValue() == 1) {
            return 1;
        }

        if (board[2][0].getValue() == 1 && board[1][1].getValue() == 1 && board[0][2].getValue() == 1) {
            return 1;
        }

        // diagnol win for o
        if (board[0][0].getValue() == 2 && board[1][1].getValue() == 2 && board[2][2].getValue() == 2) {
            return 2;
        }

        if (board[2][0].getValue() == 2 && board[1][1].getValue() == 2 && board[0][2].getValue() == 2) {
            return 2;
        }

        if (!checkFull()) {
            return 0;
        }

        return 3;
    }

    private boolean checkFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getValue() == 0) {
                    return false;
                }
            } 
        }

        return true;
    }

    public void makeMove(Move m) {
        if (board[m.getRow()][m.getCol()].getValue() == 0) {
            board[m.getRow()][m.getCol()].setValue(m.getPlayer());
        } else {
            return;
        }
    }

    /**
     * Returns the next move to be played by counting the other moves on the board
     * @return 1 for x, 2 for o
     */
    public int getTurn() {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getValue() != 0) {
                    count++;
                }
            }
        }

        if (count % 2 == 0) {
            return 1;
        }

        return 2;
    }

    private char convertToSymbol(int value) {
        if (value == 0) {
            return '_';
        } else if (value == 1) {
            return 'X';
        }

        return 'O';
    }

    @Override
    public String toString() {
        String result = "";

        for (Tile[] r : board) {
            for (Tile c : r) {
                result += convertToSymbol(c.getValue()) + " ";
            }
            result += "\n";
        }

        return result;
    }
}
