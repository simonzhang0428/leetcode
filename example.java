import java.util.*;

public class example {

    public static void main(String[] args) {

        /**
         * String
         */
        String s1 = "Hello", s2 = "hello";
        System.out.println(s1.compareToIgnoreCase(s2));
        System.out.println(s1.compareTo(s2)); // H < h

        s1 = "Look, look!";
        boolean b1, b2, b3;

        b1 = s1.regionMatches(6, "Look", 0, 4);
        b2 = s1.regionMatches(true, 6, "Look", 0, 4);
        // s1.regionMatches(ignoreCase = true, start = 0, other = "Hello", otherStart = 5, len = 5);

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);

        System.out.println("hello startWith he: " + s2.startsWith("he", 0));
        System.out.println("h | ello startWith he: " + s2.startsWith("he", 1));

        s1 = "simon";
        s2 = "simon";
        System.out.println("s1 hashcode: " + s1.hashCode());
        System.out.println("s2 hashcode: " + s1.hashCode());

        System.out.println("s1 intern: " + s1.intern()); // from String unique pool, faster than compare content
        System.out.println("s2 intern: " + s2.intern());

        s1 = s2.replace("si", "XXX");
        System.out.println("XXXmon: " + s1);

        s1 = "2021 10 01";
        s2 = s1.replace(" ", "-");
        System.out.println("2021-10-01: " + s2);
        s2 = s2.replaceAll("\\d", "X");
        System.out.println("XXXX-XX-XX: " + s2);

        char[] charArray = {'S', 'I', 'M', 'O', 'N'};
        String simon = new String(charArray);
        System.out.println("SIMON: " + simon);
        
        String mon = new String(charArray, 2, 3);
        System.out.println("MON: " + mon);

        String now = new java.util.Date().toString();
        System.out.println("time: " + now);

        StringBuilder sb = new StringBuilder();
        sb.append("Helen and Simon ").append("Love together!");
        sb.replace(0, 5, "Simon");
        System.out.println("Simon and Simon ..." + sb.toString());
        sb.delete(12, 16);
        System.out.println(sb.toString());
        System.out.println("capacity: " + sb.capacity());
        System.out.println("length: " + sb.length());

        System.out.println(new Double(1.007).compareTo(1.00700001));

        var s = "hello";
        // System.out.println(s.substring(6)); out of bound

        /**
         * TreeMap
         */
        /*
        TreeMap<Integer, String> treemap = new TreeMap<>();
        treemap.put(3, "val");
        treemap.put(2, "val");
        treemap.put(1, "val");
        treemap.put(5, "val");
        treemap.put(4, "val");
    
        System.out.println(treemap.keySet().toString());

        TreeMap<Integer, String> reverseMap = new TreeMap<>(Comparator.reverseOrder());
        reverseMap.put(3, "val");
        reverseMap.put(2, "val");
        reverseMap.put(1, "val");
        reverseMap.put(5, "val");
        reverseMap.put(4, "val");

        System.out.println(reverseMap.keySet().toString());


        Integer highestKey = treemap.lastKey();
        Integer lowestKey = treemap.firstKey();

        System.out.println(highestKey + "   " + lowestKey);

        System.out.println(treemap.ceilingKey(10)); // >10 smallest
        System.out.println(treemap.floorKey(10)); // <10 largest
        
        int i = Integer.parseInt("0001");
        System.out.println(i);
        */
    }
}
