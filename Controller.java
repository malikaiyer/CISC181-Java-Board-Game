import java.util.ArrayList;

public class Controller {
    private GameS22 gameA;
    private TextView textA;

    public GameS22 setUpGameModel(){
        // Create 4 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",3,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",3,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    public Controller(){
        this.gameA = setUpGameModel();
        textA = new TextView();
        textA.updateView(gameA);
    }

    public void carryOutAction(int rowFromSq, int ColFromSq, int rowToSq, int colToSq, char actionType) {
        if (actionType == 'M' || actionType == 'm') {
            ActionMove move = new ActionMove(gameA, rowFromSq, ColFromSq, rowToSq, colToSq);
            move.performAction();
        } else if (actionType == 'S' || actionType == 's') {
            ActionMove spawn = new ActionMove(gameA, rowFromSq, ColFromSq, rowToSq, colToSq);
            spawn.performAction();
        } else if (actionType == 'R' || actionType == 'r') {
            ActionMove recruit = new ActionMove(gameA, rowFromSq, ColFromSq, rowToSq, colToSq);
            recruit.performAction();
        } else if (actionType == 'A' || actionType == 'a') {
            ActionMove action = new ActionMove(gameA, rowFromSq, ColFromSq, rowToSq, colToSq);
            action.performAction();
        }
    }

    public void playGame(){
        boolean bool2 = gameA.isGameEnded();
        while (!bool2){
            textA.getNextPlayersAction(gameA);
            boolean bool = Rules.checkValidAction(gameA, textA.getRowFromSq(), textA.getColFromSq(), textA.getRowToSq(), textA.getColToSq(), textA.getActionType());
            System.out.println(bool);
            while (!bool){
                textA.getNextPlayersAction(gameA);
                bool = Rules.checkValidAction(gameA, textA.getRowFromSq(), textA.getColFromSq(), textA.getRowToSq(), textA.getColToSq(), textA.getActionType());
            }
            carryOutAction(textA.getRowFromSq(), textA.getColFromSq(), textA.getRowToSq(), textA.getColToSq(), textA.getActionType());
            System.out.println(gameA);
        }
        bool2 = gameA.isGameEnded();
        textA.printEndOfGameMessage(gameA);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.playGame();
    }
}
