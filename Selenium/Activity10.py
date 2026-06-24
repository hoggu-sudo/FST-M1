from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains

with webdriver.Firefox() as driver:

    actions = ActionChains(driver)

    driver.get("https://training-support.net/webelements/mouse-events")

    print("Page title:", driver.title)

    cargoLock = driver.find_element(By.XPATH, "//h1[text()='Cargo.lock']")
    cargoToml = driver.find_element(By.XPATH, "//h1[text()='Cargo.toml']")
    srcButton = driver.find_element(By.XPATH, "//h1[text()='src']")
    targetButton = driver.find_element(By.XPATH, "//h1[text()='target']")

    actions.click(cargoLock)\
           .move_to_element(cargoToml)\
           .click(cargoToml)\
           .perform()

    print("First action result:",
          driver.find_element(By.ID, "result").text)

    actions.double_click(srcButton).perform()

    actions.context_click(targetButton).perform()

    driver.find_element(By.XPATH, "//ul/li[1]").click()

    print("Second action result:",
          driver.find_element(By.ID, "result").text)