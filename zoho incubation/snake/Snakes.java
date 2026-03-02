import java.util.*;
public class Snakes{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number");
        int n=sc.nextInt();
        int temp=0;
        int dir=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp=temp+dir;
                System.out.print(temp+" ");

                
            }
            temp=temp+n+dir;
            dir=-1*dir;
            System.out.println();
        }


    }
}