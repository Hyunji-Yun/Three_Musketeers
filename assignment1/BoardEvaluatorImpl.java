package assignment1;

import java.util.List;

public class BoardEvaluatorImpl implements BoardEvaluator {

    /**
     * Calculates a score for the given Board
     * A higher score means the Musketeer is winning
     * A lower score means the Guard is winning
     * Add heuristics to generate a score given a Board
     * @param board Board to calculate the score of
     * @return int Score of the given Board
     */
    @Override
    public int evaluateBoard(Board board) { // TODO
        int score = 0;
        
        int musketeerCount = board.getMusketeerCells().size();
        int guardCount = board.getGuardCells().size();
        
        score += musketeerCount*10;
        score -= guardCount*5;
        
        List<Cell> musketeerCells = board.getMusketeerCells();
        for(int i=0; i<musketeerCells.size(); i++) {
        	for(int j=i+1; j<musketeerCells.size(); j++) {
        		Cell cellOne = musketeerCells.get(i);
        		Cell cellTwo = musketeerCells.get(j);
        		int distance = Math.abs(cellOne.getCoordinate().row - cellTwo.getCoordinate().row) + 
        					   Math.abs(cellOne.getCoordinate().col -  cellTwo.getCoordinate().col);
        		score -= distance;
        	}
        }
        
        return score;
    }
}