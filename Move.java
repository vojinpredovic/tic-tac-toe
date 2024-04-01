package TicTacToe;

public class Move {
    private int row;
    private int col;
    private int player; // 1 for x, 2 for o

    public Move(int row, int col, int player) {
        this.row = row;
        this.col = col;
        this.player = player;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getPlayer() {
        return player;
    }
}
