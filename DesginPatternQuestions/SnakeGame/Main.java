package SnakeGame;

import SnakeGame.snakeboard.Board;

public class Main {
    public static void main(String[] args) {
        Board board = Board.getInstance();
        board.setSizeOfBoard(5, 5);
    }
}
