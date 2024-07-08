package assignment1;
import java.util.List;
import java.util.Random;


public class RandomAgent extends Agent {

    public RandomAgent(Board board) {
        super(board);
    }

    /**
     * Gets a valid random move the RandomAgent can do.
     * @return a valid Move that the RandomAgent can perform on the Board
     */
    @Override
    public Move getMove() { // TODO
        List<Move> possibleMoves = board.getPossibleMoves();
        Random random = new Random();
        int ranIndex = random.nextInt(possibleMoves.size());
        return possibleMoves.get(ranIndex);
    }
}