fruit_shop = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peach": 20
}

fruit = input("Enter a fruit name: ").lower()
print("Available fruits:", list(fruit_shop.keys()))

if fruit in fruit_shop:
    print("Yes, available! Price is:", fruit_shop[fruit])
else:
    print("Sorry, this fruit is not available.")