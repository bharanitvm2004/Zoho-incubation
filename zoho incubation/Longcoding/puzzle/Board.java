package puzzle;
import java.util.*;
public class Board {
    int currX;
    int currY;
    int [][] generateBoard(int size)
    {
        int[][] board={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        currX=3;
        currY=3;
        shuffleBoard(board, currX, currY);
        return board;
    }

    void shuffleBoard(int[][] board,int curr_X,int curr_Y)
    {   currX=curr_X;
        currY=curr_Y;
        Random random=new Random();
        int shuffleCount[]={100};

        int [][] dir={{0,-1},{0,1},{-1,0},{1,0}};
        int prevMove=0;
        while(shuffleCount[0]!=0)
        {   
            int randIdx=random.nextInt(4);
            if((randIdx==0 && prevMove==1) || (randIdx==1 && prevMove==0))
            {
            randIdx=2;
            }

            else if((randIdx==2 && prevMove==3) || (randIdx==3 && prevMove==2))
            {
            randIdx=1;
            }
        
            move(board, currX+dir[randIdx][0] , currY+dir[randIdx][1],shuffleCount);

            prevMove=randIdx;
        }
        
    }

    void move(int[][] board,int newX,int newY,int[] count)
    {
        if(isValid(newX) && isValid(newY))
        {
            swap(board,currX,currY,newX,newY);
            currX=newX;
            currY=newY;
            count[0]--;
        }
    }


    void swap(int [][] board,int currX,int currY,int newX,int newY)
    {
        int temp=board[currX][currY];
        board[currX][currY]=board[newX][newY];
        board[newX][newY]=temp;
    }

    boolean isValid (int num)
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
                System.out.print(board[i][j]+"\t");
            }

            System.out.println();
        }
    }


}