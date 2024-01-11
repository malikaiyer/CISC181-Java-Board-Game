public class ActionMove extends Action{

    public ActionMove(GameS22 gameA, int rowFromSq, int colFromSq, int rowToSq, int colToSq){
        super(gameA, rowFromSq, colFromSq, rowToSq, colToSq);}

    public void performAction(){
        Piece piece1 = gameA.getBoardSquares()[rowFromSq][colFromSq].removePiece();
        piece1.speak();
        gameA.getBoardSquares()[rowToSq][colToSq].setPiece(piece1);
        gameA.changeTurn();
    }
}