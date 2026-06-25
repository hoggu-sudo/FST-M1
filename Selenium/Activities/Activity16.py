from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select

driver = webdriver.Firefox()

driver.get("https://training-support.net/webelements/selects")

print("Page title:", driver.title)

dropdown = driver.find_element(By.CSS_SELECTOR, "select.h-10")

select = Select(dropdown)

select.select_by_visible_text("Two")
print("Selected (visible text):", select.first_selected_option.text)

select.select_by_index(3)
print("Selected (index):", select.first_selected_option.text)

select.select_by_value("four")
print("Selected (value):", select.first_selected_option.text)

print("\nAll options:")
for option in select.options:
    print(option.text)

driver.quit()