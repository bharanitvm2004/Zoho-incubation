
import java.util.*;
public class Sorting2 {
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] asc = new int[n1];
        for (int i = 0; i < n1; i++) asc[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] desc = new int[n2];
        for (int i = 0; i < n2; i++) desc[i] = sc.nextInt();

        int l=0;
        int r=n2-1;
        while ( l < r) {
            int temp = desc[l];
            desc[l] = desc[r];
            desc[r] = temp;
            l++;
            r--;
        }

        int[] res = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (asc[i] < desc[j]) res[k++] = asc[i++];
            else res[k++] = desc[j++];
        }

        while (i < n1) res[k++] = asc[i++];
        while (j < n2) res[k++] = desc[j++];

        for (int x : res) System.out.print(x + " ");
    }
}

    

