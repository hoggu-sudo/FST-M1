from selenium import webdriver
from selenium.webdriver.common.by import By

# Start browser
driver = webdriver.Firefox()

# Open site
driver.get("https://training-support.net/webelements/login-form")

# Print title
print("Page title:", driver.title)

# Enter username
driver.find_element(By.ID, "username").send_keys("admin")

# Enter password
driver.find_element(By.ID, "password").send_keys("password")

# Click login
driver.find_element(By.XPATH, "//button[text()='Submit']").click()

# Print message
message = driver.find_element(By.TAG_NAME, "h1").text
print("Login message:", message)

# Close browser
driver.quit()