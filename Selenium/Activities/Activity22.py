from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()

wait = WebDriverWait(driver, 10)

driver.get("https://training-support.net/webelements/popups")

print("Page title:", driver.title)

driver.find_element(By.ID, "launcher").click()

wait.until(EC.visibility_of_element_located((By.ID, "username")))

driver.find_element(By.ID, "username").send_keys("admin")
driver.find_element(By.ID, "password").send_keys("password")

driver.find_element(By.XPATH, "//button[text()='Submit']").click()

print("Login message:", driver.find_element(By.CSS_SELECTOR, "h2.text-center").text)

driver.quit()