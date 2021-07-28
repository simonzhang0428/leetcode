arr = [3,1,4,1,5,9,2,6,5,3,5,9]
for i, ar in enumerate(arr):
  arr[i] = ar + i

arr # [3, 2, 6, 4, 9, 14, 8, 13, 13, 12, 15, 20]
arr2 = [str(ar) for ar in arr]
arr3 = [str(ar) for ar in arr if ar > 5]
arr4 = [str(ar) if ar > 5 else "x" for ar in arr]
print(arr)
print(arr2)
print(arr3)
print(arr4)

