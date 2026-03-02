import java.util.Scanner;

public class Magic{
    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 == 0) 
        {
        
            System.out.println("Magic square works only for odd numbers");
            return;
        }

        int[][] mat = new int[n][n];

        int row = 0;
        int col = n / 2;

        for (int num = 1; num <= n * n; num++) 
        {
            mat[row][col] = num;

            int nextRow = (row - 1 + n) % n;
            int nextCol = (col + 1) % n;

            if (mat[nextRow][nextCol] != 0) 
            {
            
                row = (row + 1) % n;   
            } else 
            {
                row = nextRow;
                col = nextCol;
            }
        }

        
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                System.out.printf("%4d", mat[i][j]);
            }
            System.out.println();
        }
    }
}
