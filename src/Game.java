import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private JButton[][] buttons;
    private JLabel statusLabel;
    private JLabel scoreLabel;
    private Views views;
    private String player1Name;
    private String player2Name;
    private int gameCount;
    private boolean playWithBot;

    public Game(boolean playWithBot) {
        this.playWithBot = playWithBot;
        board = new Board();
        playerX = new Player('X');

        if (playWithBot) {
            player1Name = JOptionPane.showInputDialog("Enter your name:");
            player2Name = "Bot";
            playerO = new Bot('O');
        } else {
            player1Name = JOptionPane.showInputDialog("Enter name for Player 1:");
            player2Name = JOptionPane.showInputDialog("Enter name for Player 2:");
            playerO = new Player('O');
        }

        gameCount = 0;

        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        panel.setBackground(new Color(200, 200, 255));

        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int col = j;
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setForeground(Color.BLACK);
                buttons[i][j].setText(" ");
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (board.isCellEmpty(row, col)) {
                            board.setCell(row, col, currentPlayer.getSymbol());
                            updateButton(buttons[row][col], currentPlayer.getSymbol());
                            updateStatusLabel();
                            if (checkForWin(currentPlayer.getSymbol())) {
                                showWinMessage(currentPlayer.getSymbol());
                                views.updateScore(currentPlayer == playerX ? 1 : 2);
                                resetGame();
                            } else if (checkForDraw()) {
                                JOptionPane.showMessageDialog(frame, "It's a draw!");
                                resetGame();
                            } else {
                                switchPlayer();
                                if (playWithBot && currentPlayer instanceof Bot) {
                                    botMove();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid move. Please try again.");
                        }
                    }
                });
                panel.add(buttons[i][j]);
            }
        }

        JButton finishButton = new JButton("Finish");
        finishButton.setFont(new Font("Arial", Font.BOLD, 20));
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        statusLabel = new JLabel();
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));

        scoreLabel = new JLabel();
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));

        views = new Views(scoreLabel, player1Name, player2Name);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);
        frame.add(scoreLabel, BorderLayout.NORTH);
        frame.add(finishButton, BorderLayout.EAST);

        frame.setVisible(true);

        showPlayerSymbols();
        resetGame();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        updateStatusLabel();
    }

    private void botMove() {
        int[] move = ((Bot) playerO).getNextMove(board);
        if (move != null) {
            board.setCell(move[0], move[1], playerO.getSymbol());
            updateButton(buttons[move[0]][move[1]], playerO.getSymbol());
            updateStatusLabel();
            if (checkForWin(playerO.getSymbol())) {
                showWinMessage(playerO.getSymbol());
                views.updateScore(2);
                resetGame();
            } else if (checkForDraw()) {
                JOptionPane.showMessageDialog(null, "It's a draw!");
                resetGame();
            }
            switchPlayer();
        }
    }

    private void showPlayerSymbols() {
        JOptionPane.showMessageDialog(null, player1Name + " is X and " + player2Name + " is O.");
    }

    private void updateButton(JButton button, char symbol) {
        button.setText(String.valueOf(symbol));
        button.setEnabled(false); // Disable button after clicked
        if (symbol == 'X') {
            button.setForeground(Color.RED);
        } else {
            button.setForeground(Color.BLUE);
        }
    }

    private void updateStatusLabel() {
        String currentPlayerName = (currentPlayer == playerX) ? player1Name : player2Name;
        statusLabel.setText(currentPlayerName + "'s turn (" + currentPlayer.getSymbol() + ")");
    }

    private boolean checkForWin(char symbol) {
        char[][] gameBoard = board.getBoard();

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == symbol && gameBoard[i][1] == symbol && gameBoard[i][2] == symbol) {
                return true; // Row win
            }
            if (gameBoard[0][i] == symbol && gameBoard[1][i] == symbol && gameBoard[2][i] == symbol) {
                return true; // Column win
            }
        }

        // Check main diagonal
        if (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) {
            return true; // Main diagonal win
        }

        // Check anti-diagonal
        if (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol) {
            return true; // Anti-diagonal win
        }

        return false; // No win
    }

    private boolean checkForDraw() {
        char[][] gameBoard = board.getBoard();
        // Check if there's any empty cell
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false; // Still empty cells, not a draw
                }
            }
        }
        return true; // No empty cells, it's a draw
    }

    private void resetGame() {
        board.initializeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(" ");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(Color.WHITE); // Reset màu nền của nút
            }
        }
        // Luân phiên người chơi bắt đầu
        if (gameCount % 2 == 0) {
            currentPlayer = playerX; // Lần đầu và lần thứ hai, người chơi X bắt đầu
        } else {
            currentPlayer = playerO; // Lần thứ hai, người chơi O bắt đầu
        }
        gameCount++;
        updateStatusLabel();

        // Nếu bot đánh trước và đang ở chế độ chơi với bot, cho bot đánh trước
        if (playWithBot && currentPlayer instanceof Bot) {
            botMove();
        }
    }

    private void showWinMessage(char playerSymbol) {
        String winnerName = (playerSymbol == playerX.getSymbol()) ? player1Name : player2Name;
        JOptionPane.showMessageDialog(null, winnerName + " wins! Chúc mừng!");
    }
}

