import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(sc.nextLine());

        System.out.println(binarySearch(input, key));
    }

    public static int binarySearch(int[] arr, int key) {
        int first = 0;
        int last = arr.length - 1;

        int mid = (first + last) / 2;

        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                last = mid - 1;
            }

            mid = (first + last) / 2;
        }

        if (first > last) {
            return -1;
        }

        return -1;
    }
}