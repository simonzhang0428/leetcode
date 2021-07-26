class Solution:
    """
    @param s: the string
    @return: length of longest semi alternating substring

    0   1   2   3   4   5   6   7   8   9
    b   a   a   a   b   b   a   b   b   b
                                    i
                                        j
    cnt = 2
    res = 7
    """
    def longestSemiAlternatingSubstring(self, s):
        # write your code here
        n = len(s)
        if n <= 2:
            return n

        res, cnt = 0, 1
        left = 0
        for right in range(n):
            if right > 0 and s[right] == s[right - 1]:
                cnt += 1
            else:
                cnt = 1
            if cnt == 3:
                left = right - 1
                cnt = 2
            res = max(res, right - left + 1)
        
        return res