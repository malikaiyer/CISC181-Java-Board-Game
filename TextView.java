import java.util.Scanner;

public class TextView {
    private int rowFromSq;
    private int colFromSq;
    private int rowToSq;
    private int colToSq;
    private char actionType;

    public int getRowFromSq() {
        return this.rowFromSq;
    }

    public int getColFromSq() {
        return this.colFromSq;
    }

    public int getRowToSq() {
        return this.rowToSq;
    }

    public int getColToSq() {
        return this.colToSq;
    }

    public char getActionType() {
        return this.actionType;
    }

    public static int getValidInt(int minNum, int maxNum, Scanner scr){
    // method that gets a valid integer within the range given. It returns the first valid number that the user entered.
        boolean validValue = false;
        int userInt = 0;

        while (!validValue) {
            System.out.println("Enter a number in the range " + minNum + " to " + maxNum);
            if (scr.hasNextInt()) {
                userInt = scr.nextInt();
                if (userInt >= minNum && userInt <= maxNum){
                    validValue = true; }
                else {
                    System.out.println("Your integer is not valid"); }
            }
            else{
                scr.next();
                System.out.println("Your value is not an integer"); }
        }
        return userInt;
    }

    public static char getUsersNextActionType(Scanner scr) {
// method that gets the users next action type. It takes in the users next move and returns the character that the user entered
        boolean validValue = false;
        String userChar = "";
        while (!validValue) {
            System.out.println("Please input A for attack, M for move, R for recruiting, or S to spawn");
            userChar = scr.next();
            //if (scr.hasNext()) {
                //System.out.println("enters outside if");
                if (userChar.charAt(0) == 'A' || userChar.charAt(0) == 'a') {
                    validValue = true;
                } else if (userChar.charAt(0) == 'M' || userChar.charAt(0) == 'm') {
                    validValue = true;
                } else if (userChar.charAt(0) == 'R' || userChar.charAt(0) == 'r') {
                    validValue = true;
                } else if (userChar.charAt(0) == 'S' || userChar.charAt(0) == 's') {
                    validValue = true;
                } else {
                    System.out.println("Please input a valid letter");
                }
            }
        return userChar.charAt(0);
        }


    public void getNextPlayersAction(GameS22 gameA){
        Scanner scr = new Scanner(System.in);
        actionType = getUsersNextActionType(scr);
        System.out.println("Please input the row and column number of the boardsquare you want to perform your action from");
        rowFromSq = getValidInt(0, gameA.getBoard().getNumRows() - 1, scr);
        colFromSq = getValidInt(0, gameA.getBoard().getNumColumns() - 1, scr);
        System.out.println("Please input the row and column number of the boardsquare you want to perform your action on");
        rowToSq = getValidInt(0, gameA.getBoard().getNumRows() - 1, scr);
        colToSq = getValidInt(0, gameA.getBoard().getNumColumns() - 1, scr);
    }

    public void updateView(Game gameA){
        System.out.print(gameA);
    }

    public void printEndOfGameMessage(Game gameA){
        System.out.println("The Game has Ended and the Winner is " + gameA.getWinner());
    }
}

