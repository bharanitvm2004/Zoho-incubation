import java.util.*;

public class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        long n = sc.nextLong();

        System.out.println("Next Palindrome = " + nextPal(n));
        
    }

    static long nextPal(long n) {

        
        long temp9 = n;
        boolean all9 = true;

        while (temp9 > 0) {
            if (temp9 % 10 != 9) {
                all9 = false;
                break;
            }
            temp9 /= 10;
        }

     
        if (all9) {
            return nextPal(n + 1);
        }

       
        long temp = n;
        int digits = 0;

        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        long pow = 1;
        for (int i = 0; i < digits / 2; i++) {
            pow *= 10;
        }

        long left = n / pow;
        long pal = makePal(left, digits);

        if (pal > n) return pal;

        left++;
        return makePal(left, digits);
    }

    static long makePal(long left, int digits) {

        long res = left;
        long x = (digits % 2 == 0) ? left : left / 10;

        while (x > 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
    }
}
