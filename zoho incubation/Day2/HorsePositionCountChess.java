import java.util.*;
public class HorsePositionCountChess 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the dimension of the chess board");
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        System.out.println("enter the row position of the Horse");

        int horseRow = sc.nextInt();
        System.out.println("enter the col position of the Horse");
        int horseCol = sc.nextInt();

        
        int[] rowMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};

       
        int validMoves = 0;
        for (int i = 0; i < 8; i++) 
        {
            int newRow = horseRow + rowMoves[i];
            int newCol = horseCol + colMoves[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) 
            {
                validMoves++;
                
                System.out.print(newRow+" "+newCol);
                System.out.println();
            }
            
        }

        System.out.println("Number of valid moves : " + validMoves);
        sc.close();


    }
    
}
