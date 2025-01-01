import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TicTacGUI extends JFrame {
    private TicTac game = new TicTac();
    private JButton[] buttons = new JButton[9];
    private ArrayList<String> occupiedPositions = new ArrayList<>();
    private Random comp = new Random();
    private ArrayList<String> compMoves = new ArrayList<>();

    public TicTacGUI() {
        // Setup Frame
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        // Initialize Buttons and add to Frame
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 80));
            buttons[i].setFocusPainted(false);
            int position = i + 1;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playerMove(position);
                }
            });
            add(buttons[i]);
        }

        // Generate Computer Moves
        Set<String> compMovesSet = new HashSet<>();
        while (compMovesSet.size() < 9) {
            String move = (comp.nextInt(9) + 1) + "";
            if (compMovesSet.add(move)) {
                compMoves.add(move);
            }
        }
    }

    /**
     * Handles the player's move in the Tic Tac Toe game.
     * @param position The position (1-9) where the player wants to place their mark.
     */
    private void playerMove(int position) {
        String posString = String.valueOf(position);

        // Check if the selected position is not already occupied
        if (!occupiedPositions.contains(posString)) {
            // Update the game board with the player's move ('O')
            game.updateBoard(posString.charAt(0), 'O');
            
            // Update the GUI button to display the player's mark
            buttons[position - 1].setText("O");
            
            // Add the position to the list of occupied positions
            occupiedPositions.add(posString);

            // Check if the player has won
            if (game.winner() == 2) {
                showResult("You win!");
                return;
            }

            // If the player hasn't won, it's the computer's turn
            computerMove();
        } else {
            // If the position is already occupied, show an error message
            JOptionPane.showMessageDialog(this, "Position already occupied. Try again.");
        }
    }


    private void computerMove() {
        for (String move : compMoves) {
            if (!occupiedPositions.contains(move)) {
                game.updateBoard(move.charAt(0), 'X');
                buttons[Integer.parseInt(move) - 1].setText("X");
                occupiedPositions.add(move);
                compMoves.remove(move);

                if (game.winner() == 1) {
                    showResult("Computer wins!");
                }
                return;
            }
        }

        if (game.winner() == 0 && occupiedPositions.size() == 9) {
            showResult("It's a draw!");
        }
    }

    private void showResult(String message) {
        JOptionPane.showMessageDialog(this, message);
        resetGame();
    }

    private void resetGame() {
        game.resetBoard();
        occupiedPositions.clear();
        compMoves.clear();
        Set<String> compMovesSet = new HashSet<>();
        while (compMovesSet.size() < 9) {
            String move = (comp.nextInt(9) + 1) + "";
            if (compMovesSet.add(move)) {
                compMoves.add(move);
            }
        }

        for (JButton button : buttons) {
            button.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacGUI gui = new TicTacGUI();
            gui.setVisible(true);
        });
    }
}
