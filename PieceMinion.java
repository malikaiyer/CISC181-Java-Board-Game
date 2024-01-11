/**
 * <h1>Lab5</h1>
 * <h2>CISC181-042L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This class is a subclass of Piece. Contains getters/setters and ability to spawn.
 * @author Charlotte Gottilla and Malika Iyer
 * @version 2022-04-12
 */

public class PieceMinion extends Piece implements Recruiter{
    protected int numRecruits;
    protected int numTimesSpawned;

    public static int MAX_NUM_SPAWNED = 3;

    // constructors ----------------------------------------------------------------------------------------------------
    public PieceMinion(char symbol, String teamColor, int numRecruits, int numTimesSpawned, boolean hidden,
                       boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    public PieceMinion(){
        this('M',"- -", 0,0, false,true);
    }

    // accessors -------------------------------------------------------------------------------------------------------
    public char getSymbol() {
        return symbol;}

    public String getTeamColor() {
        return teamColor;
    }
    public boolean isHidden() {
        return hidden;
    }
    public boolean isOriginal(){
        return original;
    }

    public int getNumRecruits() {
        return numRecruits;
    }
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    // mutators --------------------------------------------------------------------------------------------------------
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        this.original = original;}

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Prints PieceMinion's battle cry
     */
    public void speak(){
        System.out.println("Bello!");
    }

    // to be finished later
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true;
    }

    /**
     * Creates a new PieceMinion with the same properties as the parent and a lowercase symbol
     * @return new PieceMinion
     */
    public PieceMinion spawn(){
        return new PieceMinion(Character.toLowerCase(this.symbol),
                this.teamColor,1,
                0,
                false,
                false);
    }

    /**
     * Determines if a PieceMinion is able to spawn
     * @return true if PieceMinion is an original piece and has not yet spawned its max number of times
     */
    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }

    //implementing methods from Recruiter
    public boolean validRecruitPath(int origRowIndex, int origColumnIndex, int endRowIndex, int endColumnIndex){
        return true; //will be changed later
    }

}
