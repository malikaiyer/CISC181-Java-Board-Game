import java.util.ArrayList;
/**
 * <h1>Lab5</h1>
 * <h2>CISC181-042L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This class is a subclass of Piece. Contains getters/setters and ability to spawn.
 * @author Charlotte Gottilla and Malika Iyer
 * @version 2022-04-12
 */
public class PieceBuzz extends Piece implements Attacker {
    private int numAttacks;
    private int numTimesBeenAttacked;
    private boolean workingLaser;

    // constructors ----------------------------------------------------------------------------------------------------
    public PieceBuzz(char symbol, String teamColor, int numAttacks, int numTimesBeenAttacked, boolean workingLaser,
                     boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
    }

    public PieceBuzz(){
        this('B',"- -", 0,0, true, false, true);
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
        return original;}

    public int getNumAttacks(){
        return numAttacks;
    }
    public int getNumTimesBeenAttacked() {
        return numTimesBeenAttacked;
    }
    public boolean canAttack(){
        return workingLaser;
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

    public void setWorkingLaser(boolean workingLaser) {
        this.workingLaser = workingLaser;
    }

    public void setNumAttacks(int numAttacks)  {
        this.numAttacks = numAttacks;
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Increments numTimesBeenAttacked to increase by 1 and set workingLaser to false
     */
    public void updateNumTimesBeenAttacked(){
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }

    /**
     * Prints PieceBuzz's battle cry
     */
    public void speak(){
        System.out.println("To Infinity and Beyond!");
    }

    // to be finished later
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    public Piece spawn(){
        return null;
    }
    public boolean canSpawn(){
        return false;
    }

    //implementing methods from Attacker
    public boolean validAttackPath(int origRowIndex, int origColumnIndex, int endRowIndex, int endColumnIndex){
        return true; //will be changed later
    }
}