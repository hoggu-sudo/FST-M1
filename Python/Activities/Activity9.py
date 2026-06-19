list1 = [10, 20, 23, 11, 17]
list2 = [13, 43, 24, 36, 12]

result = []

for num in list1:
    if num % 2 != 0:
        result.append(num)

for num in list2:
    if num % 2 == 0:
        result.append(num)

print("Result List:", result)


# Bonus
list1 = list(map(int, input("Enter first list: ").split(",")))
list2 = list(map(int, input("Enter second list: ").split(",")))

result = [num for num in list1 if num % 2 != 0] + \
         [num for num in list2 if num % 2 == 0]

print("Result List:", result)