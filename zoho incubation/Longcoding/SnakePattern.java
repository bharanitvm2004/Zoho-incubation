import java.util.Scanner;

public class SnakePattern {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int temp = 0;
        int dir=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i%2==0)
                {
                    temp=temp+dir;
                    System.out.print(temp+" ");
                }
                
            }
            dir=-1;
            temp = temp+n;
            System.out.println();
        }
    }
}