package OA_amazon;

public class TeamCounts {
    /**
     * skills = [12, 4, 6, 13, 5, 10], represent skill level per player 
     * minPlayers = 3 minLevel = 4 maxLevel = 10
     * 
     * return how many teams can be created from the list 
     * 4 players: [4, 6, 5, 10]，一种, maxPlayer = 4, 4^0 = 1 
     * 3 players: 4选3，4种, maxPlayer 
     * return 5 = 1 + 4 + 6
     * 
     * 扫一遍，过滤不对的，剩下m个人，m < minPlayer, return 0 
     * for m to minPlayer: sum += combination(m, minPlayer)
     */
    public static int countTeams(int[] skills, int minPlayers, int minLevel, int maxLevel) {

        // find the max amount of players
        int validNumber = 0;
        for (int i : skills) {
            if (i >= minLevel && i <= maxLevel) {
                validNumber ++;
            }
        }

        if (validNumber < minPlayers) {
            return 0;
        }

        int teams = 0;
        for (int i = minPlayers; i <= validNumber; i++) { // big = 4, small = 2
            int comb = combination(validNumber, i); // 4选4，4选3，4选2，如何去重？应该可以选3，选4
            // System.out.println("valideNumber:"+validNumber + ", minPlayers:" + minPlayers +", comb:" + comb);
            teams += comb;
        }
        return teams;
    }

    // 2C4 = 4 * 3 / 2 = 6
    // return how many combination from big choose small. example: 4 choose 3 is 4 
    // nCr = n(n - 1)(n - 2) ... (n - r + 1)/r! = n! / r!(n - r)!
    private static int combination(int big, int small) { 
        return factorial(big) / factorial(small) / factorial(big - small);
    }

    private static int factorial(int x) {
        int res = 1;
        while (x > 1) {
            res *= x;
            x--;
        }
        return res;
    }

    public static void main(String[] args) {
        
        // countTeams
        int[] skills = { 4, 6, 5, 10 };
        int minPlayers = 3;
        int minLevel = 4;
        int maxLevel = 10;
        int teams = countTeams(skills, minPlayers, minLevel, maxLevel);
        int teams2 = countTeams(skills, 2, minLevel, maxLevel);

        System.out.println("shoud be 5: " + teams); // 1 + 4
        System.out.println("shoud be 11: " + teams2);// 1 + 4 + 6 = 11

        System.out.println("6: " + factorial(3));
        System.out.println("24  " + factorial(4));
    }
}
