import javax.swing.JLabel;

public class Views {
    private JLabel scoreLabel;
    private Scoreboard scoreboard;
    private String player1Name;
    private String player2Name;

    public Views(JLabel scoreLabel, String player1Name, String player2Name) {
        this.scoreLabel = scoreLabel;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.scoreboard = new Scoreboard();
        updateScoreLabel();
    }

    public void updateScore(int playerNumber) {
        scoreboard.updateScore(playerNumber);
        updateScoreLabel();
    }

    public void updateScoreLabel() {
        scoreLabel.setText(player1Name + ": " + scoreboard.getPlayer1Score() + " | " + player2Name + ": " + scoreboard.getPlayer2Score());
    }
}
