numbers = input("Enter numbers separated by commas: ").split(",")

total = 0

for num in numbers:
    total += int(num)

print("Sum =", total)


#Bonus
numbers = input("Enter numbers: ").split(",")

total = 0
for num in numbers:
    total += int(num.strip())  # removes spaces

print("Sum =", total)
