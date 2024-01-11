/**
 * <h1>Lab5</h1>
 * <h2>CISC181-042L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This class is a subclass of PieceMinion. Contains getters/setters and ability to spawn.
 * @author Charlotte Gottilla and Malika Iyer
 * @version 2022-04-12
 */

public class PieceEvilMinion extends PieceMinion implements Attacker, Recruiter{
    private int numAttacks;
    private boolean hungry;

    public static int MAX_NUM_ATTACKS = 4;

    //constructor ------------------------------------------------------------------------------------------------------
    public PieceEvilMinion(char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned,
                           boolean hidden, boolean original){
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
    }

    public PieceEvilMinion(){
        this('E', "NON",0,0,0,false, true);
    }

    //accessors --------------------------------------------------------------------------------------------------------
    public int getNumAttacks() {
        return numAttacks;}

    public boolean canSpawn(){
        if (this.original == true && numTimesSpawned < MAX_NUM_SPAWNED){
            return true;}
        else{ return false;}}

    public boolean canAttack(){
        return hungry;
    }

    //mutators ---------------------------------------------------------------------------------------------------------
    public void setNumAttacks (int numAttacks){
        this.numAttacks = numAttacks;
    }

    public void setNumTimesSpawned(int numTimesSpawned){
        this.numTimesSpawned = numTimesSpawned;
    }

    public void updateHungry(){
        if (numAttacks < MAX_NUM_ATTACKS){
            hungry = true;
        }
        else{
            hungry = false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Prints PieceEvilMinion's battle cry
     */
    public void speak(){
        System.out.println("Roar!");
    }

    //to be finished later
    public boolean validMovePath(){
        return true;
    }

    /**
     * Creates a new PieceEvilMinion with the same symbol and color as the parent; updates numTimesSpawned
     * @return newEvilMinion - a new PieceEvilMinion object
     */
    public PieceEvilMinion spawn(){
        PieceEvilMinion newEvilMinion = new PieceEvilMinion(this.symbol, this.teamColor, 1, 0, 0, false, false);
        hungry = true;
        this.numTimesSpawned += numTimesSpawned;
        return newEvilMinion;
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