import java.util.*;
public class boardGeneration {
    static int zeroRow=0;
    static int zeroCol=0;
    static boolean correctPositions=true;
    public static void main(String[] args)
    {  Scanner sc=new Scanner(System.in);
        int[][] board={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
       
        

       suffle(board,3,3);
      // paritycheck.parityCheck(board,4,4);
       // printBoard(board);
       displayBoard(board, 4, 4);

    }

    private static void printBoard(int [][] board)
    {   int size=4;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(board[i][j]+"\t");
            }

            System.out.println();
        }
    }

    private static void suffle(int [][] board,int currX,int currY)
    {
        int suffleCount=100;

        while(suffleCount!=0)
        {
            
            int rand=(int)(Math.random()*4);
            String [] directions={"left","right","top","bottom"};
        
            switch(directions[rand])
            {
                case "left":
                    if(isValidPosition(currX,currY+1))
                    {
                       swap(board,currX,currY,currX,currY+1);

                       currY=currY+1;
                       suffleCount--;
                    }
                    
                    break;
                case "right":
                    if(isValidPosition(currX, currY-1))
                    {
                        swap(board,currX,currY,currX,currY-1);
                        currY=currY-1;
                        suffleCount--;
                    }

                    break;
                case "top":
                    if(isValidPosition(currX+1,currY))
                    {
                       swap(board,currX,currY,currX+1,currY);

                       currX=currX+1;
                        suffleCount--;
                    }
                    
                    break;
                
                case "bottom":
                    if(isValidPosition(currX-1,currY))
                    {
                       swap(board,currX,currY,currX-1,currY);

                       currX=currX-1;
                        suffleCount--;
                    }
                    
                    break;
                
            }
        }
    }

    private static void swap(int [][] board,int currX,int currY,int newX,int newY)
    {
       board[currX][currY]=board[currX][currY]^board[newX][newY];
        board[newX][newY]=board[currX][currY]^board[newX][newY];
        board[currX][currY]=board[currX][currY]^board[newX][newY];

      // board[currX][currY]=board[newX][newY];
      // board[newX][newY]=16;

       zeroRow=newX;
       zeroCol=newY;

    }

  

    private static boolean isValidPosition(int x,int y)
    {
        return (x>=0 && x<4) && (y>=0 && y<4);
    }

    static boolean isValid(int val,int r,int c,int R,int C)
    {
        int expected =r*C+c+1;
        return val==expected;
    }
 

static int displayBoard(int [][]Board,int R,int C)
    {
        clearConsole();
        
        for(int idx1=0;idx1<R;idx1++)
        {
            for(int idx2=0;idx2<C;idx2++)
            {
                if(Board[idx1][idx2]==16)
                {
                    System.out.print(" \t");
                }
                else
                System.out.print(Board[idx1][idx2]+"\t");
                if(!isValid(Board[idx1][idx2],idx1,idx2,R,C))
                {  
                    correctPositions=false;
                }
            }
            System.out.println();
        }
        if(correctPositions)
        {
            System.out.print("u won the game");
            return 0;
        }
        else{
            getInput(Board,R,C);
            return 1;
        }
    }

    public static void getInput(int[][] Puzzle_15,int row,int col)
    {    
       
        Scanner sc=new Scanner(System.in);
        boolean[] inputDirections=new boolean[row];
    
        
        

        int[][] possibleDirections={{-1,0},{0,1},{1,0},{0,-1}};

        for(int i=0;i<possibleDirections.length;i++)
        {
            int newRow=possibleDirections[i][0]+zeroRow;
            int newCol=possibleDirections[i][1]+zeroCol;

            if(validDirections(newRow,newCol,row,col,zeroRow,zeroCol))
            {
                // System.out.println("Possible Moves: "+newRow+","+newCol);
                toggleInput(inputDirections,zeroRow,zeroCol,newRow,newCol);
            }
        }
        String choice;
        do
        {
            System.out.println("Enter the moving direction:");
            
            if(inputDirections[0])
                System.out.print(".Top\n");
            if(inputDirections[1])
                System.out.print(".Right\n");
            if(inputDirections[2])
                System.out.print(".Down\n");
            if(inputDirections[3])
                System.out.print(".Left\n");
            System.out.print(".Exit\n");
            System.out.println("Enter your choice in String: ");
            choice=sc.nextLine();
            
            switch (choice) {
                case "Top":
                    if(validateInputDirections(inputDirections[0]))
                    {
                        swap(Puzzle_15,zeroRow,zeroCol,zeroRow-1,zeroCol);
                         displayBoard(Puzzle_15, 4, 4);

                    }
                    
                    break;
                case "Right":
                    if(validateInputDirections(inputDirections[1]))
                    {
                        swap(Puzzle_15,zeroRow,zeroCol,zeroRow,zeroCol+1);
                         displayBoard(Puzzle_15, 4, 4);

                        // System.out.println("swap Directions: "+(zeroRow)+","+(zeroCol+1));
                    }
                    break;
                
                case "Down":
                    if(validateInputDirections(inputDirections[2]))
                    {
                        swap(Puzzle_15,zeroRow,zeroCol,zeroRow+1,zeroCol);
                         displayBoard(Puzzle_15, 4, 4);

                        // System.out.println("swap Directions: "+(zeroRow+1)+","+(zeroCol));
                    }
                    break;
                case "Left":
                    if(validateInputDirections(inputDirections[3]))
                    {
                        swap(Puzzle_15,zeroRow,zeroCol,zeroRow,zeroCol-1);
                        displayBoard(Puzzle_15, 4, 4);

                        // System.out.println("swap Directions: "+(zeroRow)+","+(zeroCol-1));
                    }
                    break;
                case "Exit":
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid Options");
                    break;
            }
            
        }
        while(!choice.equals("Exit") || correctPositions);
        
        sc.close();

    }
    private static boolean validateInputDirections(boolean direction)
    {
        if(direction)
            return true;
        return false;
    }

    private static boolean validDirections(int newRow,int newCol,int row,int col,int zeroRow,int zeroCol)
    {
        if(newRow<0 || newRow>=row || newCol<0 || newCol>=col)
            return false;
        
        return true;
    }

    private static void toggleInput(boolean[] inputDirections,int zeroRow,int zeroCol,int newRow,int newCol)
    {
        if(newCol==zeroCol)
        {
            if(newRow==zeroRow-1)
                inputDirections[0]=true;
            else
                inputDirections[2]=true;
        }
        else
        {
            if(newCol==zeroCol+1)
                inputDirections[1]=true;
            else
                inputDirections[3]=true;
        }
            
       
    }
    final static void clearConsole() {
        try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

}