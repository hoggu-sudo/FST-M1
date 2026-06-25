from selenium import webdriver
from selenium.webdriver.common.by import By
import time

driver = webdriver.Firefox()

driver.get("https://training-support.net/webelements/tables")

print("Page title:", driver.title)

cols = driver.find_elements(By.XPATH, "//table[contains(@class,'table-auto')]//thead//th")
print("Number of columns:", len(cols))

rows = driver.find_elements(By.XPATH, "//table[contains(@class,'table-auto')]//tbody//tr")
print("Number of rows:", len(rows))

book_before = driver.find_element(
    By.XPATH, "//table[contains(@class,'table-auto')]//tbody//tr[5]//td[2]"
)
print("Book name before sorting:", book_before.text)

driver.find_element(
    By.XPATH, "//table[contains(@class,'table-auto')]//thead//th[5]"
).click()

time.sleep(2)

book_after = driver.find_element(
    By.XPATH, "//table[contains(@class,'table-auto')]//tbody//tr[5]//td[2]"
)
print("Book name after sorting:", book_after.text)

driver.quit()