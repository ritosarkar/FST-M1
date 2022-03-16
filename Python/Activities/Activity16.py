class car:
    'This is a standard car class'
    def __init__(self,manufacturer, model, make, transmission, color):
        self.manufacturer=manufacturer
        self.model=model
        self.make=make
        self.transmisson = transmission
        self.color=color
    
    def accelerate(self):
        message='{}{} is moving'
        print(message.format(self.manufacturer,self.model))
    
    def stop(self):
        message='{}{} has stopped'
        print(message.format(self.manufacturer,self.model))

car1 = car("Maruti","Breeza","2017","Mannual","Green")
car2= car("Honda","City","2019","Automatic","Black")
car3 = car("Suzuki", "Swift", "2017", "Automatic", "Black")

car1.accelerate()
car1.stop()
car2.accelerate()
car2.stop()
car3.accelerate()
car3.stop()