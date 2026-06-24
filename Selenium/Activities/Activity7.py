from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    # Open page
    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Page title:", driver.title)

    textbox = driver.find_element(By.ID, "textInput")

    print("Textbox initially enabled:", textbox.is_enabled())

    driver.find_element(By.ID, "textInputButton").click()

    print("Textbox after click enabled:", textbox.is_enabled())

    if textbox.is_enabled():
        textbox.send_keys("Example text")
        print("Entered text:", textbox.get_attribute("value"))