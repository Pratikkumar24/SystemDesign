package TicTacToe.Board;

import TicTacToe.Enum.GameState;
import TicTacToe.Pieces.Piece;
import TicTacToe.Players.Player;

public class BoardGame {
    int size;
    Piece[][] board;
    public BoardGame(int size) {
        this.size = size;
        board = new Piece[size][size];
    }

    public void printBoard() {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(board[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(board[i][j].getPieceType());
                }
                if(j != size-1) {
                    System.out.print("|");
                }
            }
            if(i != size-1) {
                System.out.println();
                for(int j=0; j<size; j++) {
                    System.out.print("--");
                }
                System.out.println();
            }
        }
    }

    public boolean addPiece(int x, int y, Piece piece) {
        if(x<0 || x>=size || y<0 || y>=size) {
            return false;
        }
        if(board[x][y] != null) {
            return false;
        }
        board[x][y] = piece;
        return true;
    }

    public GameState checkGameState(Player player) {
        // Check row-wise
        for (int row = 0; row < size; row++) {
            boolean isSame = true;
            for (int col = 1; col < size; col++) {
                if (board[row][col] == null || !board[row][col].equals(board[row][col - 1])) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return GameState.WIN;
            }
        }
    
        // Check column-wise
        for (int col = 0; col < size; col++) {
            boolean isSame = true;
            for (int row = 1; row < size; row++) {
                if (board[row][col] == null || !board[row][col].equals(board[row - 1][col])) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return GameState.WIN;
            }
        }
    
        // Check main diagonal (top-left to bottom-right)
        boolean isMainDiagonalSame = true;
        for (int i = 1; i < size; i++) {
            if (board[i][i] == null || !board[i][i].equals(board[i - 1][i - 1])) {
                isMainDiagonalSame = false;
                break;
            }
        }
        if (isMainDiagonalSame) {
            return GameState.WIN;
        }
    
        // Check anti-diagonal (top-right to bottom-left)
        boolean isAntiDiagonalSame = true;
        for (int i = 1; i < size; i++) {
            if (board[i][size - 1 - i] == null || !board[i][size - 1 - i].equals(board[i - 1][size - i])) {
                isAntiDiagonalSame = false;
                break;
            }
        }
        if (isAntiDiagonalSame) {
            return GameState.WIN;
        }
    
        // Check if pieces are left
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == null) {
                    return GameState.IN_PROGRESS;
                }
            }
        }
    
        return GameState.DRAW;
    }

}
