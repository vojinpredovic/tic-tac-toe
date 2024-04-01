package TicTacToe;

public class Tile {
    private int value; // 0 for nothing, 1 for x, and 2 for o

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
        this(0);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
