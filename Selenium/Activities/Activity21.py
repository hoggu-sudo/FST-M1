from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()

wait = WebDriverWait(driver, 10)

driver.get("https://training-support.net/webelements/tabs")

print("Page title:", driver.title)

print("Current tab:", driver.current_window_handle)

wait.until(EC.element_to_be_clickable(
    (By.XPATH, "//button[text()='Open A New Tab']"))
).click()

wait.until(EC.number_of_windows_to_be(2))

print("All tabs:", driver.window_handles)

driver.switch_to.window(driver.window_handles[1])

wait.until(EC.element_to_be_clickable(
    (By.XPATH, "//button[contains(text(),'Another One')]"))
)

print("New tab title:", driver.title)
print("Message:", driver.find_element(By.CSS_SELECTOR, "h2.mt-5").text)

driver.find_element(By.XPATH, "//button[contains(text(),'Another One')]").click()

wait.until(EC.number_of_windows_to_be(3))

driver.switch_to.window(driver.window_handles[2])

driver.quit()