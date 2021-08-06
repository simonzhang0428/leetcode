from collections import Counter, defaultdict


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

