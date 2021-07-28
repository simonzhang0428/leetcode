# short summary

## list
| time  | operation
| -     | -
| O(1)  | arr.append(1)
| -     | arr.pop(1)
| -     | arr[1]
| O(n)  | arr.insert(0, x)
| -     | del arr[0]
| -     | arr[::-1]

```python
arr = [3,1,4,1,5,9,2,6,5,3,5,9]
for i, ar in enumerate(arr):
  arr[i] = ar + i

arr # [3, 2, 6, 4, 9, 14, 8, 13, 13, 12, 15, 20]
arr2 = [str(ar) for ar in arr]
arr3 = [str(ar) for ar in arr if ar > 5]
arr4 = [str(ar) if ar > 5 else "x" for ar in arr]

# 2D matrix
arr3 = [[0 for _ in range(1)] for _ in range(5)]
arr3[1][0] = 9
arr3 # [[0], [9], [0], [0], [0]]
```