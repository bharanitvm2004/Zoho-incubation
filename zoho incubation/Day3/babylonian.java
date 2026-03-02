import java.util.*;

public class babylonian {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to find the square root:");
        double n = sc.nextDouble();

        double x = n;
        double y = 1;
        double e = 0.000001;  

        while (Math.abs(x - y) > e) {
            x = (x + y) / 2;
            y = n / x;
        }


        System.out.println("Square root = " + x);
    }
}
