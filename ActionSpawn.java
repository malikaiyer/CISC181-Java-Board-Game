public class ActionSpawn extends Action{
    public ActionSpawn(GameS22 gameA, int rowFromSq, int colFromSq, int rowToSq, int colToSq){
        super(gameA, rowFromSq, colFromSq, rowToSq, colToSq);
    }
    public void performAction(){
        //call piece on from square's speak method
        Piece piece1 = gameA.getBoardSquares()[rowFromSq][colFromSq].getPiece();
        piece1.speak();
        //spawn piece on from square
        Piece piece2 = piece1.spawn();
        //add new piece to current team
        gameA.getCurrentTeam().addPieceToTeam(piece1);
        //put new piece on to square
        gameA.getBoardSquares()[rowToSq][colToSq].setPiece(piece2);
        //change turns
        gameA.changeTurn();
    }
}
