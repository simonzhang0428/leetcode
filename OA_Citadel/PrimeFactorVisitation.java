package OA_Citadel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeFactorVisitation {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 1, 0, 0, 1, 1, 0, 1, 1, 1);
        List<Integer> choice = Arrays.asList(3, 4, 15);
        System.out.println("[1, 0, 0, 1, 0, 0, 0, 0, 1, 1]: " + test(input, choice));
    }

    public static List<Integer> test(List<Integer> input, List<Integer> choice) {
        List<Integer> res = new ArrayList<>(input);
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : choice) {
            List<Integer> primes = findPrime(n);
            // System.out.println(primes);
            for (int p : primes) {
                freq.put(p, freq.getOrDefault(p, 0) + 1);
            }
        }

        for (Integer p : freq.keySet()) {
            if (freq.get(p) % 2 == 0) {
                continue;
            }
            for (int i = p - 1; i < res.size(); i += p) {
                res.set(i, res.get(i) ^ 1); // XOR, 异或
            }
        }

        return res;
    }

    private static List<Integer> findPrime(int n) {
        Set<Integer> primes = new HashSet<>();
        int factor = 2;
        while (factor <= n) {
            if (n % factor == 0) {
                primes.add(factor);
                while (n % factor == 0) {
                    n /= factor;
                }
            }
            factor++;
        }
        return new ArrayList<>(primes);
    }
    
}
