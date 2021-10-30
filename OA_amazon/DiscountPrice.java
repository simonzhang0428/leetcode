package OA_amazon;

import java.util.*;

public class DiscountPrice {
    /**
     * products[] = [price, tag1, tag2,..., tag m-1], [10, d0, d1], [15, EMPTY,
     * EMPTY] discounts[] = [tag, type, amount], [d0, 1, 27], [d1, 2, 5] 
     * type 0: return the amount, 1: percentage, 2: fixed discount
     * 
     * 10 - 10 * 0.27 = 7.3 -> 7 round to nearest integer 
     * 10 - 5 = 5 
     * return 5 since it is the lowest price
     */
    public static int findLowestPrice(String[][] products, String[][] discounts) {

        // build mapping for quick lookup
        Map<String, String[]> discountsMapping = new HashMap<>();
        for (String[] discount : discounts) {
            String label = discount[0];
            discountsMapping.put(label, new String[] { discount[1], discount[2] });
        }

        int total = 0;
        for (int i = 0; i < products.length; i++) {
            String[] product = products[i];
            int originalPrice = Integer.parseInt(product[0]);
            int curLowest = originalPrice;
            for (int j = 1; j < product.length; j++) {
                String id = product[j];
                if (!id.equals("EMPTY")) {
                    curLowest = Math.min(curLowest, computeAfterDiscount(id, originalPrice, discountsMapping));
                }
            }
            total += curLowest;
        }
        
        return total;
    }

    private static int computeAfterDiscount(String id, int originalPrice, Map<String, String[]> discountsMapping) {
        String[] detail = discountsMapping.get(id);
        String type = detail[0];
        int amount = Integer.parseInt(detail[1]);
        if (type.equals("0")) {
            return amount;
        }
        if (type.equals("1")) {
            return (int) Math.round(originalPrice - originalPrice * amount / 100.0);
        }
        if (type.equals("2")) {
            return originalPrice - amount;
        }
        return -1;
    }

    public static void main(String[] args) {
        // findLowestPrice
        String[][] products = { { "10", "d0", "d1" }, { "15", "EMPTY", "EMPTY" }, { "20", "d1" } };
        String[][] discounts = { { "d0", "1", "27" }, { "d1", "2", "5" } };
        System.out.println("total should be 35: " + findLowestPrice(products, discounts));

        String[][] products2 = { { "10", "sale", "1-sale" }, { "200", "sale", "EMPTY" } };
        String[][] discounts2 = { { "sale", "0", "10" }, { "1-sale", "1", "10" } };
        System.out.println("total should be 19: " + findLowestPrice(products2, discounts2));

    }
    
}
