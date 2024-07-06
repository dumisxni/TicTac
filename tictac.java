import java.sql.Array;
import java.util.*;
public class tictac {
    public int winner(String board){

        int[] winnerNumbers = {16,20,24,30,34,38,44,48,52};
        for (int i = 0; i < 8; i++) {

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
                    | 1 | 2 | 3 |
                    | 4 | 5 | 6 |
                    | 7 | 8 | 9 |
                    _____________""";

        int[] winnerNumbers = {16,20,24,30,34,38,44,48,52};
        for(int i:winnerNumbers){
            System.out.println(i);
        }
            //System.out.println("---------");
            System.out.print(board.replace(player1.charAt(0),'X'));
            //System.out.println("---------");
    }
}
