import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        List<Integer> sortedCoins = Arrays.stream(coins)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        Map<Integer, Integer> chosenCoins = new LinkedHashMap<>();
        int currentSum = 0;
        int coinIndex = 0;

        while (currentSum != targetSum && coinIndex < sortedCoins.size()) {
            int currentCoin = sortedCoins.get(coinIndex);

            int remainder =  targetSum - currentSum;
            int numberOfCoins = remainder / currentCoin;

            if (currentSum + currentCoin <= targetSum) {
                chosenCoins.put(currentCoin, numberOfCoins);
                currentSum += numberOfCoins * currentCoin;
            }

            coinIndex++;
        }

        if (currentSum != targetSum) {
            throw new IllegalArgumentException();
        }

        return chosenCoins;
    }
}