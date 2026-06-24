from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

with webdriver.Firefox() as driver:

    wait = WebDriverWait(driver, 10)

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Page title:", driver.title)

    checkbox = driver.find_element(By.ID, "checkbox")
    print("Checkbox visible:", checkbox.is_displayed())

    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()

    wait.until(EC.invisibility_of_element_located((By.ID, "checkbox")))

    print("Checkbox visible after removal: False")

    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()

    wait.until(EC.visibility_of_element_located((By.ID, "checkbox")))

    checkbox = driver.find_element(By.ID, "checkbox")
    checkbox.click()

    print("Checkbox selected:", checkbox.is_selected())