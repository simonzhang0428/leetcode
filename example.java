import java.util.*;

public class example {

    public static void main(String[] args) {
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
        
        
    }
}
