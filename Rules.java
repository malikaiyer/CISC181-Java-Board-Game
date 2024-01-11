public class Rules {
    public static boolean checkValidAction(Game GameS22, int origRowIndex, int origColumnIndex, int endRowIndex,
                                           int endColumnIndex, char userAction) {

        //initialize return value as true - will be changed to false when condition is not met
        boolean returnVal = true;
        //create instance variables for original and end squares, for piece performing action
        BoardSquare origSquare = GameS22.getBoardSquares()[origRowIndex][origColumnIndex];
        BoardSquare endSquare = GameS22.getBoardSquares()[endRowIndex][endColumnIndex];
        Piece myPiece = origSquare.getPiece();

        //if from square is empty, move is invalid
        if (GameS22.getBoardSquares()[origRowIndex][origColumnIndex].isEmpty()){
            returnVal = false;
        }
        //if piece is not on current team, move is invalid
        else if (!GameS22.getBoardSquares()[origRowIndex][origColumnIndex].getPiece().getTeamColor().equals(GameS22.getCurrentTeam().getTeamColor())){
            returnVal = false;
        }
        //if the to square is not on the board, move is invalid
        else if (!GameS22.getBoard().inBounds(endRowIndex, endColumnIndex)){
            returnVal = false;
        }
        else {
            //check move action
            if (userAction == 'm' || userAction == 'M') {
                //if end square is not empty, return false
                if (!endSquare.isEmpty()) {
                    returnVal = false;
                }
                //if path is not valid, return false
                else if (!myPiece.validMovePath(origRowIndex, origColumnIndex, endRowIndex, endColumnIndex)) {
                    returnVal = false;
                }
                else{
                    returnVal = true;
                }
            }

            //check spawn action
            if (userAction == 's' || userAction == 'S') {
                //buzz pieces cannot spawn - if myPiece is PieceBuzz, return false
                if (myPiece instanceof PieceBuzz) {
                    returnVal = false;
                }
                //if end square is not empty, return false
                else if (!endSquare.isEmpty()) {
                    returnVal = false;
                }
                //if canSpawn is false, return false
                else if (!myPiece.canSpawn()) {
                    returnVal = false;
                }
            }

            //check recruit action
            else if (userAction == 'r' || userAction == 'R') {
                //buzz pieces cannot recruit - if myPiece is PieceBuzz, return false
                if (myPiece instanceof PieceBuzz) {
                    returnVal = false;
                }
                //end square must have a piece in it - if end square is empty, return false
                else if (endSquare.isEmpty()) {
                    returnVal = false;
                }
                //end square must have piece on other team - if pieces are on same team, return false (compare colors)
                else if (myPiece.getTeamColor().equals(endSquare.getPiece().getTeamColor())) {
                    returnVal = false;
                }
                //if path is not valid, return false
                else if (!myPiece.validRecruitPath(origRowIndex, origColumnIndex, endRowIndex, endColumnIndex)) {
                    returnVal = false;
                }
            }

            //check attack action
            else if (userAction == 'a' || userAction == 'A') {
                //minions cannot attack
                if (myPiece instanceof PieceMinion) {
                    returnVal = false;
                }

                //one set of rules for buzz
                else if (myPiece instanceof PieceBuzz) {
                    //can only attack is laser is working - casting to PieceBuzz but should already be one
                    if (!((PieceBuzz) myPiece).canAttack()) {
                        returnVal = false;
                    }
                    //end square cannot be empty
                    else if (endSquare.isEmpty()) {
                        returnVal = false;
                    }
                    //piece on end square must be on opponent team - if pieces are on same team, return false (compare colors)
                    else if (myPiece.getTeamColor().equals(endSquare.getPiece().getTeamColor())) {
                        returnVal = false;
                    }
                    //attack path must be valid
                    else if (!myPiece.validAttackPath(origRowIndex, origColumnIndex, endRowIndex, endColumnIndex)) {
                        returnVal = false;
                    }
                }
                //another set of rules for blue hen
                else if (myPiece instanceof PieceBlueHen) {
                    //end square cannot be empty
                    if (endSquare.isEmpty()) {
                        returnVal = false;
                    }
                    //piece on end square must be on opponent team - if pieces are on same team, return false (compare colors)
                    else if (myPiece.getTeamColor().equals(endSquare.getPiece().getTeamColor())) {
                        returnVal = false;
                    }
                    //attack path must be valid
                    else if (!myPiece.validAttackPath(origRowIndex, origColumnIndex, endRowIndex, endColumnIndex)) {
                        returnVal = false;
                    }
                }

                //another set of rules for evil minion
                else if (myPiece instanceof PieceEvilMinion) {
                    //can only attack if it is hungry
                    if (!((PieceEvilMinion) myPiece).canAttack()) {
                        returnVal = false;
                    }
                    //end square cannot be empty
                    else if (endSquare.isEmpty()) {
                        returnVal = false;
                    }
                    //attack path must be valid
                    else if (!myPiece.validAttackPath(origRowIndex, origColumnIndex, endRowIndex, endColumnIndex)) {
                        returnVal = false;
                    }
                }
            }
        }
        return returnVal;
    }
}