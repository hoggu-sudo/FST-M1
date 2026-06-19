class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " is moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped")


car1 = Car("Toyota", "Corolla", "2015", "Manual", "White")
car2 = Car("Hyundai", "i20", "2018", "Automatic", "Blue")
car3 = Car("Honda", "City", "2020", "Manual", "Black")

car1.accelerate()
car1.stop()

car2.accelerate()
car2.stop()

car3.accelerate()
car3.stop()