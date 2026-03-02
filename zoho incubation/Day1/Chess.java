public class Chess {
    public static void main(String[] args) {

        int rows = 4;
        
        int cols = 4;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }

            }
            System.out.println();
        }
    }
}
