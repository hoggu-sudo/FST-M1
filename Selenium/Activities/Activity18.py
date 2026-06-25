from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()

wait = WebDriverWait(driver, 10)

driver.get("https://training-support.net/webelements/alerts")

print("Page title:", driver.title)

driver.find_element(By.ID, "simple").click()

alert = wait.until(EC.alert_is_present())

print("Alert Text:", alert.text)

alert.accept()

print("Result:", driver.find_element(By.ID, "result").text)

driver.quit()