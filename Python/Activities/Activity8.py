numList = [10, 20, 30, 40, 10]

print("List:", numList)

if numList[0] == numList[-1]:
    print(True)
else:
    print(False)


# User Input Version
numbers = input("Enter numbers separated by commas: ").split(",")

numList = [int(num.strip()) for num in numbers]

if numList[0] == numList[-1]:
    print(True)
else:
    print(False)