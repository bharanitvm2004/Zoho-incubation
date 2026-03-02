import java.util.Scanner;

public class Calendar
{


    private static int daysInMonth(int month) 
    {
        if (month == 2) return 28;
        if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        return 31;
    }

    private static int printCalendar(int month, int startPos)
    {

        int days = daysInMonth(month);

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < startPos; i++)
            System.out.print("    ");

        int pos = startPos;
        for (int d = 1; d <= days; d++) 
        {
            System.out.printf("%3d ", d);
            pos++;
            if (pos % 7 == 0)
                System.out.println();
        }
        System.out.println("\n");

        return pos % 7; 
    }

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter start day: ");
        String day = sc.next().toLowerCase();

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        int prev = (month == 1) ? 12 : month - 1;
        int next = (month == 12) ? 1 : month + 1;

        int startPos = switch (day) 
        {
            case "sunday" -> 0;
            case "monday" -> 1;
            case "tuesday" -> 2;
            case "wednesday" -> 3;
            case "thursday" -> 4;
            case "friday" -> 5;
            case "saturday" -> 6;
            default -> -1;
        };

        if (startPos == -1) 
        {
            System.out.println("Invalid day");
            return;
        }

        System.out.print("previous ( y/n): ");
        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') 
        {

            int prevDays = daysInMonth(prev);

            int prevStart =
                    (startPos- (prevDays % 7) + 7) % 7;

            System.out.println("Previous Month (" + prev + ")");
            printCalendar(prev, prevStart);
        }

        
        System.out.println("Current Month (" + month + ")");
        int nextStart = printCalendar(month, startPos);

        
        System.out.print("next month (y/n): ");
        ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') 
        {
            System.out.println("Next Month (" + next + ")");
            printCalendar(next, nextStart);
        }
        sc.close();
    }
}
