import java.util.*;
public class FacSort 
{

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of the array");
        int n=sc.nextInt();
        int[] A_array = new int[n];

        System.out.println("enter the elements");

        for(int i=0;i<n;i++)
        {
            A_array[i]=sc.nextInt();
        }

        int[] factorArray = new int[n];
        for (int i = 0; i < n; i++) 
        {
            factorArray[i] = countFactors(A_array[i]);
        }

        insertionSort(factorArray, A_array);
        
        System.out.println("Sorted Array based on the Factors:");

        for (int val : A_array) 
        {
            System.out.print(val + " ");
        }
        sc.close();
    }

    
    private static void insertionSort(int[] factorArray, int[] mainArray) 
    {

        for (int i = 1; i < factorArray.length; i++) 
        {
            int j = i;

            while (j > 0 && factorArray[j] < factorArray[j - 1]) 
            {
                swap(factorArray, j, j - 1);
                swap(mainArray, j, j - 1);
                j--;
            }
        }
    }

    
    private static void swap(int[] arr, int i, int j) 
    {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
    private static int countFactors(int num) 
    {

        int count = 0;

        for (int i = 1; i <= num / 2; i++) 
        {
            if (num % i == 0) 
            {
                count++;
            }
        }

        count++;

        return count;
    }
}
