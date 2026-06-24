from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains

with webdriver.Firefox() as driver:

    actions = ActionChains(driver)

    # Open page
    driver.get("https://training-support.net/webelements/drag-drop")

    print("Page title:", driver.title)

    ball = driver.find_element(By.ID, "ball")
    dropzone1 = driver.find_element(By.ID, "dropzone1")
    dropzone2 = driver.find_element(By.ID, "dropzone2")

    actions.drag_and_drop(ball, dropzone1).perform()

    dz1_text = dropzone1.find_element(By.CLASS_NAME, "dropzone-text").text
    if dz1_text == "Dropped!":
        print("Ball successfully dropped in Dropzone 1")

    actions.drag_and_drop(ball, dropzone2).perform()

    dz2_text = dropzone2.find_element(By.CLASS_NAME, "dropzone-text").text
    if dz2_text == "Dropped!":
        print("Ball successfully dropped in Dropzone 2")
