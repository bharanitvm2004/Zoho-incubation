public class NumberPattern {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= n; i++) {

            for (int s = 1; s < i; s++) {
                System.out.print("  ");
            }

            for (int j = i; j <= n; j++) {
               System.out.print(j + " ");
            }

            
            for (int j = n - 1; j >= i; j--) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
