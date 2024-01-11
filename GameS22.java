public  class GameS22 extends Game {

    //constructor---------------------------
    public GameS22(int numRows, int numColumns, Team team1, Team team2) {
        super(numRows, numColumns, team1, team2);
    }

    public boolean isAWinner() {
        if (team1.getTeamPieces().size() == 0 || team2.getTeamPieces().size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public Team getWinner() {
        if (team1.getTeamPieces().size() == 0 && team2.getTeamPieces().size()==0){
            return null;
        }
        else if (team1.getTeamPieces().size() == 0){
            return team2;
        }
        else if (team2.getTeamPieces().size() == 0){
            return team1;
        }
        else{
            return null;
        }
    }

    public boolean isGameEnded() {
        if (team1.getTeamPieces().size() == 0) {
            return true;
        }
        else if(team2.getTeamPieces().size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

}

