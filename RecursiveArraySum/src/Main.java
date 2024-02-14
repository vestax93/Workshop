import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(sum(nums, 0));

    }

    // 1, 2, 3, 4
    // index = broj elementa u nizu
    private static int sum(int[] nums, int index) {
        if (index == nums.length) {
            return 0;
        }

        // 1 + 2 + 3 + 4
        return nums[index] + sum(nums,index + 1);
    }
}