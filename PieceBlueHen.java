/**
 * <h1>Lab5</h1>
 * <h2>CISC181-042L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This class is a subclass of Piece. Creates a PieceBlueHen object and its getters/setters. Overrides toString().
 * @author Charlotte Gottilla and Malika Iyer
 * @version 2022-04-12
 */
public class PieceBlueHen extends Piece implements Attacker, Recruiter{
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    // constructors -----------------------------------------------------------------------------------------------------
    public PieceBlueHen(char symbol, String teamColor, int numAttacks, int numRecruits, boolean hidden,
                        boolean original){
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen ()  {
        this('H',"NON", 0,0, false,true);
    }

    // accessors -------------------------------------------------------------------------------------------------------
    public char getSymbol() {
        return symbol;
    }
    public String getTeamColor() {
        return teamColor;}

    public boolean isHidden() {
        return hidden;
    }
    public boolean isOriginal(){
        return original;}

    public int getNumAttacks()    {
        return this.numAttacks;
    }
    public int getNumRecruits(){
        return this.numRecruits;
    }

    public boolean canFly()    {
        return this.flies;
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

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
        updateFly();}

    public void setNumRecruits(int numRecruits)    {
        this.numRecruits = numRecruits;
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Updates canFly, will be false if max number of attacks had been reached
     */
    private void updateFly()    {
        if (this.numAttacks < MAX_NUM_ATTACKS){
            this.flies = true;
        }
        else {
            this.flies = false;
        }
    }

    /**
     * Prints PieceBlueHen's battle cry
     */
    public void speak(){
        System.out.println("Go UD!");
    }

    //to be finished later
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    /**
     * Creates a new PieceBlueHen with same properties as parents but lowercase symbol
     * @return copyHen
     */
    public PieceBlueHen spawn()    {
        PieceBlueHen copyHen =
                new PieceBlueHen(Character.toLowerCase(this.symbol), this.teamColor,this.numAttacks,this.numRecruits, false,false);
        return copyHen;
    }

    //to be finished later
    public boolean canSpawn() {
        return true;
    }

    //implementing methods from Attacker
    public boolean validAttackPath(int origRowIndex, int origColumnIndex, int endRowIndex, int endColumnIndex){
        return true; //will be changed later
    }

    //implementing methods from Recruiter
    public boolean validRecruitPath(int origRowIndex, int origColumnIndex, int endRowIndex, int endColumnIndex){
        return true; //will be changed later
    }
}
