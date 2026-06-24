from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

with webdriver.Firefox() as driver:

    wait = WebDriverWait(driver, 10)

    driver.get("https://training-support.net/webelements/dynamic-content")

    print("Page title:", driver.title)

    driver.find_element(By.ID, "genButton").click()

    wait.until(EC.text_to_be_present_in_element((By.ID, "word"), "release"))

    word = driver.find_element(By.ID, "word").text
    print("Word found:", word)