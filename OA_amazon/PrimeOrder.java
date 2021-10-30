package OA_amazon;

import java.util.*;

/**
 * Q2. Given a List of Orders , where each Order is a string . For example :
 * [aax 12 23 ] [ ff kindle ebook] [ ff2 kindle ebook]are two orders. Each order
 * has an ID which is first part of the order ( ID of order 1 = aax , ID2 = ff
 * ). The remaining part of the order is referred to as MetaData. There are two
 * types of orders, Prime orders ( which contain non numeric Meta Data) and
 * Non-Prime Orders (which contain Only-Numeric Meta Data).
 * 
 * Sort the List of Orders as given below : a. Prime Orders before NonPrime
 * Orders b. Prime Order with lexicographically smaller MetaData comes first. c.
 * In Case of tie in (b), the one with lexicographically smaller ID comes first.
 * d. The relative order of NonPrime Orders remains the same.
 */

public class PrimeOrder {

    static class Order {
        String id;
        String meta1;
        String meta2;
        Boolean isPrime;

        Order(String id, String meta1, String meta2, Boolean isPrime) {
            this.id = id;
            this.meta1 = meta1;
            this.meta2 = meta2;
            this.isPrime = isPrime;
        }

        public String toString() {
            return this.id + " " + this.meta1 + " " + this.meta2 + " " + this.isPrime;
        }
    }

    public static List<Order> preprocess(List<String> list) {
        List<Order> orders = new ArrayList<>();
        for (String s : list) {
            String[] temp = s.split(" ");
            boolean isPrime = false;

            try {
                Integer.valueOf(temp[1] + temp[2]);
            } catch (Exception e) {
                isPrime = true;
            }

            orders.add(new Order(temp[0], temp[1], temp[2], isPrime));
        }
        // System.out.println("Orders  " + orders);
        return orders;
    }

    public static List<String> sortOrder(List<String> list) {
        
        List<Order> orders = preprocess(list);

        Collections.sort(orders, (o1, o2) -> {
            int prime = o2.isPrime.compareTo(o1.isPrime);
            if (o1.isPrime && o2.isPrime) {
                int meta = (o1.meta1 + o1.meta2).compareTo(o2.meta1 + o2.meta2);
                if (meta == 0)
                    return (o1.id).compareTo(o2.id);
                return meta;
            }
            return prime;
        });

        List<String> res = new ArrayList<>();
        for (Order x : orders)
            res.add(x.id + " " + x.meta1 + " " + x.meta2);
        return res;
    }

    // public static int orderToPrimeNum(String o) {
    //     // if (isPrime) return 0; else return 1;
    //     return 0;
    // }
    // public String meta1(String o) {
    //     return "";
    // }
    // public String meta2(String o) {
    //     return "";

    // }
    // public static List<String> sort(List<String> list) {
    //     List<String> res = new ArrayList<>();

    //     Collections.sort(list, new Comparator<String>(){
    //         @Override
    //         public int compare(String o1, String o2) {
    //             // 如果升序, 在o1 应该在 o2之前的时候,返回 -1
    //             // 降序, 返回1
    //             // a. Prime Orders before NonPrime Orders
    //             int primeNum1 = orderToPrimeNum(o1);
    //             int primeNum2 = orderToPrimeNum(o2);
    //             if (primeNum1 != primeNum2) {
    //                 return primeNum1 - primeNum2;
    //             }
                
    //             // * b. Prime Order with lexicographically smaller MetaData comes first.
    //             if (primeNum1 == 0) {
    //                 // TODO
    //             }
    //             // * c. In Case of tie in (b), the one with lexicographically smaller ID comes
    //             // first.
    //             // * d. The relative order of NonPrime Orders remains the same.

    //             return 0;
    //         }
    //     });

    //     return res;
    // }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("aax 12 23");
        list.add("sde 1 00");      
        list.add("ff kindle ebook");
        list.add("wed abc zz");
        list.add("a2 kindle ebook");
        List<String> res = sortOrder(list);
        System.out.println(list);
        System.out.println(res);
    }
}