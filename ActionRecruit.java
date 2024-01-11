public class ActionRecruit extends Action{
    public ActionRecruit(GameS22 gameA, int rowFromSq, int colFromSq, int rowToSq, int colToSq){
        super(gameA, rowFromSq, colFromSq, rowToSq, colToSq);
    }

    public void performAction(){
        //call piece on from square's speak method
        Piece piece1 = gameA.getBoardSquares()[rowFromSq][colFromSq].getPiece();
        piece1.speak();
        //remove piece recruited from the opponent team
        Piece piece2 = gameA.getBoardSquares()[rowToSq][colToSq].getPiece();
        gameA.getOpponentTeam().removePieceFromTeam(piece2);
        //add piece recruited to the current team
        gameA.getCurrentTeam().addPieceToTeam(piece2);
        //change turns
        gameA.changeTurn();
    }
}
