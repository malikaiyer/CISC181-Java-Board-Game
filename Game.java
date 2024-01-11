/**
 * <h1>Lab5</h1>
 * <h2>CISC181-042L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This class creates a Game object comprised of a GameBoard and the two teams playing. Contains methods to be used
 * while playing the game. Overrides toString().
 * @author Charlotte Gottilla and Malika Iyer
 * @version 2022-04-12
 */

import java.util.ArrayList;
import java.util.Collections;

public abstract class Game {
    protected GameBoard board;
    protected Team team1;
    protected Team team2;
    protected String turn;

    //abstract methods (lab 7) ---------------------------------
    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();

    //constructor ------------------------------------------------------------------------------------------------------
    public Game(int numberRows, int numberColumns, Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        turn = team1.getTeamColor();
        initializeGameBoard(numberRows, numberColumns);
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Creates and sets up the GameBoard with each team's pieces in random spots; no return
     * @param numRows - number of rows
     * @param numColumns - number of columns
     */
    private void initializeGameBoard(int numRows, int numColumns){
        GameBoard newBoard = new GameBoard(numRows, numColumns);
        newBoard.setUpEmptyBoard();
        ArrayList<Piece> teamPieces1 = team1.getTeamPieces();
        ArrayList<Piece> teamPieces2 = team2.getTeamPieces();
        for (int i = 0; i < teamPieces1.size(); i++) {newBoard.findRandomEmptySpace().setPiece(teamPieces1.get(i));}
        for (int j = 0; j < teamPieces2.size(); j++) {newBoard.findRandomEmptySpace().setPiece(teamPieces2.get(j));}
        this.board = newBoard;
    }

    //accessors --------------------------------------------------------------------------------------------------------
    public GameBoard getBoard(){
        return this.board;
    }
    public Team getCurrentTeam() {
        Team currentTeam = null;
        if (turn.equals(team1.getTeamColor())) {currentTeam = team1;}
        if (turn.equals(team2.getTeamColor())) {currentTeam = team2;}
        return currentTeam;
    }

    public Team getOpponentTeam() {
        Team opponentTeam = null;
        if (turn.equals(team1.getTeamColor())) {opponentTeam = team2;}
        if (turn.equals(team2.getTeamColor())) {opponentTeam = team1;}
        return opponentTeam;
    }

    public BoardSquare[][] getBoardSquares() {
        return getBoard().getSquares();
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Determines if it is myTeam's turn
     * @param myTeam - the team whose turn is being determined
     * @return true if myTeam is up, false if it is the other team's turn
     */
    public boolean isTurn(Team myTeam) {
        boolean returnVal = false;
        Team currentTeam = getCurrentTeam();
        if (myTeam.getTeamColor().equals(currentTeam.getTeamColor())){returnVal =true;}
        return returnVal;
    }

    /**
     * Switches turn to be assigned to the other team; no param/return
     */
    public void changeTurn() {
        if (turn.equals(team1.getTeamColor())) {
            turn = team2.getTeamColor();
        }
        else if (turn.equals(team2.getTeamColor())) {
            turn = team1.getTeamColor();
        }
    }

    //toString override ------------------------------------------------------------------------------------------------
    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();

    }
}
