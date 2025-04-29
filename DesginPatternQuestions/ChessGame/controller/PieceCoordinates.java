package ChessGame.controller;

public class PieceCoordinates {
    private int row;
    private int col;

    PieceCoordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
