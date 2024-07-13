public class Scoreboard {
    private int player1Score;
    private int player2Score;

    public Scoreboard() {
        player1Score = 0;
        player2Score = 0;
    }

    public void updateScore(int playerNumber) {
        if (playerNumber == 1) {
            player1Score++;
        } else if (playerNumber == 2) {
            player2Score++;
        }
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }
}
