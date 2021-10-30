package OA_Citadel;

public class GetMaxDeletions {

    // getMaxDeletions function
    public static int getMaxDeletions(String s) {
        int n = s.length();

        // algo you will cancel D and R will can cancel L
        // therefore final answer will be (min(U,D)+min(R,L))*2
        int U = 0, D = 0, R = 0, L = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'U')
                U++;
            else if (s.charAt(i) == 'L')
                L++;
            else if (s.charAt(i) == 'R')
                R++;
            else
                L++;
        }

        // returning result
        return Math.min(U, D) * 2 + Math.min(R, L) * 2;
    }

    // Driver class
    public static void main(String[] args) {

        String s;

        // user input
        s = "URDR";

        // calling getMaxDeletions function with user input as parameter
        System.out.println("2: " + getMaxDeletions(s));

    }
}

