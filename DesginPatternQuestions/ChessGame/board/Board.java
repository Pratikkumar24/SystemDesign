package ChessGame.board;

import java.util.LinkedList;
import java.util.Queue;

import ChessGame.controller.Controller;
import ChessGame.controller.PieceCoordinates;
import ChessGame.pieces.Pieces;
import ChessGame.pieces.PiecesFactory;
import ChessGame.player.Player;
import ChessGame.type.ChessPiece;
import ChessGame.type.PieceType;

public class Board {
    Pieces[][] pieces;
    PiecesFactory piecesFactory;
    Queue<Player> queue;
    Controller controller;

    public Board(Player player1, Player player2) {
        pieces = new Pieces[8][8];
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                pieces[i][j] = null;
            }
        }
        piecesFactory = new PiecesFactory();
        controller = new Controller();
        initialize();
        queue = new LinkedList<>();
        queue.offer(player1);
        queue.offer(player2);
    }

    public Pieces getPieces(int row, int col) {
        return pieces[row][col];
    }

    public Pieces[][] getBoardPieces() {
        return pieces;
    }

    private void initialize() {
        pieces[0][0] = new Pieces(PieceType.WHITE_PIECE, ChessPiece.ROOK, piecesFactory.getPiecesFactory("rook"));
        pieces[0][1] = new Pieces(PieceType.WHITE_PIECE, ChessPiece.KNIGHT,piecesFactory.getPiecesFactory("knight"));
        pieces[0][2] = new Pieces(PieceType.WHITE_PIECE, ChessPiece.BISHOP,piecesFactory.getPiecesFactory("bishop"));
        pieces[0][3] = new Pieces(PieceType.WHITE_PIECE, ChessPiece.KING,piecesFactory.getPiecesFactory("king"));
        pieces[0][4] = new Pieces(PieceType.WHITE_PIECE, ChessPiece.QUEEN,piecesFactory.getPiecesFactory("queen"));
        pieces[0][5] = new Pieces(PieceType.WHITE_PIECE, ChessPiece.BISHOP,piecesFactory.getPiecesFactory("bishop"));
        pieces[0][6] = new Pieces(PieceType.WHITE_PIECE, ChessPiece.KNIGHT,piecesFactory.getPiecesFactory("knight"));
        pieces[0][7] = new Pieces(PieceType.WHITE_PIECE, ChessPiece.ROOK,piecesFactory.getPiecesFactory("rook"));

        fillPawn(1, PieceType.WHITE_PIECE);
        pieces[7][0] = new Pieces(PieceType.BLACK_PIECE, ChessPiece.ROOK,piecesFactory.getPiecesFactory("rook"));
        pieces[7][1] = new Pieces(PieceType.BLACK_PIECE, ChessPiece.KNIGHT,piecesFactory.getPiecesFactory("knight"));
        pieces[7][2] = new Pieces(PieceType.BLACK_PIECE, ChessPiece.BISHOP,piecesFactory.getPiecesFactory("bishop"));
        pieces[7][3] = new Pieces(PieceType.BLACK_PIECE, ChessPiece.KING,piecesFactory.getPiecesFactory("king"));
        pieces[7][4] = new Pieces(PieceType.BLACK_PIECE, ChessPiece.QUEEN,piecesFactory.getPiecesFactory("queen"));
        pieces[7][5] = new Pieces(PieceType.BLACK_PIECE, ChessPiece.BISHOP,piecesFactory.getPiecesFactory("bishop"));
        pieces[7][6] = new Pieces(PieceType.BLACK_PIECE, ChessPiece.KNIGHT,piecesFactory.getPiecesFactory("knight"));
        pieces[7][7] = new Pieces(PieceType.BLACK_PIECE, ChessPiece.ROOK, piecesFactory.getPiecesFactory("rook"));
        fillPawn(6, PieceType.BLACK_PIECE);

    }

    private void fillPawn(int row, PieceType type) {
        for(int col=0; col<8; col++) {
            pieces[row][col] = new Pieces(type, ChessPiece.PAWN, piecesFactory.getPiecesFactory("pawn"));
        }
    }

    public void startGame() {
        Player currPlayer = queue.poll();
        while (true) {
            printBoard();
            PieceCoordinates startCoordinates;
            PieceCoordinates endCoordinates;
            
            do {
                System.out.println(currPlayer.getName()+" ["+currPlayer.getPieceType()+"] plays ---> ");
                startCoordinates = controller.selectStartPiece(this, currPlayer);
            } while(startCoordinates.getRow()==-1);

            System.out.println("You have choosen a "+pieces[startCoordinates.getRow()][startCoordinates.getCol()].getChessPiece());
            do {
                System.out.println(currPlayer.getName()+" ["+currPlayer.getPieceType()+"] plays ---> ");
                endCoordinates = controller.selectDestination(this, currPlayer);
                if (endCoordinates.getRow()!=-1) {
                    Pieces currPieces = pieces[startCoordinates.getRow()][startCoordinates.getCol()];
                    if (!currPieces.canMove(this, startCoordinates.getRow(), startCoordinates.getCol())) {
                        System.out.println(currPieces.getChessPiece()+" can't move to "+endCoordinates.getRow()+","+endCoordinates.getCol());
                        endCoordinates.setRow(-1);
                    }
                }
            } while(endCoordinates.getRow()==-1);

            Pieces p = pieces[startCoordinates.getRow()][startCoordinates.getCol()];

            // Move the piece from this area
            pieces[startCoordinates.getRow()][startCoordinates.getCol()] = null;

            pieces[endCoordinates.getRow()][endCoordinates.getCol()] = p;
            
            if(pieces[endCoordinates.getRow()][endCoordinates.getCol()].getChessPiece() == ChessPiece.KING) {
                System.out.println("----------- PLayer: "+currPlayer.getName()+" WON THE GAME -----------");
                return;
            }
            queue.offer(currPlayer);
            currPlayer = queue.poll();
        }
    }

    public void printBoard() {
        for (int row = 0; row < 8; row++) {
            System.out.print(row + "  "); // Print rank (8 to 1)
            for (int col = 0; col < 8; col++) {
                if (pieces[row][col] == null) {
                    System.out.print(". "); // Empty square
                } else {
                    System.out.print(getPieceSymbol(pieces[row][col]) + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("   0 1 2 3 4 5 6 7"); // Print file labels
    }

    private String getPieceSymbol(Pieces piece) {
        PieceType color = piece.getPieceType();
        ChessPiece type = piece.getChessPiece(); // Assuming ChessPiece is WHITE / BLACK

        String symbol = "";
        switch (type) {
            case KING:   symbol = "K"; break;
            case QUEEN:  symbol = "Q"; break;
            case ROOK:   symbol = "R"; break;
            case BISHOP: symbol = "B"; break;
            case KNIGHT: symbol = "N"; break;
            case PAWN:   symbol = "P"; break;
        }
        if (color == PieceType.BLACK_PIECE) {
            symbol = symbol.toLowerCase(); // Black pieces in lowercase
        }
        return symbol;
    }
}
