from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()

driver.get("https://training-support.net/webelements/tables")

print("Page title:", driver.title)

cols = driver.find_elements(By.XPATH, "//table[contains(@class,'table-auto')]//thead//th")
print("Columns:", len(cols))

rows = driver.find_elements(By.XPATH, "//table[contains(@class,'table-auto')]//tbody//tr")
print("Rows:", len(rows))

third_row = driver.find_elements(By.XPATH, "//table[contains(@class,'table-auto')]//tbody//tr[3]//td")
print("Third row:")
for cell in third_row:
    print(cell.text)

cell = driver.find_element(By.XPATH, "//table[contains(@class,'table-auto')]//tbody//tr[2]//td[2]")
print("Cell (2,2):", cell.text)

driver.quit()