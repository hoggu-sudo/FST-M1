import pandas as pd  

df = pd.read_csv("users.csv")

print("Full Data:")
print(df)

print("\nUsernames:")
print(df["Usernames"])

print("\nSecond Row Details:")
print("Username:", df.loc[1, "Usernames"])
print("Password:", df.loc[1, "Passwords"])

print("\nSorted by Usernames (Ascending):")
print(df.sort_values("Usernames"))

print("\nSorted by Passwords (Descending):")
print(df.sort_values("Passwords", ascending=False))