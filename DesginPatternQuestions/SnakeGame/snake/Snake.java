package SnakeGame.snake;

public class Snake {
    int id;
    Snake head;
    Snake tail;
    int row, col;

    public Snake(int row, int col) {
        this.row = row;
        this.col = col;
        head = null;
        tail = null;
    }

    public int[] getSnakeCoordinates() {
        return new int[]{row, col};
    }

    public int getSnakeId() {
        return this.id;
    }
    
    public void addToTail(Snake tailSnake) {
        this.tail = tailSnake;
    }

    public void removeTail() {
        this.tail = null;
    }

    public Snake getNext() {
        return this.tail;
    }
}
