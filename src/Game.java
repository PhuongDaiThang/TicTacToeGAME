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

    public Game() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        gameCount = 0;

        player1Name = JOptionPane.showInputDialog("Enter name for Player 1:");
        player2Name = JOptionPane.showInputDialog("Enter name for Player 2:");

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
                            }
                            currentPlayer = (currentPlayer == playerX) ? playerO : playerX; // Chuyển lượt
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid move. Please try again.");
                        }
                    }
                });
                panel.add(buttons[i][j]);
            }
        }

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

        frame.setVisible(true);

        showPlayerSymbols();
        resetGame();
    }

    private void showPlayerSymbols() {
        JOptionPane.showMessageDialog(null, player1Name + " is X and " + player2Name + " is O.");
    }

    private void updateButton(JButton button, char symbol) {
        button.setText(String.valueOf(symbol));
        button.setEnabled(false); // Disable button sau khi được click
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

        // Kiểm tra các hàng và cột
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == symbol && gameBoard[i][1] == symbol && gameBoard[i][2] == symbol) {
                return true; // Có hàng thắng
            }
            if (gameBoard[0][i] == symbol && gameBoard[1][i] == symbol && gameBoard[2][i] == symbol) {
                return true; // Có cột thắng
            }
        }

        // Kiểm tra đường chéo chính
        if (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) {
            return true; // Có đường chéo chính thắng
        }

        // Kiểm tra đường chéo phụ
        if (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol) {
            return true; // Có đường chéo phụ thắng
        }

        return false; // Không có ai thắng
    }

    private boolean checkForDraw() {
        char[][] gameBoard = board.getBoard();
        // Kiểm tra xem có ô nào trống không
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false; // Còn ô trống, chưa hòa
                }
            }
        }
        return true; // Hết ô trống, hòa
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
    }

    private void showWinMessage(char playerSymbol) {
        String winnerName = (playerSymbol == playerX.getSymbol()) ? player1Name : player2Name;
        JOptionPane.showMessageDialog(null, winnerName + " wins! Chúc mừng!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game());
    }
}
