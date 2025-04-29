package SnakeGame.coordinateGenerator;

import java.util.Random;

import SnakeGame.snake.Snake;
import SnakeGame.snakeboard.Board;

public class Generator {
    static Random random = new Random();

    public static int[] generateCoordinatePoint(Board board) {
        int[] matrixSize = board.getMatrixSize();

        if (!isSpaceLeft(board)) {
            return new int[]{-1, -1};
        }
        int x, y;
        do {
            x = random.nextInt(matrixSize[0]);
            y = random.nextInt(matrixSize[1]);
        } while(isPlaceFilled(board, x, y));

        return new int[]{x, y};
    }

    private static boolean isPlaceFilled(Board board, int x, int y) {
        Snake snake = board.getSnake();
        boolean isPresent = false;
        while (snake!=null) {
            int[] coor = snake.getSnakeCoordinates();
            if (coor[0] == x && coor[1] == y) {
                isPresent = true;
            }
            snake = snake.getNext();
        }
        
        return isPresent;
    }

    private static boolean isSpaceLeft(Board board) {
        int length = 0;
        Snake snake = board.getSnake();
        int[] size = board.getMatrixSize();
        while (snake!=null) {
            length++;
            snake = snake.getNext();
        }
        int totalSize = size[0] * size[1];
        return length<totalSize;
    }
}
