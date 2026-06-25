from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()

wait = WebDriverWait(driver, 10)

driver.get("https://training-support.net/webelements/dynamic-attributes")

print("Page title:", driver.title)

full_name = driver.find_element(By.XPATH, "//input[starts-with(@id,'full-name')]")
email = driver.find_element(By.XPATH, "//input[contains(@id,'-email')]")
event_date = driver.find_element(By.XPATH, "//input[contains(@name,'event-date')]")
details = driver.find_element(By.XPATH, "//textarea[contains(@id,'additional')]")

full_name.send_keys("Hema Sundar")
email.send_keys("hema@example.com")
event_date.send_keys("2026-06-20")
details.send_keys("Automation with Selenium")

driver.find_element(By.XPATH, "//button[text()='Submit']").click()

message = wait.until(
    EC.visibility_of_element_located((By.ID, "action-confirmation"))
)

print("Success message:", message.text)

driver.quit()