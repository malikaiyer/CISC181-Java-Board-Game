/**
 * <h1>Lab5</h1>
 * <h2>CISC181-042L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This class creates a Team object containing a team's color and an arraylist of the team's pieces. Also contains
 * getters/setters and overrides the toString method.
 * @author Charlotte Gottilla and Malika Iyer
 * @version 2022-04-12
 */

import java.util.ArrayList;

public class Team {
    private String teamColor;
    private ArrayList<Piece> teamPieces;

    //constructor ------------------------------------------------------------------------------------------------------
    public Team(String teamColor, ArrayList<Piece> teamPieces){
        this.teamColor = teamColor;
        this.teamPieces = teamPieces;
    }

    //accessors --------------------------------------------------------------------------------------------------------
    public String getTeamColor() {
        return teamColor;
    }

    public ArrayList<Piece> getTeamPieces(){
        return teamPieces;
    }

    //mutators ---------------------------------------------------------------------------------------------------------
    public void removePieceFromTeam(Piece removedPiece){
        teamPieces.remove(teamPieces.indexOf(removedPiece));
    }

    public void addPieceToTeam(Piece addedPiece){
        addedPiece.setTeamColor(this.teamColor);
        teamPieces.add(addedPiece);
    }

    //toString ---------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        StringBuilder teamString = new StringBuilder();
        teamString.append(" Team " + getTeamColor() + " Pieces : ");
        teamString.append("\n");
        for (int i = 0; i < teamPieces.size(); i++) {
            teamString.append(teamPieces.get(i).toString() + " ");
        }
        return teamString.toString();
    }
}
