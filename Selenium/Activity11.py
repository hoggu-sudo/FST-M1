from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains

with webdriver.Firefox() as driver:

    actions = ActionChains(driver)

    # Open page
    driver.get("https://training-support.net/webelements/keyboard-events")

    print("Page title:", driver.title)

    actions.send_keys("This is coming from Selenium") \
           .send_keys(Keys.ENTER) \
           .perform()

    result = driver.find_element(By.CSS_SELECTOR, "h1.mt-3").text
    print("Message displayed:", result)