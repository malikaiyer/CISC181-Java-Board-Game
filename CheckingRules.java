import java.util.ArrayList;

public class CheckingRules {

    public static void main(String args[]) {

        //SETTING UP THE BOARD -----------------------------------------------------------------------------------------
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M', "Blu",
                0, 0, false, true));
        piecesTeamA.add(new PieceBuzz('B', "Blu", 2, 1,
                true, false, true));
        piecesTeamA.add(new PieceBlueHen('H', "Blu", 3,
                9, false, true));
        piecesTeamA.add(new PieceEvilMinion('E', "Blu", 1,
                1, 4, false, true));
        // Create a team object
        Team teamA = new Team("Blu", piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M', "Red",
                0, 0, false, true));
        piecesTeamB.add(new PieceBlueHen('H', "Red", 3,
                9, false, true));
        piecesTeamB.add(new PieceBuzz('B', "Red", 2, 1,
                true, false, true));
        piecesTeamB.add(new PieceEvilMinion('E', "Red", 1,
                1, 4, false, true));
        // Create a team object
        Team teamB = new Team("Red", piecesTeamB);

        // create a game
        GameS22 game = new GameS22(6, 6, teamA, teamB);

        // clear Piece off the board
        for (int row = 0; row < game.getBoard().getNumRows(); row++) {
            for (int col = 0; col < game.getBoard().getNumColumns(); col++) {
                game.getBoard().getSquares()[row][col].removePiece();
            }
        }
        System.out.println(game);

        // load your pieces in specific locations of your choice
        game.getBoard().getSquares()[0][0].setPiece(piecesTeamA.get(0));
        game.getBoard().getSquares()[0][1].setPiece(piecesTeamA.get(1));
        game.getBoard().getSquares()[0][2].setPiece(piecesTeamA.get(2));
        game.getBoard().getSquares()[0][3].setPiece(piecesTeamA.get(3));
        game.getBoard().getSquares()[2][0].setPiece(piecesTeamB.get(0));
        game.getBoard().getSquares()[2][1].setPiece(piecesTeamB.get(1));
        game.getBoard().getSquares()[2][2].setPiece(piecesTeamB.get(2));
        game.getBoard().getSquares()[2][3].setPiece(piecesTeamB.get(3));

        System.out.println(game);

        //TESTING FOR MOVE----------------------------------------------------------------------------------------------
        System.out.println("Testing for Move-------------------------------------------------------------------------");
        // Empty end square and valid path - should be valid
        System.out.print("Should be true: ");
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                1, 4, 'M'));

        // To Square isn't empty - should not be a valid move
        System.out.print("Should be false: ");
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                0, 1, 'M'));
        // This isn't current team's piece - should not be valid
        System.out.print("Should be false: ");
        System.out.println(Rules.checkValidAction(game,
                2, 0,
                0, 5, 'M'));

        //TESTING FOR SPAWN---------------------------------------------------------------------------------------------
        System.out.println("Testing for Spawn------------------------------------------------------------------------");
        //test a valid move
        System.out.print("Should be true: ");
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                5, 5, 'S'));
        //test with a buzz piece - should return false because buzz can't spawn
        System.out.print("Should be false: ");
        System.out.println(Rules.checkValidAction(game,
                0, 1,
                0, 5, 'S'));
        //test with an non empty end square - not valid
        System.out.print("Should be false: ");
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                0, 2, 'S'));
        //test with a piece with !canSpawn - not valid
        System.out.print("Should be false: ");
        System.out.println(Rules.checkValidAction(game,
                0, 3,
                0, 4, 'S'));

        //TESTING RECRUIT ----------------------------------------------------------------------------------------------
        System.out.println("Testing for Recruit----------------------------------------------------------------------");
        //test a valid move
        System.out.print("Should be true: ");
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                2, 3, 'R'));
        //test a piece buzz - buzz can't recruit so should be invalid
        System.out.print("Should be false: ");
        System.out.println(Rules.checkValidAction(game,
                0, 1,
                2, 3, 'R'));
        //test an empty end square - should be invalid
        System.out.print("Should be false: ");
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                2, 5, 'R'));

        //TESTING ATTACK------------------------------------------------------------------------------------------------
        System.out.println("Testing for Attack-----------------------------------------------------------------------");
        //test a valid attack
        System.out.print("Should be true: ");
        System.out.println(Rules.checkValidAction(game,
                0, 1,
                2, 1, 'A'));
        //test w piece minion - minions cannot attack so should be invalid
        System.out.print("Should be false: ");
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                2, 1, 'A'));
        //test with a piece buzz - should be valid
        System.out.print("Should be true: ");
        System.out.println(Rules.checkValidAction(game,
                0, 1,
                2, 1, 'A'));
        //test with a piece blue hen - should be valid
        System.out.print("Should be true: ");
        System.out.println(Rules.checkValidAction(game,
                0, 2,
                2, 1, 'A'));
        //test with piece evil minion that has more than max attacks - should be invalid
        ((PieceEvilMinion) game.getBoardSquares()[2][3].getPiece()).setNumAttacks(20);
        System.out.print("Should be false: ");
        System.out.println(Rules.checkValidAction(game,
                2, 3,
                1, 1, 'A'));
    }
}
