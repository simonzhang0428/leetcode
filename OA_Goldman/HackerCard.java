package OA_Goldman;

import java.util.*;

public class HackerCard {
    public static void main(String[] args) {
        List<Integer> cards = new ArrayList<>();

        Collections.addAll(cards, 1, 1, 1, 3, 4);
        System.out.println("[2, 5]: " + test(cards, 7));
        System.out.println("[2, 5]: " + test2(cards, 7));

        cards.clear();
        cards.add(4);
        cards.add(6);
        cards.add(12);
        cards.add(8);
        System.out.println("[1, 2, 3, 5]: " + test(cards, 14));
        System.out.println("[1, 2, 3, 5]: " + test2(cards, 14));

        cards.clear();
        cards.add(1);
        cards.add(2);
        cards.add(3);
        cards.add(4);
        System.out.println("[5]: " + test(cards, 5));
        System.out.println("[5]: " + test2(cards, 5));

    }

    public static List<Integer> test(List<Integer> cards, int budget) {
        List<Integer> res = new ArrayList<>();

        // remove duplicate in cards
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < cards.size(); i++) {
            if (!seen.add(cards.get(i))) {
                cards.remove(i); // shrink the size if ascending order
                i--;
            }
        }

        Collections.sort(cards);

        for (int i = 1; i <= budget; i++) {
            if (i > budget) {
                break;
            }
            if (i <= budget && !seen.contains(i)) {
                budget -= i;
                res.add(i);
            }
        }

        return res;
    }

    public static List<Integer> test2(List<Integer> cards, int budget) {
        int max_card = Collections.max(cards);
        max_card = Math.max(max_card, budget);
        Set<Integer> set_card = new HashSet<>(cards);
        Set<Integer> res = new HashSet<>();

        for (int i = 1; i <= max_card; i++) {
            if (i <= budget && !set_card.contains(i) && !res.contains(i)) {
                res.add(i);
                budget -= i;
            }
        }

        List<Integer> resList = new ArrayList<>(res);
        Collections.sort(resList);
        return resList;
    }
}
