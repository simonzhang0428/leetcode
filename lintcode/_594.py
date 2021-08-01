"""
rolling hash, O(n + m)
7/31    9:15 - 9:46

example:
s = abcdef  n = 6
t =    bcd  m = 3
return 1

input: two string, s = source, t = target
output: int idx, first match or -1 if not found

high level:
O(1) compare abc and bcd -> rolling hash
abc = 31^2 * a + 31^1 * b + c
bcd = 31^2 * b + 31^1 * c + d
bcd = (abc) * 31 + d - 31^3 * a
if h(s) == h(t), compare string char by char

mid level:
n = len(s), m = len(t)
init: power = 31^m, h(abc), h(bcd)
for i in range(0, n - m + 1):
    if h(s[i:i+m+1]) == h(t) and s[i:i+m+1] == t, return i

time: O(m + n)
space: O(1)

test:
s = "abc"
t = "c"
n = 3
m = 1
power = 31
s_hash = b * 31 + c - b * 31 = c
t_hash = c
i = 2

"""
class Solution:
    """
    @param: source: A source string
    @param: target: A target string
    @return: An integer as index
    """
    def strStr2(self, s, t):
        # write your code here
        if t is None or s is None or len(t) > len(s):
            return -1

        n, m = len(s), len(t)
        power, BASE, MOD = 1, 31, 1000007
        s_hash, t_hash = 0, 0
        for i in range(m):
            power = power * BASE % MOD
            s_hash = (BASE * s_hash + ord(s[i])) % MOD
            t_hash = (BASE * t_hash + ord(t[i])) % MOD
        for i in range(n - m + 1):
            if i > 0:
                # bcd = (abc) * 31 + d - 31^3 * a
                s_hash = ((s_hash * BASE) % MOD + ord(s[i + m - 1]) - (power * ord(s[i-1]) % MOD)) % MOD
                if s_hash < 0:
                    s_hash += MOD
            if s_hash == t_hash and s[i:i+m] == t:
                return i
        return -1


if __name__ == '__main__':
    sol = Solution()
    print(sol.strStr2("tartarget", "target"))




