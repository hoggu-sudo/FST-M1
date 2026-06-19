def calculate_sum(numbers):
    total = 0
    for num in numbers:
        total += num
    return total

numList = [10, 40, 60, 90]

result = calculate_sum(numList)

print("Sum of all elements:", result)

# Bonus 
numbers = list(map(int, input("Enter numbers: ").split(",")))

print("Sum:", calculate_sum(numbers))