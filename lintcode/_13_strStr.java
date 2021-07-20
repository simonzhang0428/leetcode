package lintcode;

public class _13_strStr {
    public class Solution {
        /**
         * @param source:
         * @param target:
         * @return: return the index
         */

        /**
         * 0 1 2 3 source a b c d i target b c d j
         * 
         * return 1
         */

        // Time: O(m * n)
        public int strStr(String source, String target) {
            // Write your code here
            if (target.length() > source.length()) {
                return -1;
            }

            if (target == null || target.length() == 0) {
                return 0;
            }

            int index = -1;
            for (int i = 0; i <= source.length() - target.length(); i++) {
                int j = 0;
                for (; j < target.length(); j++) {
                    if (source.charAt(i + j) != target.charAt(j)) {
                        break;
                    }
                }

                if (j == target.length()) {
                    return i;
                }
            }

            return index;
        }
    }
}
