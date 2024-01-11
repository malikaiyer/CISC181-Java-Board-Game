public interface Recruiter {
    public int getNumRecruits();
    public void setNumRecruits(int numRecruits);
    public boolean validRecruitPath(int origRowIndex, int origColumnIndex, int endRowIndex, int endColumnIndex);
}
