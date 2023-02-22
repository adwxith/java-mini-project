import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGUI extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private char[][] board;
    private char currentPlayer;
    private JLabel statusLabel;

    public TicTacToeGUI() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(4, 3));

        buttons = new JButton[3][3];
        board = new char[3][3];
        currentPlayer = 'X';

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].addActionListener(this);
                add(buttons[row][col]);
            }
        }

        statusLabel = new JLabel("Player " + currentPlayer + "'s turn");
        add(statusLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (button == buttons[row][col]) {
                    if (board[row][col] == 0) {
                        board[row][col] = currentPlayer;
                        button.setText("" + currentPlayer);

                        if (isWinningMove(row, col)) {
                            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                            resetGame();
                            return;
                        }

                        if (isBoardFull()) {
                            JOptionPane.showMessageDialog(this, "It's a tie!");
                            resetGame();
                            return;
                        }

                        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                        statusLabel.setText("Player " + currentPlayer + "'s turn");
                    }
                }
            }
        }
    }

    private boolean isWinningMove(int row, int col) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) ||
                (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) ||
                (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[2][0] == currentPlayer && board[1][1] == currentPlayer && board[0][2] == currentPlayer);
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private void resetGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                board[row][col] = 0;
            }
        }

        currentPlayer = 'X';
        statusLabel.setText("Player " + currentPlayer + "'s turn");
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
