import java.sql.Array;
import java.util.*;
public class tictac {
    public static int winner(String board){
            int startingNo = 16;
            int startingNo1 = 16;
            int startingNo2 = 16;
            for (int j = 0; j < 8; j++) {
                if (j<2) {
                    if (board.charAt(startingNo) == 'X' && board.charAt(startingNo + 4) == 'X' && board.charAt(startingNo + 8) == 'X') {
                        return 1;
                    } else if (board.charAt(startingNo) == 'O' && board.charAt(startingNo + 4) == 'O' && board.charAt(startingNo + 8) == 'O') {
                        return 2;
                    } else startingNo += 14;
                }
                else if (j > 3 && j<6){
                    if (board.charAt(startingNo1)== 'X' && board.charAt(startingNo1+14)=='X' && board.charAt(startingNo1+28)=='X'){
                        return 1;
                    }
                    else if(board.charAt(startingNo1)== 'O' && board.charAt(startingNo1+14)=='O' && board.charAt(startingNo1+28)=='O'){
                        return 2;
                    }
                    else startingNo1+=4;
                }
                else if(j == 6){
                    if (board.charAt(startingNo2) == 'X' && board.charAt(startingNo2 + 18) == 'X' && board.charAt(startingNo2 + 36) == 'X') {
                        return 1;
                    } else if (board.charAt(startingNo2) == 'O' && board.charAt(startingNo2 + 18) == 'O' && board.charAt(startingNo2 + 36) == 'O') {
                        return 2;
                    } else startingNo2 += 8;
                } else if (j == 7) {
                    if (board.charAt(startingNo2) == 'X' && board.charAt(startingNo2 + 10) == 'X' && board.charAt(startingNo2 + 10) == 'X') {
                        return 1;
                    } else if (board.charAt(startingNo2) == 'O' && board.charAt(startingNo2 + 10) == 'O' && board.charAt(startingNo2 + 10) == 'O') {
                        return 2;
                    }
                }
            }
        return 0;
    }
    public static void main(String[] args) {
            Scanner keyboard = new Scanner(System.in);
            Random comp = new Random();

            String player1 =  (comp.nextInt(9)+1)+"";
            System.out.println("choose position in the board");
            //String player2 = keyboard.nextLine();

            String board = """
                    _____________
                    | O | X | X |
                    | X | O | O |
                    | X | O | X |
                    -------------""";

            System.out.println(winner(board));

            //System.out.println("---------");
            System.out.print(board.replace(player1.charAt(0),'X'));
            //System.out.println("---------");
    }
}
