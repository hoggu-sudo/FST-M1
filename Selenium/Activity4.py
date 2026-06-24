from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color

# Start browser
with webdriver.Firefox() as driver:

    # Open page
    driver.get("https://training-support.net/webelements/target-practice")

    # Print page title
    print("Page title:", driver.title)

    third_header = driver.find_element(By.XPATH, "//h3[contains(text(),'#3')]")
    print("Third header:", third_header.text)

    color_value = driver.find_element(
        By.XPATH, "//h5[contains(text(),'#5')]"
    ).value_of_css_property("color")

    color = Color.from_string(color_value)
    print("RGB:", color.rgb)
    print("HEX:", color.hex)

    purple_button = driver.find_element(By.XPATH, "//button[text()='Purple']")
    print("Purple classes:", purple_button.get_attribute("class"))

    slate_button = driver.find_element(By.XPATH, "//button[text()='Slate']")
    print("Slate button text:", slate_button.text)