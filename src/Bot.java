import java.util.Random;

public class Bot extends Player {

    private Random random;

    public Bot(char symbol) {
        super(symbol);
        random = new Random();
    }

    public int[] getNextMove(Board board) {
        int[] move = new int[2];
        do {
            move[0] = random.nextInt(3);
            move[1] = random.nextInt(3);
        } while (!board.isCellEmpty(move[0], move[1]));
        return move;
    }
}
