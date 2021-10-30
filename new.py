s = 'hell'
for c in s:
    print(c)

### random
from collections import Counter, defaultdict, deque
import collections, random

random.randint(0, 10) # [0, 10]
random.uniform(0, 10) # [0, 10], float
random.randrange(10) # [0, 10)
random.random() # [0, 1)

random.choice(['win', 'lose', 'draw'])      # Single random element from a sequence

deck = 'ace two three four'.split()
random.shuffle(deck)                        # Shuffle a list
deck

random.sample([10, 20, 30, 40, 50], k=4)    # Four samples without replacement

################################################
strings = ['1', '2', '3', 'do', 're', 'mi']
strings = ','.join(strings)
strings.split(',')

data = '1,2,#,#,3,4,#,#,5,#,#'
vals = collections.deque(val for val in data.split(','))

################################################
l1 = [(1, 10), (2, 100), (2, -5), (1, -100)]
l1.sort(key=lambda x: (x[0], x[1]))
print(l1)

################################################
l2 = [i for i in range(10)]
bisect.bisect(l2, 5) # binary search

from sortedcontainers import SortedList # treemap
sl = SortedList(['e', 'a', 'c', 'd', 'b'])
sl
SortedList(['a', 'b', 'c', 'd', 'e'])
sl *= 10_000_000
sl.count('c')
10000000
sl[-3:]
['e', 'e', 'e']

from sortedcontainers import SortedDict
sd = SortedDict({'c': 3, 'a': 1, 'b': 2})
sd
SortedDict({'a': 1, 'b': 2, 'c': 3})
sd.popitem(index=-1)
('c', 3)

from sortedcontainers import SortedSet
ss = SortedSet('abracadabra')
ss
SortedSet(['a', 'b', 'c', 'd', 'r'])
ss.bisect_left('c')
2

################################################
name_height = {'simon': 177, 'helen': 166}
name_height.get('dudu', 30)

name_default = defaultdict(list)
name_default[0] # no error, default is []
name_default[1].append(4)
name_default[1].append(4)
name_default[1].append(4)
name_default

################################################
# tuple unpacking
t = (1, [1, 2, 3]) 
one, more = t
print(one, more)
print(t[0], t[1])

################################################
dp = deque()
dp.appendleft(1)
dp.appendleft(2)
dp.appendleft(3)
dp.appendleft(4)
print(dp)

################################################
word = "mississippi"
counter = defaultdict(int)
for letter in word:
    counter[letter] += 1

letters = Counter('mississippi')
# Counter({'i': 4, 's': 4, 'p': 2, 'm': 1})
letters.update("missouri")
# Counter({'i': 6, 's': 6, 'p': 2, 'm': 2, 'o': 1, 'u': 1, 'r': 1})

letters = Counter({"i": 4, "s": 4, "p": 2, "m": 1})
for letter, freq in letters.items():
    print(letter, freq)
print(letters.keys()) # dict_keys(['m', 'i', 's', 'p'])
print(letters.values()) # dict_values([1, 4, 4, 2])

letters['a'] # 0 if not found

sales = Counter(banana=15, tomato=4, apple=39, orange=30)

# The most common object -> [('apple', 39)]
sales.most_common(1) 

# The two most common objects -> [('apple', 39), ('orange', 30)]
sales.most_common(2)

# All objects sorted by count
sales.most_common()

# All objects in reverse order
sales.most_common()[::-1]
# [('tomato', 4), ('banana', 15), ('orange', 30), ('apple', 39)]

# The two least-common objects
sales.most_common()[:-3:-1]
# [('tomato', 4), ('banana', 15)]

################################################
# sort vs sorted
digits = [0, 5, 7, 3, 4, 9, 1, 6, 3, 8]

digits.sort(reverse=True) # change input
print(digits) # [9, 8, 7, 6, 5, 4, 3, 3, 1, 0]

digits = [0, 5, 7, 3, 4, 9, 1, 6, 3, 8]
sorted(digits, reverse=True) # return copy of input, not change input
print(digits) # [0, 5, 7, 3, 4, 9, 1, 6, 3, 8]

################################################
# lambda
lambda x : x
(lambda x : x + 1)(2) # (func)(args)
(lambda x, y: x + y)(2, 3)

high_ord_func = lambda x, func: x + func(x)
high_ord_func(3, lambda x: x ** 2)


#####   2D matrix
col, row = 5, 2
arr3 = [[0 for _ in range(col)] for _ in range(row)]
print(arr3)

##### call, transfer class to family of functions
'''
put the constant into __init__
put the change variabel into __call__

like drive, no matter where:
    constant are vehicle, variable are start and end
for example, you want to LA, no matter what transfermation:
    constant is start and end, variable is vehicle
'''
