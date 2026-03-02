public class Combine {
    public static void main(String[] args) {

        int n = 5;

        for (int i = 1; i <= n; i++) {

            for (int s = 1; s <= (n - i); s++) {
                System.out.print("   ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.printf("%3d", j);
            }

            for (int j = 2; j <= i; j++) {
                System.out.printf("%3d", j);
            }

            System.out.println();
        }

        
        for (int i = n - 1; i >= 1; i--) {

            for (int s = 1; s <= (n - i); s++) {
                System.out.print("   ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.printf("%3d", j);
            }

            for (int j = 2; j <= i; j++) {
                System.out.printf("%3d", j);
            }

            System.out.println();
        }
    }
}
