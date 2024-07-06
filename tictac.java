public class tictac {
    public static String topLayer(int position){
        return "| 1 2 3 |";
    }
    public static String middleLayer(int position){
            return "| 4 5 6 |";
    }

    public static String bottomLayer(int position){
        return "| 7 8 9 |";
    }


    public static void main(String[] args) {
        System.out.println("---------\n" + ""+topLayer(1)+"\n"+middleLayer(3)+"\n"+bottomLayer(3)+"\n"+"---------");

        System.out.println(middleLayer(2).length());
        System.out.println(middleLayer(2).replace('4','X'));

    }
}
