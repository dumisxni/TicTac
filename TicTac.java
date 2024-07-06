import java.util.*;
public class TicTac {
    public static String board = """
                    _____________
                    | 1 | 2 | 3 |
                    | 4 | 5 | 6 |
                    | 7 | 8 | 9 |
                    -------------""";
    public int startingNumber;

    private boolean winningRows(int start,int step){
        this.startingNumber = start;
        return (board.charAt(start) ==  board.charAt(start + step) && board.charAt(start) == board.charAt(start + step*2) );
    }

    private void updateStartingNumber(int step){
        this.startingNumber+=step;
    }

    public void updateBoard(String newBoard){
        board = newBoard;
    }

    public int winner(){
        this.startingNumber = 16;
        for (int j = 0; j < 8; j++) {
            if (j<=2) {
                if (winningRows(startingNumber,4) ){
                    return board.charAt(startingNumber) == 'X' ? 1 : 2;
                }  else updateStartingNumber(14);
            }

            else if (j >= 3 && j<6){
                this.startingNumber = 16;
                if (winningRows(startingNumber,14)){
                    return board.charAt(startingNumber) == 'X' ? 1 : 2;
                }
                else updateStartingNumber(4);
            }

            else if(j == 6){
                this.startingNumber = 16;
                if (winningRows(startingNumber,18)) {
                    return board.charAt(startingNumber) == 'X' ? 1 : 2;
                }
                else updateStartingNumber(8);
            }

            else if (j == 7) {
                if (winningRows(startingNumber,10)) {
                    return board.charAt(startingNumber) == 'X' ? 1 : 2;
                }
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random comp = new Random();
        TicTac game = new TicTac();
        Set<String> compMovesSet = new HashSet<>();
        ArrayList<String> occupiedPositions = new ArrayList<String>();
        ArrayList<String> compMoves = new ArrayList<String>();

        while (compMovesSet.size() < 9) {
            String move = (comp.nextInt(9) + 1) + "";
            if (compMovesSet.add(move)) {
                compMoves.add(move);
            }
        }

        int i = 0;

        while (game.winner() == 0 && i<=8 && occupiedPositions.size() <=8){
            game.updateBoard(board.replace(compMoves.get(i).charAt(0),'X'));
            System.out.println(board);
            occupiedPositions.add(compMoves.get(i));

            if(game.winner() == 1){
                System.out.print("player 1 wins");
                break;
            }
            else if (game.winner() == 2){
                System.out.print("player 2 wins");
                break;
            }
            boolean validMove = true;
            while(validMove){
                System.out.println("Your turn, choose position on the board");
                String playerMove = keyboard.nextLine();
                if (!occupiedPositions.contains(playerMove)) {
                    game.updateBoard(board.replace(playerMove.charAt(0),'O'));
                    System.out.println(board);
                    occupiedPositions.add(playerMove);
                    compMoves.remove(playerMove);
                    validMove = false;
                }
                else System.out.println("enter a valid position");
            }

            i++;
            if(game.winner() == 1){
                System.out.print("player 1 wins");
                break;
            }
            else if (game.winner() == 2){
                System.out.print("player 2 wins");
                break;
            }
            System.out.println("Computer's turn");
        }
        if(game.winner() == 0){
            System.out.print("Nobody won");
        }


    }
}