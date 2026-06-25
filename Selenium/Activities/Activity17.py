from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select

driver = webdriver.Firefox()

driver.get("https://training-support.net/webelements/selects")

print("Page title:", driver.title)

dropdown = driver.find_element(By.CSS_SELECTOR, "select.h-80")
multi_select = Select(dropdown)

multi_select.select_by_visible_text("HTML")

multi_select.select_by_index(3)
multi_select.select_by_index(4)
multi_select.select_by_index(5)

multi_select.select_by_value("nodejs")

print("\nSelected options:")
for option in multi_select.all_selected_options:
    print(option.text)

multi_select.deselect_by_index(4)

print("\nAfter deselecting index 4:")
for option in multi_select.all_selected_options:
    print(option.text)

driver.quit()