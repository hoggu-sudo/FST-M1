from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Page title:", driver.title)

    is_visible = len(driver.find_elements(By.ID, "checkbox")) > 0
    print("Checkbox visible before click:", is_visible)

    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()

    is_visible = len(driver.find_elements(By.ID, "checkbox")) > 0
    print("Checkbox visible after removal:", is_visible)

    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()

    is_visible = len(driver.find_elements(By.ID, "checkbox")) > 0
    print("Checkbox visible after adding back:", is_visible)