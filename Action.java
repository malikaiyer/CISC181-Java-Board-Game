public abstract class  Action {
    GameS22 gameA;
    int rowFromSq;
    int colFromSq;
    int rowToSq;
    int colToSq;

    public Action(GameS22 gameA, int rowFromSq, int colFromSq, int rowToSq, int colToSq){
        this.gameA = gameA;
        this.rowFromSq = rowFromSq;
        this.colFromSq = colFromSq;
        this.rowToSq = rowToSq;
        this.colToSq = colToSq;
    }

    public abstract void performAction();
}
