public interface Attacker {
    public int getNumAttacks();
    public void setNumAttacks(int numAttacks);
    public boolean validAttackPath(int origRowIndex, int origColumnIndex, int endRowIndex, int endColumnIndex);
}
