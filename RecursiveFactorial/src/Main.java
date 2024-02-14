import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(calculateFactorial(n));
    }

    private static long calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        }

        // n = 5
        // 5 * 4 * 3 * 2 * 1
        return n * calculateFactorial(n - 1);
    }
}