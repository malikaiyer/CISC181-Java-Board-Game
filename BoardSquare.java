/**
 * <h1>Lab5</h1>
 * <h2>CISC181-042L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This class creates a BoardSquare object and contains its getters/setters. Also overrides toString() method.
 * @author Charlotte Gottilla and Malika Iyer
 * @version 2022-04-12
 */

public class BoardSquare {
    protected boolean isEmpty;
    private Piece Piece;
    private String squareColor;

    //constructor ------------------------------------------------------------------------------------------------------
    public BoardSquare(String squareColor) {
        this.isEmpty = true;
        this.Piece = null;
        this.squareColor = squareColor;
    }

    //accessors --------------------------------------------------------------------------------------------------------
    public boolean isEmpty() {
        return this.isEmpty;
    }

    public Piece getPiece() {
        return this.Piece;
    }

    public String getSquareColor() {
        return this.squareColor;
    }

    //mutators ---------------------------------------------------------------------------------------------------------
    public void setPiece(Piece newPiece) {
        this.Piece = newPiece;
        this.isEmpty = false;
    }

    public Piece removePiece() {
        this.isEmpty = true;
        Piece temp = this.Piece;
        this.Piece = null;
        return temp;
    }

    //String method override -------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        if (isEmpty == true) {
            return "-------";
        }
        else{
            return "-" + Piece.toString() + "-";
        }
    }
}
