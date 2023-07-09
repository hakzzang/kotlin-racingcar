package util

import model.Car

class CarCreator {
    fun create(name: String): Car {
        return Car(name)
    }

    fun createCars(inputCarName: String): List<Car> {
        return inputCarName.split(",").map { name -> create(name) }.toList()
    }
}