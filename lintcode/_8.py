class Solution:
    """
    @param str: An array of char
    @param offset: An integer
    @return: nothing
            0    1    2
    str = ['a', 'b', 'c']   n = 3
    str = ['c', 'a', 'b']   offset = 1
    str = ['b', 'c', 'a']   offset = 2

    tmp = 'c'
    
    a=s[:4] b=s[4:]
    abcd    efg     offset = 3, idx = n - offset = 4
    efg     abcd

    """


    def rotateString(self, s, offset):
        # write your code here
        if not s:
            return 
        n = len(s)
        if offset > n:
            offset = offset % n

        index = n - offset
        a = s[:index]
        b = s[index:]
        s[:offset] = b
        s[offset:] = a