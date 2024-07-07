package assignment1;
import java.util.Scanner;
import assignment1.Exceptions.InvalidMoveException;

public class HumanAgent extends Agent {
	private final Scanner scanner = new Scanner(System.in);
	
    public HumanAgent(Board board) {
        super(board);
    }

    /**
     * Asks the human for a move with from and to coordinates and makes sure its valid.
     * Create a Move object with the chosen fromCell and toCell
     * @return the valid human inputted Move
     */
    @Override
    public Move getMove() { // TODO
        Move move = null;
        boolean validMove = false;
        
        while(!validMove) {
        	try {
        		System.out.print("Enter move (ex. A1 B2): ");
        		String input = scanner.nextLine().toUpperCase();
        		String[] parts = input.split(" ");
        		
        		if(parts.length != 2) {
        			throw new IllegalArgumentException("Invalid input. Enter two coordinates separated by a space.");
        			
        		}
        		Coordinate fromCoordinate = Utils.parseUserMove(parts[0]);
        		Coordinate toCoordinate = Utils.parseUserMove(parts[1]);
        		Cell fromCell = board.getCell(fromCoordinate);
        		Cell toCell = board.getCell(toCoordinate);
        		
        		move = new Move(fromCell, toCell);
        		
        		if(!board.isValidMove(move)) {
        			throw new InvalidMoveException("Invalid move. Try again.");
        		}
        		validMove = true;
        	
        	}
        	catch(IllegalArgumentException | InvalidMoveException e) {
        		System.out.println(e.getMessage());
        	}
        }
        return move;
    }
}
