package puzzle;

import java.util.*;
public class Mains {
    static int currX=0;
    static int currY=0;
    static Stack<int []> undo=new Stack<>();
    static Stack<int []> redo=new Stack<>();
    public static void main(String[] args) {
        Board boardObj=new Board();
        Scanner sc=new Scanner(System.in);
        int [][] board=boardObj.generateBoard(4);
        printBoard(board);
        
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(board[i][j]==16)
                {
                    currX=i;
                    currY=j;
                    break;
                }
            }
        }

        String[] moveName={"left","right","top","bottom"};
        int [][] dir={{0,-1},{0,1},{-1,0},{1,0}};
        int [] availMoves;
        while(!isWon(board))
        {   
            System.out.println("Enter 1 to play\nEnter 2 to perform undo\nEnter 3 to perform redo");
            int choice=sc.nextInt();
            
            switch(choice)
            {
                case 1:
                    availMoves=getAvailableMoves(currX,currY);

                    System.out.println("Available Moves:");
                    for(int i=0;i<4;i++)
                    {   if(availMoves[i]==1)
                        {
                            System.out.println(i+"-"+moveName[i]);
                        }
                        
                    }
                    System.out.println("Enter your Choice");
                    int option=sc.nextInt();

                    move(board,currX+dir[option][0],currY+dir[option][1]);
                    printBoard(board);
                    break;

                case 2:
                    undoSwap(board);
                    printBoard(board);
                    break;
                case 3:
                    redoSwap(board);
                    printBoard(board);
                    break;         
            }   
        }
        

    }


    static boolean isWon(int [][] board)
    {   int count=1;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {   
                if(count!=board[i][j])
                {
                    return false;
                }

                count++;
            }
        }

        return true;
    }
    static void move(int[][] board,int newX,int newY)
    {
        if(isValid(newX) && isValid(newY))
        {
            swap(board,currX,currY,newX,newY);
            currX=newX;
            currY=newY;
        }
    }


    static void undoSwap(int [][]board)
    {
        if(!undo.isEmpty())
        {
            int [] move=undo.pop();
            int temp=board[move[0]][move[1]];
            board[move[0]][move[1]]=board[move[2]][move[3]];
            board[move[2]][move[3]]=temp;

            redo.push(new int[]{move[2],move[3],move[0],move[1]});
        }
    }

    static void redoSwap(int [][]board)
    {   
        if(!redo.isEmpty())
        {
            int [] move=redo.pop();
            int temp=board[move[0]][move[1]];
            board[move[0]][move[1]]=board[move[2]][move[3]];
            board[move[2]][move[3]]=temp;

            undo.push(new int[]{move[2],move[3],move[0],move[1]});

        }

    }
    static void swap(int [][] board,int currX,int currY,int newX,int newY)
    {
        int temp=board[currX][currY];
        board[currX][currY]=board[newX][newY];
        board[newX][newY]=temp;

        int[] moves={currX,currY,newX,newY};
        undo.push(moves);
    }
    static int[] getAvailableMoves(int curr_X,int curr_Y)
    {
        int[] possibleMove=new int[4];
        int size=3;
        Arrays.fill(possibleMove,1);
        
        if(curr_X==0)
        {
            possibleMove[2]=-1;
        }

        if(curr_X==(size))
        {
            possibleMove[3]=-1;
        }

        if(curr_Y==0)
        {
            possibleMove[0]=-1;
        }

        if(curr_Y==(size))
        {
            possibleMove[1]=-1;
        }
       
               
        return possibleMove;
    }
   static boolean isValid (int num)
    {   int size=4;
        if(num>=0 && num<size)
        {
            return true;
        }
        return false;
    }


    private static void printBoard(int [][] board)
    {   int size=4;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<size;j++)
            {   
                if(board[i][j]==16)
                {
                    System.out.print("*\t");
                }

                else
                {
                    System.out.print(board[i][j]+"\t");
                }
            }

            System.out.println();
        }
    }
}