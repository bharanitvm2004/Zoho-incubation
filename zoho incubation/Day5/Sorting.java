import java.util.*;

public class Sorting {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of 1st array (Ascending): ");
        int n1 = sc.nextInt();
        int[] asc = new int[n1];

        for (int i = 0; i < n1; i++) {
            asc[i] = sc.nextInt();
        }

        System.out.print("Enter size of 2nd array (Descending): ");
        int n2 = sc.nextInt();
        int[] desc = new int[n2];

        for (int i = 0; i < n2; i++) {
            desc[i] = sc.nextInt();
        }

        int[] res = new int[n1 + n2];

        int i = 0;          
        int j = n2 - 1;     
        int k = 0;          


        while (i < n1 && j >= 0) {
            if (asc[i] <= desc[j]) {
                res[k++] = asc[i++];
            } else {
                res[k++] = desc[j--];
            }
        }


        while (i < n1) res[k++] = asc[i++];
        while (j >= 0) res[k++] = desc[j--];
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
