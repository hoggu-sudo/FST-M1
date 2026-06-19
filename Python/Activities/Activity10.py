num_tuple = (10, 20, 33, 46, 55)

print("Tuple:", num_tuple)

print("Numbers divisible by 5:")
for num in num_tuple:
    if num % 5 == 0:
        print(num)


# Bonus
numbers = input("Enter numbers separated by commas: ").split(",")

num_tuple = tuple(int(num.strip()) for num in numbers)

print("Numbers divisible by 5:")
for num in num_tuple:
    if num % 5 == 0:
        print(num)