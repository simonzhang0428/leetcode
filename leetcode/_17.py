'''
20:57 - 21:31
1. string corner case: str is None or len(str) == 0
2. need self.map to access, self.function to recursive call
3. ''.join(['a', 'b']) == 'ab' == StringBuilder
 
input: str '23'
output: list ['ab', 'ae', ...]
 
DFS:
base case: reach the end(index == len(str)), add path to res
recursive rule: backtrack,
   add one letter
   dfs
   remove that letter
 
lvl0                    ''
                     /         \   \
lvl1:2               a           b   c
                 /   \   \
lvl2:3           ad  ae  af  
 
test:
digits: '23'
res = []
path = ['a']
'''
class Solution:
   def letterCombinations(self, digits: str) -> List[str]:
       if digits is None or len(digits) == 0:
           return []
 
       self.map = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
       res = []
       self.dfs(digits, [], 0, res)
       return res
 
   #               '23'    []      0     []
   def dfs(self, digits, path, index, res):
       if index == len(digits):
           res.append(''.join(path))
           return
 
       #   'a', 'b', 'c'
       for i in self.map[int(digits[index])]:
           path.append(i)
           self.dfs(digits, path, index+1, res)
           path.pop()
