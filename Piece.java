/**
 * <h1>Lab5</h1>
 * <h2>CISC181-042L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This abstract class is the super class for PieceBlueHen, PieceBuzz, and PieceMinion. Contains only abstract methods
 * and overrides toString() method.
 * @author Charlotte Gottilla and Malika Iyer
 * @version 2022-04-12
 */
public abstract class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    //constructor ------------------------------------------------------------------------------------------------------
    public Piece(char symbol, String teamColor, boolean hidden, boolean original){
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    //accessors --------------------------------------------------------------------------------------------------------
    public abstract char getSymbol();

    public abstract String getTeamColor();

    public abstract boolean isHidden();

    public abstract boolean isOriginal();

    //mutators ---------------------------------------------------------------------------------------------------------
    public abstract void setSymbol(char symbol);

    public abstract void setTeamColor(String teamColor);

    public abstract void setHidden(boolean hidden);

    public abstract void setOriginal(boolean original);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Abstract speak method, will be in subclasses
     */
    public abstract void speak();

    public abstract Piece spawn();

    //toString Override ------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return this.teamColor + " " + this.symbol;
    }

    //------------------------------------------------------------------------------------------------------------------
    public abstract boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                          int toSquareRow, int toSquareCol);

    public abstract boolean canSpawn();

    public boolean validRecruitPath(int origRowIndex, int origColumnIndex, int endRowIndex, int endColumnIndex){
        return true; //will be changed later
    }

    public boolean validAttackPath(int origRowIndex, int origColumnIndex, int endRowIndex, int endColumnIndex){
        return true; //will be changed later
    }

}
