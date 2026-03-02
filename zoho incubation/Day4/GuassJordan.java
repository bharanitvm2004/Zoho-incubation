import java.util.Scanner;

public class GuassJordan {

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of variables: ");
        int n = sc.nextInt();

        double[][] matrix = new double[n][n + 1];

        System.out.println("Enter augmented matrix:");
        for (int row = 0; row < n; row++) 
        {
            for (int col = 0; col <= n; col++) 
            {
            
                matrix[row][col] = sc.nextDouble();
            }
        }

        solve(matrix, n);

        System.out.println("\nSolution:");
        for (int row = 0; row < n; row++) 
        {
            System.out.println("x"+row+ "="+ matrix[row][n]);
        }

        sc.close();
    }

    static void solve(double[][] matrix, int n) 
    {

        for (int row = 0; row < n; row++) 
        {

           
            if (Math.abs(matrix[row][row]) < 1e-9) 
            {
                for (int k = row + 1; k < n; k++) 
                {

                    if (Math.abs(matrix[k][row]) > 1e-9) 
                    {
                        swap(matrix, row, k);
                        break;
                    }
                    
                }
            }

            double pivot = matrix[row][row];

            if (Math.abs(pivot) < 1e-9) 
            {
                System.out.println("No unique solution exists.");
                return;
            }

            
            for (int col = 0; col <= n; col++) {
                matrix[row][col] /= pivot;
            }

            
            for (int k = 0; k < n; k++) {
                if (k != row) {
                    double factor = matrix[k][row];
                    for (int col = 0; col <= n; col++) {
                        matrix[k][col] -= factor * matrix[row][col];
                    }
                }
            }
        }
    }

    static void swap(double[][] matrix, int r1, int r2) {
        double[] temp = matrix[r1];
        matrix[r1] = matrix[r2];
        matrix[r2] = temp;
    }
}
