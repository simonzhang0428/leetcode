package OA_Goldman;

public class Compression {
    
    public static String compress(String s) {
        // write your code here
        int i = 0, n = s.length();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        while (i < n) {
            char cur = s.charAt(i);
            while (i + 1 < n && s.charAt(i + 1) == s.charAt(i)) {
                num++;
                i++;
            }
            sb.append(cur);
            if (num != 1) {
                sb.append(num);
            }
            num = 1;
            i++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("aba2b3c " + compress("abaabbbc"));
    }
}
