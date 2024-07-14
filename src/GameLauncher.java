import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tic Tac Toe");
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1));

            JButton playWithFriendButton = new JButton("Play with a Friend");
            JButton playWithBotButton = new JButton("Play with a Bot");

            playWithFriendButton.setFont(new Font("Arial", Font.BOLD, 20));
            playWithBotButton.setFont(new Font("Arial", Font.BOLD, 20));

            playWithFriendButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Game(false); // Chế độ chơi với bạn bè
                    frame.dispose(); // Đóng cửa sổ chọn chế độ
                }
            });

            playWithBotButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Game(true); // Chế độ chơi với bot
                    frame.dispose(); // Đóng cửa sổ chọn chế độ
                }
            });

            panel.add(playWithFriendButton);
            panel.add(playWithBotButton);

            frame.add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
