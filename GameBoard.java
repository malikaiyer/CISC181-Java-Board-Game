/**
 * <h1>Lab5</h1>
 * <h2>CISC181-042L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This class creates a GameBoard object which is a 2D array of BoardSquares. Contains methods to initialize board at
 * the start of the game. Overrides toString() method.
 * @author Charlotte Gottilla and Malika Iyer
 * @version 2022-04-12
 */

public class GameBoard {
    private int numRows = 0;
    private int numColumns = 0;
    private BoardSquare[][] squares;

    //constructor ------------------------------------------------------------------------------------------------------
    public GameBoard(int numRows, int numColumns){
        squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    //accessors --------------------------------------------------------------------------------------------------------
    public int getNumRows(){
        return squares.length;
    }

    public int getNumColumns(){
        return squares[1].length;
    }

    public BoardSquare[][] getSquares(){
        return this.squares;
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Determines if a given spot is on the GameBoard
     * @param rowIndex - row index of spot being tested
     * @param columnIndex - column index of spot being tested
     * @return true if spot is on board, false otherwise
     */
    public boolean inBounds(int rowIndex, int columnIndex){
        boolean flag = false;
        if (rowIndex < squares.length && columnIndex < squares[1].length){ flag = true; }
        if (rowIndex < 0 || columnIndex < 0) { flag = false;}
        return flag;
    }

    /**
     * Assigns BoardSquares in alternating colors to each location in squares 2D array
     */
    protected void setUpEmptyBoard() {
        String squareColor;
        int count = 0;
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (count % 2 == 0){ squareColor = "white";}
                else {squareColor = "black";}
                squares[i][j] = new BoardSquare(squareColor);
            }
        }
    }

    /**
     * Finds a random empty location in squares 2D array
     * @return squares[random row][random column] - selected random location in squares
     */
    public BoardSquare findRandomEmptySpace(){
        int myRow = (int)(Math.random() * (squares.length));
        int myColumn = (int) (Math.random() * (squares[1].length));
        boolean flag = true;
        if (squares[myRow][myColumn].isEmpty()){
            flag = false;
        }
        while (flag == true){
            myRow = (int)(Math.random() * (squares.length));
            myColumn = (int) (Math.random() * (squares[1].length));
            if (squares[myRow][myColumn].isEmpty() == true){
                flag = false;
            }
        }
        return squares[myRow][myColumn];
    }

    //toString Override ------------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
