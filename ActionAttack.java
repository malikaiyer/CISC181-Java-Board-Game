public class ActionAttack extends Action{
    public ActionAttack(GameS22 gameA, int rowFromSq, int colFromSq, int rowToSq, int colToSq){
        super(gameA, rowFromSq, colFromSq, rowToSq, colToSq);
    }

    public void performAction(){
        //if attacking an opponent piece
        if (!gameA.getBoardSquares()[rowFromSq][colFromSq].getPiece().getTeamColor().equals
                (gameA.getBoardSquares()[rowToSq][colToSq].getPiece().getTeamColor())){
            //call the from piece's speak method
            Piece piece1 = gameA.getBoardSquares()[rowFromSq][colFromSq].getPiece();
            piece1.speak();
            //remove attacked piece from the board
            gameA.getBoardSquares()[rowToSq][colToSq].removePiece();
            //move the piece on the from square to the to square
            gameA.getBoardSquares()[rowFromSq][colFromSq].removePiece(); //first remove from from square
            gameA.getBoardSquares()[rowToSq][colToSq].setPiece(piece1); //next add to to square
            //change turns
            gameA.changeTurn();
        }

        //if a PieceEvilMinion is attacking a PieceMinion on the same team
        else if (gameA.getBoardSquares()[rowFromSq][colFromSq].getPiece() instanceof PieceEvilMinion
                && gameA.getBoardSquares()[rowFromSq][colFromSq].getPiece() instanceof PieceMinion
                && gameA.getBoardSquares()[rowFromSq][colFromSq].getPiece().getTeamColor().equals
                (gameA.getBoardSquares()[rowToSq][colToSq].getPiece().getTeamColor())){
            //call the from piece's speak method
            Piece piece1 = gameA.getBoardSquares()[rowFromSq][colFromSq].getPiece();
            piece1.speak();
            //remove attacked piece from the board
            gameA.getBoardSquares()[rowToSq][colToSq].removePiece();
            //remove attacked piece from current team
            Piece piece2 = gameA.getBoardSquares()[rowToSq][colToSq].getPiece();
            gameA.getOpponentTeam().removePieceFromTeam(piece2);
            //create new PieceEvilMinion - default constructor
            PieceEvilMinion evilPiece2 = new PieceEvilMinion();
            //add the new piece to the current team
            gameA.getCurrentTeam().addPieceToTeam(evilPiece2);
            //place the new piece where the attacked minion piece was
            gameA.getBoardSquares()[rowToSq][colToSq].setPiece(evilPiece2);
            //change turns
            gameA.changeTurn();
        }
    }
}
