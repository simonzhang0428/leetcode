package OA_Goldman;

public class TagIdentificationNumber {
    public static int numOfIDs(String s) {
        int n = s.length();
        int max = n / 11;
        int numOf8 = 0;
        for (char c : s.toCharArray()) {
            if (c - '0' == 8) {
                numOf8++;
            }
        }
        return Math.min(numOf8, max);
    }

    public static void main(String[] args) {
        System.out.println("2: " + numOfIDs("8012345678901234567890"));
        System.out.println("2: " + numOfIDs("8111111111181111111111"));
    }
}
