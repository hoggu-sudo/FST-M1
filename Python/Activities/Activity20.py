import pandas as pd

df = pd.read_excel("users.xlsx")

print("Full Data:")
print(df)

print("\nRows and Columns:", df.shape)

print("\nEmails:")
print(df["Email"])

print("\nSorted Data (by FirstName):")
print(df.sort_values("FirstName"))
