from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    # Open page
    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Page title:", driver.title)

    checkbox = driver.find_element(By.ID, "checkbox")

    print("Checkbox initially selected:", checkbox.is_selected())

    checkbox.click()

    print("Checkbox after click:", checkbox.is_selected())

    checkbox.click()

    print("Checkbox after second click:", checkbox.is_selected())