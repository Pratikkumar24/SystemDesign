package SystemDesign.DesginPatternQuestions.TicTacToe.Players;

import SystemDesign.DesginPatternQuestions.TicTacToe.Pieces.Piece;

public class Player {
    String name;
    Piece pieceType;

    public Player(String name, Piece pieceType) {
        this.name = name;
        this.pieceType = pieceType;
    }

    public String getPlayerName() {
        return name;
    }

    public Piece getPieceType() {
        return pieceType;
    }
}