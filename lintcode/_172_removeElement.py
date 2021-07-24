class Solution:
    """
    @param: A: A list of integers
    @param: elem: An integer
    @return: The new length after remove

    0   1   2   3   4   5   6   7   
    0   0   2   0   4   4   4   4
    i
                j
    elem = 4
    ans = 4
    i is the index scan whole list from right to left
    j is the wall whose left (including j) is the array without element
    """
    def removeElement(self, A, elem):
        # write your code here
        if not A and len(A) == 0:
            return 0

        j = len(A) - 1
        for i in range(len(A) - 1, -1, -1):
            if A[i] == elem:
                A[i], A[j] = A[j], A[i]
                j -= 1
        return j+1