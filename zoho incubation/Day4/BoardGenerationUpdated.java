import java.util.*;

class BoardGenerationUpdated
{
    static int move[][]=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    static int correctPositions=0;
    static int cnt=0;
    static int[]space=new int[2];
    static int displayBoard(int [][]Board,int R,int C)
    {
        boolean correctPositions=true;
        for(int idx1=0;idx1<R;idx1++)
        {
            for(int idx2=0;idx2<C;idx2++)
            {
                System.out.print(Board[idx1][idx2]+"\t");
                if(!isValidPosition(Board[idx1][idx2],idx1,idx2,R,C))
                {
                    correctPositions=false;
                }
            }
            System.out.println();
        }
        if(isValidBoard())
        {
            System.out.print("u won the game");
            return 0;
        }
        else{
            getInput(Board,R,C);
            return 1;
        }
    }
    static void getInput(int[][]Board,int R,int C)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1.up 2.down 3.left 4.right");
        int moveDir=sc.nextInt();
        System.out.print(space[0]+" "+space[1]);
        int curr_x=space[0]+move[moveDir-1][0];
        int curr_y=space[1]+move[moveDir-1][1];
         if(curr_x>=0 && curr_x<R && curr_y>=0  && curr_y<C)
         {
            swap(Board,space[0],space[1],curr_x,curr_y);
         }
    }
    static boolean isValidBoard()
    {
       return correctPositions==(1<<16)-1;
    }
    static boolean isValidPosition(int val,int r,int c,int R,int C)
    {
        int expected =r*C+c+1;
        return val==expected;
    }
 
    static void swap(int [][]Board,int x,int y,int curr_x,int curr_y)
    {
        int temp=Board[x][y];
        Board[x][y]=Board[curr_x][curr_y];
        Board[curr_x][curr_y]=temp;
        space[0]=curr_x;
        space[1]=curr_y;
    }
    static void shuffleBoard(int [][]Board,int R,int C,int space_r,int space_c)
    {
        if(cnt==300)
        {
        return ;
        }
        int x=space_r;
        int y=space_c;
        Random randObj=new Random();
        int idx=randObj.nextInt(4);
        int curr_x=x+move[idx][0];
        int curr_y=y+move[idx][1];
        if(curr_x>=0 && curr_x<R && curr_y>=0  && curr_y<C)
        {
            swap(Board,x,y,curr_x,curr_y);
            shuffleBoard(Board,R,C,curr_x,curr_y);
        }
        cnt++;
    }
    public static void main(String[]args)
    {
        int R=4,C=4;
        int Board[][]=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        space[0]=R-1;
        space[1]=C-1;
        for(int i=0;i<100;i++)
        {
        shuffleBoard(Board,R,C,R-1,C-1);
        }
        int n=1;
        while(n>0)
        {
        n=displayBoard(Board,R,C);
        }
    }



}