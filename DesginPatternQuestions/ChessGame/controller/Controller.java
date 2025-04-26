package controller;

import java.util.Scanner;

import board.Board;
import player.Player;
import type.PieceType;

public class Controller {

    Scanner scanner = new Scanner(System.in);

    public boolean isValid(int row, int col, Board board) {
        return row>=0 && col>=0 && row<8 && col<8;
    }

    public PieceCoordinates selectStartPiece(Board board, Player player) {
        System.out.println("Enter the row and col of your piece type");
        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();

        if (!isValid(startRow, startCol, board)) {
            System.out.println("[-] Can't pick up this piece");
            return new PieceCoordinates(-1, -1);
        }
        
        if (board.getPieces(startRow, startCol) == null) {
            return new PieceCoordinates(startRow, startCol);
        }
        PieceType foundPlayerPieceType = board.getPieces(startRow, startCol).getPieceType();
        PieceType currPlayerPieceType = player.getPieceType();
        if (foundPlayerPieceType != currPlayerPieceType) {
            System.out.println("Can't choose this place");
            return new PieceCoordinates(-1, -1);
        }
        return new PieceCoordinates(startRow, startCol);
    }

    public PieceCoordinates selectDestination(Board board, Player player) {
        System.out.println("Enter the destination row and col of your piece type");
        int desRow = scanner.nextInt();
        int desCol = scanner.nextInt();

        if (!isValid(desRow, desCol, board)) {
            return new PieceCoordinates(-1, -1);
        }

        if (board.getPieces(desRow, desCol) == null) {
            return new PieceCoordinates(desRow, desCol);
        }
        PieceType foundPlayerPieceType = board.getPieces(desRow, desCol).getPieceType();
        PieceType currPlayerPieceType = player.getPieceType();

        if (foundPlayerPieceType == currPlayerPieceType) {
            System.out.println("Can't keep at this place");
            return new PieceCoordinates(-1, -1);
        }

        return new PieceCoordinates(desRow, desCol);
    }
}
