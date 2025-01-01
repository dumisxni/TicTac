import java.util.*;

public class TicTac {
    public static String board = """
                    _____________
                    | 1 | 2 | 3 |
                    | 4 | 5 | 6 |
                    | 7 | 8 | 9 |
                    -------------""";
    public int startingNumber;

    private boolean winningRows(int start, int step) {
        return (board.charAt(start) == board.charAt(start + step) && board.charAt(start) == board.charAt(start + step * 2));
    }

    public void resetBoard() {
        board = """
                    _____________
                    | 1 | 2 | 3 |
                    | 4 | 5 | 6 |
                    | 7 | 8 | 9 |
                    -------------""";
    }

    private void updateStartingNumber(int step) {
        this.startingNumber += step;
    }

    public void updateBoard(char position, char symbol) {
        board = board.replace(position, symbol);
    }

    public int winner() {
        this.startingNumber = 16;
        for (int i = 0; i < 3; i++) {
            if (winningRows(startingNumber, 4)) {
                return board.charAt(startingNumber) == 'X' ? 1 : 2;
            }
            updateStartingNumber(14);
        }
        this.startingNumber = 16;
        for (int i = 0; i < 3; i++) {
            if (winningRows(startingNumber, 14)) {
                return board.charAt(startingNumber) == 'X' ? 1 : 2;
            }
            updateStartingNumber(4);
        }
        if (winningRows(16, 18)) {
            return board.charAt(16) == 'X' ? 1 : 2;
        }
        if (winningRows(24, 10)) {
            return board.charAt(24) == 'X' ? 1 : 2;
        }
        return 0;
    }

    // public static void main(String[] args) {
    //     Scanner keyboard = new Scanner(System.in);
    //     Random comp = new Random();
    //     TicTac game = new TicTac();

    //     for (int h = 0; h < 3; h++) {
    //         game.resetBoard();
    //         Set<String> compMovesSet = new HashSet<>();
    //         ArrayList<String> occupiedPositions = new ArrayList<>();
    //         ArrayList<String> compMoves = new ArrayList<>();

    //         while (compMovesSet.size() < 9) {
    //             String move = (comp.nextInt(9) + 1) + "";
    //             if (compMovesSet.add(move)) {
    //                 compMoves.add(move);
    //             }
    //         }

    //         int i = 0;
    //         while (game.winner() == 0 && i < 9 && occupiedPositions.size() < 9) {
    //             game.updateBoard(compMoves.get(i).charAt(0), 'X');
    //             System.out.println(game.board);
    //             occupiedPositions.add(compMoves.get(i));

    //             if (game.winner() == 1) {
    //                 System.out.println("Computer wins");
    //                 break;
    //             }

    //             boolean validMove = true;
    //             while (validMove) {
    //                 System.out.println("Your turn, choose position on the board");
    //                 String playerMove = keyboard.nextLine();
    //                 if (!occupiedPositions.contains(playerMove) && playerMove.length() == 1 && Character.isDigit(playerMove.charAt(0))) {
    //                     game.updateBoard(playerMove.charAt(0), 'O');
    //                     System.out.println(game.board);
    //                     occupiedPositions.add(playerMove);
    //                     compMoves.remove(playerMove);
    //                     validMove = false;
    //                 } else {
    //                     System.out.println("Enter a valid position");
    //                 }
    //             }

    //             if (game.winner() == 2) {
    //                 System.out.println("You win");
    //                 break;
    //             }

    //             i++;
    //         }

    //         if (game.winner() == 0) {
    //             System.out.println("Nobody won");
    //         }
    //     }
    // }
}
