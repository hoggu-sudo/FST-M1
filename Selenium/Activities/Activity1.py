from selenium import webdriver
from selenium.webdriver.common.by import By

# Create driver
driver = webdriver.Firefox()

# Open website
driver.get("https://training-support.net")

# Print current page title
print("Page title is:", driver.title)

# Click "About Us" link
driver.find_element(By.LINK_TEXT, "About Us").click()

# Print new page title
print("New page title is:", driver.title)

# Close browser
driver.quit()